package Threads;

import java.util.ArrayList;
import Tabellen.Person;
import Tabellen.Tabelle;

public class SearchNr {
	
	private ArrayList<Person> foundNumbers;
	
	public SearchNr() {
		
	}

	public ArrayList<Person >search (int number){
		
		ArrayList<Person> table = new Tabelle().getList();
		for (int i = 0; i < table.size(); i++) {
			if (number == table.get(i).getNr() ) {
				foundNumbers.add(table.get(i));
			}
			
		}
		return foundNumbers;
	}
}
