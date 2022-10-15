package chap05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame {

	private MyPanel panel = new MyPanel();

	public paintJPanelEx() {
		setTitle("PaintJPanelEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		setSize(250, 220);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 30);
			g.drawRect(50, 30, 50, 30);

			g.setColor(Color.MAGENTA);
			g.drawRect(90, 50, 50, 30);

		}
	}

	public static void main(String[] args) {
		new paintJPanelEx();
	}
}
