import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class JavaServerCleanUpTable implements Runnable{

	public String[] Table;
	
	HashFunction theFunction;
	
	public JavaServerCleanUpTable(String[] Table, HashFunction theFunction) {
		// TODO Auto-generated constructor stub
		this.Table = Table;
		
		this.theFunction = theFunction;
		
	}
	
	public void run() {
		
			for(int m = 0; m < 1000; m++) {
				
				if(theFunction.Table[m] != "-1"){
					
					String stringFromArray = theFunction.Table[m];
					
					long timeToDelete = 30;
					
					String stringTimeStampFromTable = stringFromArray.split(",")[13];
					
					System.out.println("Index " + m + ", timeStamp from Table: " + stringTimeStampFromTable);
					
					LocalTime timeStamp = LocalTime.parse(stringTimeStampFromTable);
					
					LocalTime time = LocalTime.now();
					
					long timeBetween = ChronoUnit.SECONDS.between(timeStamp, time);
					
					System.out.println("Index " + m + ", timeBetween from Table: " + timeBetween);	
					
					if (timeBetween > timeToDelete){
						
						theFunction.Table[m] = "-1";
				}
			}
		}
			
	}
	
}

