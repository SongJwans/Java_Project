package chap06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton okBtn = new JButton("OK");

	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		setLayout(new FlowLayout());
		setSize(200, 100);
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		this.add(tf);
		this.add(okBtn);
	}
}

public class DialogEx extends JFrame {

	private MyDialog dialog;

	public DialogEx() {

		super("DialogEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();

		dialog = new MyDialog(this, "Test Dialog");

		JButton btn = new JButton("Show Dialog");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		c.add(btn);

		setSize(250, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new DialogEx();
	}

}
