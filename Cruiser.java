import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Crusier class.
 * There is nothing special about thsi class as it is for increase the diversity
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Cruiser extends Ship
{
    /**
     * This is the constructor of the Cruiser
     * 
     * @param origin This is the spawner it will spawn on
     * @param lane This is teh lane it will move on
     */
    public Cruiser(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 2;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 5;
    }
    
    //This is the act method of the Crusier class
    public void act()
    {
        drive();
        hitted();
        damage();
    }
    
    //This is the not need method from the ship class
    public boolean checkHitPedestrian ()
    {
        return false;
    }
    
    //This is the not need method from the ship class
    public void stopPlay()
    {
        
    }
}
