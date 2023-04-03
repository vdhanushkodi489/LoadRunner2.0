import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage myImage;
    boolean isDown = false;
    Actor uLad; 
    Actor plat;
    public void keyMovement() {
        if (Greenfoot.isKeyDown("Right")) {
            setRotation(0);
            move(3);
            myImage = new GreenfootImage("player_run_02.png");
            setImage(myImage);
            isDown = false;
        }
            
        
        if (Greenfoot.isKeyDown("Left")) {
            setRotation(180);
            move(3);
            setImage(myImage);
            if (isDown == false) {
                myImage.mirrorVertically();
                isDown = true;
            }
        } 
    }
    public void ladderMovement() {
        uLad = getOneIntersectingObject(Ladder.class);
        if (Greenfoot.isKeyDown("Up") && uLad != null){
             setLocation(uLad.getX(), getY());
             setLocation(getX(), getY() -3);
             myImage = new GreenfootImage("player_climb_ladder.png");
             setImage(myImage);
        } else if (Greenfoot.isKeyDown("Down") && uLad != null){
            setLocation(uLad.getX(), getY()); 
            setLocation(getX(), getY() + 3);
            myImage = new GreenfootImage("player_climb_ladder.png");
            setImage(myImage);
        } 
        
    }
    public void checkUnderWall() {
        while(getOneObjectAtOffset(0, 11, Platform.class) != null){
            setLocation(getX(), getY() -1); 
        }
        
    }
    public void fall() {
       
            setLocation(getX(), getY() + 3);    
      
    }
    public void act()
    {
        if(uLad == null && getOneObjectAtOffset(0, 11, Platform.class) == null) {
            fall();
        } 
        checkUnderWall();
        keyMovement();
        ladderMovement();
        
     
        
    }
}
