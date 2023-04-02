import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class VerticalObjectSpawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalObjectSpawn extends Actor
{
    public static final Color BLACK = new Color (0, 0, 0);
    private GreenfootImage image, nothing;
    private int x, y, count, hp, speed,  random, respawnTime, count1;
    private World w;
    private int topOrNot;
    private ArrayList<FiredBullet> fb;
    
    
    public VerticalObjectSpawn(int x, int y, int topOrNot)
    {
        image = new GreenfootImage(35, 20);
        image.setColor(BLACK);
        image.fill();
        setImage(image);
        this.x = x;
        this.y = y;
        this.topOrNot = topOrNot;
        count = 120;
        hp = 10;
        nothing = new GreenfootImage("nothing.png");
        random = Greenfoot.getRandomNumber(4);
        if(random == 0)
        {
            setRotation(0);
        }
        else
        {
            setRotation(180);
        }
        
        respawnTime = 420;
        count1 = 0;
        count = 0;
        speed = 2;
    }
    
    public void act()
    {
        moveAround();
        
        if(respawnTime == 0)
        {
            setImage(image);
            speed = 2;
            hp = 20;
            respawnTime = 420;
        }
        if(count%120 == 0 && hp > 0)
        {
            addSpawner(topOrNot);
        }
        count--;
        fb = (ArrayList<FiredBullet>)(getIntersectingObjects(FiredBullet.class));
        for(FiredBullet fb1: fb)
        {
            getWorld().removeObject(fb1);
            hp--;
        }
        if(hp <= 0)
        {
            speed = 0;
            respawnTime--;
            setImage(nothing);
        }
        
    }
    
    public int getHP()
    {
        return hp;
    }
    
    
    public void addSpawner(int direction)
    {
        int verticalObjects = Greenfoot.getRandomNumber(4);
        if(verticalObjects == 0)
        {
            w.addObject (new Supply (direction), getX(), getY());
        }
        else if(verticalObjects == 1)
        {
            w.addObject (new SupplyBoat (direction), getX(), getY());     
        }
        else if(verticalObjects == 2)
        {
            w.addObject(new Bullet(direction), getX(), getY());
        }else if(verticalObjects == 3)
        {
            w.addObject(new Missile(direction), x, y);
        }
    }
    
    public void moveAround()
    {
        if(Greenfoot.getRandomNumber(240) == 0)
        {
            random = Greenfoot.getRandomNumber(4);
            if(random == 0)
            {
                setRotation(0);
            }
            else
            {
                setRotation(180);
            }
        }
        if(getX() == 1000)
        {
            setRotation(180);
        }
        if(getX() == 100)
        {
            setRotation(0);
        }
        move(speed);
    }
    
    
    
    public void addedToWorld(World w)
    {
        this.w = w;
    }
}
