import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldEffect extends Actor
{
    /**
     * Act - do whatever the WorldEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    protected void fade (int timeLeft, int fadeTime){
        double percent = timeLeft / (double)fadeTime;
        int newTransparency = (int)(percent * 255);
        //image.setTransparency (newTransparency);
        
    }
    
}
