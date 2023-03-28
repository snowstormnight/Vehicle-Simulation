import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SuperSmoothMover
{
    private int random;
    private World w;
    
    public Weapon()
    {
        int random = Greenfoot.getRandomNumber(6);
    }
    
    
    public void act()
    {
        if(random == 0)
        {
            turnTowards(215, 25);
        }
        else if(random == 1)
        {
            turnTowards(490, 25);
        }
        else if(random == 2)
        {
            turnTowards(765, 25);
        }
        else if(random == 3)
        {
            turnTowards(215, 575);
        }
        else if(random == 4)
        {
            turnTowards(490, 575);
        }
        else if(random == 4)
        {
            turnTowards(765, 575);
        }
        move(4);
    }
    
    public void addedToWorld()
    {
        w = getWorld();
        
        
    }
    
    
    
}
