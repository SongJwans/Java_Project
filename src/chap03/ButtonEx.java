package chap03;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx extends JFrame {

	public ButtonEx() {
		setTitle("ButtonEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");

		JButton btn = new JButton("call", normalIcon);
		btn.setRolloverIcon(rolloverIcon);
		btn.setPressedIcon(pressedIcon);

		c.add(btn);

		setSize(350, 200);
		setVisible(true);

	}

	public static void main(String[] args) {

		new ButtonEx();
	}

}
