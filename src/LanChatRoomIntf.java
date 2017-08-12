import java.io.IOException;

public interface LanChatRoomIntf {
	
	public void setServer(String host,int port) throws IOException;

	public void setClientConnection(String ID);
	
	public String[] getConnection();
	
	public void sendMessage(String msg);
	
	public String receiveMessage();
	
}
