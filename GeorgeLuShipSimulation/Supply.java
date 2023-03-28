import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supply here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Supply extends VerticalObjects
{
    public Supply(int direction)
    {
        super(direction);
    }
    
    public void act()
    {
        setLocation (getX(), getY() + (int)(speed*direction));
        
    }
    
    //need to heal the aircraft carrier after
}
