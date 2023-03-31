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
    private int duration, count;
    private SimpleTimer animationTimer;
    private GreenfootImage[] animation;
    private GreenfootSound thunderSound;
    
    public Lightning(int duration)
    {
        this.duration = duration;
        animationTimer = new SimpleTimer();
        animationTimer.mark();
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i + 1) + ".png");
        }
    }
    
    //now can cause damage to both vo and ships
    public void act()
    {
        duration--;
        
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
        
}
    
