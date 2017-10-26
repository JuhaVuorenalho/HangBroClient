import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//This is a testing line
//Push it
//Hack

public class Server
{
	static Socket clientSocket;
	static ServerSocket serverSocket;
	
	public static void main(String[] args)
	{
		try
		{
			serverSocket = new ServerSocket(3000);
			System.out.println("IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
			//executor.submit(new SocketHandler(serverSocket.accept()));
			//Socket s = serverSocket.accept();
			clientSocket = serverSocket.accept();

			System.out.println("Bro with ip adress:" + Inet4Address.getLocalHost().getHostAddress() + " has joined the game");//this has to display "Client x has joined the server" in the client.

			chatReceiver();

			serverSocket.close();
		} catch (Exception e) {
			
			System.out.println(e.toString());
			

		}
		
	}
	
	static void chatReceiver()
	{
		try 
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			if(Objects.equals(in.readLine(), "close"))
				serverSocket.close();
			
			System.out.println(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chatReceiver();
	}
}
