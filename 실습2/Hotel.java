import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JLabel label;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public MyFrame() {
		setTitle("ȣ�� ���� ���ø����̼�");
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		label = new JLabel("�ڹ� ȣ�ڿ� ���Ű��� ȯ���մϴ�.�����ο��� �����ϼ���.");
		
		panel1.add(label);
		
		button1 = new JButton("1��");
		button2 = new JButton("2��");
		button3 = new JButton("3��");
		button4 = new JButton("4��");
		button5 = new JButton("5��");
		
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		
		
		panel3.add(panel1);
		panel3.add(panel2);
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
		add(panel3);

		setVisible(true);
		
		// 201502049 ��ȿ��
	}
}

public class Hotel {

	public static void main(String[] args) {

		new MyFrame();
	}
}
