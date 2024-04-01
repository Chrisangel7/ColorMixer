import java.awt.*;

public class Hole {
    public double xpos;                //the x position
    public double ypos;                //the y position
    public int width;
    public int height;
    //the speed of the hero in the y direction
    public Rectangle rec;
    public Image pic;

    public Hole(double pXpos, double pYpos, Image picParameter) {
        width = 30;
        height = 30;
        xpos = pXpos;
        ypos = pYpos;
        pic = picParameter;
        rec = new Rectangle((int)xpos, (int)ypos, width,height);
//      g.drawRect(750, 635, 30, 30);
    }
}
