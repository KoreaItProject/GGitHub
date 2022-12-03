package com.ggit.socket;

import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeroturnaround.zip.ZipUtil;

import com.ggit.service.MemberService;
import com.ggit.service.RepoService;
import com.ggit.socket.InfoDTO.Info;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepositoriesVO;
import com.mysql.cj.protocol.Message;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;

class ServerHandler extends Thread // 처리해주는 곳(소켓에 대한 정보가 담겨있는 곳. 소켓을 처리함)
{
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	// private InfoDTO dto;
	/// private Info command;
	private List<ServerHandler> list;
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;

	MemberService memberService;
	RepoService repoService;
	MemberVo memberVo;
	RepositoriesVO repoVo;

	// 생성자
	public ServerHandler(Socket socket, List<ServerHandler> list, MemberService memberService, RepoService repoService)
			throws IOException {

		this.socket = socket;
		this.list = list;
		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
		// 순서가 뒤바뀌면 값을 입력받지 못하는 상황이 벌어지기 때문에 반드시 writer부터 생성시켜주어야 함!!!!!!
		this.memberService = memberService;
		this.repoService = repoService;
		this.memberVo = new MemberVo();
		this.repoVo = new RepositoriesVO();

	}

	public void run() {
		InfoDTO dto = null;

		try {

			while (true) {
				dto = (InfoDTO) reader.readObject();

				if (dto.getCommand() == Info.STATE && dto.getMessage().equals("running")) {
					writer.writeObject(dto);
					writer.flush();
				} else if (dto.getCommand() == Info.EXIT) {
					System.out.println("종료");

					writer.writeObject(dto);
					writer.flush();

					list.remove(this);
					this.stop();

					break;
				} else if (dto.getCommand() == Info.LOGIN) {
					InfoDTO infoDTO = new InfoDTO();
					memberVo.setEmail(dto.getId());
					memberVo.setPw(dto.getPw());

					infoDTO.setCommand(Info.LOGINRESULT);
					if ((memberVo = memberService.memberByemailPw(memberVo)) != null) {
						infoDTO.setMessage("true");
						infoDTO.setIdx(memberVo.getIdx() + "");

					} else {

						infoDTO.setMessage("false");
					}
					writer.writeObject(infoDTO);
					writer.flush();
				} else if (dto.getCommand() == Info.CLONE) {
					InfoDTO infoDTO = new InfoDTO();
					infoDTO.setCommand(Info.CLONERESULT);
					repoVo = repoService.clone(dto.getMessage());
					if (repoVo != null) {
						infoDTO.setIdx(repoVo.getRepo_idx() + "");
						infoDTO.setToken(repoVo.getPush_token());
					}

					writer.writeObject(infoDTO);
					writer.flush();
				} else if (dto.getCommand() == Info.PULL) {
					System.out.println("PULL");
					InfoDTO infoDTO = new InfoDTO();
					infoDTO.setCommand(Info.PULLRESULT);
					writer.writeObject(infoDTO);
					writer.flush();
					fileSend(writer);

				} else if (dto.getCommand() == Info.PUSH) {

					String result = fileWrite(reader);
				}
			} // while

		} catch (IOException e) {
			list.remove(this);
			this.stop();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void fileSend(ObjectOutputStream dos) {

		File path = new File("C:/gitdata/GGitHub/Project/GGit/STORAGE/repositorys/1/asda231/");
		String dirName = path.listFiles()[0].getName();
		String zip = path.getPath() + "\\" + dirName + ".zip";
		System.out.println(path.getPath() + "/" + dirName);
		ZipUtil.pack(new File(path.getPath() + "/" + dirName), new File(zip));
		FileInputStream fis;
		BufferedInputStream bis;

		try {

			dos.writeUTF(dirName + ".zip");
			/* test */System.out.println("파일 이름(" + dirName + ".zip" + ")을 전송하였습니다.");

			// 파일을 읽어서 서버에 전송

			File file = new File(zip);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			int len;
			int size = 1024;
			int i = 0;
			byte[] Object = new byte[size];
			while ((len = bis.read(Object)) > 0) {

				dos.write(Object, 0, len);
			}

			System.out.println(len);
			// 서버에 전송
			dos.flush();
			fis.close();
			bis.close();
			InfoDTO infoDTO = new InfoDTO();
			infoDTO.setCommand(Info.FILEEND);
			dos.writeObject(infoDTO);
			dos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 다른 클라이언트에게 전체 메세지 보내주기
	public void broadcast(InfoDTO dto) throws IOException {
		for (ServerHandler handler : list) {
			handler.writer.writeObject(dto); // 핸들러 안의 writer에 값을 보내기
			handler.writer.flush(); // 핸들러 안의 writer 값 비워주기
		}
	}

	private String fileWrite(ObjectInputStream dis) {

		String result;
		String filePath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\";

		try {
			System.out.println("파일 수신 작업을 시작합니다.");

			// 파일명을 전송 받고 파일명 수정
			String fileNm = dis.readUTF();
			System.out.println("파일명 " + fileNm + "을 전송받았습니다.");

			// 파일을 생성하고 파일에 대한 출력 스트림 생성
			File file = new File(filePath + "/" + fileNm);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			System.out.println(fileNm + "파일을 생성하였습니다.");

			// 바이트 데이터를 전송받으면서 기록
			int len;
			int size = 4096;
			byte[] Object = new byte[size];
			while ((len = dis.read(Object)) != -1) {
				bos.write(Object, 0, len);
			}

			// bos.flush();
			result = "SUCCESS";

			System.out.println("파일 수신 작업을 완료하였습니다.");
			System.out.println("받은 파일의 사이즈 : " + file.length());
		} catch (IOException e) {
			e.printStackTrace();
			result = "ERROR";
		} finally {
			try {
				bos.close();
				fos.close();
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}