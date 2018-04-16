import java.time.LocalTime;
import java.util.Arrays;

public class HashFunction {

	public String[] Table;
	public int arraySize; 
	public int itemsInArray = 0;

	public HashFunction(int size) {
		// TODO Auto-generated constructor stub
		
		
		arraySize = size;
		Table = new String[size];
		Arrays.fill((String[]) Table, "-1");
		
		
	}

	
	public void FrameHash3(String stringsForArray, String[] Table) {
			
			String newElementVal = stringsForArray;
			
			String Hold = stringsForArray;
			
			String ID = Hold.split(",")[12];
			
			ID = ID.substring(0, ID.length() - 5);
			
			System.out.println("HERE!! " + ID);
			
			int arrayIndex = Integer.parseInt(ID);
			
			System.out.println(arrayIndex);
			
			LocalTime time = LocalTime.now();
			
			newElementVal = newElementVal + "," + time;
			

			
			Table[arrayIndex] = newElementVal;
		}
		
	
	public void DisplayHash2() {

		
		LocalTime time = LocalTime.now();
		
		
        int last = 0, index = 0;
        
        String item = "";
        
        
        
        for(int m = 0; m < 1000; m++){
        	if(Table[m] != "-1"){
        	
        	System.out.print("\nIndex " + m);
        	System.out.print(" | Value:  " + Table[m]);
        
        	}
        	index += 1;
        	
        	
        }
        
        
        

        }


}
