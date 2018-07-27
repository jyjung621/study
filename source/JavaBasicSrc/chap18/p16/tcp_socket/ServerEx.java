package p16.tcp_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while (true) {
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함]" + isa.getHostName());

				byte[] bytes = null;
				String message = null;

				//	InputStream 인스턴스인 is가 필요한 이유는
				//	client에서 네트워크를 통해 데이터를 보낸 것을
				//	read하기 위해서 임
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				//	read하면, client에서 보낸 데이터를 가져옴
				int readByteCount = is.read(bytes);
				//	String을 통해 utf-8로 decoding하여
				//	바이트 배열을 문자열로 변환함
				message = new String(bytes, 0, readByteCount, "utf-8");
				System.out.println("[데이터 받기 성공] : " + message);

				//	서버에서 클라이언트로 문자를 보내기 위해
				//	OutputStream instance인 os를 가져옴
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				//	string인 message를 utf-8로 encoding하여
				//	byte배열로 변환(bytes)
				bytes = message.getBytes("utf-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");

				is.close();
				os.flush();
				//	socket.close()를 하여 메모리에서 제거시킴
				socket.close();
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
