package chap06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolTipEx extends JFrame {

	private Container contentPane;

	public ToolTipEx() {

		setTitle("ToolBarEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = this.getContentPane();
		createToolBar();

		setSize(640, 480);
		setVisible(true);
	}

	private void createToolBar() {

		JToolBar toolBar = new JToolBar("툴바 메뉴");
		toolBar.setBackground(Color.LIGHT_GRAY);

		JButton btn = new JButton("New");
		btn.setToolTipText("파일을 생성합니다.");
		toolBar.add(btn);

		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("파일을 엽니다.");
		toolBar.add(openBtn);

		JButton SaveBtn = new JButton(new ImageIcon("images/save.jpg"));
		SaveBtn.setToolTipText("파일을 저장합니다.");
		toolBar.add(SaveBtn);

		toolBar.add(new JLabel("검색"));
		JTextField tf = new JTextField("검색할 내용을 입력하세요");
		tf.setToolTipText("입력한 내용을 검색합니다.");
		toolBar.add(tf);

		contentPane.add(toolBar, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		new ToolTipEx();
	}

}
