package swing.SocketServer;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

class ServerMain {
	private ServerSocket serverSocket;
	private List<ServerHandler> list;
	public static List<String> member;
	public static HashMap<String, Integer> room;

	public ServerMain() {
		try {
			serverSocket = new ServerSocket(9988);
			System.out.println("서버 준비 완료");
			list = new ArrayList<ServerHandler>();
			member = new ArrayList<>();
			room = new HashMap<>();

			while (true) {
				System.out.println(123);
				Socket socket = serverSocket.accept();
				ServerHandler handler = new ServerHandler(socket, list); // 스레드를 생성한 것이랑 동일함! 떄문에 시자해주어야
				handler.start(); // 스레드 시작- 스레드 실행
				list.add(handler); // 핸들러를 담음( 이 리스트의 개수가 클라이언트의 갯수!!)

			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerMain();
	}

}