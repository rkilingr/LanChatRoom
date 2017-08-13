package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;

public class ClientReceiverThread implements Runnable {
	private Socket 				serverSocket;
	private PrintWriter 		out;
	private BufferedReader 		in;
	public 	ClientReceiverThread(Socket socket) {
		// TODO Auto-generated constructor stub
		serverSocket	= socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String input=null;
		try {
			out	= new PrintWriter(System.out,true);
			in	= new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!serverSocket.isClosed()) {
			try {
				input	= in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			if(input!=null)
				try {
					Client.putMessagetoRQueue(input);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
