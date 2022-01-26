package paket;

import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {
	
	public ServerMain() throws Exception{
		int port = 106 % 24 + 2000;
		
		ServerSocket ss = new ServerSocket(port);
		
		while(true) {
			Socket socket = ss.accept();
			Server_Thread server_thread = new Server_Thread(socket, this);
			Thread thread = new Thread(server_thread);
			thread.start();
		}
	}
	public static void main(String[] args) {
		try {
			new ServerMain();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}