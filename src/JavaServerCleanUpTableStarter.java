import java.io.IOException;
public class JavaServerCleanUpTableStarter implements Runnable {
	
	HashFunction theFunction;
	
	public String[] Table;

	public JavaServerCleanUpTableStarter(HashFunction theFunction, String[] Table){
		
		this.Table = Table;
		
		this.theFunction = theFunction;
		
	}

	@Override
	public void run() {

		
		try{
			
			int T = 3;
			
			while(T > 0){
				
			new Thread(new JavaServerCleanUpTable(Table, theFunction)).start();
			//30 seconds wait
			Thread.sleep(500);
			
			}
		}catch (InterruptedException e){
			
			e.printStackTrace();
			
			System.out.println("Error #78");
		}

	}

}
