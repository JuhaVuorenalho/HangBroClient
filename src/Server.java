import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SocketHandler;

//This is a testing line
//Push it

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
			
			
			serverSocket.close();
		} catch (Exception e) {}
		
		System.out.println("I'm the server!");
	}
}
