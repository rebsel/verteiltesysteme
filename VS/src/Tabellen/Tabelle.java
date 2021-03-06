package Tabellen;

import java.util.ArrayList;
/**
 * Tabelle.java
 * @author Karin, Rebecca, Victor
 * 31.3.2014
 * Tabelle represents a table containing test data
 */
public class Tabelle {
	
	// list containing Person-objects
	private ArrayList<Person> list; 
	
	/**
	 * creating a list with persons for testing use
	 */
	public Tabelle() {
		list = new ArrayList<Person>();
		list.add(new Person("Müller", 1110));
		list.add(new Person("Müller", 1100));
		list.add(new Person("von Reihbach", 2222));
		list.add(new Person("Schumacher", 1234));
		list.add(new Person("Schumacher", 1222));
		list.add(new Person("Anders", 1234));
	}

	// Getters & Setters
	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}
	
	

}
