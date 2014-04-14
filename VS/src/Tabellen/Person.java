package Tabellen;
/**
 * Person.java
 * @author Karin, Rebecca, Victor
 * 31.3.2014
 * represents one person containing name + nr
 * 
 */
public class Person {
	
	// name of person
	private String name;
	// phone number of person 
	private int nr;
	
	/**
	 * constructor 
	 * @param name : name of person
	 * @param nr : given number
	 */
	public Person(String name, int nr) {
		this.name = name;
		this.nr = nr;
	}
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNr() {
		return nr;
	}
	
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	/**
	 * Overwrite the string-method for a better presentation of the
	 * results in the view
	 */
	@Override
	public String toString() {
		return name + "       " + nr;
	}
	
	

}
