import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Destroyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Destroyer extends Ship
{
    public Destroyer(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 2.5;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 3;
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
