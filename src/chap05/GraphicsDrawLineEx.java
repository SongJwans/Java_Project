package chap05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineEx extends JFrame {

	private MyPanel panel = new MyPanel();

	public GraphicsDrawLineEx() {

		setTitle("GraphicsDrawLineEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		setSize(400, 400);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.setColor(Color.RED);
			g.drawLine(20, 20, 80, 160);

		}
	}

	public static void main(String[] args) {
		new GraphicsDrawLineEx();
	}
}
