import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the SupplyBoat class.
 * The mission of the SupplyBoat class is to reach the other side.
 * When it is hitted by the Ship class, it will be sank and wait for the RepairBoat to reapir it
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SupplyBoat extends VerticalObjects
{
    private boolean sink;
    private GreenfootImage sank;

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
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public void setSink(boolean sink)
    {
        this.sink = sink;
    }
    
    public boolean getSink()
    {
        return sink;
    }
    
    public void act()
    {
        checkLightning();
        move();
    }
    
    
}
