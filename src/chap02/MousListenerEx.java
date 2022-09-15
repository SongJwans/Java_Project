package chap02;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MousListenerEx extends JFrame {
	private JLabel la = new JLabel("Hello");

	public MousListenerEx() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());

		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 20);
		c.add(la);

		setSize(350, 150);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MousListenerEx();
	}

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		la.setLocation(x,y);
		la.setVisible(true);

	}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setVisible(false);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}
}
