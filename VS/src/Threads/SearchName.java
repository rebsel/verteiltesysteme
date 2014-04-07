package Threads;

import java.util.ArrayList;

import Tabellen.Person;
import Tabellen.Tabelle;

public class SearchName {
	
	private ArrayList<Person> foundNames;
	
	public SearchName(){
		
	}

	public ArrayList<Person >search (String name){
		
		ArrayList<Person> table = new Tabelle().getList();
		for (int i = 0; i < table.size(); i++ ){
			if(name.equals(table.get(i).getName() )){
				foundNames.add(table.get(i));
			}
			
		}
		return foundNames;
	}
}
