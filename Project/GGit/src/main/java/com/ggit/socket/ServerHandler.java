package com.ggit.socket;

import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeroturnaround.zip.ZipUtil;

import com.ggit.service.MemberService;
import com.ggit.service.PushService;
import com.ggit.service.RepoService;
import com.ggit.socket.InfoDTO.Info;
import com.ggit.vo.MemberVo;
import com.ggit.vo.PushVo;
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
	PushService pushService;
	MemberVo memberVo;
	RepositoriesVO repoVo;
	PushVo pushVo;
	String storage;

	// 생성자
	public ServerHandler(Socket socket, List<ServerHandler> list, MemberService memberService,
			RepoService repoService, PushService pushService,
			String storage)
			throws IOException {
		this.storage = storage;
		this.socket = socket;
		this.list = list;
		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
		// 순서가 뒤바뀌면 값을 입력받지 못하는 상황이 벌어지기 때문에 반드시 writer부터 생성시켜주어야 함!!!!!!
		this.memberService = memberService;
		this.repoService = repoService;
		this.pushService = pushService;
		this.memberVo = new MemberVo();
		this.repoVo = new RepositoriesVO();
		this.pushVo = new PushVo();

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

					list.remove(this);

					this.stop();

					break;
				} else if (dto.getCommand() == Info.LOGIN) {
					InfoDTO infoDTO = new InfoDTO();

					MemberVo vo = new MemberVo();

					vo.setEmail(dto.getId());
					vo.setPw(dto.getPw());
					infoDTO.setCommand(Info.LOGINRESULT);
					if ((vo = memberService.memberByemailPw(vo)) != null) {
						infoDTO.setMessage("true");
						infoDTO.setIdx(vo.getIdx() + "");

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

					fileSend(writer, dto.getIdx(), dto.getToken());

				} else if (dto.getCommand() == Info.PUSH) {

					pushVo.setToken(dto.getToken());
					pushVo.setMember(Integer.parseInt(dto.getId()));
					pushVo.setRepo(Integer.parseInt(dto.getIdx()));
					pushVo.setMessage(dto.getMessage());
					pushVo.setBranch(Integer.parseInt(dto.getId()));
					pushVo.setBefore_token(dto.getLastToken());
					pushService.push(pushVo);

					String writePath = storage + "repositorys/" + dto.getIdx() + "/";
					System.out.println(storage + "repositorys/" + dto.getIdx() + "/");
					File file = new File(writePath);
					file.mkdir();
					String result = fileWrite(writePath, dto.getToken());

				} else if (dto.getCommand() == Info.FILEEND) {
					System.out.println("end");
				}
			} // while

		} catch (BindException e) {

			list.remove(this);
			this.stop();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void fileSend(ObjectOutputStream dos, String repo, String token) {

		File path = new File(storage + "repositorys/" + repo + "/" + token);
		ZipUtil.pack(path, new File(path.getPath() + ".zip"));
		FileInputStream fis;
		BufferedInputStream bis;

		try {

			dos.writeUTF("project");

			// 파일을 읽어서 서버에 전송

			File file = new File(path.getPath() + ".zip");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			int len;
			int size = 100000;
			int i = 0;
			byte[] Object = new byte[size];
			while ((len = bis.read(Object)) > 0) {

				dos.write(Object, 0, len);
			}

			System.out.println(len);
			// 서버에 전송

			fis.close();
			bis.close();
			dos.flush();
			InfoDTO infoDTO = new InfoDTO();
			infoDTO.setCommand(Info.FILEEND);
			dos.writeObject(infoDTO);
			dos.flush();

			file.delete();

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

	private String fileWrite(String writePath, String token) {
		String result = "";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			String projectName = reader.readUTF();
			System.out.println("파일 수신 작업을 시작합니다.");

			// 파일명을 전송 받고 파일명 수정
			System.out.println("파일명 " + projectName + "을 전송받았습니다.");
			// 파일을 생성하고 파일에 대한 출력 스트림 생성
			File file = new File(writePath + token + ".zip");
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			System.out.println("file.zip을 생성하였습니다.");

			// 바이트 데이터를 전송받으면서 기록
			int len = 0;
			int size = 100000;
			byte[] Object = new byte[size];
			int i = 0;
			while ((len = reader.read(Object)) > 0) {

				bos.write(Object, 0, len);

			}
			System.out.println(len);
			result = "SUCCESS";
			// bos.flush();
			System.out.println(1);
			System.out.println("파일 수신 작업을 완료하였습니다.");
			System.out.println("받은 파일의 사이즈 : " + file.length());

			bos.close();
			fos.close();
			File zip = new File(writePath + token + ".zip");
			ZipUtil.unpack(zip, new File(zip.getPath().replace(".zip", "")));
			zip.delete();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}

}