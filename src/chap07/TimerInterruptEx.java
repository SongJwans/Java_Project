package chap07;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable2 implements Runnable {

	private JLabel la;

	public TimerRunnable2(JLabel la) {
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

public class TimerInterruptEx extends JFrame {

	public TimerInterruptEx() {

		setTitle("TimerInterruptEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel la = new JLabel();
		la.setFont(new Font("Consolas", Font.ITALIC, 80));
		c.add(la);

		TimerRunnable2 runnable = new TimerRunnable2(la);
		Thread th = new Thread(runnable);

		JButton btn = new JButton("KILL");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton btn = (JButton) e.getSource();
				btn.setEnabled(false);
			}
		});
		c.add(btn);

		setSize(300, 170);
		setVisible(true);

		th.start();

	}

	public static void main(String[] args) {
		new TimerInterruptEx();
	}

}
