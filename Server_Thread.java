package paket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Server_Thread implements Runnable{

	private Socket socket; 
	private ServerMain server;
	
	public Server_Thread(Socket socket, ServerMain server) {
		this.socket = socket;
		this.server = server;
	}
	@Override
	public void run() {

		try {
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			String message;
		
			String konacno = null;
		

			while(true) {
				
				out_socket.println("Dobrodosli");
				message = in_socket.readLine();
	
				if(message.equalsIgnoreCase("kraj")) {
					
					socket.close();
					break;
				}

				String[] niz = message.split(",");
				for(int i=0;i <niz.length; i++) {
					if(i==0) {
						konacno = niz[i].toUpperCase();
						konacno = konacno.concat(",");
					}
				 else if(i%2==0) {
					 	String str = niz[i].toUpperCase();
						konacno = konacno.concat(str);
						konacno = konacno.concat(",");
					}
					else {
						konacno = konacno.concat(niz[i]);
						konacno = konacno.concat(",");
					}
				}

				
				out_socket.println(konacno);
			

				

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}