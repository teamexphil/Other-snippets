import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: PHIMCD
 * Date: 23/03/15
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
public class MandelPanel extends JPanel {

    private double acorner=-2;
    private double bcorner=-1.25;
    private double side=2.5;

    public static int SIZE = 600;

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // get mandel int[]
        int[] pic;
        int iterations=0;
        int colourR,colourG,colourB=0;
        Mandel mandel = new Mandel();

        //pic = mandel.mandel(SIZE, -2, -1.25, 2.5);
        pic = mandel.mandel(SIZE, acorner, bcorner, side);

        // iterate array for panel
        for (int i=0 ; i<SIZE*SIZE ; i++){
            // when array % SIZE ++  y ++

            // set color based on value
            iterations =  pic[i];

            if (iterations<20){
              colourR = iterations*8;
              colourG = iterations*4;
              colourB = iterations*8;
            }
            else if(iterations>900){
                colourR = iterations/8;
                colourG = iterations/4;
                colourB = 0;
            }
            else {
                colourR = iterations/4;
                colourG = iterations/4;
                colourB = 20;
            }
            g2d.setColor(new Color(colourR,colourG,colourB));

            // plot location
            g2d.drawLine(i%SIZE, i/SIZE, i%SIZE, i/SIZE);

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public void paintComponent(Graphics g,double Acorner, double BCorner, double Side) {
        acorner = Acorner;
        bcorner = BCorner;
        side = Side;

        super.paintComponent(g);
        doDrawing(g);
    }
}
