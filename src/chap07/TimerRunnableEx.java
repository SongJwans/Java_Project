package chap07;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable implements Runnable {

	private JLabel la;

	public TimerRunnable(JLabel la) {
		this.la = la;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			la.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class TimerRunnableEx extends JFrame {

	public TimerRunnableEx() {

		setTitle("TimerRunnableEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel la = new JLabel();
		la.setFont(new Font("Consolas", Font.ITALIC, 80));
		c.add(la);

		setSize(300, 170);
		setVisible(true);

		TimerRunnable runnable = new TimerRunnable(la);
		Thread th = new Thread(runnable);

		th.start();

	}

	public static void main(String[] args) {
		new TimerRunnableEx();
	}

}
