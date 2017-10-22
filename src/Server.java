import java.net.ServerSocket;
import java.net.Socket;

//This is a testing line

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(3000);
			Socket s = serverSocket.accept();

			System.out.println("Bro has connected");
		
		} catch (Exception e) {}
	}
}
