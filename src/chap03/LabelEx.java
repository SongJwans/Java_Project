package chap03;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {
	public LabelEx() {
		setTitle("LabelEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel tla = new JLabel("Love");

		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel ila = new JLabel(beauty);

		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		JLabel la =new JLabel("Call me if you want", normalIcon, SwingConstants.CENTER);

		c.add(tla);
		c.add(ila);
		c.add(la);


		setSize(400, 600);
		setVisible(true);
	}
	public static void main(String[] args) {

		new LabelEx();
	}
}
