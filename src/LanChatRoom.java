import java.io.IOException;
import java.net.BindException;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;

import Client.Client;
import Client.ClientBuilder;
import Server.Server;
import Server.ServerBuilder;

public class LanChatRoom{
private Server 	currentServer;
private String 	currentHost;
private int 	currentPort;
private Client 	currentClient;
	public LanChatRoom(String host, int port) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Initializing Server....");
		currentHost			= host;
		currentPort			= port;
		try {
		currentServer		= new ServerBuilder().setHost(host).setPort(port).build();
		Thread serverThread	= new Thread(currentServer);
		serverThread.start();
		}catch(BindException e) {
			System.out.println("Server already Present");
		}
	}

	public void setClientConnection() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		currentClient	= new ClientBuilder().setHost(currentHost).setPort(currentPort).build();
		currentClient.start();
	}

	public String[] getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendMessage(String msg) throws InterruptedException {
		// TODO Auto-generated method stub
		Client.putMessagetoSQueue(msg);
	}

	public String receiveMessage() throws InterruptedException {
		// TODO Auto-generated method stub
		String msg	= Client.getMessageFromRQueue();
		return msg;
	}

	
}
