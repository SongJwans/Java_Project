package chap02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousClassListener extends JFrame {
	public AnonymousClassListener() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		c.add(btn);

		btn.addActionListener(new MyActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton j = (JButton) e.getSource();
				if (j.getText().equals("Action"))
					j.setText("액션");
				else
					j.setText("Action");
				setTitle(j.getText());
			}
		});

		setSize(350, 150);
		setVisible(true);

	}

	public static void main(String[] args) {
		new AnonymousClassListener();
	}
}
