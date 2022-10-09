package chap04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame {

	private JLabel la = new JLabel("    COLORED LABEL    ");
	private JSlider[] sl = new JSlider[3];

	public SliderChangeEx() {
		setTitle("SliderChangeEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		for (int i = 0; i < sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].setPaintTicks(true);
			sl[i].setPaintLabels(true);
			sl[i].addChangeListener(new MyListener());
			c.add(sl[i]);
		}

		sl[0].setBackground(Color.RED);
		sl[1].setBackground(Color.GREEN);
		sl[2].setBackground(Color.BLUE);

		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		la.setOpaque(true);
		la.setBackground(new Color(r, g, b));
		c.add(la);

		setSize(300, 300);
		setVisible(true);
	}

	class MyListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			la.setBackground(new Color(r, g, b));
		}
	}

	public static void main(String[] args) {

		new SliderChangeEx();
	}
}
