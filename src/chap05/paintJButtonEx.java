package chap05;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class paintJButtonEx extends JFrame {

	public paintJButtonEx() {

		setTitle("paintJPanelEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		MyButton b = new MyButton("MyButton");
		b.setOpaque(true);
		b.setBackground(Color.CYAN);
		c.add(b);

		setSize(250, 220);
		setVisible(true);
	}

	class MyButton extends JButton {

		public MyButton(String s) {
			super(s);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);

		}
	}

	public static void main(String[] args) {
		new paintJButtonEx();
	}
}
