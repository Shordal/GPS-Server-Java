import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JavaServerRunable implements Runnable{
	
	private Socket clientSocket = null;
	
	private String Find = null;
	
	public String[] Table;
	
	public int arraySize,size; 
	
	DataInputStream is;
	
	DataOutputStream os;
	
	private HashFunction theFunction;
	
	public JavaServerRunable(Socket clientSocket, String[] Table, HashFunction theFunction) {
		
		this.clientSocket = clientSocket;
		
		this.Table = Table;
		
		this.theFunction = theFunction;
		
		size = 200;
	
	}

	public void run() {
		
		try{
			
			System.out.print("Code:36");
			
			System.out.println("HERE!!!: " + theFunction.Table[189]);
			
			Boolean KeepGoing1 = true;
			
			Boolean KeepGoing2 = true;
			
			while(KeepGoing1){

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			int N = 2;
		
			Find = in.readLine();
			
			System.out.println("From Client: " + Find);
			
			KeepGoing2 = true;
			
			if (Find == null){
				
				KeepGoing1 = false;
				
				System.out.println("Server: Hello, closing socket");
				
				out.flush();

			}
			
			else if (Find.contains("<AVL><vehicles>active</vehicles></AVL>")){
				
				System.out.println("Command found, returning Active Positions Only vehicles");
				
				String header ="{\"status\":\"active\",\"vehicles\":[{";
				
				String end = "}]}\n";
				
				String body = "";
				
				String link = "},{";
				
				int index = 0;
					
					for(int m = 0; m < 1000; m++){
						
						System.out.println("ERROR OVER HERE: " + theFunction.Table[m]);
						
						if(theFunction.Table[m] != "-1"){
							
							String stringFromArray = theFunction.Table[m];
							
						String ident = ""; 
						
						String status = "";
						
						String latitude = ""; String longitude = ""; String speed = ""; String heading = ""; String time = ""; 
						
						ident = stringFromArray.split(",")[12];
						
						ident = ident.substring(0, ident.length() - 5);
						
						System.out.println(ident);
						
						//--status--
						
						status = stringFromArray.split(",")[2];
						
						status = status.substring(0, status.length());
						
						System.out.println(status);
						
						//--latitude--
						
						latitude = stringFromArray.split(",")[3];
						
						latitude = latitude.substring(0, latitude.length());
						
						System.out.println(latitude);
						
						//--longitude--
						
						longitude = stringFromArray.split(",")[5];
						
						longitude = longitude.substring(0, longitude.length());
						
						System.out.println(longitude);
						
						//--speed--
						
						speed = stringFromArray.split(",")[7];
						
						speed = speed.substring(0, speed.length());
						
						System.out.println(speed);
						
						//--heading--
						
						heading = stringFromArray.split(",")[8];
						
						heading = heading.substring(0, heading.length());
						
						System.out.println(heading);
						
						//--time--
						
						time = stringFromArray.split(",")[13];
						
						System.out.println(time);
						
						//====================end of substring================
						
						String bodyAdd = "\"ident\":\""+ident+"\",\"status\":\""+status+"\",\"latitude\":\""+latitude+"\",\"longitude\":\""+longitude+"\",\"speed\":\""+speed+"\",\"heading\":\""+heading+"\",\"time\":\""
								+time+"\"";
						
						body = body + bodyAdd + link;
						
						System.out.println("FOR THE EMPPAR: " + body);
						
						m++;
						
						}
					
					}
					
				body = body.substring(0, body.length() -3);
					
				String output = header + body + end;
				
				System.out.print("going to client: " + output);
				
				out.print(output);
		
				out.flush();

				N = 0;

			Thread.sleep(10);
			
			}
			
			else if (Find.contains("<AVL><vehicles>all</vehicles></AVL>")){
				
				System.out.println("Command found, returning all vehicles");
				
				String string ="{\"status\":\"active\",\"vehicles\":[{\"ident\":\"V102\",\"status\":\"A\",\"latitude\":\"-49.2273\",\"longitude\":\"-23.47\",\"speed\":\"70\",\"heading\":\"45\",\"time\":\"13:35:19\"}]}\n";
				
				System.out.print("going to client: " + string);
				
				out.print(string);
				
				out.flush();
				
				Thread.sleep(10);
				
			}
			
			else {
				
				System.out.println("Command Not found, Exiting");
			
			KeepGoing1 = true;
			
			}
			
		}
			System.out.println("Out of here!");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Code:37");
		
	}

}
