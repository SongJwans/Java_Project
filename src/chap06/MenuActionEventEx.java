package chap06;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuActionEventEx extends JFrame {

	private JLabel la = new JLabel();

	public MenuActionEventEx() {
		setTitle("MenuActionEventEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		createMenu();

		c.add(la, BorderLayout.CENTER);

		setSize(250, 200);
		setVisible(true);
	}

	private void createMenu() {

		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");

		JMenuItem[] menuItem = new JMenuItem[4];
		String[] itemTitle = { "Load", "Hide", "Reshow", "Exit" };

		MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			if (i == menuItem.length - 1)
				screenMenu.addSeparator();
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(listener);
			screenMenu.add(menuItem[i]);
		}

		mb.add(screenMenu);
		mb.add(new JMenu("edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));

		this.setJMenuBar(mb);
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "Load" :
				if(la.getIcon()!=null)
					return;
				la.setIcon(new ImageIcon("images/pear.jpg"));
				break;
			case "Hide":
				la.setVisible(false);
				break;
			case "Reshow":
				la.setVisible(false);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new MenuActionEventEx();
	}

}
