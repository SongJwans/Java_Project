package chap08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;

		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);

		try {
			listener = new ServerSocket(9999);

			System.out.println("클라이언트를 대기 중입니다.");
			socket = listener.accept();

			System.out.println("클라이언트와 연결됐습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String inMsg = in.readLine();
				if (inMsg.equalsIgnoreCase("bye")) {
					System.out.println("연결을 종료합니다.");
					break;
				}
				System.out.println("클라이언트$ " + inMsg);
				System.out.println("서버> ");
				String outMsg = scanner.nextLine();
				out.write(outMsg + "\n");
				out.flush();

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				socket.close();
				listener.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
