package algorithms.sort.extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	
	public String name;
	public int gpa;
	
	public Student(String name, int gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
}
public class SortByGPA {
	
	public static boolean performBinarySearch(List<Student> students, Student student, Comparator<Student> compGpa) {
		
		return Collections.binarySearch(students, student, compGpa)>=0;
	}
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Mayank", 30);
		Student s2 = new Student("Aarav", 50);
		Student s3 = new Student("Pranav", 40);
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		for (Student student : students) {
			System.out.println(student.name  +": " + student.gpa);
		}
		
		//Comparator<Student> sortByGPA = Comparator.comparing((Student a) -> a.gpa);
		
		Comparator<Student> sortByGPA = (Student a, Student b) -> {
			if(a.gpa!=b.gpa) {
				return Integer.compare(b.gpa, a.gpa);
			}
			
			return a.name.compareTo(b.name);
			
		};
		
		students.sort(sortByGPA);
		System.out.println();
		
		for (Student student : students) {
			System.out.println(student.name  +": " + student.gpa);
		}
		
		System.out.println(performBinarySearch(students, s1, sortByGPA));

	}

}
