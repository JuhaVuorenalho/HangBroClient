import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//So is tsadsdfasdf asld:D 
public class Client
{
	public static void main(String[] args)
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Welcome to HangBro! Type \"start\" if you want to make a server or \"connect\" if you have friends :)");
		System.out.println("---------------------------------------------------------------");
		
		String s = "";
		
		try {
			s = input.readLine();
		} catch (IOException e1) {}
		
		switch(s)
		{
			case "start": System.out.println("Starting the server!");
				break;
			case "connect": System.out.println("Write the ip you want to connect to");
				break;
			default: System.out.println("Wrong command!");
		}
		
		try
		{
			Socket clientSocket = new Socket ("127.0.0.1", 3000);
			System.out.println("Connected to server");
			System.out.println(Inet4Address.getLocalHost().getHostAddress());
		} catch (Exception e) {}
		
		System.out.println("Failed to connect or the connection was closed");
	}
}
