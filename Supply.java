import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Supply here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Supply extends VerticalObjects
{
    private int heal;
    public Supply(int direction)
    {
        super(direction);
        heal = 2;
    }
    
    public void act()
    {
        move();
    }
    
    
    public void heal()
    {
        AircraftCarrier ac = (AircraftCarrier)(getOneIntersectingObject(AircraftCarrier.class));
        ac.hp++;
    }
}
