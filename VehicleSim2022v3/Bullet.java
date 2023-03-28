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
    private SimpleTimer st;
    private int count,c;
    private ArrayList<Ship> ship;
    private ArrayList<VerticalObjects> vo;
    
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
        vo = new ArrayList<VerticalObjects>();
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        st = new SimpleTimer();
        st.mark();
        count = 0;
    }
    
    
    
    public void act()
    {
        check();
        setLocation (getX(), getY() + (int)(speed*direction));
        explosion();
        
        
    }
    
    public void explosion()
    {
        if(direction == 1 && getY() == 500)
        {
            setZero();
            ship = (ArrayList<Ship>)(getObjectsInRange(130,Ship.class));
            
            vo = (ArrayList<VerticalObjects>)(getObjectsInRange(130,VerticalObjects.class));
            for(int i = 0; i < vo.size(); i++)
            {
                getWorld().removeObject(vo.get(i));
            }
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
                System.out.println("f");
            }
            destroy();
            speed = 0;
        }
    }
    
    
    
    public void setZero()
    {
        if(direction == 1 && getY() == 500 && c < 1)
        {
            st.mark();
            c++;
        }
    }
    
    public void destroy()
    {
        if(st.millisElapsed() < 50)
        {
            return;
        }
        else if(st.millisElapsed() >= 50)
        {
            setImage(animation[count]);
            count++;
            if(count == 20)
            {
                count = 0;
                getWorld().removeObject(this);
            }
            st.mark();
        }
        
    }
}
