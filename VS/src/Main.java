import Threads.SearchNr;
import UI.View;

/**
 * Main.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 * Main-class of phone book 
 *
 */
public class Main {
	
	public static void main (String[] args) {
		View view = new View();
		SearchNr searchnr = new SearchNr();
		Thread t1 = new Thread(searchnr);
		t1.start();
		System.out.println("ich bin "+ Thread.currentThread().getName());
	}

}
