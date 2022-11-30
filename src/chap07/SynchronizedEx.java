package chap07;

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();

		Thread th1 = new StudentThread("JH", board);
		Thread th2 = new StudentThread("MY", board);

		th1.start();
		th2.start();
	}
}
	class SharedBoard {


		private int sum = 0;

		synchronized public void add() {
			int n = sum;
			Thread.yield(); //보수적으로 밀어낸다?
			n += 1;
			sum = n;
			System.out.println(Thread.currentThread().getName() + ": " + sum);
		}

		public int getSum() {
			return sum;
		}

	}

	class StudentThread extends Thread {
		private SharedBoard board;

		public StudentThread(String name, SharedBoard board) {
			super(name);
			this.board = board;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++)
				board.add();
		}

	}

