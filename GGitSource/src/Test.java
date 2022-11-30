import java.beans.Visibility;

import javax.swing.*;
import java.awt.*;

class F extends JFrame {
    F() {
        setSize(1000, 500); // 컨테이너 크기 지정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        // 레이블을 넣기 위한 패널 생성

        JPanel backPanel = new JPanel();
        backPanel.setLayout(null);

        String str[];

        String str1[] = { "asdf999999999999999999999999999999", "fdas" };
        str = str1;

        JList scrollList = new JList(str);
        JScrollPane jp = new JScrollPane(scrollList);
        jp.setBounds(100, 100, 100, 200);
        backPanel.add(jp);

        add(backPanel);
        setVisible(true);
    }

}

public class Test extends JFrame {

    public static void main(String[] args) {
        new F();
    }
}
