import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class that helps RepairBoat to decide whether change lane or not.
 * They are invisible rectangles that can detect whether they are in touch with a boat and tell RepairBoat, and RepairBoat will make decision base on the 
 * result
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class CheckLane extends SuperSmoothMover
{
    public static final Color TRANSPARENT_RED = new Color (255, 0, 0, 128);
    private int width, height, direction;
    private double speed;
    private GreenfootImage image;
    
    
    /**
     * The constructor of the CheeckLane class
     * 
     * @param width This is the width of the rectangle
     * @param height This is the height of the rectangle
     * @param speed This is the speed it should move with
     * @param direction This is the direction it should move
     */
    public CheckLane(int width, int height, double speed, int direction)
    {
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        image = new GreenfootImage(width, height);
        image.setColor(TRANSPARENT_RED);
        //image.fillRect(0, 0, width-1, height - 1);
        setImage(image);
    }
    
    //This is the act method
    public void act()
    {
        move(speed*direction);
        
    }
    
    //This method will return the height of the rectangle
    public int get()
    {
        return height;
    }
    
    
    //This is the boolean that returns whether it is touching otehr ships
    public boolean checkSide()
    {
        return isTouching(Ship.class);
    }
    
    /**This is the method that can set the speed of the rectangle to make it move with ship
     * 
     * 
     * @param change This is the speed it will change to
     */
    public void setSpeed(double change)
    {
        speed = change;
    }
}
