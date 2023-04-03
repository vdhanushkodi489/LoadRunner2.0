import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public void createRows(int numWalls, int numRows, int X, int Y) {
        for(int i = 0; i < numRows; i++) {
            for(int n = 0; n < numWalls; n++) {
                addObject(new Platform(), X + (24 * n), Y + (i * 24));
            }
        }
       
    }
    public void createLadderStack(int numLadders, int X, int Y) {
        for (int i = 0; i < numLadders;i++) {
            addObject(new Ladder(), X, Y + (i * 24));
        }
    }
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage background = new GreenfootImage(600, 480);
        background.setColor(Color.BLACK);
        background.fillRect(0, 0, 600, 480);
        setBackground(background);
        createRows(10, 1, 0, 150);
        createRows(100, 2, 0, 365);
        createLadderStack(9, 235, 150);
    }
}
