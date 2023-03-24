import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealBoat extends Vehicle
{
    /**
     * Act - do whatever the HealBoat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HealBoat(VehicleSpawner origin){
    super (origin); // call the superclass' constructor first
        
    maxSpeed = 2.5;
    speed = maxSpeed;

    }   

    public void act(){
        drive();
        damage();
    }
    
    
    public boolean checkHitPedestrian()
    {
        return false;
    }
}
