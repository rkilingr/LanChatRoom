
public interface LanChatRoomIntf {
	
	public void setServer(String host,int port);

	public void setClientConnection(String ID);
	
	public String[] getConnection();
	
	public void sendMessage(String msg);
	
	public String receiveMessage();
	
}
