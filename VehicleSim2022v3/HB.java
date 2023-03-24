import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HB extends Pedestrian
{
    private int x,y;
    
    public HB(int direction)
    {
        super(direction);
    }
    
    
    public void act()
    {
        setLocation (getX(), getY() + (int)(speed*direction));
        if (direction == -1 && getY() < 100){
            getWorld().removeObject(this);
        } else if (direction == 1 && getY() > 550){
            getWorld().removeObject(this);
        }
    
    }
    

}
