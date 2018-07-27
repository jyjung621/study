package p15.tcp_networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			//	server에게 요청하기 위해 먼저 socket instance를 생성
			socket = new Socket();
			System.out.println("[연결 요청]");
			//	server에게 연결을 요청
			//	(server의 ip address, port번호를 사용해서)
			//socket.connect(new InetSocketAddress("localhost", 5001));
			socket.connect(new InetSocketAddress("192.168.20.109", 5001));
			System.out.println("[연결 성공]");

		} catch (Exception e) {

		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e1) {

			}
		}
	}
}
