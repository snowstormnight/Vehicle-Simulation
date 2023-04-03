import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * This is the Supply class.
 * This class will move vertically upwards and will be take in by the AircraftCarrier after it is in touch with it.
 * When it is being take in, it will increase the AircraftCarrier's hp by one.
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Supply extends VerticalObjects
{
    private int heal;
    
    /**
     * This is the constructor of the Supply class
     * 
     * @param direction The direction the object travels in
     */
    public Supply(int direction)
    {
        super(direction);
        heal = 2;
    }
    
    //This is the act method of the Supply class
    public void act()
    {
        move();
    }
    
    //This is the method that will heal the AircraftCarrier that is in contact with it.
    public void heal()
    {
        AircraftCarrier ac = (AircraftCarrier)(getOneIntersectingObject(AircraftCarrier.class));
        ac.hp++;
    }
}
