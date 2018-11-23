import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame implements ActionListener {

	private JPanel main; // ���� �г�
	private JPanel text; // �ؽ�Ʈ �г�
	private JPanel cancel; // ��� �г�
	private JPanel input; // �Է� �г�
	
	private TextField t;

	
	int size = 0;
	String[] cal = new String[size];
	
	public MyFrame2() {
		setTitle("����"); // Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ� ��ư ����

		main = new JPanel();// ���� �г� ����
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS)); // ���� �г� - BoxLayout Y�� ���� ����

		text = new JPanel(); // �ؽ�Ʈ �г� ����

		cancel = new JPanel(); // ��� �г� ����
		cancel.setLayout(new GridLayout(0, 4, 3, 3)); // ����г� - 0�� 4�� ���� 3,3 ����
		cancel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // �гΰ� ���� ����

		input = new JPanel(); // ��� �г� ����
		input.setLayout(new GridLayout(0, 4, 3, 3));// �Է��г� - 0�� 4�� ���� 3,3 ����
		input.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // �гΰ� ���� ����

		t = new TextField(25); // �ؽ�Ʈ �ʵ� ����

		text.add(t); // �ؽ�Ʈ �ʵ� ->�ؽ�Ʈ �гο� �߰�
		makeButton(cancel, "C"); // �޼ҵ� �̿� ��ư ��� �гο� �߰�
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
		makeButton(input, "+"); // �޼ҵ� �̿� ��ư �Է� �гο� �߰�

		main.add(text);
		main.add(cancel);
		main.add(input); // �� �г� ���� �гο� �߰�

		add(main); // ���� �г� �����ӿ� �߰�
		pack(); // pack() �޼ҵ� ����

		setVisible(true);
	}

	private void makeButton(JPanel panel, String text) { // ��ư �߰� �޼ҵ�
		JButton button = new JButton(text); // text�� �޴� ��ư ����
		button.setSize(3, 3); // ��ư ������ ����
		button.addActionListener(this);
		panel.add(button); // �гο� ��ư �߰�
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
