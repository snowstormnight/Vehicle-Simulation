import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends VerticalObjects
{
    public Bullet(int direction)
    {
        super(direction);
        if(direction == 1)
        {
            setRotation(90);
        }
        else
        {
            setRotation(270);
        }
    }
    
    
    
    public void act()
    {
        setLocation (getX(), getY() + (int)(speed*direction));
        
    }
}
