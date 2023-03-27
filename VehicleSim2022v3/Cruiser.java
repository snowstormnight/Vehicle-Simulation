import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cruiser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cruiser extends Ship
{
    public Cruiser(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 2;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 4;
    }
    
    
    public void act()
    {
        drive();
        damage();
        hitted();
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
