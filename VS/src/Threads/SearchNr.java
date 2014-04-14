package Threads;

import java.util.ArrayList;
import Tabellen.Person;
import Tabellen.Tabelle;
/**
 * SearchNr.java
 * @author Karin, Rebecca, Victor
 * 7.4.2014
 * represents a Thread containing the given number and a list of found numbers
 */
public class SearchNr implements Runnable {
	// number to search for
	private int givenNumber;
	// list of found Persons
	private ArrayList<Person> foundNumbers;
	
	/**
	 * constructor
	 * @param givenNumber
	 */
	public SearchNr(int givenNumber) {
		this.givenNumber = givenNumber;
		this.foundNumbers = new ArrayList<Person>();
	}
	
	// Getters & Setters
	public int getGivenNumber() {
		return givenNumber;
	}

	public void setGivenNumber(int givenNumber) {
		this.givenNumber = givenNumber;
	}

	public ArrayList<Person> getFoundNumbers() {
		return foundNumbers;
	}

	public void setFoundNumbers(ArrayList<Person> foundNumbers) {
		this.foundNumbers = foundNumbers;
	}
	
	/**
	 * searching for the number in the list
	 * @param number : String containing the value of the input field
	 * @return list of found Persons
	 */
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
	
	/**
	 * started by start()-method in the View
	 */
	public void run() {
		search(givenNumber);
	}
}
