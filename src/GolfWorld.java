import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.awt.event.*;
//import com.scrtwpns.Mixbox;
import java.awt.Color;

//Keyboard and Mouse
//Step 0 - Import
import java.awt.event.*;

//*******************************************************************************
// Class Definition Section

//Step 1 for Keyboard control - implements Keylistener
public class GolfWorld implements Runnable, KeyListener, MouseListener {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public Image golfPic;
    public Image backgroundPic;
    public Image rockPic;
    public Image startPic;
    public Image endGame;
    public Image flagPic;
    public Image wingame;
    public Image SunsetPic;
    public Image BlueBucket;
    public Image RedBucket;
    public Image YellowBucket;

    public int mouseX, mouseY;
    public int clickX, clickY;

    // public SoundFile winningMusic;
    // public SoundFile themeMusic;

   /* public Player user;
    public Rock[] rocky;

    public Hole hole1;
    public int count=0;
    public int flaps=0;
    public boolean endOfGame = false;
    public boolean winGame = false; */

    public boolean startScreen = true;
    public boolean MouseClicked = false;

    public int[] chosenColor = {0,0,0};
    public int[] canvasColor= {0, 0, 0};

    public static void main(String[] args) {
        GolfWorld myApp = new GolfWorld();   //creates a new instance of the game
        new Thread(myApp).start();                 //creates a threads & starts up the code in the run( ) method
    }

    public GolfWorld() {
        setUpGraphics();

        canvas.addKeyListener(this);
        canvas.addMouseListener(this);

        //Step 3 - Keyboard use.  addKeyListener(this)
        //canvas.addKeyListener(this);
        //canvas.addMouseListener(this);

        //variable and objects
        //load images
        golfPic = Toolkit.getDefaultToolkit().getImage("golf.png"); //load the picture
        backgroundPic = Toolkit.getDefaultToolkit().getImage("oilfield.jpg");
        rockPic = Toolkit.getDefaultToolkit().getImage("rocks.png");
        startPic = Toolkit.getDefaultToolkit().getImage("startpic.png");
        endGame = Toolkit.getDefaultToolkit().getImage("endgame.png");
        flagPic = Toolkit.getDefaultToolkit().getImage("flagpole.png");
        wingame = Toolkit.getDefaultToolkit().getImage("wingame.png");
        BlueBucket = Toolkit.getDefaultToolkit().getImage("BlueBucket.png");
        RedBucket = Toolkit.getDefaultToolkit().getImage("RedBucket.png");
        YellowBucket = Toolkit.getDefaultToolkit().getImage("YellowBucket.png");

        SunsetPic = Toolkit.getDefaultToolkit().getImage("Sunset.png");


        // themeMusic = new SoundFile ("flappygolfbgm.wav");
        //themeMusic.play();
        //winningMusic = new SoundFile ("winsound.wav");


        //create (construct) the objects needed for the game
        /*user = new Player(70, 100, 5, 5, golfPic);
        rocky = new Rock[6];
        rocky[0] = new Rock(0,175,230,590);
        rocky[1] = new Rock(900, 170, 100, 595);
        rocky[2] = new Rock(600, 275, 100, 610);
        //rocky[2] = new Rock(790, 300, 350, 90);
        rocky[3]=new Rock(600, 440, 200, 85);
        rocky[4]= new Rock(700, 650, 800, 80);
        rocky[5] = new Rock(300,285,100,30);

        hole1 = new Hole (750, 635, flagPic); */

    }

    public void moveThings() {
        //calls the move( ) code in the objects
//        if (user.onRock == false) {
//            user.move();
//        } else {
//            user.ypos = 175 - user.width;
//        }
        // user.move();
//        user.ypos = 175 - user.height;


    }

   /* public void checkIntersections() {
    System.out.println(user.xpos+ "    "+user.ypos);
        if (user.recWhole.intersects(hole1.rec)){

            user.isAlive = false;
            winGame = true;
        }

//        if(user.recUp){
//
//        }
      //  System.out.println(user.onRock);
        for(int i=0;i<rocky.length; i++){
            if(user.recDown.intersects(rocky[i].rec)){
                System.out.println("crash1");

//            if(user.xpos<150- user.width && user.xpos > 0) {
                user.onRock = true;
                user.dy = -0.8*user.dy;
                user.move();
//                user.right = false;
//                user.left = false;
//            }
            }
        }
        for(int i=0;i<rocky.length; i++){
            if(user.recUp.intersects(rocky[i].rec)){
                System.out.println("crash2");

//            if(user.xpos<150- user.width && user.xpos > 0) {
                user.onRock = true;
                user.dy = -0.8*user.dy;
                user.move();
//                user.right = false;
//                user.left = false;
//            }
            }

        }
        for(int i=0;i<rocky.length; i++){
            if(user.recLeft.intersects(rocky[i].rec)){
                System.out.println("crash3");

                user.onRock = true;
                user.dx = -0.8*user.dx;
                user.xpos=user.xpos-10;
//                user.move();
//                user.xpos += 5;
               // user.xpos = rocky[i].xpos + rocky[i].width;
                //user.right = true;
                //user.left = false;

            } // left
        }

        for(int i=0;i<rocky.length; i++){
            if(user.recRight.intersects(rocky[i].rec)){
                System.out.println("crash4");

                user.onRock = true;
                user.dx = -0.8*user.dx;
               user.xpos=user.xpos+10;
//                user.move();
//                user.xpos -= 5;
                user.right = false;
                user.left = true;
            } // right
        }

//        if (!user.recDown.intersects(rock1.rec)) {
//            user.onRock = false;
//        }
//        if(user.recLeft.intersects(rock1.rec)){
//            user.onRock = true;
//            user.dx = -user.dx;
//            user.move();
//
//
//        }
//        if (!user.recLeft.intersects(rock1.rec)) {
//            user.onRock = false;
//        }
//        if(user.rec.intersects(rock2.rec)){
////            if(user.xpos<150- user.width && user.xpos > 0) {
//            user.onRock = true;
//            user.dy = -user.dy;
//            user.move();
////                user.right = false;
////                user.left = false;
////            }
//        }
//        if (!user.rec.intersects(rock2.rec)) {
//            user.onRock = false;
//        }
//        if(user.rec.intersects(rock3.rec)){
////            if(user.xpos<150- user.width && user.xpos > 0) {
//            user.onRock = true;
//            user.dy = -user.dy;
//            user.move();
////                user.right = false;
////                user.left = false;
////            }
//        }
//        if (!user.rec.intersects(rock3.rec)) {
//            user.onRock = false;
//        }
//        if(user.rec.intersects(rock4.rec)){
////            if(user.xpos<150- user.width && user.xpos > 0) {
//            user.onRock = true;
//            user.dy = -user.dy;
//            user.move();
////                user.right = false;
////                user.left = false;
////            }
//        }
//        if (!user.rec.intersects(rock4.rec)) {
//            user.onRock = false;
//        }

    } */


    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (startScreen == true) {
            g.drawImage(startPic, 0, 0, 1000, 700, null);

        } else {

            g.drawImage(SunsetPic, 0, 0, 1000, 700, null);
            g.drawImage(rockPic, 0, 0, 1000, 700, null);
            g.drawImage(BlueBucket, 250, 300, 100, 300, null);
            g.drawImage(RedBucket, 500, 300, 100, 300, null);
            g.drawImage(YellowBucket, 750, 300, 100, 300, null);
            //   g.drawImage(hole1.pic, (int)hole1.xpos, (int)hole1.ypos-40, 60,60, null);
            g.setColor(Color.blue);

            g.setColor(new Color (canvasColor[0], canvasColor[1], canvasColor[2]));
            g.fillRect(500, 600, 400, 100);
            //g.drawRect((int)hole1.xpos, (int)hole1.ypos, hole1.width, hole1.height);

            //put your code to draw things on the screen here.
            //  if(user.isAlive == true) {
            //     g.drawImage(user.pic, (int) user.xpos, (int) user.ypos, user.width, user.height, null);

            g.setColor(Color.red);
        // g.drawRect((int) user.xpos, (int) user.ypos, user.width, user.height);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.setColor(Color.white);


            //   g.drawString("Number of Flaps: " + String.valueOf(flaps), 10, 60);

        //   for(int i=0;i<rocky.length; i++) {
        //g.drawRect((int) rocky[i].xpos, (int)rocky[i].ypos, (int)rocky[i].width, (int)rocky[i].height);
    }

//            g.drawRect(600, 440, 250, 85);
//            g.drawRect(700, 650, 800, 80);
    //   g.setColor(Color.green);
//            g.drawRect((int) user.xpos+10, (int) user.ypos, user.width-20, 10);
//            g.drawRect((int) user.xpos+10, (int) user.ypos+40, user.width-20, 10);
//            g.drawRect((int) user.xpos, (int) user.ypos+10, 10, 30);
//            g.drawRect((int) user.xpos+50, (int) user.ypos+10, 10, 30);

    //   if(user.ypos>700){
    //    g.drawImage(endGame,250,80,500,500,null);
    //     endOfGame=true;

    //  }
            /*if (winGame==true){
                g.drawImage(wingame,250,80,500,500,null);
                System.out.println("playwinningsound");
                //winningMusic.play();

            }*/
        g.dispose();
        bufferStrategy.show();
}






    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            //checkIntersections();
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
          //  if(endOfGame==true) {
          //      count++;
           //     System.out.println(count);
          //  }
         //   if(winGame==true) {
            //    count++;
            //    System.out.println(count);
            }
            //if(count==100){
              //  System.out.println("quit");
             //   System.exit(0);

            }







    //Graphics setup method
    public void setUpGraphics() {
        frame = new JFrame("CheeseWorld");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements here

        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

        if (keyCode > 0 && startScreen == true){
            startScreen = false;
        }
    } //keyPressed()

    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
        //This method will do something when a key is released
        if (keyCode == 68) {
//           user.onRock = false;
        }

        if(keyCode == 65){
//            user.onRock = false;
        }

    }


    public void keyTyped(KeyEvent event) {
        // handles a press of a character key  (any key that can be printed but not keys like SHIFT)
        // we won't be using this method but the definition needs to be in your program
    }//keyTyped()

    public void mousePressed(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        int x,y;
        x = e.getX();
        y = e.getY();
        clickX = x;
        clickY = y;
        MouseClicked = true;
        if(x<350 && x>250 && y>300 && y<600){
            System.out.println("clicked in blue bucket");
            chosenColor[0] = 0;
            chosenColor[1] = 0;
            chosenColor[2] = 255;
        }
        if(x>500 && x<600 && y>300 && y<600){
            System.out.println("clicked in red bucket");
            chosenColor[0] = 255;
            chosenColor[1] = 0;
            chosenColor[2] = 0;        }
        if(x>750 && x<850 && y>300 && y<600){
            System.out.println("clicked in green bucket");
            chosenColor[0] = 0;
            chosenColor[1] = 255;
            chosenColor[2] = 0;        }

        if(x>500 && x<900 && y>600 &&y<700){
            for(int i = 0; i<canvasColor.length;i++){
                canvasColor[i] = (canvasColor[i] + chosenColor[i])/2;
            }
            //            g.fillRect(500, 600, 400, 100);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e) {

    }

    // REQUIRED Mouse Listener methods
    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        int x, y;
        x = e.getX();
        y = e.getY();
        mouseX = x;
        mouseY = y;
    }
}

