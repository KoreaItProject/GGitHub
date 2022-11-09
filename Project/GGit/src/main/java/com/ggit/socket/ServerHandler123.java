// package com.ggit.socket;

// import java.net.Socket;
// import java.util.List;
// import java.util.Random;

// import com.ggit.socket.InfoDTO.Info;

// import java.io.BufferedOutputStream;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;

// class ServerHandler123 extends Thread // 처리해주는 곳(소켓에 대한 정보가 담겨있는 곳. 소켓을 처리함)
// {
// private ObjectInputStream reader;
// private ObjectOutputStream writer;
// private Socket socket;
// // private InfoDTO dto;
// /// private Info command;
// private List<ServerHandler> list;
// FileOutputStream fos = null;
// BufferedOutputStream bos = null;

// // 생성자
// public ServerHandler123(Socket socket, List<ServerHandler> list) throws
// IOException {

// this.socket = socket;
// this.list = list;
// writer = new ObjectOutputStream(socket.getOutputStream());
// reader = new ObjectInputStream(socket.getInputStream());
// // 순서가 뒤바뀌면 값을 입력받지 못하는 상황이 벌어지기 때문에 반드시 writer부터 생성시켜주어야 함!!!!!!

// }

// public void run() {
// InfoDTO dto = null;

// try {

// while (true) {
// dto = (InfoDTO) reader.readObject();

// String result = fileWrite(reader);

// } // while

// } catch (IOException e) {
// e.printStackTrace();
// } catch (ClassNotFoundException e) {
// e.printStackTrace();
// }

// }

// // 다른 클라이언트에게 전체 메세지 보내주기
// public void broadcast(InfoDTO dto) throws IOException {
// for (ServerHandler handler : list) {
// handler.writer.writeObject(dto); // 핸들러 안의 writer에 값을 보내기
// handler.writer.flush(); // 핸들러 안의 writer 값 비워주기
// }
// }

// private String fileWrite(ObjectInputStream dis) {

// String result;
// String filePath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\";

// try {
// System.out.println("파일 수신 작업을 시작합니다.");

// // 파일명을 전송 받고 파일명 수정
// String fileNm = dis.readUTF();
// System.out.println("파일명 " + fileNm + "을 전송받았습니다.");

// // 파일을 생성하고 파일에 대한 출력 스트림 생성
// File file = new File(filePath + "/" + fileNm);
// fos = new FileOutputStream(file);
// bos = new BufferedOutputStream(fos);
// System.out.println(fileNm + "파일을 생성하였습니다.");

// // 바이트 데이터를 전송받으면서 기록
// int len;
// int size = 4096;
// byte[] Object = new byte[size];
// while ((len = dis.read(Object)) != -1) {
// bos.write(Object, 0, len);
// }

// // bos.flush();
// result = "SUCCESS";

// System.out.println("파일 수신 작업을 완료하였습니다.");
// System.out.println("받은 파일의 사이즈 : " + file.length());
// } catch (IOException e) {
// e.printStackTrace();
// result = "ERROR";
// } finally {
// try {
// bos.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// try {
// fos.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// try {
// dis.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }

// return result;
// }

// }