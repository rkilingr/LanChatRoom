package Server;

public class ServerBuilder {
private String currentHost=null;
private String currentPort=null;
public ServerBuilder setHost(String host) {
	currentHost=host;
	return this;
}
public ServerBuilder setPort(String port) {
	currentPort=port;
	return this;
}
public Server build() {
	return new Server(currentHost,currentPort);
}
}
