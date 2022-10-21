import java.beans.Visibility;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class F extends JFrame {
    F() {
        setSize(1000, 500); // 컨테이너 크기 지정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        // 레이블을 넣기 위한 패널 생성

        JPanel backPanel = new JPanel();
        backPanel.setLayout(null);
        add(backPanel);
        setVisible(true);

        JList scrollList = new JList(fruits);
        backPanel.add(new JScrollPane(scrollList));
    }
}

public class Test extends JFrame {

    public static void main(String[] args) {
        new F();
    }
}
