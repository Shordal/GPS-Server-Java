import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	int portNumber = 9099;
	
	ServerSocket serverSocket = null;
	
	
	public void runServer() {
		
		try{
			
			serverSocket = new ServerSocket(portNumber);
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		while (true){
			
			try{
				
				Socket clientSocket = serverSocket.accept();
				
				//old
				//new Thread(new JavaServerRunable(clientSocket)).start();
				//or
				//JavaServerRunable m = new JavaServerRunable(clientSocket);
				//new Thread(m).start();
				
			} catch (IOException ex) {
				
			System.out.println(ex.getMessage());
			
			}
			
		}

	}
	
}
