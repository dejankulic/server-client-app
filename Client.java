package paket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception{
		
		int port = 106 % 24 + 2000;
		Socket socket = new Socket("localhost", port);
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner tastatura = new Scanner(System.in);
		String message;
	
		message = in_socket.readLine();
		System.out.println("[Server]: " + message);

		
		String poruka;
		while(true) {
			message = tastatura.nextLine();
	
			if(message.equalsIgnoreCase("kraj")) {
				out_socket.println("kraj");
				socket.close();
			
				break;
			}
			
				out_socket.println(message);
					
			poruka = in_socket.readLine();
			System.out.println(poruka);
		}
	
	}

		
	public static void main(String[] args) {
		try {
			new Client();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

