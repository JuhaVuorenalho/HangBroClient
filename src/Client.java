import java.net.*;

//So is this
public class Client
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to HangBro! Type \"start\" if you want to make a server or \"connect\" if you have friends :)");
		
		try
		{
			Socket clientSocket = new Socket ("127.0.0.1", 3000);
			System.out.println("Connected to server");
			System.out.println(Inet4Address.getLocalHost().getHostAddress());
		} catch (Exception e) {}
		
		System.out.println("I'm the client!");
	}
}
