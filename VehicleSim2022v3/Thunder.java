import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thunder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thunder extends WorldEffect
{
    SimpleTimer st = new SimpleTimer();
    /**
     * Act - do whatever the Thunder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Thunder()
    {
        st.mark();
    }
    
    public void act()
    {
        destroy();
        if(st.millisElapsed() < 1000)
        {
            return;
        }
        else if(st.millisElapsed() > 1000)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void destroy()
    {
        if(isTouching(Vehicle.class))
        {
            removeTouching(Vehicle.class);
        }
    }
}
