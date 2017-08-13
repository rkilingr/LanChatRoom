package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSenderThread implements Runnable{
	private Socket 				serverSocket;
	private PrintWriter 		out;
	private BufferedReader 		in;
	public ClientSenderThread(Socket socket) {
		// TODO Auto-generated constructor stub
		serverSocket	= socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String input=null;
		try {
			out	= new PrintWriter(serverSocket.getOutputStream(),true);
			in	= new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!serverSocket.isClosed()) {
			try {
				input	= Client.getMessageFromSQueue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(input!=null)
				out.println(input);
		}
		
	}

}
