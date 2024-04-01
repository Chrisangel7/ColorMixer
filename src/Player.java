
import java.awt.*;

public class Player {


    public double xpos;                //the x position
    public double ypos;                //the y position
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public double dx;                    //the speed of the hero in the x direction
    public double dy;                    //the speed of the hero in the y direction
    public Rectangle recUp;
    public Rectangle recDown;
    public Rectangle recRight;
    public Rectangle recLeft;
    public Rectangle recWhole;
    public Image pic;

    //movement booleans
    public boolean right;
    public boolean left;
    public boolean onRock;


    public Player(double pXpos, double pYpos, double dxParameter, double dyParameter, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        width = 60;
        height = 50;
        dx = dxParameter;
        dy = dyParameter;
        pic = picParameter;
        isAlive = true;
        recUp = new Rectangle((int) xpos+10, (int) ypos, width-20, 10);
        recDown = new Rectangle((int) xpos+10, (int) ypos+40, width-20, 10);
        recRight = new Rectangle((int) xpos, (int) ypos+10, 10, 30);
        recLeft = new Rectangle((int) xpos+50, (int) ypos+10, 10, 30);
        recWhole = new Rectangle((int)xpos, (int)ypos, width, height);
//

        onRock = false;

    } // constructor

    //move( ) method for a keyboard controlled character
    public void move() {
//        if(onRock==true){
////            dy = dy + 0;
//        }else{
//            dy = (dy + 0.3);
//        }

//        if (onRock == true) {
////            right = false;
////            left = false;
//        }
//        else {
            if (right == true) {
                xpos = xpos + dx;
                ypos = ypos - dy;
                dy = dy - 0.3;
                if (xpos > 1000 - width) {
                    xpos = 1000 - width;
                }
            }

            if (left == true) {
                xpos = xpos - dx;
                ypos = ypos - dy;

                dy = dy - 0.3;

                if (xpos < 0) {
                    xpos = 0;
                }
//            }
        }


        //always put this after you've done all the changing of the xpos and ypos values
        recUp = new Rectangle((int) xpos+10, (int) ypos, width-20, 10);
        recDown = new Rectangle((int) xpos+10, (int) ypos+40, width-20, 10);
        recRight = new Rectangle((int) xpos, (int) ypos+10, 10, 30);
        recLeft = new Rectangle((int) xpos+50, (int) ypos+10, 10, 30);
        recWhole = new Rectangle((int)xpos, (int)ypos, width, height);
    }

}
