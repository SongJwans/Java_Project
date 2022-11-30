package chap07;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLabel extends JLabel implements Runnable {

	private long delay;

	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		this.setOpaque(true);

		Thread th = new Thread(this);
		// this 는 FlickeringLabel
		th.start();
	}

	@Override
	public void run() {
		boolean flag = false;

		while (true) {
			if (flag)
				setBackground(Color.YELLOW);
			else
				setBackground(Color.GREEN);

			flag = !flag;

			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {

		setTitle("FlickeringLabelEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		FlickeringLabel la1 = new FlickeringLabel("깜빡", 1000);

		JLabel la = new JLabel("안깜빡");

		FlickeringLabel la2 = new FlickeringLabel("깜빡", 500);

		c.add(la1);
		c.add(la);
		c.add(la2);

		setSize(300, 170);
		setVisible(true);

	}

	public static void main(String[] args) {
		new FlickeringLabelEx();
	}

}
