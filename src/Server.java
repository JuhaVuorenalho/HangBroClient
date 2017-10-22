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
			Socket s = serverSocket.accept();

			System.out.println("IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
		
			serverSocket.close();
		} catch (Exception e) {}
		
		System.out.println("I'm the server!");
	}
}
