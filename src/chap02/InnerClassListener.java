package chap02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassListener extends JFrame {
	public InnerClassListener() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		MyActionListener listner = new MyActionListener();
		// btn.addActionListener(new MyActionListener());
		btn.addActionListener(listner);
		c.add(btn);

		setSize(350, 150);
		setVisible(true);

	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if (j.getText().equals("Action"))
				j.setText("액션");
			else
				j.setText("Action");
		}
	}

	public static void main(String[] args) {
		new InnerClassListener();
	}
}
