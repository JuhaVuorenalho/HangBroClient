import java.net.*;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Client
{
	static BufferedReader input;
	static Socket clientSocket;
	static PrintWriter clientOut;
	static BufferedReader inFromServer;
    static BufferedReader inFromUser;
	
	public static void main(String[] args)
	{
//User enters the main lounge. Option: to join existing game--------------------------------------------------------
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
//--------------------------Main lounge above----------------------------------------------------------------------------------------
// Enters Game lounge.Options: start game--------------------------------------------------------------------------------------------	
	static void gameLounge() throws IOException {
		//nickname being created---------------------
		Scanner input = new Scanner(System.in);
		String nickname = "";//the nickname chosen
		 String s = "";
		 try {
             nickname = input.nextLine(); //reads the nickname
             clientOut.println(nickname);
        //-------------------------------------------

             //gameRunning = true;
         } catch (Exception e){}
		// Introduction to the game lounge
		System.out.println("---------------------------------------------------------------");
		System.out.println("Welcome to the game lounge! Here you can see all players who have joined \n Wait here until someone starts the game. Type \"start\" if you want the game to start :)");
		System.out.println("---------------------------------------------------------------");
		// display when a new client joins
		
		//If the user inputs the "start" command the server should receive this and start the game on all clients. 
		
		startGame();
	}
	
// A chat?
	static void chatHandler() throws IOException
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
				//System.out.println("this was sent: " + s);
				//This does not really work
				//chatHandler();
			}
	}
	
// The game starts. Options: enter letter -------------------------------------------------------------------------------------------
	
	static void startGame() throws IOException {
	// send to server to startGame on all Clients. 
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("---------------------------------------------------------------");
		System.out.println("The game has begun! May the odds be ever in your favor!");
		System.out.println("---------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------");
		System.out.println("In order to win the game, you have to guess letters of the word \n If you type the incorrect letter you lose a life");
		System.out.println("---------------------------------------------------------------");
		//Receive number of lives from server
		//Receive word in underscores
	
		
		String string = null;
		boolean gameRunning = false;
		//receiving string from server---------------------------------------
				  try {

		                inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		            } catch (Exception e){
		                e.printStackTrace();
		            }
		            do {
		                try {
		  //receive from server---------------------------------------------
		                	//READ STRING AND GAMESTATE FROM SERVER! Currently working on it
		                    while(inFromServer.ready() && (string = inFromServer.readLine()) != null) {
		                        if(string.equals("*") || string.equals(" -> ") || string.length() == 1) {
		                            System.out.print(string);
		                        } else {
		                            System.out.print("\n" + string);
		                        }
		                    }
		 //sending to server-------------------------------------------------
		                    inFromUser = new BufferedReader( new InputStreamReader(System.in));
		                    char i = inFromUser.readLine().charAt(0);
		                    System.out.println(i);
		                    clientOut.println(i);
		                    
		                } catch (Exception e){}
		            } while(gameRunning);
		            
		// Deal with gameState received from server--------------------------
		            int gameState = 0;
				
	        
				//display String
				//process gameState
				int i = 0; // int for wether game continues or not
				if (i==0) {
				// ending game
				}
				else {// game continues
					gameStateFromServer(gameState);
				}
		}

	
// GameStates. --------------------------------------------------------------------------------------------------------------------

	
	public static void gameStateFromServer(int state) {
	    
		try {
			
			//Instantiate a BufferedInputStream object for reading
		    //Instantiate a BufferedInputStream object for reading incoming socket streams
			
			BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
			
			//Instantiate an InputStreamReader with the optional character encoding
			
			InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
			state = isr.read();
			
		} catch (IOException e) {}
  
	
		String stateString = null;
		
		switch (state) {
       
        case 1:  stateString = "Congratulations Bro, you won!";
        	//End server after 10 seconds
        	//	 gameLounge();
                 break;
                 
        case 2:  stateString = "Bad news Bro, you lost. Better luck next time!";
        	//End server after 10 seconds
        	//	 gameLounge();
                 
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
        	//End server after 10 seconds
        	//	 gameLounge();
                 break;
		}
		
		System.out.println(stateString);
	}
	
}


