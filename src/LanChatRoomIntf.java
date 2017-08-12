
public interface LanChatRoomIntf {
	
	public void setServer(String host,String port);

	public void setClientConnection(String ID);
	
	public String[] getConnection();
	
	public void sendMessage(String msg);
	
	public String receiveMessage();
	
}
