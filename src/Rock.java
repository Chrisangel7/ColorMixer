import java.awt.*;

public class Rock {


    public double xpos;                //the x position
    public double ypos;                //the y position
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public double width;                    //the speed of the hero in the x direction
    public double height;                    //the speed of the hero in the y direction
    public Rectangle rec;




    public Rock(double pXpos, double pYpos, double widthParameter, double heightParameter) {

        xpos = pXpos;
        ypos = pYpos;
        width = widthParameter;
        height = heightParameter;
        isAlive = true;
        rec = new Rectangle((int)xpos, (int)ypos, (int)width, (int)height);

    } // constructor
}