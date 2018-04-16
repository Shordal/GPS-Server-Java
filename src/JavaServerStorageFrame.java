import java.awt.Frame;
import java.util.*;

public class JavaServerStorageFrame implements Runnable {
	
	String name, itemsInArray, x;
	
	public String[] Table; 
	
	int time, arraySize;

	Random r = new Random();
	
	HashFunction theFunction;
	
	
	public JavaServerStorageFrame (String x, String[] Table, int arraySize, String itemsInArray, HashFunction theFunction) {
		name = x;
		time = r.nextInt(9999);
		this.theFunction = theFunction;
		
	}
	
	
	
	public void run(){
		
		try{
			
			
			System.out.printf("\n%s is sleeping for %d.\n", name, time);
			
			Thread.sleep(time);
			
			System.out.printf("\n%s is done\n", name);
			
		}catch(Exception e){}
	}

}