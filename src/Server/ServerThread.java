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
private String serverThreadName;
	public ServerThread(Socket socket,int ID) {
		// TODO Auto-generated constructor stub
		currentSocket	= socket;
		serverThreadID	= ID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			in					= new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));
			out					= new PrintWriter(currentSocket.getOutputStream(),true);
			out.println("Enter your Network NickName:\t");
			serverThreadName	= in.readLine();
			Server.getClients().put(serverThreadName, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Client with ID:"+serverThreadID+" has trouble communicating");
			e.printStackTrace();
		}				
		for(ServerThread client:Server.getClients().values()) 
			client.getWriter().println("\t\t\t"+serverThreadName+" is Online");
			
		while(!currentSocket.isClosed()) {
			String input	= null;
			try {

				input = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(input.equalsIgnoreCase("Bye")) {
				Server.getClients().remove(serverThreadName);
				try {
					currentSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(input!=null) {
				
				for(ServerThread client:Server.getClients().values()) {
					if(!client.serverThreadName.equals(this.serverThreadName))
						client.getWriter().println(serverThreadName+":"+input);
					else

						client.getWriter().println("Yourself:"+input);
				}
			}
		}
	}
	public PrintWriter getWriter() {
		return out;
	}

}
