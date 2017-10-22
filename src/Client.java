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
		System.out.println("Welcome to HangBro! Type \"start\" if you want to make a server or \"connect\" if you have friends :)");
		System.out.println("---------------------------------------------------------------");
		
		String s = "";
		String IPAdress = "";
		
		//Wait for user input
		try {
			s = input.readLine();
		} catch (IOException e1) {}
		
		//Check if the user input fits any of the predetermined commands
		switch(s)
		{
			case "start": System.out.println("Starting the server!");
				break;
			case "connect": System.out.println("Write the ip you want to connect to");
					//Wait for user input
					try {
						IPAdress = input.readLine();
					} catch (IOException e1) {}
				break;
			default: System.out.println("Wrong command!");
		}		
		
		try
		{
			Socket clientSocket = new Socket (IPAdress, 3000); //Request permission to the IP address
			System.out.println("Connected to server");
			System.out.println("Bro, you are connected to the IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
		} catch (Exception e) {}
		
		System.out.println("Connection was closed, or program failed to connect");
	}
}
