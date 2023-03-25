import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Border here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Border extends Actor
{
    public Border(boolean direction)
    {
        if(direction)
        {
            setRotation(270);
        }
    }
    
    public void act()
    {
        if(isTouching(SuperSmoothMover.class))
        {
            removeTouching(SuperSmoothMover.class);
        }
    }
}
