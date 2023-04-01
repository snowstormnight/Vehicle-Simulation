import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleShip extends Ship
{
    private int time;
    private World w;
    public BattleShip(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 6;
        time = 180;
    }
    
    
    public void act()
    {
        if(time % 180 == 0)
        {
            w.addObject(new FiredBullet(), getX(), getY());
        }
        time--;
        drive();
        hitted();
        damage();
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
    
    
    public void addedToWorld(World w)
    {
        this.w = w;
    }
    
    public void stopPlay()
    {
        
    }
}
