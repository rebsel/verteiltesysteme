package Threads;

import java.util.ArrayList;

import Tabellen.Person;
import Tabellen.Tabelle;
/**
 * SearchName.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 * represents a Thread containing the given name and a list of the found names
 * 
 */
public class SearchName implements Runnable {
	// name to search for
	private String givenName;
	// list of found Persons
	private ArrayList<Person> foundNames;
	
	/**
	 * constructor
	 * trims blanks before and after input value
	 * @param givenName
	 */
	public SearchName(String givenName) {
		this.givenName = givenName.trim(); // trim blanks
		this.foundNames = new ArrayList<Person>();
	}
	
	// Getters & Setters
	public ArrayList<Person> getFoundNames() {
		return foundNames;
	}

	public void setFoundNames(ArrayList<Person> foundNames) {
		this.foundNames = foundNames;
	}

	/**
	 * searching for the name in the list
	 * @param name : String containing the value of the input field
	 * @return list of found Persons
	 */
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
	
	/**
	 * started by start()-method in the View
	 */
	public void run() {
		search(givenName);
	}

}
