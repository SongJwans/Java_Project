package Project;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class User {
	String id;
	String pass;

	public User(String i, String p) {
		id = i;
		pass = p;
	}

	void print() {
		System.out.println(id + " " + pass);
	}
}

class UserList {
	ArrayList<User> ul = new ArrayList<>();

	void add(User u) {
		ul.add(u);
	}

	void print() {
		for (User u : ul)
			u.print();
	}

	boolean isValidID(String i) {
		for (User u : ul)
			if (u.id.equals(i))
				return true;
		return false;
	}

	User getCurrentUser(String i) {
		for (User u : ul)
			if (u.id.equals(i))
				return u;
		return null;
	}

	boolean isValidPass(String i, String p) {
		String pass = new String();
		for (User u : ul)
			if (u.id.equals(i)) {
				pass = u.pass;
				break;
			}
		if (pass.equals(p))
			return true;
		else
			return false;
	}
}

class BGame {

	private int[] target = new int[4];
	private int count;

	BGame() {
		count = 0;
	}

	void incCount() {
		count++;
	}

	public void init() {
		Random r = new Random();
		int newNum;
		for (int i = 0; i < 4; i++) {
			do {
				newNum = r.nextInt(9) + 1;
			} while (isDup(i, newNum));
			target[i] = newNum;
		}
	}

	private boolean isDup(int i, int num) {
		boolean dup = false;
		for (int j = 0; j < i; j++)
			if (target[j] == num) {
				dup = true;
				break;
			}
		return dup;
	}

	public void print() {
		for (int i = 0; i < 4; i++)
			System.out.print(target[i] + " ");
		System.out.println();
	}

	public int getStrike(int[] input) {
		int s = 0;
		for (int i = 0; i < 4; i++)
			if (target[i] == input[i])
				s++;
		return s;
	}

	public int getBall(int[] input) {
		int b = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (target[i] == input[j])
					b++;
		return b - getStrike(input);
	}
}

//로그인 클래스
@SuppressWarnings("serial")
class LoginWindow extends JFrame {
	JTextField tf;
	JPasswordField pf;
	UserList ul;

	void setUserList(UserList ul) {
		this.ul = ul;
	}

	public LoginWindow() {
		setTitle("로그인");
		setLocation(200, 200);
		setLayout(new GridLayout(3, 1));

		JPanel p1 = new JPanel();
		add(p1);
		JPanel p2 = new JPanel();
		add(p2);
		JPanel p3 = new JPanel();
		add(p3);

		p1.add(new JLabel("아이디"));
		tf = new JTextField(20);
		p1.add(tf);
		p2.add(new JLabel("암 호"));
		pf = new JPasswordField(20);
		p2.add(pf);

		JButton login = new JButton("로그인");
		p3.add(login);
		login.addActionListener(e -> {
			String id = tf.getText();
			String pass = new String(pf.getPassword());
			if (!ul.isValidID(id))
				JOptionPane.showMessageDialog(null, "유효하지 않은 아이디", "로그인", JOptionPane.ERROR_MESSAGE);
			else if (!ul.isValidPass(id, pass))
				JOptionPane.showMessageDialog(null, "부정확한 암호", "로그인", JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "로그인 완료", "로그인 정보", JOptionPane.INFORMATION_MESSAGE);
				User u = ul.getCurrentUser(id);
				GameWindow gw = new GameWindow(u);
				dispose();
			}
		});
		JButton reg = new JButton("회원등록");
		p3.add(reg);
		reg.addActionListener(e -> {
			RegWindow rw = new RegWindow();
			rw.setUserList(ul);
		});
		JButton cancel = new JButton("취소");
		cancel.addActionListener(e -> {
			dispose();
		});
		p3.add(cancel);

		pack();
		setVisible(true);
	}
}

//회원 등록 클래스
@SuppressWarnings("serial")
class RegWindow extends JFrame {
	JTextField tf;
	JPasswordField pf1, pf2;
	UserList ul;

	void setUserList(UserList ul) {
		this.ul = ul;
	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File("data.txt");
				if (!file.exists())
					file.createNewFile();
				FileWriter fwr = new FileWriter(file, true);
				PrintWriter pwr = new PrintWriter(fwr);
				String id = tf.getText();
				String pass1 = new String(pf1.getPassword());
				String pass2 = new String(pf2.getPassword());
				if (ul.isValidID(id))
					JOptionPane.showMessageDialog(null, "등록된 아이디", "회원등록", JOptionPane.ERROR_MESSAGE);
				else if (!pass1.equals(pass2))
					JOptionPane.showMessageDialog(null, "암호 불일치", "회원등록", JOptionPane.ERROR_MESSAGE);
				else {
					pwr.println(id);
					pwr.println(pass1);
					User newUser = new User(id, pass1);
					ul.add(newUser);
					ul.print();
					JOptionPane.showMessageDialog(null, "회원 등록 완료", "회원등록", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				pwr.close();
			} catch (IOException er) {
				er.printStackTrace();
			}
		}
	}

	public RegWindow() {
		setTitle("회원 등록");
		setLocation(250, 250);
		setLayout(new GridLayout(4, 1));

		JPanel p1 = new JPanel();
		add(p1);
		JPanel p2 = new JPanel();
		add(p2);
		JPanel p3 = new JPanel();
		add(p3);
		JPanel p4 = new JPanel();
		add(p4);
		p1.add(new JLabel("아 이 디"));
		tf = new JTextField(20);
		p1.add(tf);
		p2.add(new JLabel("암 호"));
		pf1 = new JPasswordField(20);
		p2.add(pf1);
		p3.add(new JLabel("암호확인"));
		pf2 = new JPasswordField(20);
		p3.add(pf2);
		JButton reg = new JButton("등록");
		p4.add(reg);
		reg.addActionListener(new MyListener());
		JButton cancel = new JButton("취소");
		p4.add(cancel);
		cancel.addActionListener(e -> {
			dispose();
		});
		pack();
		setVisible(true);
	}
}

//게임 진행 클래스
class GameWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// 아래 필드 선언을 참고하여 필요에 따라 필드의 선언을 추가 또는 삭제하시오.
	User cUser;
	JTextField txt; // 2. 왼쪽 textField 에 입력된 값이
	JTextArea textArea; // 3. ok를 누르면 textArea 에 append하여 추가
	JLabel cTry;

	int count = 0; // 시도횟수
	int iCount = 0; // input 배열 count

	BGame g;

	int[] input; // 1. 값을 input[] 로 받아서 넣야함

	@Override
	public void actionPerformed(ActionEvent e) {
		// input 값에 입력 받은 수를 넣어야됨
		switch (e.getActionCommand()) {
		case "1":
			txt.setText(txt.getText() + "1");
			input[iCount++] = 1;
			break;

		case "2":
			txt.setText(txt.getText() + "2");
			input[iCount++] = 2;
			break;

		case "3":
			txt.setText(txt.getText() + "3");
			input[iCount++] = 3;
			break;

		case "4":
			txt.setText(txt.getText() + "4");
			input[iCount++] = 4;
			break;

		case "5":
			txt.setText(txt.getText() + "5");
			input[iCount++] = 5;
			break;

		case "6":
			txt.setText(txt.getText() + "6");
			input[iCount++] = 6;
			break;

		case "7":
			txt.setText(txt.getText() + "7");
			input[iCount++] = 7;
			break;

		case "8":
			txt.setText(txt.getText() + "8");
			input[iCount++] = 8;
			break;
		case "9":
			txt.setText(txt.getText() + "9");
			input[iCount++] = 9;
			break;
		}
		if (input.length >= 4) {
			// 선택사항
		}
		if (e.getActionCommand().contentEquals("OK")) {
			++count;
			cTry.setText("시도횟수: " + count);
			textArea.append(txt.getText() + "  " + g.getStrike(input) + "S" + g.getBall(input) + "B" + "\n");

			if (g.getStrike(input) == 4) {
				JOptionPane.showMessageDialog(null, "시도횟수:" + count + " \n 축하합니다~ 게임완료", "게임 완료",
						JOptionPane.INFORMATION_MESSAGE);
				textArea.setText("");
				count = 0;
				cTry.setText("시도횟수: " + count);
				g = new BGame();
				g.init();
				g.print();
				input = new int[4];
			}

			iCount = 0;// iCount 초기화
			input = new int[4]; // input 초기화
			txt.setText("");
		}
	}

	// 게임 진행 화면 구성 사례
	GameWindow(User u) {
		User cUser = u;
		JPanel left = new JPanel();
		JPanel right = new JPanel();

		left.setLayout(new BorderLayout());
		add(left, BorderLayout.WEST);
		left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

		right.setLayout(new BorderLayout());
		add(right, BorderLayout.EAST);
		right.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

		txt = new JTextField(20);
		left.add(txt, BorderLayout.NORTH);
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(3, 3));
		left.add(bPanel, BorderLayout.CENTER);
		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton("" + i);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(50, 30));
			bPanel.add(btn);
		}
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		left.add(okButton, BorderLayout.SOUTH);

		JLabel cu = new JLabel("사용자 : " + cUser.id);
		right.add(cu, BorderLayout.NORTH);

		textArea = new JTextArea(6, 15); // 텍스트 영역의 행과 열을 지정
		textArea.setEditable(false);
		JScrollPane sp = new JScrollPane(textArea);
		right.add(sp, BorderLayout.CENTER);

		cTry = new JLabel("시도횟수 : " + count);
		right.add(cTry, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		g = new BGame();
		g.init();
		g.print();
		input = new int[4];
	}
}

public class GUITest {

	public static void main(String[] args) throws IOException {
		User u;
		UserList ul = new UserList();

		LoginWindow lw = new LoginWindow();

		Scanner sc = new Scanner(new File("data.txt"));
		while (sc.hasNext()) {
			String id = sc.next();
			String pass = sc.next();
			u = new User(id, pass);
			ul.add(u);
		}
		ul.print();
		lw.setUserList(ul);
		sc.close();
	}

}