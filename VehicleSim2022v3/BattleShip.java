import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleShip extends Ship
{
    private int shoot;
    private World w;
    public BattleShip(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 5;
        shoot = 60;
    }
    
    
    public void act()
    {
        drive();
        hitted();
        if(shoot == 0)
        {
            shoot = 60;
            setRotation(getRotation());
            w.addObject(new Weapon(), getX(), getY());
            
        }
        shoot--;
        damage();
        
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
