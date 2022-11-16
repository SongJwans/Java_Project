package chap06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPaneEx extends JFrame {

	public OptionPaneEx() {

		super("OptionPaneEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(new MyPanel(), BorderLayout.NORTH);

		setSize(500, 200);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		private JButton inputBtn = new JButton("Input Name");
		private JButton confirmBtn = new JButton("Confirm");
		private JButton messageBtn = new JButton("Message");
		private JTextField tf = new JTextField(10);

		public MyPanel() {
			this.setBackground(Color.LIGHT_GRAY);
			this.add(inputBtn);
			this.add(confirmBtn);
			this.add(messageBtn);
			this.add(tf);

			inputBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name = JOptionPane.showInputDialog("이름을 입력하세요");
					if (name != null)
						tf.setText(name);
				}
			});

			confirmBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton) e.getSource();
					int result = JOptionPane.showConfirmDialog(btn.getTopLevelAncestor(), "계속 하시겠습니까?", "확인",
							JOptionPane.YES_NO_OPTION);
					switch (result) {
					case JOptionPane.YES_OPTION:
						tf.setText("Yes");
						break;
					case JOptionPane.NO_OPTION:
						tf.setText("No");
						break;
					case JOptionPane.CLOSED_OPTION:
						tf.setText("w/o SELECTION");
						break;

					}
				}
			});
			messageBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showInputDialog(null, "조심하세요", "오류 메세지", JOptionPane.ERROR_MESSAGE);

				}
			});
		}

	}

	public static void main(String[] args) {
		new OptionPaneEx();
	}

}
