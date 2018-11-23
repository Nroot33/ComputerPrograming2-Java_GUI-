import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.add("Zero");
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add(2, "��");
		list.remove(3);
		
		Iterator<String> e = list.iterator();
		
		while(e.hasNext()) {
			String s = e.next();
			System.out.println(s);
		}
		
		while(e.hasNext()) {
			String s = e.next();
			System.out.println(s);
		}
	}

}
