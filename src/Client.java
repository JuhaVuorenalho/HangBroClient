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
		// if they write connect
		if(s== "connect") {
			System.out.println("Write the ip you want to connect to");// then write an IP address
			//Wait for user input
			try {
				IPAdress = input.readLine(); //Read the IP address 
				
				//connect to the IP address given. 
			} catch (IOException e1) {}
			
		}
		else {
			System.out.println("Wrong command!");
		}
			
		
		try
		{
			Socket clientSocket = new Socket (IPAdress, 3000); //Request permission to the IP address
			System.out.println("Connected to server");
			System.out.println("Bro, you are connected to the IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			// join gameLounge()
		} catch (Exception e) {}
		
		System.out.println("Connection was closed, or program failed to connect");
	}
	void gameLounge() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// Introduction to the game lounge
		System.out.println("---------------------------------------------------------------");
		System.out.println("Welcome to the game lounge! Here you can see all players who have joined \n Wait here until someone starts the game. Type \"start\" if you want the game to start :)");
		System.out.println("---------------------------------------------------------------");
		// display when a new client join
		
		String s = "";
		try {
			s = input.readLine();
		} catch (IOException e1) {}
		//If the user inputs the "start" command
		if(s== "start") {
		startGame(); // the game should start	
		}
	}
	void startGame() {
		
		System.out.println("YO it works");
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


