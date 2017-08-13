import java.io.IOException;

public class LanChatRoomBuilder {

private String currentHost;
private int currentPort;
	public LanChatRoomBuilder setHost(String host) {
		currentHost=host;
		return this;
	}
	public LanChatRoomBuilder setPort(int port) {
		currentPort=port;
		return this;
	}
	public LanChatRoom build() throws IOException {
		return new LanChatRoom(currentHost,currentPort);
	}
}
