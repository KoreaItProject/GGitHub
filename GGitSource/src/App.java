import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.attribute.FileTime;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.awt.*;
import java.awt.event.*;

class c extends JFrame implements ActionListener {

    JButton btn1, btn2, btn3;
    String serverPath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\file1\\server";
    String clientPath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\file1\\client";
    File folder1, folder2;

    c() {

        folder1 = new File(serverPath);
        folder2 = new File(clientPath);

        setSize(1000, 500); // 컨테이너 크기 지정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        // 레이블을 넣기 위한 패널 생성

        JPanel backPanel = new JPanel();
        backPanel.setLayout(null);

        btn1 = new JButton("push");
        btn2 = new JButton("pull");
        btn3 = new JButton("Path");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn1.setBounds(450, 100, 100, 50);
        btn2.setBounds(450, 200, 100, 50);
        btn3.setBounds(450, 300, 100, 50);
        backPanel.add(btn1);
        backPanel.add(btn2);
        backPanel.add(btn3);
        add(backPanel);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            delete(clientPath, serverPath);
            copy(folder2, folder1);

        } else if (e.getSource() == btn2) {
            delete(serverPath, clientPath);
            copy(folder1, folder2);

        } else if (e.getSource() == btn3) {

            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.showDialog(this, null);
            File dir = jfc.getSelectedFile();
            clientPath = dir.getPath();
            folder2 = new File(clientPath);
        }

    }

    void delete(String serverPath, String clientPath) {
        File folder2 = new File(clientPath);

        try {
            if (folder2.exists()) {

                File[] folder_list2 = folder2.listFiles(); // 파일리스트 얻어오기

                for (int i = 0; i < folder_list2.length; i++) {
                    System.out.println(123);
                    if (folder_list2[i].isFile()) {// 파일일경우

                        if (!(new File(serverPath + "\\" + folder_list2[i].getName()).isFile()))
                            folder_list2[i].delete();

                    } else {// 디렉토리일경우
                        if (!(new File(folder_list2[i].getPath().replace(clientPath, serverPath)).isDirectory())) {
                            alldelete(folder_list2[i].getPath());
                        }
                        delete(folder_list2[i].getPath().replace(clientPath, serverPath),
                                folder_list2[i].getPath()); // 재귀함수호출

                    }
                }

            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    void alldelete(String clientPath) {

        File folder2 = new File(clientPath);
        try {
            if (folder2.exists()) {
                File[] folder_list2 = folder2.listFiles(); // 파일리스트 얻어오기

                for (int i = 0; i < folder_list2.length; i++) {
                    System.out.println(123);
                    if (folder_list2[i].isFile()) {

                        if (!(new File(serverPath + "\\" + folder_list2[i].getName()).isFile()))

                            folder_list2[i].delete();

                        System.out.println("파일이 삭제되었습니다.");
                    } else {

                        alldelete(folder_list2[i].getPath()); // 재귀함수호출

                    }
                    folder_list2[i].delete();
                }
                folder2.delete();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    void copy(File sourceF, File targetF) {

        File[] target_file = sourceF.listFiles();
        for (File file : target_file) {
            File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());
            try {

                System.out.println();

                if (file.isDirectory()) {
                    temp.mkdir();
                    copy(file, temp);
                } else {
                    FileInputStream fis = null;
                    FileOutputStream fos = null;
                    try {
                        if (temp.isFile()) {
                            FileTime lastModifiedTime = (FileTime) Files.getAttribute(Paths.get(file.getPath()),
                                    "lastModifiedTime");
                            FileTime lastModifiedTime1 = (FileTime) Files.getAttribute(Paths.get(temp.getPath()),
                                    "lastModifiedTime");
                            if (lastModifiedTime.toMillis() > lastModifiedTime1.toMillis()) {
                                fis = new FileInputStream(file);
                                fos = new FileOutputStream(temp);
                                byte[] b = new byte[4096];
                                int cnt = 0;
                                while ((cnt = fis.read(b)) != -1) {
                                    fos.write(b, 0, cnt);
                                }
                            }
                        } else {
                            fis = new FileInputStream(file);
                            fos = new FileOutputStream(temp);
                            byte[] b = new byte[4096];
                            int cnt = 0;
                            while ((cnt = fis.read(b)) != -1) {
                                fos.write(b, 0, cnt);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fis.close();
                            fos.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

}

public class App extends JFrame {

    public static void main(String[] args) {

        new c();
    }

}
