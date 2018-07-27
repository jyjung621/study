package p15.tcp_networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			//	bind : ServerSocket의 ip address, port 할당
			serverSocket.bind(new InetSocketAddress("192.168.20.27", 5001));
			//	client가 서비스 요청하는 것을 기다리는 것(무한 loop)
			while (true) {
				System.out.println("[연결 기다림]");
				//	client가 server에 server의 ip주소와 port번호를 이용하여
				//	요청하면 accept 메소드는 client가 요청한 ip 주소와 port번호가
				//	본인 서버의 ip 주소와 port번호와 동일하면 return 값으로
				//	socket이라는 instance를 만들어줌
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함]" + isa.getHostName());
			}
		} catch (Exception e) {
		}

		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {

			}
		}
	}
}
