import java.net.*;


public class Server {

	public static void main(String[] args) {
		
		try {
		ServerSocket server = new ServerSocket(3000);
		Socket s = server.accept();
		
		
		System.out.println("Bro has connected");
		
			} catch (Exception e) {}
	}

}
