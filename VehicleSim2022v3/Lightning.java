import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Lightning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lightning extends Effect
{
    private int duration;
    private int count;
    private SimpleTimer animationTimer;
    private GreenfootImage[] animation;
    public Lightning(int duration)
    {
        this.duration = duration;
        //image = new GreenfootImage("lightning.png");
        animationTimer = new SimpleTimer();
        animationTimer.mark();
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i + 1) + ".png");
        }
    }
    
    public void act()
    {
        duration--;
        ArrayList<VerticalObjects> vo = (ArrayList<VerticalObjects>)(getObjectsInRange(150,VerticalObjects.class));
        
        if(duration < 30)
        {
            for(int i = 0; i < vo.size(); i++)
            {
                getWorld().removeObject(vo.get(i));
            }
            explode();
            
        }
        
        
    }
    
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
        
}
    

