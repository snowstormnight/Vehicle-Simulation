import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the SupplyBoat class.
 * The mission of the SupplyBoat class is to reach the other side.
 * When it is hitted by the Ship class, it will be sank and wait for the RepairBoat to reapir it
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class SupplyBoat extends VerticalObjects
{
    private boolean sink;
    private GreenfootImage sank;

    /**
     * This is the constructor of SupplyBoat
     * 
     * @param direction The direction the object travels in
     */
    public SupplyBoat(int direction) {
        super(direction);
        
        if(direction == 1)
        {
            setRotation(90);
        }
        else
        {
            setRotation(270);
        }
        sink = false;
        sank = new GreenfootImage("Sink Boat.png");
    }
    
    //This is the method that will change the speed of the SupplyBoat object
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    //This is the method that tells the SupplyBoat object that it is sank
    public void setSink(boolean sink)
    {
        this.sink = sink;
    }
    
    //This will return a boolean about whether the current SupplyBoat object sank or not
    public boolean getSink()
    {
        return sink;
    }
    
    //This is the act method of the SupplyBoat class
    public void act()
    {
        checkLightning();
        move();
    }
    
    
}
