import java.util.Arrays;

public class JavaServer {

		public static void main(String[] args) {
			System.out.println("Server: Hello there!\nServer: I'm gonna run some tests real quick!\n");

			
			final String[] Table = null; 
			int arraySize = 0;
			String itemsInArray = "";
			
			HashFunction theFunction = new HashFunction(1000);

			System.out.println("\nServer: I'm going to build a table to hold all the data, please wait!\n");
			
			Thread t1 = new Thread(new JavaServerThreadTester("Zero"));
			Thread t2 = new Thread(new JavaServerThreadTester("One"));
			Thread t3 = new Thread(new JavaServerThreadTester("Two"));
			Thread t4 = new Thread(new JavaServerThreadTester("Three"));
			
			System.out.println("\nServer: Testing nearly done, thanks for waiting!\n");
			

			
			t1.start(); t2.start(); t3.start(); t4.start();
			

			
			System.out.println("\nServer: I'm gonna start listening for data!\n");
			
			SocketServer2 t = new SocketServer2(Table, arraySize, itemsInArray, theFunction);
			
			t.runServer();
			
			
			
		}
}

