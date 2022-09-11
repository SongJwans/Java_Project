package Project1;

import javax.swing.JFrame;

class MyFrame1 extends JFrame {
	public MyFrame1() {
		setTitle("640x480 스윙 프레임 만들기");
		setSize(640, 480);
		setVisible(true);// default: false
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

public class MyApp {
	public static void main(String[] args) {
		MyFrame1 frame = new MyFrame1();
	}
}