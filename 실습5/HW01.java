import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame implements ActionListener {

	private JPanel main; // 메인 패널
	private JPanel text; // 텍스트 패널
	private JPanel cancel; // 취소 패널
	private JPanel input; // 입력 패널
	
	private TextField t;

	
	int size = 0;
	String[] cal = new String[size];
	
	public MyFrame2() {
		setTitle("계산기"); // 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 설정

		main = new JPanel();// 메인 패널 생성
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS)); // 메인 패널 - BoxLayout Y축 정렬 설정

		text = new JPanel(); // 텍스트 패널 생성

		cancel = new JPanel(); // 취소 패널 생성
		cancel.setLayout(new GridLayout(0, 4, 3, 3)); // 취소패널 - 0행 4열 여백 3,3 설정
		cancel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // 패널간 여백 설정

		input = new JPanel(); // 취소 패널 생성
		input.setLayout(new GridLayout(0, 4, 3, 3));// 입력패널 - 0행 4열 여백 3,3 설정
		input.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // 패널간 여백 설정

		t = new TextField(25); // 텍스트 필드 생성

		text.add(t); // 텍스트 필드 ->텍스트 패널에 추가
		makeButton(cancel, "C"); // 메소드 이용 버튼 취소 패널에 추가
		makeButton(input, "7");
		makeButton(input, "8");
		makeButton(input, "9");
		makeButton(input, "/");
		makeButton(input, "4");
		makeButton(input, "5");
		makeButton(input, "6");
		makeButton(input, "*");
		makeButton(input, "1");
		makeButton(input, "2");
		makeButton(input, "3");
		makeButton(input, "-");
		makeButton(input, "0");
		makeButton(input, "back");
		makeButton(input, "=");
		makeButton(input, "+"); // 메소드 이용 버튼 입력 패널에 추가

		main.add(text);
		main.add(cancel);
		main.add(input); // 각 패널 메인 패널에 추가

		add(main); // 메인 패널 프레임에 추가
		pack(); // pack() 메소드 실행

		setVisible(true);
	}

	private void makeButton(JPanel panel, String text) { // 버튼 추가 메소드
		JButton button = new JButton(text); // text를 받는 버튼 생성
		button.setSize(3, 3); // 버튼 사이즈 설정
		button.addActionListener(this);
		panel.add(button); // 패널에 버튼 추가
	}
	
	int oldnum,temp,result;
	String tempFunc,tempinput ="";
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		
		if(input.equals("+")) {
			oldnum = temp;
			tempFunc = "+";
			tempinput ="";
		}
		else if(input.equals("-")) {
			oldnum = temp;
			tempFunc = "-";
			tempinput ="";
		}
		else if(input.equals("*")) {
			oldnum = temp;
			tempFunc = "*";
			tempinput ="";
		}
		else if(input.equals("/")) {
			oldnum = temp;
			tempFunc = "/";
			tempinput ="";
		}
		else if(input.equals("C")) {
			oldnum = 0;
			temp = 0;
			tempinput ="";
			t.setText("");
		}
		else if(input.equals("=")) {
			if(tempFunc.equals("+")) {
				result = oldnum+temp;
				t.setText(String.valueOf(result));
			}
			else if(tempFunc.equals("-")) {
				result = oldnum-temp;
				t.setText(String.valueOf(result));
			}
			else if(tempFunc.equals("*")) {
				result = oldnum*temp;
				t.setText(String.valueOf(result));
			}
			else if(tempFunc.equals("/")) {
				if(temp == 0)
					t.setText("error");
				result = oldnum/temp;
				t.setText(String.valueOf(result));
			}
		}
		
		else {
			tempinput +=e.getActionCommand();
			t.setText(tempinput);
			temp = Integer.parseInt(tempinput);
		}
	}
}

public class HW01 {
	public static void main(String[] args) {

		MyFrame2 f = new MyFrame2();
	}

}
