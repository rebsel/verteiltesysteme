package Threads;

import java.util.ArrayList;
import Tabellen.Person;
import Tabellen.Tabelle;
/**
 * SearchNr.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 */
public class SearchNr implements Runnable {
	
	private ArrayList<Person> foundNumbers;
	
	public SearchNr() {
		
	}

	public ArrayList<Person> search (int number) {
		
		foundNumbers.clear();
		ArrayList<Person> table = new Tabelle().getList();
		for (int i = 0; i < table.size(); i++) {
			if (number == table.get(i).getNr() ) {
				foundNumbers.add(table.get(i));
			}
			
		}
		return foundNumbers;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("NR: Ich bin " + Thread.currentThread().getName());
		
	}
}
