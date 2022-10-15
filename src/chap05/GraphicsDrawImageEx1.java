package chap05;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame {
	private MyPanel panel = new MyPanel();

	public GraphicsDrawImageEx1() {
		setTitle("GraphicsDrawImageEx1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(300, 420);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpeg");
		private Image image = icon.getImage();

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}
}
