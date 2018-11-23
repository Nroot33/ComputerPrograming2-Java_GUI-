import java.awt.*;
import javax.swing.*;

class MyFrame1 extends JFrame {

	private JButton button;

	private JLabel label1;
	private JLabel label2;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private TextField t1, t2, t3;

	public MyFrame1() {
		setTitle("이자 계산기"); // 타이틀 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0,2,150,5)); // 원금 패널 - 0행 2열 여백 150,5 설정
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,2,150,5)); // 이자 패널 - 0행 2열 여백 150,5 설정
		
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // 텍스트 패널 - BoxLayout Y축 정렬 설정
		
		
		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS)); // 메인 패널 - BoxLayout Y축 정렬 설정
		
		label1 = new JLabel("원금을 입력하시오."); //라벨 생성
		label2 = new JLabel("이율을 입력하시오.");
		
		t1 = new TextField(10); // 원글 텍스트 필드 생성
		t2 = new TextField(10); // 이자 텍스트 필드 생성
		t3 = new TextField(30); // 결과 텍스트 필드 생성
		
		button = new JButton("변환");
		button.setAlignmentX(Component.CENTER_ALIGNMENT); //버튼 정렬
		
		panel1.add(label1);
		panel1.add(t1);
		// 원금 패널에 버튼과 라벨 추가
		panel2.add(label2);
		panel2.add(t2);
		// 이자 패널에 버튼과 라벨 추가
		panel3.add(panel1);
		panel3.add(panel2);
		// 텍스트 패널에 원금,이자 패널 추가
		panel4.add(panel3);
		// 메인 패널에 텍스트 패널 추가
		panel4.add(button);
		// 메인 패널에 "변환" 버튼 추가
		panel4.add(t3);
		// 메인 패널에 결과 텍스트  추가
		
		add(panel4);
		pack();


		setVisible(true);
	}
}

public class HW01 {
	public static void main(String[] args) {
		
		MyFrame1 f = new MyFrame1();
	}

}
