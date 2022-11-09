package com.ggit.socket;

import java.net.Socket;
import java.util.List;
import java.util.Random;

import com.ggit.socket.InfoDTO.Info;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;

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
				System.out.println(dto.getMessage());

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
}