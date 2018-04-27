import java.net.DatagramPacket;

public class JavaServerRunableStorage implements Runnable{

	protected String msg; 
	
	protected DatagramPacket packet;
	
	protected byte[] buffer;
	
	int N = 2;
	
	boolean running = false;
	
	HashFunction theFunction;
	
	String name, itemsInArray, x;
	
	public String[] Table;
	
	int time, arraySize;
	
	public JavaServerRunableStorage(byte[] buffer, DatagramPacket packet, String msg,String[] Table, int arraySize, String itemsInArray, HashFunction theFunction) {
		
		this.msg = msg;
		
		this.packet = packet;
		
		this.buffer = buffer;
		
		this.Table = Table;
		
		this.arraySize = arraySize;
		
		this.itemsInArray = itemsInArray;
		
		this.theFunction = theFunction;

	}
	
	public void run() {

		try{
			
			while(N>1){
			
			System.out.println("Received Message: " + msg);
			
			String fullString = msg;
			
			String elementstoAdd2 = fullString;
						
			theFunction.FrameHash3(elementstoAdd2, theFunction.Table);
			
			
			theFunction.DisplayHash2();
			
			N = 0;
			
			}
			
		}catch (Exception e){}
		
	}
	
}
