import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class a extends JFrame {

    public static void main(String[] args) {
        String serverPath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\file1\\server\\123.txt";
        String clientPath = "C:\\Users\\harry\\OneDrive\\바탕 화면\\file1\\client";
        File folder1 = new File(serverPath);
        File folder2 = new File(clientPath);

        System.out.println(folder1.toPath().getFileName());
        System.out.println(new File(folder2.getPath() + "\\" + folder1.getName()).isFile());

    }

}
