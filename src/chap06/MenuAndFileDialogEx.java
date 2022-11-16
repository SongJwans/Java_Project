package chap06;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuAndFileDialogEx extends JFrame {

	private JLabel la = new JLabel();

	public MenuAndFileDialogEx() {
		setTitle("MenuAndFileDialogEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(la, BorderLayout.NORTH);

		createMenu();

		setSize(350, 200);
		setVisible(true);
	}

	private void createMenu() {

		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("open");
		openItem.addActionListener(new OpenActionListener());
		screenMenu.add(openItem);

		mb.add(screenMenu);
		this.setJMenuBar(mb);
	}

	class OpenActionListener implements ActionListener {

		private JFileChooser chooser;

		public OpenActionListener() {
			chooser = new JFileChooser();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			FileNameExtensionFilter filter1 = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			FileNameExtensionFilter filter2 = new FileNameExtensionFilter("BMP Images", "bmp");

			chooser.addChoosableFileFilter(filter1);
			chooser.addChoosableFileFilter(filter2);

			chooser.setFileFilter(filter1);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String filePath = chooser.getSelectedFile().getPath();
			la.setIcon(new ImageIcon(filePath));
			pack();

		}

	}

	public static void main(String[] args) {
		new MenuAndFileDialogEx();
	}

}
