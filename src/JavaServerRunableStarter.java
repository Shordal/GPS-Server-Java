import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class JavaServerRunableStarter implements Runnable {
	
	int portNumber;
	ServerSocket serverSocket2;
	public String[] Table;
	private HashFunction theFunction;

	
	public JavaServerRunableStarter(int portNumber, ServerSocket serverSocket2, String[] Table, HashFunction theFunction) {
		// TODO Auto-generated constructor stub
		this.portNumber = portNumber;
		this.serverSocket2 = serverSocket2;
		this.Table = Table;
		this.theFunction = theFunction;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		
		int T = 3;
		
		while(T>0){
			
			Socket clientSocket = serverSocket2.accept();	
			new Thread(new JavaServerRunable(clientSocket,Table,theFunction)).start();
		}
		
	}catch(IOException e){
		e.printStackTrace();
	}

}
}
