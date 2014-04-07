package Threads;

import java.util.ArrayList;

import Tabellen.Person;
import Tabellen.Tabelle;
/**
 * SearchName.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 * 
 */
public class SearchName implements Runnable {
	
	private String givenName;
	private ArrayList<Person> foundNames;
	
	public SearchName(String givenName) {
		this.givenName = givenName; 
		this.foundNames = new ArrayList<Person>();
	}

	public ArrayList<Person> getFoundNames() {
		return foundNames;
	}

	public void setFoundNames(ArrayList<Person> foundNames) {
		this.foundNames = foundNames;
	}

	public ArrayList<Person> search (String name){
		
		foundNames.clear();
		ArrayList<Person> table = new Tabelle().getList();
		for (int i = 0; i < table.size(); i++ ){
			if(name.equals(table.get(i).getName() )){
				foundNames.add(table.get(i));
			}
		}
		return foundNames;
	}

	public void run() {
		search(givenName);
	}
}
