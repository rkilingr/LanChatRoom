package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
private String currentHost;
private int currentPort;
private ServerSocket serverSocket;
	public Server(String host, int port) throws IOException {
		// TODO Auto-generated constructor stub
		currentHost=host;
		currentPort=port;
		serverSocket=null;
		
		serverSocket=new ServerSocket(port);
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
