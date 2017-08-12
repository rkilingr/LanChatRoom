import java.io.IOException;

import Server.Server;
import Server.ServerBuilder;

public class LanChatRoom implements LanChatRoomIntf{
private Server currentServer=null;
	@Override
	public void setServer(String host, int port) {
		// TODO Auto-generated method stub
		try {
			currentServer=new ServerBuilder().setHost(host).setPort(port).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not listen through port:"+port);
			e.printStackTrace();
		}
	}

	@Override
	public void setClientConnection(String ID) {
		// TODO Auto-generated method stub
		
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
