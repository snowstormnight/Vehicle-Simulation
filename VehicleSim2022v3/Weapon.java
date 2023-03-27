import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SuperSmoothMover
{
    private int direction;
    private World w;
    
    public Weapon()
    {
        
    }
    
    public void addedToWorld()
    {
        w = getWorld();
    }
    
    
    
}
