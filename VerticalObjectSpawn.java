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
    private GreenfootImage[] animation;
    private GreenfootImage image, nothing;
    private SimpleTimer timer;
    private int x, y, count, hp, speed, random, respawnTime, count1, dead;
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
        hp = 1;
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
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        respawnTime = 420;
        timer = new SimpleTimer();
        timer.mark();
        count1 = 0;
        count = 0;
        dead = 0;
    }
    
    public void act()
    {
        moveAround();
        if(respawnTime == 0)
        {
            setImage(image);
            hp = 20;
            respawnTime = 420;
            dead = 0;
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
            respawnTime--;
            if(dead < 60)
            {
                destroy();
            }
            dead++;
        }
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
        speed = 2;
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
    
    public void destroy()
    {
        if(timer.millisElapsed() < 50)
        {
            return;
        }
        else if(timer.millisElapsed() >= 50)
        {
            setImage(animation[count1]);
            count1++;
            if(count1 == 20)
            {
                count1 = 0;
                setImage(nothing);
            }
            timer.mark();
        }
        
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
    }
}
