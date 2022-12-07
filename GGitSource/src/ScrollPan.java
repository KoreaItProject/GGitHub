
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;

public class ScrollPan {

    public JScrollPane getScrollPan(String clientPath) {
        String str[] = { "변경사항 없음" };
        JList scrollList = new JList();
        scrollList.setListData(str);

        new FileState(clientPath, scrollList).start();

        JScrollPane jp = new JScrollPane(scrollList);
        MyScrollBarUI myScrollBarUI = new MyScrollBarUI();
        jp.getVerticalScrollBar().setUI(new MyScrollBarUI());
        jp.getHorizontalScrollBar().setUI(new MyScrollBarUI());

        return jp;
    }

    class MyScrollBarUI extends BasicScrollBarUI {
        private final Dimension d = new Dimension();

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Color color = null;

            g2.setPaint(Color.pink);
            g2.fillRoundRect(r.x, r.y, r.width, r.height, 12, 12);
            g2.setPaint(Color.pink);
            g2.drawRoundRect(r.x, r.y, r.width, r.height, 12, 12);
            uninstallComponents();

            g2.dispose();

        }

        protected JButton createDecreaseButton(int orientation) {

            JButton button = new BasicArrowButton(orientation);
            decrGap = -13;
            incrGap = -13;
            scrollBarWidth = scrollBarWidth - 8;
            return button;

        }

        /*
         * (non-Javadoc)
         * ScrollBar 하단에 화살표 모양의 버튼 색상 지정
         * 
         * @see javax.swing.plaf.basic.BasicScrollBarUI#createIncreaseButton(int)
         */
        protected JButton createIncreaseButton(int orientation) {
            JButton button = new BasicArrowButton(orientation);

            return button;
        }

        @Override
        protected Dimension getMaximumThumbSize() {
            // TODO Auto-generated method stub

            return new Dimension((int) maximumThumbSize.getWidth(), (int) maximumThumbSize.getHeight());
        }

        @Override
        protected void setThumbBounds(int x, int y, int width, int height) {
            /*
             * If the thumbs bounds haven't changed, we're done.
             */

            if ((thumbRect.x == x) &&
                    (thumbRect.y == y) &&
                    (thumbRect.width == width) &&
                    (thumbRect.height == height)) {
                return;
            }

            /*
             * Update thumbRect, and repaint the union of x,y,w,h and
             * the old thumbRect.
             */
            int minX = Math.min(x, thumbRect.x);
            int minY = Math.min(y, thumbRect.y);
            int maxX = Math.max(x + width, thumbRect.x + thumbRect.width);
            int maxY = Math.max(y + height, thumbRect.y + thumbRect.height);

            thumbRect.setBounds(x, y, width, height);
            scrollbar.repaint(minX, minY, maxX - minX, maxY - minY);

            // Once there is API to determine the mouse location this will need
            // to be changed.
            setThumbRollover(false);
        }

    }

}
