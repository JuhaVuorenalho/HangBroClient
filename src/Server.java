import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class Server {

    static Gamelounge gameLounge = new Gamelounge();
    static ServerThreadCl handler;

    public static void main(String[] args) throws Exception {
        try {

            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("IP address: " + Inet4Address.getLocalHost().getHostAddress());  //The IP address user should connect to

            while(true) {
                //before gamelounge is initialized, setting up clients
                System.out.println("Listening!");
                Socket client = serverSocket.accept();//server waits for clients to establish connection
                System.out.println("A CLIENT CONNECTED");

                handler = new ServerThreadCl(client);
                handler.start();
            }

        /*
        //Server connection fix thing
        while (true) {

            //before gamelounge is initialized, setting up clients
            System.out.println("Listening!");
            while(!gameLounge.areClientsReady) {
                Socket client = serverSocket.accept();//server waits for clients to establish connection
                System.out.println("A CLIENT CONNECTED");
                handler = new ServerThread(client);
                // handler.start() might have to be moved out of while-loop
                handler.start();


            }

                //when all clients have typed start it should stop the listening loop and jump to game (handler.start)
*/




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
			
			

			
	        //System.out.println(din.readInt());
			//This does not really work yet
			//chatReceiver();
			while(true)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println("in.readLine = " + in.readLine());
				System.out.println("in.read = " + in.read());
				System.out.println("in.toString = " + in.toString());
				
				if(Objects.equals(in.toString(), "l"))
					System.out.println("you lost");
				
				//if(gamestate == 1 || gamestate == 2)
				//serverSocket.close();
				
				//To send gamestate int to the client, the receiver is missing still from the client
				int gameState = 0;		
				PrintWriter serverOut = null;
				try {
					serverOut = new PrintWriter(clientSocket.getOutputStream(), true);
				} catch (IOException e) {}
				serverOut.println(gameState);
			}
			
			
			
			
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
	
	void commands() {
		try {
		String command = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		switch (command) {
		case "start":
			//gameStart();
		break;
		case ".*123":
			// check if the character matches a letter in the word. 
		break;
		}
		}catch (IOException e) {
		e.printStackTrace();	
		}
		chatReceiver();
	}
>>>>>>> c28c84365beab70134f38d26ad8fdb9f4dd5bec8
}

