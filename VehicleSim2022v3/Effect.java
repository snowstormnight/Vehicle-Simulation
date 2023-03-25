import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Effect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Effect extends Actor
{
    protected GreenfootImage image;
    protected double transparency;
    public void act()
    {
        
    }
    
    public void controlEffect(int duration, int remainTime)
    {
        if(duration <= 0)
        {
            getWorld().removeObject(this);
        }
        else if(duration <= 90)
        {
            transparency = ((double)(duration)/(remainTime));
            int newTransparency = (int)(transparency * 255);
            image.setTransparency(newTransparency);
        }
    }
}
