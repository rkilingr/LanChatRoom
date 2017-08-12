package Server;

import java.io.IOException;

public class ServerBuilder {
private String currentHost=null;
private int currentPort=4444;
public ServerBuilder setHost(String host) {
	currentHost=host;
	return this;
}
public ServerBuilder setPort(int port) {
	currentPort=port;
	return this;
}
public Server build() throws IOException {
	return new Server(currentHost,currentPort);
}
}
