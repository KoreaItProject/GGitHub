package com.ggit.socket;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Mbeanregistry;

import com.ggit.service.MemberService;
import com.ggit.service.RepoService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerMain {
	private ServerSocket serverSocket;
	private List<ServerHandler> list;
	public static List<String> member;
	public static HashMap<String, Integer> room;
	MemberService memberService;
	RepoService repoService;
	int port = 4445;
	String storage;

	public ServerMain(MemberService memberService, RepoService repoService, String storage) {
		System.out.println("서버시작");
		try {
			this.storage = storage;
			this.repoService = repoService;
			this.memberService = memberService;
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(0);
			System.out.println("서버 준비 완료");
			list = new ArrayList<ServerHandler>();
			member = new ArrayList<>();
			room = new HashMap<>();

			while (true) {
				System.out.println(123);
				Socket socket = serverSocket.accept();
				ServerHandler handler = new ServerHandler(socket, list, memberService, repoService, storage); // 스레드를
																												// 생성한
																												// 것이랑
				// 동일함! 떄문에
				// 시자해주어야
				handler.start(); // 스레드 시작- 스레드 실행
				list.add(handler); // 핸들러를 담음( 이 리스트의 개수가 클라이언트의 갯수!!)

			} // while

		} catch (Exception e) {

			killProcessID(port);
			e.printStackTrace();

		} finally {

		}
	}

	public int killProcessID(int port) {
		Process ps = null;
		BufferedReader br = null;
		try {
			// netstat -a -o라는 명령어를 프로세스로 실행한다.
			ps = new ProcessBuilder("cmd", "/c", "netstat -a -o").start();
			// 프로세스 실행한걸 읽어들인다.
			br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			String line = "";
			String[] arr = null;
			// 읽어들인 br객체에서 한줄씩 가져온다. 없으면 종료
			while ((line = br.readLine()) != null) {
				// 만약 내가 원하는 포트번호를 포함한다면
				if (line.contains(":" + port)) {
					// 2칸짜리 공백이 있으면
					while (line.contains("  ")) {
						// 2칸짜리 공백을 1칸으로 줄인다.
						line = line.replace("  ", " ");
					}
					// line을 공백을 기준으로 나누게 되면
					arr = line.split(" ");
					// 5번 index가 pid
					int pid = Integer.parseInt(arr[5]);
					// 프로세스를 죽인다.
					ps.destroy();
					// pid를 리턴
					return pid;
				}
			}
			new ServerMain(memberService, repoService, storage);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}