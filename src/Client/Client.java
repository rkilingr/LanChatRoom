package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;

public class Client {
private String 								currentHost;
private int 								currentPort;
private ClientReceiverThread 				receiver	= null;
private ClientSenderThread 					sender		= null;
private static ArrayBlockingQueue<String> 	sendingMsgQueue;
private static ArrayBlockingQueue<String> 	receivingMsgQueue;
	public Client(String host, int port) {
		// TODO Auto-generated constructor stub
		currentHost=host;
		currentPort			=port;
		sendingMsgQueue		=new ArrayBlockingQueue<>(20);
		receivingMsgQueue	=new ArrayBlockingQueue<>(20);
	}
	public void start() throws UnknownHostException, IOException {
		Socket socket=new Socket(currentHost,currentPort);
		receiver	= new ClientReceiverThread(socket);
		sender		= new ClientSenderThread(socket);
		new Thread(receiver).start();
		new Thread(sender).start();
	}
	
	public static String getMessageFromSQueue() throws InterruptedException {
		String 	msg = sendingMsgQueue.take();
		
		return msg;
	}
	
	public static void putMessagetoSQueue(String msg) throws InterruptedException {
		
		sendingMsgQueue.put(msg);
	}
	
	public static void putMessagetoRQueue(String msg) throws InterruptedException {
		receivingMsgQueue.put(msg);
	}
	
	public static String getMessageFromRQueue() throws InterruptedException {
		String 	msg = receivingMsgQueue.take();

		return msg;
	}
	
}
