import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HW02 extends JFrame {
  
   BufferedImage img1 = null;
   BufferedImage img2 = null;
   BufferedImage img3 = null;
   BufferedImage img4 = null;
   BufferedImage img5 = null;
   BufferedImage img6 = null;

   public HW02() { 
      setSize(750, 750);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("주사위 던지기 프로그램");
      add(new Mypaen1());
      setVisible(true);

      try { 
         img1 = ImageIO.read(new File("dice1"));
         img2 = ImageIO.read(new File("dice2"));
         img3 = ImageIO.read(new File("dice3"));
         img4 = ImageIO.read(new File("dice4"));
         img5 = ImageIO.read(new File("dice5"));
         img6 = ImageIO.read(new File("dice6"));
      } catch (IOException e) {
         System.out.println(e.getMessage());
         System.exit(0);
      }
   }

   class Mypaen1 extends JPanel { 
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
       
         int x1 = (int) (Math.random() * 100); 
         int y1 = (int) (Math.random() * 100); 

        
         int x2 = (int) (Math.random() * 750) + (x1 + 1); 
         int y2 = (int) (Math.random() * 750) + (y1 + 1); 

         int pictures1 = (int) (Math.random() * 6); 
         int pictures2 = (int) (Math.random() * 6); 
         
         if ( (x1 != x2 && y1 != y2) && (x1 != y2 && y1 != x2) ) { 
            if ( (x1 < 100 && y1 < 100) &&  
                  (x2 >=100 && x2 <=849 && y2 >=100 && y2 <=849) ) {

               if (pictures1 == 1) // 
                  g.drawImage(img1, x1, y1, null);
               else if (pictures1 == 2) // 
                  g.drawImage(img2, x1, y1, null);
               else if (pictures1 == 3) //
                  g.drawImage(img3, x1, y1, null);
               else if (pictures1 == 4) // 
                  g.drawImage(img4, x1, y1, null);
               else if (pictures1 == 5) // 
                  g.drawImage(img5, x1, y1, null);
               else if (pictures1 == 6) // 
                  g.drawImage(img6, x1, y1, null);
               else
                  return;

               if (pictures2 == 1) 
                  g.drawImage(img1, x2, y2, null);
               else if (pictures2 == 2) // 
                  g.drawImage(img2, x2, y2, null);
               else if (pictures2 == 3) // 
                  g.drawImage(img3, x2, y2, null);
               else if (pictures2 == 4) //
                  g.drawImage(img4, x2, y2, null);
               else if (pictures2 == 5) //
                  g.drawImage(img5, x2, y2, null);
               else if (pictures2 == 6) // 
                  g.drawImage(img6, x2, y2, null);
               else
                  return;

            }
         }
      }
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new HW02();
   }

}