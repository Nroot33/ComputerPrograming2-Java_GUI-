import java.awt.*;
import javax.swing.*;

class Circle {
	int radius;
	int centerX;
	int centerY;
	Color color;

	public Circle(int radius, int centerX, int centerY, Color color) {
		this.radius = radius;
		this.centerX = centerX;
		this.centerY = centerY;
		this.color = color;
	}

	public void drawCircle(Graphics g) {
		g.setColor(color);
		g.fillOval(centerX, centerY, radius, radius);
	}
}

class MainPanel extends JPanel {
	public void paint(Graphics g) 
   { 

     Color c1 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)); 
     Color c2 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
     Color c3 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
     Color c4 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
     Color c5 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
     
     Circle C1 = new Circle((int)(Math.random()*125),(int)(Math.random()*75),(int)(Math.random()*75),c1); 
     C1.drawCircle(g);
     Circle C2 = new Circle((int)(Math.random()*75),(int)(Math.random()*150),(int)(Math.random()*150),c2);  
     C2.drawCircle(g);
     Circle C3 = new Circle((int)(Math.random()*150),(int)(Math.random()*100),(int)(Math.random()*100),c3); 
     C3.drawCircle(g);
     Circle C4 = new Circle((int)(Math.random()*100),(int)(Math.random()*50),(int)(Math.random()*50),c4); 
     C4.drawCircle(g);
     Circle C5 = new Circle((int)(Math.random()*200),(int)(Math.random()*125),(int)(Math.random()*125),c5); 
     C5.drawCircle(g);
     
   }
}

class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	MainFrame() {
		super("원 그리기");
		this.add(new MainPanel());
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

public class HW01 {
	public static void main(String[] args) {
		new MainFrame();
	}
}
