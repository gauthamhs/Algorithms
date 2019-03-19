package algorithms.sort.extras;

import java.util.ArrayList;
import java.util.List;

class Name implements Comparable<Name>{
	String firstName;
	String lastName;
	
	Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Name name) {
		int compareFirst = firstName.compareTo(name.firstName);
		if(compareFirst!=0) {
			return compareFirst;
		}
		return lastName.compareTo(name.lastName);
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	
}

public class RemoveFirstNameDuplicates {
	
	public static void removeFirstDuplicates(List<Name> names){
		int writeIndex = 0;
		for(int i=1;i<names.size();i++) {
			if(!names.get(i).firstName.equals(names.get(writeIndex).firstName)) {
				names.set(++writeIndex, names.get(i));
			}
		}
		
		names.subList(++writeIndex, names.size()).clear();
	}
	
	
	public static void main(String[] args) {
		List<Name> names = new ArrayList<>();
		Name name1 = new Name("David", "Grover");
		Name name2 = new Name("Ian", "Botham");
		Name name3 = new Name("Ian", "Chapell");
		Name name4 = new Name("Ian", "Beckham");
		names.add(name1);
		names.add(name2);
		names.add(name3);
		names.add(name4);
		
		System.out.println(names);
		removeFirstDuplicates(names);
		System.out.println(names);
		
	}

}
