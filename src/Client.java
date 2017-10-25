import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client
{
	public static void main(String[] args)
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Welcome to HangBro! Type \"connect\" if you want to join a game :)");
		System.out.println("---------------------------------------------------------------");
		
		String s = "";
		String IPAdress = "";
		
		//Wait for user input
		try {
			s = input.readLine();
		} catch (IOException e1) {}
		
		if(s== "connect") {
			System.out.println("Write the ip you want to connect to");
			//Wait for user input
			try {
				IPAdress = input.readLine();
			} catch (IOException e1) {}
			
		}
		else {
			System.out.println("Wrong command!");
		}
			
		
		try
		{
			Socket clientSocket = new Socket (IPAdress, 3000); //Request permission to the IP address
			clientSocket.bind(new InetSocketAddress("ServerIP", 3000)); //Juha's test
			System.out.println("Connected to server");
			System.out.println("Bro, you are connected to the IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
		} catch (Exception e) {}
		
		System.out.println("Connection was closed, or program failed to connect");
	}
	void clientHasJoined() {
		
		
		
		
	}
	void startGame() {
		//Check if the user input fits any of the predetermined commands
				/*switch(s)
				{
					case "start": System.out.println("Starting the server!"); // not an option
						break;
					case "connect": System.out.println("Write the ip you want to connect to");
							//Wait for user input
							try {
								IPAdress = input.readLine();
							} catch (IOException e1) {}
						break;
					default: System.out.println("Wrong command!");*/
				}		
				
		
	}


