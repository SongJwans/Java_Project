package chap05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsColorFontEx extends JFrame {

	private MyPanel panel = new MyPanel();

	public GraphicsColorFontEx() {

		setTitle("GraphicsColorFontEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);

		setSize(600, 400);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.setColor(Color.BLUE);
			g.drawString("BLUE-default", 30, 30);

			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("Red-Arial-30", 30, 60);

			g.setColor(new Color(0x00ff00ff));
			for (int i = 0; i <= 5; i++) {
				g.setFont(new Font("Consolas", Font.ITALIC, i * 10));
				g.drawString("MAGENTA-Consolas" + Integer.toString(i * 10), 30, 60 + i * 50);
			}
		}
	}

	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}
}
