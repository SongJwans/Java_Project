package Project1;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("640x480 스윙 프레임 만들기");
		setSize(640, 480);
		setVisible(true);// default: false
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}
