package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
private String currentHost;
private int currentPort;
private ServerSocket serverSocket;
private static ArrayList<ServerThread> serverThreads;
	public Server(String host, int port) throws IOException {
		// TODO Auto-generated constructor stub
		currentHost=host;
		currentPort=port;
		serverSocket=null;
		
		serverSocket=new ServerSocket(port);
		
	}
	public static ArrayList<ServerThread> getClients(){
		return serverThreads;
	}
	public void acceptClients() throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			Socket socket=null;
			socket=serverSocket.accept();
			ServerThread serverThread=new ServerThread(socket,serverThreads.size()+1);
			Thread thread=new Thread(serverThread);
			thread.start();
			serverThreads.add(serverThread);
		}
	}

}
