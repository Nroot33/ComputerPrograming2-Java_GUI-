import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
   public static void main(String[] args) {
      java.util.HashSet<String> list = new java.util.HashSet<String>();

      try {
         BufferedReader in = new BufferedReader(new FileReader("hangman.txt")); 
         String line = in.readLine(); 

         while (line != null) { 
            list.add(line);
            line = in.readLine();
         }
      } catch (IOException e) { 
         System.out.println(e);
      }
      Object[] hangman = list.toArray();
      Random r = new Random();
      String word = (String) hangman[r.nextInt(hangman.length)]; 

      String[] word2 = word.split(""); 
      String[] dash = new String[word2.length];

      Scanner sc = new Scanner(System.in);

      int correctCount = 0;
      int num = 0;

      System.out.println("행맨 게임!");
      System.out.println("(제한 횟수는 " + (2 * dash.length) + "번입니다. )");

      for (int i = 0; i < word2.length; i++) {
         dash[i] = "_ ";
      }

      while (true) {
         System.out.print("현재 상태 : ");
         for (int i = 0; i < word2.length; i++)
            System.out.print(dash[i]);
         System.out.println();

         System.out.print("문자를 입력해주세요(한글자) : ");
         String select = sc.nextLine();
         if(select.length() != 1)
            System.out.println("한글자만 입력가능합니다.");

         for (int i = 0; i < word2.length; i++) {
            if (word2[i].equalsIgnoreCase(select)) {
               dash[i] = word2[i];
               correctCount++;
            } 
         }
         
         if(select.length() != 1)
            continue;
         else
         num++; 

         System.out.println();
         if (correctCount == word2.length) {
        	 for (int i = 0; i < word2.length; i++)
                 System.out.print(word2[i]);
            System.out.println("정답을 맞혔습니다");
            System.exit(0);
         }
         if (num == 2 * (word2.length)) {
            System.out.println("정답을 맞추지 못했습니다.");
            for (int i = 0; i < word2.length; i++)
               System.out.print(word2[i]);
            System.exit(0);
         }
      }
   }
}