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
    protected static ArrayList<Actor> a;
    protected static ArrayList<BJA> b;
    protected static ArrayList<CJA> c;
    protected static ArrayList<DJA> d;
    protected static ArrayList<HJA> e;
    protected int[] position;
    public static boolean c1;
    protected int m;
    public static int x,y,random;
    
    
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    
    
    public Weapon(int damage, double speed)
    {
        this.damage = damage;
        this.speed = speed;
        position = new int[3];
        position[0] = 0;
        a = new ArrayList<Actor>();
    }
    
    public void act()
    {
        a = (ArrayList<Actor>)(getWorld().getObjects(Actor.class));
        
        //a = (ArrayList<ACJA>)(getWorld().getObjects(ACJA.class));
        b = (ArrayList<BJA>)(getWorld().getObjects(BJA.class));
        c = (ArrayList<CJA>)(getWorld().getObjects(CJA.class));
        d = (ArrayList<DJA>)(getWorld().getObjects(DJA.class));
        e = (ArrayList<HJA>)(getWorld().getObjects(HJA.class));
        if(!a.isEmpty())
            {
                getWorld().removeObject(this);
                //random = Greenfoot.getRandomNumber(a.size());
                //position[0] = (a.get(random)).getX();
                //if(position[0] != 0)
                //{
                    //getWorld().removeObject(this);
                //}
                //position[1] = (a.get(random)).getY();
                //x = position[0];
                //y = position[1];
            }
            
              
    }
    
    public void aim()
    {
        //if(us)
        //{
            random = Greenfoot.getRandomNumber(5);
            if(!a.isEmpty())
            {
                getWorld().removeObject(this);
                //random = Greenfoot.getRandomNumber(a.size());
                //position[0] = (a.get(random)).getX();
                //if(position[0] != 0)
                //{
                    //getWorld().removeObject(this);
                //}
                //position[1] = (a.get(random)).getY();
                //x = position[0];
                //y = position[1];
            }
            
                
                
                
                
                //return position;
            //if(random == 0)
           // {
                
           // } //else if(random == 1)
           // {
                //random = Greenfoot.getRandomNumber(b.size());
            //}else if(random == 2)
            //{
                //random = Greenfoot.getRandomNumber(c.size());
            //}else if(random == 3)
           // {
                //random = Greenfoot.getRandomNumber(d.size());
            //}else if(random == 4)
            //{
                //random = Greenfoot.getRandomNumber(e.size());
            //}
            
            
          
        //}
    }
    
    public void damageRange()
    {
        ArrayList<BattleShip> b = (ArrayList<BattleShip>)(getObjectsInRange(50, BattleShip.class));
        if(b.size() > 0)
        {
            
        }
    }
}
