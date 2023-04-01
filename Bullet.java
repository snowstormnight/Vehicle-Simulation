import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends VerticalObjects
{
    private GreenfootImage[] animation;
    private int count, c;
    private ArrayList<Ship> ship;
    private ArrayList<VerticalObjects> verticalObject;
    private GreenfootSound explode;
    
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
        animation = new GreenfootImage[20];
        ship = new ArrayList<Ship>();
        verticalObject = new ArrayList<VerticalObjects>();
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        timer = new SimpleTimer();
        timer.mark();
        count = 0;
        explode = new GreenfootSound("explode.mp3");
        explode.setVolume(25);
    }
    
    
    
    public void act()
    {
        checkLightning();
        setLocation (getX(), getY() + (int)(speed*direction));
        explosion();
        if(getWorld() != null)
        {
            hitShip();
        }
        
    }

    
    public void explodeStop()
    {
        explode.stop();
    }
    
    public void explosion()
    {
        if(direction == 1 && getY() == 500)
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
        if(direction == -1 && getY() == 150)
        {
            setZero();
            ship = (ArrayList<Ship>)(getObjectsInRange(130,Ship.class));
            for(int i = 0; i < ship.size(); i++)
            {
                ship.get(i).decreaseHP();
            }
            explode.play();
            destroy();
            speed = 0;
        }
    }
    
    
    
    public void setZero()
    {
        if(direction == 1 && getY() == 500 && c < 1)
        {
            timer.mark();
            c++;
        }
    }
    
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
