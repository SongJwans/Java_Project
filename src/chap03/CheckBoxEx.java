package chap03;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {
	public CheckBoxEx() {
		setTitle("CheckBoxEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		JCheckBox apple = new JCheckBox("apple");
		JCheckBox pear = new JCheckBox("pear");
		JCheckBox cherry = new JCheckBox("cherry",cherryIcon);

		cherry.setSelectedIcon(selectedCherryIcon);
		cherry.setBorderPainted(true);

		c.add(apple);
		c.add(pear);
		c.add(cherry);

		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {

		new CheckBoxEx();
	}
}
