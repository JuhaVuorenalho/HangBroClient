import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

//This is a testing line
//Push it

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
			Socket s = serverSocket.accept();
		
			serverSocket.close();
		} catch (Exception e) {}
		
		System.out.println("I'm the server!");
	}
}
