import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class App1 {

    public static void main(String[] args) {

        String serverIp = "localhost";
        Socket socket = null;

        try {
            // 서버 연결
            socket = new Socket(serverIp, 4440);
            System.out.println("서버에 연결되었습니다.");

            // 파일 전송용 클래스

            String filePath = "src";
            // String fileNm = "DSC01129.jpg";
            String fileNm = "testfile.txt";
            FileSender fs = new FileSender(socket, filePath, fileNm);
            fs.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 파일 전송용 클래스
class FileSender extends Thread {

    String filePath;
    String fileNm;
    Socket socket;
    ObjectOutputStream dos;
    FileInputStream fis;
    BufferedInputStream bis;

    public FileSender(Socket socket, String filePath, String fileNm) {

        this.socket = socket;
        this.fileNm = fileNm;
        this.filePath = filePath;

        try {
            // 데이터 전송용 스트림 생성
            dos = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Override
    public void run() {

        try {
            // 파일전송을 서버에 알린다.('file' 구분자 전송)
            SockDto sockDto = new SockDto();
            sockDto.setMessage("file");
            dos.writeObject(sockDto);

            dos.flush();

            // 전송할 파일을 읽어서 Socket Server에 전송
            String result = fileRead(dos);
            /* test */System.out.println("result : " + result);

        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 리소스 초기화
            try {
                dos.close();
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

    private String fileRead(ObjectOutputStream dos) {

        String result;

        try {
            dos.writeUTF(fileNm);
            /* test */System.out.println("파일 이름(" + fileNm + ")을 전송하였습니다.");

            // 파일을 읽어서 서버에 전송

            File file = new File(filePath + "/" + fileNm);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            int len;
            int size = 4096;
            byte[] Object = new byte[size];
            while ((len = bis.read(Object)) != -1) {
                dos.write(Object, 0, len);
            }

            // 서버에 전송

            dos.flush();

            result = "SUCCESS";
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
