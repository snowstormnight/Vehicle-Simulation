import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cruiser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cruiser extends Ship
{
    public Cruiser(VehicleSpawner origin)
    {
        super(origin);
        maxSpeed = 2;
        speed = maxSpeed;
        save = maxSpeed;
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
