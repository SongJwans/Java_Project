package chap06;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class ToolTipDelayEx extends JFrame {

	public ToolTipDelayEx() {

		setTitle("ToolTipDelayEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		JLabel cherryLabel = new JLabel(
				new ImageIcon("images/cherry.jpg"));
		cherryLabel.setToolTipText("체리 이미지입니다.");
		c.add(cherryLabel);

		JLabel appleLabel = new JLabel(
				new ImageIcon("images/apple.jpg"));
		appleLabel.setToolTipText("사과 이미지입니다.");
		c.add(appleLabel);

		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(3000);


		setSize(640, 480);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ToolTipDelayEx();
	}

}
