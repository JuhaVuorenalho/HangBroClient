import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		
		try {
			
		serverSocket = new ServerSocket(3000);
		Socket s = server.accept();
		
		
		System.out.println("Bro has connected");
		
			} catch (Exception e) {}
	}

}
