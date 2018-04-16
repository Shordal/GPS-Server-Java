import java.util.*;

public class JavaServerThreadTester implements Runnable {
	
	String name;
	
	int time;
	
	Random r = new Random();
	
	public JavaServerThreadTester (String x) {
		
		name = x;
		
		time = r.nextInt(9999);
	}
	
	public void Frame(String[] stringsForArray, String[] theArray){
		
		for(int n = 0; n < stringsForArray.length; n++){
			
		}
		
	}
	
	public void run(){
		
		try{
			
			System.out.printf("%s is sleeping for %d.\n", name, time);
			
			Thread.sleep(time);
			
			System.out.printf("%s is done\n", name);
			
		}catch(Exception e){}
	}

}