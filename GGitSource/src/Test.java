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

        String str[] = { "asdf", "fdas", "edsf", "acvsd", "fdas", "edsf", "acvsd", "fdas", "edsf", "acvsd", "fdas",
                "edsf", "acvsd", "fdas", "edsf", "acvsd", "fdas", "edsf", "acvsd" };
        JList scrollList = new JList(str);

        scrollList.setVisible(true);
        JScrollPane jp = new JScrollPane(scrollList);
        jp.setVisible(true);
        jp.setBounds(100, 100, 100, 300);
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
