package chap04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxEx extends JFrame {

	public ComboBoxEx() {
		setTitle("ComboBoxEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		String[] fruits = { "apple", "banana", "kiwi", "mango", "pear", "peach", "cherry", "strawberry", "blackberry" };
		String[] fruits2 = { "사과", "바나나", "키위", "망고", "배", "복숭아", "체리", "딸기", "블랙베리" };

		JComboBox<String> strCombo = new JComboBox<>(fruits);
		c.add(strCombo);

		JComboBox<String> strCombo2 = new JComboBox<>();
		for (int i = 0; i < fruits2.length; i++) {
			strCombo2.addItem(fruits2[i]);
		}
		c.add(strCombo2);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxEx();
	}

}
