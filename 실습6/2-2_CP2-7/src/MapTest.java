import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<>();

		st.put("20180001", new Student(20180001, "유비"));
		st.put("20180002", new Student(20180002, "관우"));
		st.put("20180003", new Student(20180003, "장비"));

		System.out.println(st);

		st.remove("20180002");

		st.put("20180003", new Student(20180003, "조자룡"));

		System.out.println(st.get("200180003"));

		for (Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key=" + key + ", value" + value);
		}
	}

	class Student{
		@SuppressWarnings("unused")
		private int number;
		private String name;
		
		public Student(int number, String name) {
			this.number = number;
			this.name = name;
		}
		public String toString() {
			return name;
		}
	}
}
