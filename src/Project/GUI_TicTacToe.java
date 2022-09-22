package Project;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyPanel extends JFrame implements ActionListener{
	JButton btnArr[][] = new JButton[3][3];
	int arr[][] = new int[3][3];// player1,2 의 지표
	int turn = 0;

	Font gameFont = new Font("고딕", Font.PLAIN, 20);

	MyPanel() {
		setTitle("GUI Tic Tac Toc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(3, 3);
		Container c = getContentPane();
		c.setLayout(grid);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btnArr[i][j] = new JButton();
				btnArr[i][j].setFont(gameFont);
				btnArr[i][j].setSize(100, 100);
				btnArr[i][j].setText(i * 3 + j + 1 + "");
				btnArr[i][j].addActionListener(this);
				this.add(btnArr[i][j]);
				arr[i][j] = 0;
			}
		}

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (e.getSource() == btnArr[i][j]) {
					if (turn % 2 == 0) { // Player1 가 누른 버튼을 arr에 1으로 저장
						btnArr[i][j].setText("O");
						btnArr[i][j].setFont(gameFont);
						arr[i][j] = 1;
					} else { // Player2 가 누른 버튼을 arr에 2으로 저장
						btnArr[i][j].setText("X");
						btnArr[i][j].setFont(gameFont);
						arr[i][j] = 2;
					}
					btnArr[i][j].setEnabled(false);
					turn++;
				}
			}
		}
		if (check() == 1) {
			setTitle("Player1 WIN!");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					btnArr[i][j].setEnabled(false);
				}
			}
		} else if (check() == 2) {
			setTitle("Player2 WIN!");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					btnArr[i][j].setEnabled(false);
				}
			}
		}

	}

	// arr 값으로 TicTacToe 값 체쿠
	int check() {
		int j = 0; // 열 체크
		for (int i = 0; i < 3; i++) {
			if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1) {
				return 1;
			} else if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2) {
				return 2;
			}
		}

		int i = 0; // 행 체크
		for (j = 0; j < 3; j++) {
			if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1) {
				return 1;
			} else if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2) {
				return 2;
			}
		}

		// 대각선 체크(\)
		i = 0;
		if (arr[i][i] == 1 && arr[i + 1][i + 1] == 1 && arr[i + 2][i + 2] == 1) {
			return 1;
		} else if (arr[i][i] == 2 && arr[i + 1][i + 1] == 2 && arr[i + 2][i + 2] == 2) {
			return 2;
		}

		// 대각선 체크(/)
		i = 0;
		if (arr[i][i + 2] == 1 && arr[i + 1][i + 1] == 1 && arr[i + 2][i] == 1) {
			return 1;
		} else if (arr[i][i + 2] == 2 && arr[i + 1][i + 1] == 2 && arr[i + 2][i] == 2) {
			return 2;
		}
		return 0;
	}
}

public class GUI_TicTacToe {
	public static void main(String[] args) {
		new MyPanel();
	}
}