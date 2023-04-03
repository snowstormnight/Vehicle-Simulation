import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the Bullet class
 * Its main method is to destroy other VerticalObjects class and damage the Ship class
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Bullet extends VerticalObjects
{
    private GreenfootImage[] animation;
    private int count, c;
    private ArrayList<Ship> ship;
    private ArrayList<VerticalObjects> verticalObject;
    private GreenfootSound explode;
    
    /**
     * This is the constructor of the Bullet class
     * 
     * @param direction The direction the object travels in
     */
    public Bullet(int direction)
    {
        super(direction);
        if(direction == -1)
        {
            setRotation(270);
        }
        else
        {
            setRotation(90);
        }
        
        //Below is the code for explsion animation
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        timer = new SimpleTimer();
        timer.mark();
        count = 0;
        
        ship = new ArrayList<Ship>();
        verticalObject = new ArrayList<VerticalObjects>();
        
        explode = new GreenfootSound("explode.mp3");
        explode.setVolume(25);
    }
    
    //The act method of Bullet class
    public void act()
    {
        checkLightning();
        move();
        explosion();
        if(getWorld() != null)
        {
            hitShip();
        }
        
    }

    //This method will pause the explode sound effect of the Bullet
    public void explodeStop()
    {
        explode.stop();
    }
    
    //This will make the Bullet explode when it is about to reach the end of the world
    public void explosion()
    {
        if(direction == 1 && getY() == 500)
        {
            explosionAnimation();
        }
        if(direction == -1 && getY() == 150)
        {
            explosionAnimation();
        }
    }
    
    //This method is will play the explosion animation and decrease the hp of Ships and remove any VerticalObjects in the explosion range
    public void explosionAnimation()
    {
        setZero();
        ship = (ArrayList<Ship>)(getObjectsInRange(130,Ship.class));
        for(int i = 0; i < ship.size(); i++)
        {
            ship.get(i).decreaseHP();
        }
        verticalObject = (ArrayList<VerticalObjects>)(getObjectsInRange(130,VerticalObjects.class));
        for(int i = 0; i < verticalObject.size(); i++)
        {
            getWorld().removeObject(verticalObject.get(i));
        }
        explode.play();
        destroy();
        speed = 0;
    }
    
    
    //This will reset the timer to zero to make sure the animation can run
    public void setZero()
    {
        if(direction == 1 && getY() == 500 && c < 1)
        {
            timer.mark();
            c++;
        }
    }
    
    //This method will play the explosion animation and remove itself 
    public void destroy()
    {
        if(timer.millisElapsed() < 50)
        {
            return;
        }
        else if(timer.millisElapsed() >= 50)
        {
            setImage(animation[count]);
            count++;
            if(count == 20)
            {
                count = 0;
                getWorld().removeObject(this);
            }
            timer.mark();
        }
        
    }
}
