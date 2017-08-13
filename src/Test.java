import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanChatRoom 	lanChatRoom		= null;
		Scanner 		in				= new Scanner(System.in);
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			if(args.length!=0)
				lanChatRoom		= new LanChatRoomBuilder().setHost(args[0]).setPort(Integer.parseInt(args[1])).build();
			else
				lanChatRoom		= new LanChatRoomBuilder().setHost(InetAddress.getLocalHost().getHostName()).setPort(5000).build();
			lanChatRoom.setClientConnection();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final LanChatRoom lanChatRoom2	= lanChatRoom;
		
		//Sender Thread
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					try {
						lanChatRoom2.sendMessage(in.nextLine());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();
		
		//Receiver thread
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					try {
						System.out.println(lanChatRoom2.receiveMessage());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();
	}

}
