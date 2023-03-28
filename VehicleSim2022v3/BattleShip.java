import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleShip extends Ship
{
    public BattleShip(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 5;
    }
    
    
    public void act()
    {
        drive();
        hitted();
        damage();
        
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
