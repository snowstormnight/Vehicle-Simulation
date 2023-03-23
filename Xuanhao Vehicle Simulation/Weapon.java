import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SuperSmoothMover
{
    protected int damage;
    protected double speed;
    protected boolean us;
    protected static ArrayList<ACJA> a;
    protected static ArrayList<BJA> b;
    protected static ArrayList<CJA> c;
    protected static ArrayList<DJA> d;
    protected static ArrayList<HJA> e;
    
    
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    public void act()
    {
        a = (ArrayList<ACJA>)(getWorld().getObjects(ACJA.class));
        b = (ArrayList<BJA>)(getWorld().getObjects(BJA.class));
        c = (ArrayList<CJA>)(getWorld().getObjects(CJA.class));
        d = (ArrayList<DJA>)(getWorld().getObjects(DJA.class));
        e = (ArrayList<HJA>)(getWorld().getObjects(HJA.class));
    }
    
    public Weapon(int damage, double speed, boolean us)
    {
        this.damage = damage;
        this.speed = speed;
        this.us = us;
        
        
    }
    
    public double[] aim()
    {
        if(us)
        {
            int random = Greenfoot.getRandomNumber(5);
            if(random == 0)
            {
                random = Greenfoot.getRandomNumber(a.size());
                
            } else if(random == 1)
            {
                random = Greenfoot.getRandomNumber(b.size());
            }else if(random == 2)
            {
                random = Greenfoot.getRandomNumber(c.size());
            }else if(random == 3)
            {
                random = Greenfoot.getRandomNumber(d.size());
            }else if(random == 4)
            {
                random = Greenfoot.getRandomNumber(e.size());
            }
            
            
          
        }
    }
    
    public void damageRange()
    {
        ArrayList<BattleShip> b = (ArrayList<BattleShip>)(getObjectsInRange(50, BattleShip.class));
        if(b.size() > 0)
        {
            
        }
    }
}
