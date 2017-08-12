package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class ServerThread implements Runnable {
private Socket currentSocket;
private BufferedReader in;
private PrintWriter out;
private int serverThreadID;
	public ServerThread(Socket socket,int ID) {
		// TODO Auto-generated constructor stub
		currentSocket=socket;
		serverThreadID=ID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			out=new PrintWriter(currentSocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Client with ID:"+serverThreadID+" has trouble communicating");
			e.printStackTrace();
		}
		
		while(!currentSocket.isClosed()) {
			String input = null;
			try {
				input = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(input!=null)
				for(ServerThread client:Server.getClients()) {
					client.getWriter().write(input);
				}
		}
	}
	public PrintWriter getWriter() {
		return out;
	}

}
