import java.io.IOException;

import Client.Client;
import Client.ClientBuilder;
import Server.Server;
import Server.ServerBuilder;

public class LanChatRoom implements LanChatRoomIntf{
private Server currentServer;
private String currentHost;
private int currentPort;
private Client currentClient;
	@Override
	public void setServer(String host, int port) throws IOException {
		// TODO Auto-generated method stub
		
		currentHost=host;
		currentPort=port;
		currentServer=new ServerBuilder().setHost(host).setPort(port).build();
		
	}

	@Override
	public void setClientConnection(String ID) {
		// TODO Auto-generated method stub
		currentClient=new ClientBuilder().setHost(currentHost).setPort(currentPort).build();
	}

	@Override
	public String[] getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String receiveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
