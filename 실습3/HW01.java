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
		setTitle("���� ����"); // Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0,2,150,5)); // ���� �г� - 0�� 2�� ���� 150,5 ����
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,2,150,5)); // ���� �г� - 0�� 2�� ���� 150,5 ����
		
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // �ؽ�Ʈ �г� - BoxLayout Y�� ���� ����
		
		
		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS)); // ���� �г� - BoxLayout Y�� ���� ����
		
		label1 = new JLabel("������ �Է��Ͻÿ�."); //�� ����
		label2 = new JLabel("������ �Է��Ͻÿ�.");
		
		t1 = new TextField(10); // ���� �ؽ�Ʈ �ʵ� ����
		t2 = new TextField(10); // ���� �ؽ�Ʈ �ʵ� ����
		t3 = new TextField(30); // ��� �ؽ�Ʈ �ʵ� ����
		
		button = new JButton("��ȯ");
		button.setAlignmentX(Component.CENTER_ALIGNMENT); //��ư ����
		
		panel1.add(label1);
		panel1.add(t1);
		// ���� �гο� ��ư�� �� �߰�
		panel2.add(label2);
		panel2.add(t2);
		// ���� �гο� ��ư�� �� �߰�
		panel3.add(panel1);
		panel3.add(panel2);
		// �ؽ�Ʈ �гο� ����,���� �г� �߰�
		panel4.add(panel3);
		// ���� �гο� �ؽ�Ʈ �г� �߰�
		panel4.add(button);
		// ���� �гο� "��ȯ" ��ư �߰�
		panel4.add(t3);
		// ���� �гο� ��� �ؽ�Ʈ  �߰�
		
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
