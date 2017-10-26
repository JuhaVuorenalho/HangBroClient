import java.net.Inet4Address;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//This is a testing line
//Push it
//Hack

public class Server
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();;
	
		try
		{
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
			//executor.submit(new SocketHandler(serverSocket.accept()));
			//Socket s = serverSocket.accept();
			Socket s = serverSocket.accept();



			System.out.println("Bro with ip adress:" + Inet4Address.getLocalHost().getHostAddress() + " has joined the game");//this has to display "Client x has joined the server" in the client.

		
			serverSocket.close();
		} catch (Exception e) {
			
			System.out.println(e.toString());
			

		}
		
	}
}
