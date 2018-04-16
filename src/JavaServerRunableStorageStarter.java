import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerRunableStorageStarter implements Runnable {
	
	ServerSocket serverSocket2;
	
	protected String msg;
	protected DatagramPacket packet;
	protected byte[] buffer;
	int N = 2;
	boolean running = false;
	int portNumber;
	
	protected DatagramSocket dsocket;
	
	
	HashFunction theFunction;
	String name, itemsInArray, x;
	
	public String[] Table;
	
	int time, arraySize;

	public JavaServerRunableStorageStarter(ServerSocket serverSocket2, int portNumber, DatagramSocket dsocket, byte[] buffer, DatagramPacket packet, String msg, String[] Table, int arraySize, String itemsInArray, HashFunction theFunction) {
		
		this.portNumber = portNumber;
		this.msg = msg;
		this.packet = packet;
		this.buffer = buffer;
		this.theFunction = theFunction;
		this.Table = Table;
		this.itemsInArray = itemsInArray;
		this.arraySize = arraySize;
		this.dsocket = dsocket;
		
		
	}

	@Override
	public void run() {

		
		while(N>0){
			
			try {

		String msg = new String(buffer, 0, packet.getLength());

			dsocket.receive(packet);

		new Thread(new JavaServerRunableStorage(buffer, packet, msg, Table, arraySize, itemsInArray, theFunction)).start();
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		}
	}

}
