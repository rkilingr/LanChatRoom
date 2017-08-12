package Client;

public class ClientBuilder {
private String currentHost;
private int currentPort;
private String clientID;
public ClientBuilder setHost(String host) {
	currentHost=host;
	return this;
}
public ClientBuilder setPort(int port) {
	currentPort=port;
	return this;
}
public ClientBuilder setClientID(String ID) {
	clientID=ID;
	return this;
}
public Client build() {
	return new Client(currentHost,currentPort,clientID);
}
}
