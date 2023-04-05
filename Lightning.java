import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the lightning class
 * When they 
 * 
 * @author George Lu 
 * @version final 2023/4/1
 */
public class Lightning extends Effect
{
    //set up variables
    private int duration, count;
    private SimpleTimer animationTimer;
    private GreenfootImage[] animation;
    private GreenfootSound thunderSound;
    
    /**Constructor of the lightning class
     * 
     * @param duration This is the time this efect should last
     */
    public Lightning(int duration)
    {
        this.duration = duration;
        //The variables below is to create a sequence of PNGs and timer to form animation 
        animationTimer = new SimpleTimer();
        animationTimer.mark();
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i + 1) + ".png");
        }
        
        //Sound variable
        thunderSound = new GreenfootSound("thunder.mp3");
        thunderSound.setVolume(7);
    }
    
    //This is the act method of lightning
    public void act()
    {
        duration--;
        
        damage();
        
        if(getWorld() != null)
        {
            thunderSound.play();
        }
        
        
        
    }
    
    //This will cause damage to ships and remove vertical objects
    public void damage()
    {
        ArrayList<VerticalObjects> vo = (ArrayList<VerticalObjects>)(getObjectsInRange(150,VerticalObjects.class));
        ArrayList<Ship> s = (ArrayList<Ship>)(getObjectsInRange(150,Ship.class));
        if(duration < 30)
        {
            for(int i = 0; i < vo.size(); i++)
            {
                getWorld().removeObject(vo.get(i));
            }
            for(int i = 0; i < s.size(); i++)
            {
                s.get(i).decreaseHP();
            }
            explode();
        }
    }
    
    //This method will stop the sound effect of lightning
    public void stopPlay()
    {
        thunderSound.stop();
    }
    
    //This method can play the explode animation and destroy verticalobejcts and damage ships
    public void explode()
    {
        
        if(animationTimer.millisElapsed() < 25)
        {
            return;
        }
        else if(animationTimer.millisElapsed() >= 25)
        {
            setImage(animation[count]);
            count++;
            if(count == 20)
            {
                count = 0;
                getWorld().removeObject(this);
            }
            animationTimer.mark();
        }
    }
    
    //This method play the sound effect when the lightning class is added to the world
    public void addedToWorld(World w)
    {
        thunderSound.play();
    }
        
}
    

