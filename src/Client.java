import java.net.*;

//So is this
public class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket clientSocket = new Socket ("127.0.0.1", 3000);
			System.out.println("Connected to server");
		} catch (Exception e) {}
	}
}
