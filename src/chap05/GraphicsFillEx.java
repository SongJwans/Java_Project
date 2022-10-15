package chap05;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFillEx extends JFrame {

	private MyPanel panel = new MyPanel();

	public GraphicsFillEx() {

		setTitle("GraphicsFillEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(200, 320);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.setColor(Color.RED);
			g.fillRect(20, 20, 40, 40);

			g.setColor(Color.BLUE);
			g.fillOval(20, 70, 40, 40);

			g.setColor(Color.GREEN);
			g.fillRoundRect(20, 120, 40, 40, 10, 10);

			g.setColor(Color.MAGENTA);
			g.fillArc(20, 170, 40, 40, 0, 270);

			g.setColor(Color.YELLOW);
			int[] x = { 25, 20, 25, 60 };
			int[] y = { 220, 240, 260, 240 };
			g.fillPolygon(x, y, 4);

		}
	}

	public static void main(String[] args) {
		new GraphicsFillEx();
	}
}
