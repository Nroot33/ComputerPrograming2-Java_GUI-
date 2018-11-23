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
			System.out.print("로그인 하거나 ID가 없으면 회원가입을 하세요. (1. 로그인 2. 회원가입 3. 종료) : ");
			int number = sc.nextInt();
			switch (number) {

			case 1:
				System.out.print("ID를 입력하세요 : ");
				newID = sc.next();
				I:{
					for (int i = 0; i < ID.size(); i++) {
						if (newID.equals(ID.get(i))) {
							System.out.print("비밀번호를 입력하세요 : ");
							newPW = sc.next();
							if (newPW.equals(PW.get(i))) {
								System.out.println("로그인 되었습니다.");
								System.out.print("1. 비밀번호 수정 2. 종료 : ");
								int num = sc.nextInt();
								if (num == 2)
									break;
								else {
									System.out.print("본인의 ID를한번 더 입력하세요 : ");
									newID = sc.next();
									if (newID.equals(ID.get(i))) {
										System.out.println("확인 되었습니다.");
										System.out.print("새로운 비밀번호를 입력하세요 : ");
										newPW = sc.next();
										PW.set(i, newPW);
										break I;
									} else {
										System.out.println("올바르지 않은 ID입니다.");
										break I;
									}
								}
							} else {
								System.out.println("올바르지 않은 비밀번호입니다.");
								break I;
							}
						}
					}
					System.out.println("존재하지않는 ID입니다.");
					break I;
				}
				break;

			case 2:

				if (ID.isEmpty()) {
					System.out.print("새로운 ID를 입력하세요 : ");
					newID = sc.next();
					ID.add(0, newID);
					System.out.print("비밀번호를 입력하세요 : ");
					newPW = sc.next();
					PW.add(0, newPW);
					break;
				} else
					make: {
						for (int i = 0; i < ID.size(); i++) {
							System.out.print("새로운 ID를 입력하세요 : ");
							newID = sc.next();
							for (int j = 0; j < ID.size(); j++) {
								if (newID.equals(ID.get(j))) {
									System.out.println("존재하는 ID입니다.");
									break make;
								}
							}
							ID.add(i, newID);
							System.out.print("비밀번호를 입력하세요 : ");
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
				System.out.println("종료");
				System.exit(0);
				break;
			default:
				continue;
			}
		}
	}
}