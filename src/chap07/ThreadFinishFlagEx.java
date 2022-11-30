package chap07;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomThread extends Thread {

	private Container c;
	private boolean flag = false;

	public RandomThread(Container c) {
		this.c = c;
	}

	public void finish() {
		flag = true;
	}

	@Override
	public void run() {
		while (true) {
			int x = ((int) (Math.random() * c.getWidth()));
			int y = ((int) (Math.random() * c.getHeight()));
			JLabel la = new JLabel("Java");
			la.setSize(80, 30);
			la.setLocation(x, y);
			c.add(la);
			c.repaint();
			try {
				Thread.sleep(300);
				if (flag == true) {
					c.removeAll();
					la = new JLabel("finish");
					la.setSize(80, 30);
					la.setLocation(100, 100);
					la.setForeground(Color.RED);
					c.add(la);
					c.repaint();
					return;
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadFinishFlagEx extends JFrame {

	private RandomThread th;

	public ThreadFinishFlagEx() {

		setTitle("ThreadFinishFlagEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});

		setSize(300, 200);
		setVisible(true);
		th = new RandomThread(c);
		th.start();

	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}

}
