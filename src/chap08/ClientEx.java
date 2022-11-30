package chap08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {

		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;

		Scanner scanner = new Scanner(System.in);

		try {
			socket = new Socket("localhost", 9999);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {

				System.out.println("클라이언트> ");
				String outMsg = scanner.nextLine();
				out.write(outMsg + "\n");
				out.flush();

				if (outMsg.equalsIgnoreCase("bye")) {
					System.out.println("연결을 종료합니다.");
					break;
				}
				String inMsg = in.readLine();
				System.out.println("서버$ " + inMsg);

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if (socket != null)
					socket.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
