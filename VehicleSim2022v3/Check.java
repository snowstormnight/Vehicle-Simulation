import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Check here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Check extends Actor
{
    /**
     * Act - do whatever the Check wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(HB.class))
        {
            removeTouching(HB.class);
        }
    }
}
