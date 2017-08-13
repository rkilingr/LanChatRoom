package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server implements Runnable{
private String currentHost;
private int currentPort;
private ServerSocket serverSocket;
private static HashMap<String,ServerThread> serverThreads;
	public Server(String host, int port) throws IOException {
		// TODO Auto-generated constructor stub
		currentHost		= host;
		currentPort		= port;
		serverSocket	= null;
		serverSocket	= new ServerSocket(port);
		serverThreads	= new HashMap<>();
		
	}
	public static HashMap<String, ServerThread> getClients(){
		return serverThreads;
	}
	public void acceptClients() throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			try {

				System.out.println("Accepting clients....");
				Socket 			socket			= serverSocket.accept();

				System.out.println("Client Accepted....");
				ServerThread 	serverThread	= new ServerThread(socket,serverThreads.size()+1);
				new Thread(serverThread).start();
			}
			catch(NullPointerException e) {
				System.out.println("Client not connected");
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Initializing Server....");
		try {
			acceptClients();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
