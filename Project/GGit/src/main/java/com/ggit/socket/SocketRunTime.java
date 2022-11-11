package com.ggit.socket;

import java.io.BufferedInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import com.ggit.socket.InfoDTO.Info;

public class SocketRunTime {

    public SocketRunTime() {
        String serverIp = "localhost";
        Socket socket = null;
        try {
            socket = new Socket(serverIp, 4445);
            System.out.println("서버에 연결되었습니다.");

            Sender fs = new Sender(socket);
            fs.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Sender extends Thread {

    Socket socket;
    ObjectOutputStream writer;
    ObjectInputStream reader;
    FileInputStream fis;
    BufferedInputStream bis;
    InfoDTO infoDTO;

    public Sender(Socket socket) {

        this.socket = socket;

        try {
            // 데이터 전송용 스트림 생성
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
            infoDTO = new InfoDTO();
            try {

                // 파일전송을 서버에 알린다.('file' 구분자 전송)

                infoDTO.setCommand(Info.RUNNING);
                writer.writeObject(infoDTO);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally { // 리소스 초기화

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Override
    public void run() {

        try {
            while (true) {
                infoDTO = (InfoDTO) reader.readObject();
                if (infoDTO.getCommand() == Info.RUNNING) {
                    Thread.sleep(30000);
                    writer.writeObject(infoDTO);
                    writer.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally { // 리소스 초기화

        }

    }

}
