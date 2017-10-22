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

			System.out.println("Bro has joined");//this has to display "Client x has joined the server" in the client.
		
			serverSocket.close();
		} catch (Exception e) {}
		
		System.out.println("I'm the server!");
	}
}
