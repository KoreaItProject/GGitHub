package swing.SocketServer;

import java.net.Socket;
import java.util.List;
import java.util.Random;

import swing.SocketServer.InfoDTO.Info;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class ServerHandler extends Thread // 처리해주는 곳(소켓에 대한 정보가 담겨있는 곳. 소켓을 처리함)
{
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	// private InfoDTO dto;
	/// private Info command;
	private List<ServerHandler> list;

	// 생성자
	public ServerHandler(Socket socket, List<ServerHandler> list) throws IOException {

		this.socket = socket;
		this.list = list;
		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
		// 순서가 뒤바뀌면 값을 입력받지 못하는 상황이 벌어지기 때문에 반드시 writer부터 생성시켜주어야 함!!!!!!

	}

	public void run() {
		InfoDTO dto = null;

		try {
			while (true) {
				dto = (InfoDTO) reader.readObject();
				System.out.println(dto.getRoomId());
				System.out.println(dto.getNickName());
				if (dto.getCommand() == Info.EXIT) {
					System.out.println("종료");

					if (dto.getMessage() == null || !dto.getMessage().equals("startGame")) {
						writer.writeObject(dto);
						broadcast(dto);
					}
					outMember(dto.getNickName());

					// reader.close();
					// writer.close();
					// socket.close();

					list.remove(this);
					this.stop();

					break;
				} else if (dto.getCommand() == Info.JOIN) {
					dto.setCommand(Info.JOIN);
					dto.setNickName(dto.getNickName());

					System.out.println("조인" + ServerMain.room.get(dto.getRoomId()));

					if (isMember(dto.getNickName())) {
						dto.setMessage(dto.getNickName() + "ERR");
						System.out.println("닉중복");
						broadcast(dto);

					} else {

						if (ServerMain.room.get(dto.getRoomId()) == null) {
							dto.setMessage(dto.getRoomId() + "ERR");
							System.out.println("방없음");
							broadcast(dto);

						} else {// 방입장하기
							dto.setSeed(ServerMain.room.get(dto.getRoomId()));
							dto.setRoomId(dto.getRoomId());

							broadcast(dto);
						}
					}

				} else if (dto.getCommand() == Info.SEND) {
					broadcast(dto);
				} else if (dto.getCommand() == Info.MAKE) {
					dto.setCommand(Info.MAKE);
					dto.setNickName(dto.getNickName());

					if (isMember(dto.getNickName())) {
						dto.setMessage(dto.getNickName() + "ERR");
						broadcast(dto);

					} else {// 방만들기

						ServerMain.member.add(dto.getNickName());
						int leftLimit = 97; // letter 'a'
						int rightLimit = 122; // letter 'z'
						int targetStringLength = 7;
						Random random = new Random();
						String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
								.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
								.toString();
						/*
						 * int seed=400;
						 * Random rand = new Random();
						 * rand.setSeed(seed);
						 * 
						 * for (int i = 1; i <= 5; i++) {
						 * System.out.print(rand.nextInt(2) + " ");
						 * 
						 * }
						 */
						Random rand = new Random();
						int seed = rand.nextInt(10000);

						ServerMain.room.put(generatedString, seed);

						dto.setRoomId(generatedString);
						dto.setSeed(seed);
						broadcast(dto);

					}

				} else if (dto.getCommand() == Info.STATE) {
					dto.setCommand(Info.STATE);
					dto.setNickName(dto.getNickName());
					dto.setMessage(dto.getMessage());
					dto.setRoomId(dto.getRoomId());
					broadcast(dto);

				} else if (dto.getCommand() == Info.STATELOSE) {

					dto.setCommand(Info.STATELOSE);
					dto.setWinlose("패배");
					dto.setRoomId(dto.getRoomId());
					dto.setNickName(dto.getNickName());
					dto.setStep(dto.getStep()); // 내 step 횟수
					dto.setSkillCount(dto.getSkillCount()); // 내 스킬 횟수
					dto.setComboCount(dto.getComboCount()); // 내 최대 콤보 횟수

					broadcast(dto);

				}
			} // while

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	public boolean isMember(String nick) {
		for (int i = 0; i < ServerMain.member.size(); i++) {
			if (nick.equals(ServerMain.member.get(i))) {
				return true;
			}

		}
		return false;
	}

	public void outMember(String nick) {
		for (int i = 0; i < ServerMain.member.size(); i++) {
			if (nick.equals(ServerMain.member.get(i))) {
				ServerMain.member.remove(i);
			}

		}
	}
}