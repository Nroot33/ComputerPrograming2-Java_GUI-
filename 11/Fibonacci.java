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

      System.out.print("��� �� �� �Է�: ");
      int n = sc.nextInt();
      long start = System.currentTimeMillis();
      for (int i = 0; i < n; i++)
         loopFibonacci(i);
      long end = System.currentTimeMillis();

      System.out.println();
      System.out.println("loopFibonaci");
      System.out.println(n + "��° �� : " + loopFibonacci(n));
      System.out.println("Time : " + ((end - start) / 1000.0) + "s");

      long start2 = System.currentTimeMillis();
      for (int i = 0; i < n; i++)
         recursiveFibonacci(i);
      long end2 = System.currentTimeMillis();

      System.out.println("recursiveFibonacci");
      System.out.println(n + "��° �� : " + recursiveFibonacci(n));
      System.out.println("Time : " + ((end2 - start2) / 1000.0) + "s\n");
   }

   // �ð� �� : �ݺ����� �� ������. �ݺ����� �ʱⰪ�� ���� ���·� ����� ���� ���� �����Ƿ� �ӵ��� ������ ����.
   // �׷��� ����Լ��� ���ϴ� ������� ���̱� ���� ���� ������ ����� ��� �ݺ��ϹǷ� �ӵ��� ������.

   // ����Լ��� ������� : �ݺ����� ���� �ڵ� �ؾ��� ���� �پ���, ���� ���� �ݺ������� ����Լ��� �� ���� ������ ��Ÿ ������ �ִ�.
}