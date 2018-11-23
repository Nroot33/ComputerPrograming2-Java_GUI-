import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) throws IOException {

		ArrayList<String> ID = new ArrayList<String>();
		ArrayList<String> PW = new ArrayList<String>();

		BufferedReader inID = new BufferedReader(new FileReader("ID.txt"));
		BufferedReader inPW = new BufferedReader(new FileReader("PW.txt"));

		String line1 = inID.readLine();
		String line2 = inPW.readLine();

		while (line1 != null && line2 != null) {
			ID.add(line1);
			PW.add(line2);
			line1 = inID.readLine();
			line2 = inPW.readLine();
		}

		Scanner sc = new Scanner(System.in);

		String newID;
		String newPW;

		while (true) {			
			System.out.print("�α��� �ϰų� ID�� ������ ȸ�������� �ϼ���. (1. �α��� 2. ȸ������ 3. ����) : ");
			int number = sc.nextInt();
			switch (number) {

			case 1:
				System.out.print("ID�� �Է��ϼ��� : ");
				newID = sc.next();
				I:{
					for (int i = 0; i < ID.size(); i++) {
						if (newID.equals(ID.get(i))) {
							System.out.print("��й�ȣ�� �Է��ϼ��� : ");
							newPW = sc.next();
							if (newPW.equals(PW.get(i))) {
								System.out.println("�α��� �Ǿ����ϴ�.");
								System.out.print("1. ��й�ȣ ���� 2. ���� : ");
								int num = sc.nextInt();
								if (num == 2)
									break;
								else {
									System.out.print("������ ID���ѹ� �� �Է��ϼ��� : ");
									newID = sc.next();
									if (newID.equals(ID.get(i))) {
										System.out.println("Ȯ�� �Ǿ����ϴ�.");
										System.out.print("���ο� ��й�ȣ�� �Է��ϼ��� : ");
										newPW = sc.next();
										PW.set(i, newPW);
										break I;
									} else {
										System.out.println("�ùٸ��� ���� ID�Դϴ�.");
										break I;
									}
								}
							} else {
								System.out.println("�ùٸ��� ���� ��й�ȣ�Դϴ�.");
								break I;
							}
						}
					}
					System.out.println("���������ʴ� ID�Դϴ�.");
					break I;
				}
				break;

			case 2:

				if (ID.isEmpty()) {
					System.out.print("���ο� ID�� �Է��ϼ��� : ");
					newID = sc.next();
					ID.add(0, newID);
					System.out.print("��й�ȣ�� �Է��ϼ��� : ");
					newPW = sc.next();
					PW.add(0, newPW);
					break;
				} else
					make: {
						for (int i = 0; i < ID.size(); i++) {
							System.out.print("���ο� ID�� �Է��ϼ��� : ");
							newID = sc.next();
							for (int j = 0; j < ID.size(); j++) {
								if (newID.equals(ID.get(j))) {
									System.out.println("�����ϴ� ID�Դϴ�.");
									break make;
								}
							}
							ID.add(i, newID);
							System.out.print("��й�ȣ�� �Է��ϼ��� : ");
							newPW = sc.next();
							PW.add(i, newPW);
							break;
						}
					}
				break;

			case 3:

				PrintWriter outID = new PrintWriter(new FileWriter("ID.txt"));
				PrintWriter outPW = new PrintWriter(new FileWriter("PW.txt"));
				for (int i = 0; i < ID.size(); i++) {
					outID.println(ID.get(i));
					outPW.println(PW.get(i));
				}
				outID.flush();
				outPW.flush();
				if (inID != null)
					inID.close();
				if (outID != null)
					outID.close();
				if (inPW != null)
					inPW.close();
				if (outPW != null)
					outPW.close();
				System.out.println("����");
				System.exit(0);
				break;
			default:
				continue;
			}
		}
	}
}