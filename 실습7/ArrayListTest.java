
public class ArrayListTest {

   public static void main(String[] args) {
     // 과제1 
      List<Integer> list1 = new ArrayList<>(3);
      for(int i = 0; i<20; i++) 
         list1.addLast(i);
      System.out.println(list1);
      
      //과제 2-1
      List<Integer> list2 = new ArrayList<>(3);
      list2.add(1, 30); 
      System.out.println("List : " + list2 + "\n" + "size : " + list2.size());
      
      //과제 2-3
      List<Integer> list3 = new ArrayList<>(3);
      System.out.println(list3.remove(2));
      
   }

}