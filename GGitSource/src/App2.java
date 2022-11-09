import java.io.BufferedInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import com.ggit.socket.InfoDTO;

public class App2 {

    public static void main(String[] args) {

        String serverIp = "localhost";
        Socket socket = null;

        try {
            // 서버 연결
            socket = new Socket(serverIp, 4445);
            System.out.println("서버에 연결되었습니다.");

            Sender fs = new Sender(socket);
            fs.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 파일 전송용 클래스
class Sender extends Thread {

    Socket socket;
    ObjectOutputStream writer;

    FileInputStream fis;
    BufferedInputStream bis;

    public Sender(Socket socket) {

        this.socket = socket;

        try {
            // 데이터 전송용 스트림 생성
            writer = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Override
    public void run() {

        try {
            // 파일전송을 서버에 알린다.('file' 구분자 전송)
            InfoDTO InfoDTO = new InfoDTO();
            InfoDTO.setMessage("file");
            writer.writeObject(InfoDTO);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 리소스 초기화
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
