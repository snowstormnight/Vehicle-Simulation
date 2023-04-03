import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the effect class. This class will form some effects as time goes.
 * Those effects will affect the ships.
 * 
 * @author George Lu 
 * @version final 2023/4/1
 */
public abstract class Effect extends Actor
{
    protected GreenfootImage image;
    protected double transparency;
    
    /**This method will control the transparency of the effect and the remain time. When remain time is zero, it will remove the effect.
     * 
     * @param duration This is the totla time it should show up the world
     * @param remainTime This is the current remaining time of the object
     * @param count This is the variable determines when should the object fade
     */
    public void controlEffect(int duration, int remainTime, int count)
    {
        if(duration <= 0)
        {
            getWorld().removeObject(this);
        }
        else if(duration <= count)
        {
            transparency = ((double)(duration)/(remainTime));
            int newTransparency = (int)(transparency * 255);
            image.setTransparency(newTransparency);
        }
    }
    
    public abstract void stopPlay();
}
