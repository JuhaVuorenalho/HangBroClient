import java.net.*;
import java.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class Client
{
	static Socket clientSocket;
	
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
		if(Objects.equals(s, "connect")) {
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
			//clientSocket = new Socket (IPAdress, 3000); //Request permission to the IP address
			clientSocket = new Socket ("localhost", 3000); //Request permission to the IP address
			System.out.println("Connected to server");
			System.out.println("Bro, you are connected to the IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user connected to
			
			gameLounge();
		} catch (Exception e) {}
		
		System.out.println("Connection was closed, or program failed to connect");
	}
	
	static void gameLounge() {	
		// Introduction to the game lounge
		System.out.println("---------------------------------------------------------------");
		System.out.println("Welcome to the game lounge! Here you can see all players who have joined \n Wait here until someone starts the game. Type \"start\" if you want the game to start :)");
		System.out.println("---------------------------------------------------------------");
		// display when a new client joins
		
		//If the user inputs the "start" command
		chatHandler();
	}
	
	
	static void chatHandler()
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		
		try {
			s = input.readLine();
		} catch (IOException e1) {
			System.out.println(e1.toString());
		}
		
		if(s== "start") {
			startGame(); // the game should start	
			} else {
				PrintWriter clientOut = null;
				try {
					clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
				} catch (IOException e) {}
				clientOut.println(s);
				chatHandler();
			}
	}
	
	static void startGame() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("---------------------------------------------------------------");
		System.out.println("The game has begun! May the odds be ever in your favor!");
		System.out.println("---------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------");
		System.out.println("In order to win the game, you have to guess letters of the word \n If you type the incorrect letter you lose a life");
		System.out.println("---------------------------------------------------------------");
		//Receive number of lives from server
		//Receive word in underscores
				String s="";
				try {
					s = input.readLine();
				} catch (IOException e1) {}// send this to server for computation
		// Receive from server if letter is correct or not
				//Receive indication to wether game continues or not
				//Get the return message from the server
				 
	        
				int i = 0;// int for wether game continues or not
				if (i==0) {
				endGame();	// ending game
				}
				else {// game continues
				//Receive number of lives from server
				//Receive word in underscores
				}		
	}
	
	static void endGame() {
	// 	
		
	}
	
	public static void gameStateFromServer(String[] args) {
	
		 //Instantiate a BufferedInputStream object for reading
	     //Instantiate a BufferedInputStream object for reading incoming socket streams
	      

	     BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
	     
	     //Instantiate an InputStreamReader with the optional character encoding
	       

	     InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
	      
	    int state;  
		state = (Integer.parseInt(Reader.readLine()
		
		String stateString = null;
		
		switch (state) {
       
        case 1:  stateString = "Congratulations Bro, you won!";
        		 endGame();
        		 gameLounge();
                 break;
                 
        case 2:  stateString = "Bad news Bro, you lost. Better luck next time!";
        		 endGame();
        		 gameLounge();
        		 break;
                 
        case 3:  stateString = "Bro, you dead :(    "
        		+ "____\r\n" + 
        		"  |    |      \r\n" + 
        		"  |    o      \r\n" + 
        		"  |   /|\\     \r\n" + 
        		"  |    |\r\n" + 
        		"  |   / \\ \r\n" + 
        		" _|_\r\n" + 
        		"|   |______\r\n" + 
        		"|          |\r\n" + 
        		"|__________|\r\n" + 
        		"";
        		 endGame();
        		 gameLounge();
                 break;
		}
		
		System.out.println(stateString);
	}
	
}


