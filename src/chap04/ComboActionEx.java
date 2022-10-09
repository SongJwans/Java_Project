package chap04;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame {

	private String[] fruits = { "apple", "banana", "kiwi", "mango" };
	private ImageIcon[] images = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/kiwi.jpg"), new ImageIcon("images/mango.jpg") };
	private JLabel la = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);

	public ComboActionEx() {
		setTitle("ComboActionEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(strCombo);
		c.add(la);

		strCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				la.setIcon(images[index]);
			}
		});

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {

		new ComboActionEx();
	}
}
