package chap02;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MousListenerEx2 extends JFrame {
	private JLabel la = new JLabel("Hello");

	public MousListenerEx2() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdatper());

		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);

		setSize(250	, 250);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MousListenerEx2();
	}

	class MyMouseAdatper extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}
}
