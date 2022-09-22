package chap03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RadioButtonItemEventEx extends JFrame {

	private JRadioButton[] radio = new JRadioButton[3];
	private String[] text = { "apple", "pear", "cherry" };
	private ImageIcon[] image = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg") };
	private JLabel la = new JLabel();

	public RadioButtonItemEventEx() {
		setTitle("RadioButtonItemEventEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel rp = new JPanel();
		rp.setBackground(Color.gray);

		MyItemListner l = new MyItemListner();
		ButtonGroup g = new ButtonGroup();

		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			radio[i].addItemListener(l);

			g.add(radio[i]);
			rp.add(radio[i]);

		}
		radio[0].setSelected(true);
		c.add(rp, BorderLayout.NORTH);
		c.add(la, BorderLayout.CENTER);
		la.setHorizontalAlignment(SwingConstants.CENTER);

		setSize(250, 200);
		setVisible(true);
	}

	class MyItemListner implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if (radio[0].isSelected())
				la.setIcon(image[0]);
			else if (radio[1].isSelected())
				la.setIcon(image[1]);
			else if (radio[2].isSelected())
				la.setIcon(image[2]);
		}
	}

	public static void main(String[] args) {

		new RadioButtonItemEventEx();
	}
}
