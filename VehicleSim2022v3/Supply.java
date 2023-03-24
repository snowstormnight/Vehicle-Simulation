import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supply here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Supply extends Pedestrian
{
    GreenfootImage s = new GreenfootImage("supply.png");
    
    public Supply(int direction)
    {
        super(direction);
        setImage(s);
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
