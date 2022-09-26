package Project;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		char[][] board = new char[3][3]; // 게임판을 나타내는 2차원 배열
		int numA;
		int numB;
		int x = 0;
		int y = 0;
		boolean game_check = true;
		char player_win = 'd';

		Scanner scanner = new Scanner(System.in);

		// 게임판을 나타내는 2차원 배열을 초기화
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = ' ';

		// 게임판을 그린다.
		System.out.println("  " + 1 + "|  " + 2 + "|  " + 3);
		System.out.println("---|---|---");
		System.out.println("  " + 4 + "|  " + 5 + "|  " + 6);
		System.out.println("---|---|---");
		System.out.println("  " + 7 + "|  " + 8 + "|  " + 9);

		while (game_check) {

			// 틱택토 게임 종료 판단 --- 0
			int count = 0;
			boolean player1 = true;
			boolean player2 = true;
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					if (board[i][j] != ' ')
						count += 1;
			if (count == 8) {
				player2 = false;
			} else if (count == 9) {
				player1 = false;
			}

			while (player1) {
				// PlayerA 차례
				System.out.print("Player 1: ");
				while (true) {
					try {
						// 예외 발생 가능성이 있는 코드
						numA = scanner.nextInt();
						break;
					} catch (InputMismatchException e) {
						scanner = new Scanner(System.in);
						System.out.print("잘못된 좌표입니다. 정수만 입력하세요. :");
						numA = scanner.nextInt();
						continue;
					}
				}
				switch (numA) {
				case 1:
					x = 0;
					y = 0;
					break;
				case 2:
					x = 0;
					y = 1;
					break;
				case 3:
					x = 0;
					y = 2;
					break;
				case 4:
					x = 1;
					y = 0;
					break;
				case 5:
					x = 1;
					y = 1;
					break;
				case 6:
					x = 1;
					y = 2;
					break;
				case 7:
					x = 2;
					y = 0;
					break;
				case 8:
					x = 2;
					y = 1;
					break;
				case 9:
					x = 2;
					y = 2;
					break;
				default:
					System.out.print("잘못된 좌표입니다. 0 ~ 9 사이의 정수를 입력하세요.\n");
					continue;
				}
				// 사용자가 놓은 위치를 검사 --- 1
				if (board[x][y] != ' ') {
					System.out.println("잘못된 위치입니다.");
					continue;
				} else {
					board[x][y] = 'O';
				}
				// player 2가 놓을 위치를 결정 --- 2
				while (player2) {
					// Player2 차례
					System.out.print("Player 2: ");
					while (true) {
						try {
							// 예외 발생 가능성이 있는 코드
							numB = scanner.nextInt();
							break;
						} catch (InputMismatchException e) {
							scanner = new Scanner(System.in);
							System.out.print("잘못된 좌표입니다. 정수만 입력하세요. :");
							numA = scanner.nextInt();
							continue;
						}
					}

					switch (numB) {
					case 1:
						x = 0;
						y = 0;
						break;
					case 2:
						x = 0;
						y = 1;
						break;
					case 3:
						x = 0;
						y = 2;
						break;
					case 4:
						x = 1;
						y = 0;
						break;
					case 5:
						x = 1;
						y = 1;
						break;
					case 6:
						x = 1;
						y = 2;
						break;
					case 7:
						x = 2;
						y = 0;
						break;
					case 8:
						x = 2;
						y = 1;
						break;
					case 9:
						x = 2;
						y = 2;
						break;
					}
					// Player2가 놓은 위치를 검사 --- 2
					if (board[x][y] != ' ') {
						System.out.println("잘못된 위치입니다.");
						continue;
					} else {
						board[x][y] = 'X';
						break;
					}
				}

				// 게임판 그리기 --- 3
				for (int i = 0; i < 3; i++) {
					System.out.println("  " + board[i][0] + "|  " + board[i][1] + "|  " + board[i][2]);
					if (i != 2)
						System.out.println("---|---|---");
				}
				break;
			}

			// 승리 여부 판단 --- 4
			for (int i = 0; i < 3; i++) {
				if ((board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
						|| (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')
						|| (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
						|| (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')) {
					player_win = 'y';
					game_check = false;
					break;
				}
				if ((board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
						|| (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X')
						|| (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
						|| (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')) {
					player_win = 'n';
					game_check = false;
					break;
				}
			}
		}

		if (player_win == 'y') {
			System.out.println("Player1 WIN!");
		} else if (player_win == 'n') {
			System.out.println("Player2 WIN!");
		} else {
			System.out.println("Draw");
		}
	}
}
