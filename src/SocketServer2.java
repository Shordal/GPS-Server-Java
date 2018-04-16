import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer2 {
	int portNumber = 9099;
	ServerSocket serverSocket2 = null;
	
	HashFunction theFunction;
	String name, itemsInArray, x;
	
	public String[] Table;
	
	int time, arraySize, j;
	private String msg;
	
	public SocketServer2(String[] Table, int arraySize, String itemsInArray, HashFunction theFunction) {
		
		this.Table = Table;
		this.arraySize = arraySize;
		this.itemsInArray = itemsInArray;
		this.theFunction = theFunction;
		j = 5;
		
	}
		
	

	public void runServer() {
		try{
			
			serverSocket2 = new ServerSocket(portNumber);
			
			DatagramSocket dsocket = new DatagramSocket(portNumber);
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			
			
			int n = 1;
			
				new Thread( new JavaServerRunableStarter(portNumber, serverSocket2, Table,theFunction)).start();
				
				new Thread(new JavaServerRunableStorageStarter(serverSocket2, portNumber, dsocket, buffer, packet, msg, Table, arraySize, itemsInArray, theFunction)).start();
				
				//Cleanup thread for table
				new Thread(new JavaServerCleanUpTableStarter(theFunction, Table)).start();
				//Socket clientSocket = serverSocket2.accept();	
				
		} catch (IOException e) {
			System.err.println(e);
		
		}
		
		
	}
		}



