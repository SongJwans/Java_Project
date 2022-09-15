package chap02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickAndDoubleClickEx extends JFrame {

	private JLabel la = new JLabel();

	public ClickAndDoubleClickEx() {
		setTitle("ClickAndDoubleClickEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		MyMouseListener MListener = new MyMouseListener();
		c.addMouseListener(MListener);
		c.addMouseWheelListener(MListener);

		c.add(la);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ClickAndDoubleClickEx();
	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			// la.setText(Integer.toString(e.getClickCount() + "-times Clicked!"));

			if (e.getClickCount() == 2) {
				la.setText("Double Clicked!");
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);

				Component c = (Component) e.getSource();
				c.setBackground(new Color(r, g, b));
			} else if (e.getClickCount() == 1) {
				la.setText("Single Clicked!");
			}

		}

		public void MouseWheelMoved(MouseWheelEvent e) {
			Component c = (Component) e.getSource();

			if (e.getWheelRotation() > 0) {
				la.setText("Up Scroll!");
				c.setBackground(Color.YELLOW);
			} else if (e.getWheelRotation() < 0) {
				la.setText("DOWN Scroll!");
				c.setBackground(Color.BLUE);
			}
		}
	}
}
