import Server.Server;
import Server.ServerBuilder;

public class LanChatRoom implements LanChatRoomIntf{
private Server currentServer=null;
	@Override
	public void setServer(String host, String port) {
		// TODO Auto-generated method stub
		currentServer=new ServerBuilder().setHost(host).setPort(port).build();
	}

	private void currentServer(String host, String port) {
		// TODO Auto-generated method stub
		
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
