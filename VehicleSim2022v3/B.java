import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class B extends Vehicle
{
   
    
    public B(VehicleSpawner origin, int x){
        super (origin); // call the superclass' constructor first
        
        maxSpeed = 2.5;
        speed = maxSpeed;
       
    }
    
    public void act()
    {
        checkHitPedestrian ();
        drive();
        damage();
    }
    
    public boolean checkHitPedestrian () {
        if(isTouching(Pedestrian.class))
        {
            speed = 0;
        }
        return false;
    }
}
