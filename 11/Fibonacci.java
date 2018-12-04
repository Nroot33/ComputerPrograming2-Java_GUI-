import java.util.Scanner;

public class Fibonacci {

   public static int loopFibonacci(int n) {
      if (n < 2)
         return n;
      else {
         int temp, current = 1, last = 0;
         for (int i = 2; i <= n; i++) {
            temp = current;
            current += last;
            last = temp;
         }
         return current;
      }
   }

   public static int recursiveFibonacci(int n) {
      if (n == 0)
         return 0;
      else if (n == 1)
         return 1;
      return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
   }

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      System.out.print("출력 할 항 입력: ");
      int n = sc.nextInt();
      long start = System.currentTimeMillis();
      for (int i = 0; i < n; i++)
         loopFibonacci(i);
      long end = System.currentTimeMillis();

      System.out.println();
      System.out.println("loopFibonaci");
      System.out.println(n + "번째 항 : " + loopFibonacci(n));
      System.out.println("Time : " + ((end - start) / 1000.0) + "s");

      long start2 = System.currentTimeMillis();
      for (int i = 0; i < n; i++)
         recursiveFibonacci(i);
      long end2 = System.currentTimeMillis();

      System.out.println("recursiveFibonacci");
      System.out.println(n + "번째 항 : " + recursiveFibonacci(n));
      System.out.println("Time : " + ((end2 - start2) / 1000.0) + "s\n");
   }

   // 시간 비교 : 반복문이 더 빠르다. 반복문은 초기값이 변수 형태로 계산을 통해 값이 나오므로 속도의 제약이 없다.
   // 그러나 재귀함수는 원하는 결과값을 보이기 위해 이전 연산의 결과을 계속 반복하므로 속도가 느리다.

   // 재귀함수의 사용이유 : 반복문에 비해 코딩 해야할 양이 줄어들고, 때에 따라 반복문보다 재귀함수가 더 좋은 성능을 나타 낼때도 있다.
}