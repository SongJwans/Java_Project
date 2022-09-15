package chap02;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx extends JFrame {
	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("Hello");

	public FlyingTextEx() {
		setTitle("FlyingTextEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		la.setSize(100, 20);
		la.setLocation(50, 50);
		c.add(la);

		setSize(300	, 300);
		setVisible(true);
		c.setFocusable(true); // Focusable은 Visible 다음
		c.requestFocus();

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		}
		);

	}

	public static void main(String[] args) {
		new FlyingTextEx();
	}

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY() - FLYING_UNIT);
			break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY() + FLYING_UNIT);
			break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX() - FLYING_UNIT,la.getY());
			break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX() + FLYING_UNIT,la.getY() - FLYING_UNIT);
			break;
			}
		}
	}
}
