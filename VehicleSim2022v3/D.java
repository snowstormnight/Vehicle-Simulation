import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class D extends Vehicle
{
    GreenfootImage original = new GreenfootImage("American destroyer.png");
    GreenfootImage original1 = new GreenfootImage("japan destroyer.png");
    
    public D(VehicleSpawner origin, int x){
        super (origin); // call the superclass' constructor first
        
        maxSpeed = 2.5;
        speed = maxSpeed;
        
    }
    
    public void act()
    {
        drive();
        damage();
    }
    
    public boolean checkHitPedestrian () {
        // currently empty
        return false;
    }
}
