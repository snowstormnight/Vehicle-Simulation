import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the VerticalObjectSpawn class.
 * The mission of this class is to spawn VerticalObjects and move horizontally.
 * Thius class also has hp to determine whether they should exist or not. 
 * When they are hit by the FiredBullet class, their hp will be decrease by 1.
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class VerticalObjectSpawn extends Actor
{
    public static final Color BLACK = new Color (0, 0, 0);
    private GreenfootImage image, nothing;
    private int x, y, count, hp, speed,  random, respawnTime, count1;
    private World w;
    private int topOrNot;
    private ArrayList<FiredBullet> fb;
    
    /**
     * This is the constructor of the VerticalObjectsSpawn class
     * 
     * @param x This is the x cordinate it should spawn
     * @param y This is the y cordinate it should spawn
     * @param topOrNot This is the integer that determines whether this object is at top or bottom
     */
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
    
    //This is teh act method of VerticalObjectsSpawn class
    public void act()
    {
        moveAround();
        respawn();
        addvo();
        count--;
        checkDamage();
        dead();
        
        
    }
    
    //This is the method that respawn this spawn place after the dead time is passed.
    public void respawn()
    {
        if(respawnTime == 0)
        {
            setImage(image);
            speed = 2;
            hp = 20;
            respawnTime = 420;
        }
    }
    
    //This is the method that determine whether a VerticalObjects should be add or not
    public void addvo()
    {
        if(count%120 == 0 && hp > 0)
        {
            addSpawner(topOrNot);
        }
    }
    
    //This is the method that checks if it is hit by a FiredBullet. It will decrase the hp by one and remove the FiredBullet object if it is true;
    public void checkDamage()
    {
        fb = (ArrayList<FiredBullet>)(getIntersectingObjects(FiredBullet.class));
        for(FiredBullet fb1: fb)
        {
            getWorld().removeObject(fb1);
            hp--;
        }
    }
    
    //This is the method that will set this object into dead mode, such as change picture and count respawn time.
    public void dead()
    {
        if(hp <= 0)
        {
            speed = 0;
            respawnTime--;
            setImage(nothing);
        }
    }
    
    //This method will return the hp of the current VerticalObjectsSpawner object
    public int getHP()
    {
        return hp;
    }
    
    //This is the method taht determines which VerticalObject should be add.
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
    
    //This is the methdo that ensure this object will move around and will be in the world.
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
    
    
    //This method is called when the object is added and will turn the world this object currently live in for it to use.
    public void addedToWorld(World w)
    {
        this.w = w;
    }
}
