import java.awt.List;
import java.util.Arrays;
import java.util.Collections;

class Student implements Comparable<Student> {
	private int number;
	private String name;

	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public int compareTo(Student s) {
		return number - s.number;
	}

	public String toString() {
		return name;
	}
}

public class SortTest {
	public static void main(String[] args) {
		Student array[] = { 
				new Student(2018005, "±èÃ¶¼ö"),
				new Student(2018002, "ÀÌÃ¶¼ö"), 
				new Student(2018003, "¹ÚÃ¶¼ö") 
				};
		List<Student> list = Arrays.asList(array);
		Collections.sort(list);
		System.out.println(list);
	}
}



