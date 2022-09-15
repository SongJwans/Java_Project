package chap02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MousListenerAllEx extends JFrame {

	private JLabel la = new JLabel("No Mouse Event");

	public MousListenerAllEx() {
		setTitle("MousListenerAllEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		MyMouseListener MListener = new MyMouseListener();
		c.addMouseListener(MListener);
		c.addMouseMotionListener(MListener);

		c.add(la);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MousListenerAllEx();
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged (" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved (" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed (" + e.getX() + ", " + e.getY() + ")");

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("mouseReleased (" + e.getX() + ", " + e.getY() + ")");

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component c =(Component)e.getSource();
			c.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component c =(Component)e.getSource();
			c.setBackground(Color.YELLOW);

		}
	}
}
