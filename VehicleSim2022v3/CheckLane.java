import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CheckLane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckLane extends SuperSmoothMover
{
    public static final Color TRANSPARENT_RED = new Color (255, 0, 0, 128);
    private int width, height, direction;
    private double speed;
    private GreenfootImage image;
    
    public CheckLane(int width, int height, double speed, int direction)
    {
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        image = new GreenfootImage(width, height);
        image.setColor(TRANSPARENT_RED);
        image.fillRect(0, 0, width-1, height - 1);
        setImage(image);
    }
    
    public void act()
    {
        move(speed*direction);
        
    }
    
    public int get()
    {
        return height;
    }
    
    public boolean checkSide()
    {
        return isTouching(Ship.class);
    }
    
    public void setSpeed(double change)
    {
        speed = change;
    }
}
