import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the BattleShip class
 * It will shoot bullet that can destroy the VerticalObjectSpawn objects
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class BattleShip extends Ship
{
    private int time;
    private World w;
    
    /**
     * This is the constructor of the BattleShip 
     * 
     * @param origin This is the spawner it will spawn on
     * @param lane This is teh lane it will move on
     */
    public BattleShip(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        save = maxSpeed;
        hp = 6;
        time = 180;
    }
    
    //This is the act method
    public void act()
    {
        //The code down below will help BattleShip fire a bullet every 3 secs
        if(time % 180 == 0)
        {
            w.addObject(new FiredBullet(), getX(), getY());
        }
        time--;
        drive();
        hitted();
        damage();
    }
    
    //This is the not needed abstract method
    public boolean checkHitPedestrian ()
    {
        return false;
    }
    
    /**
     * This method will return a world to help BattleShip to do the shooting
     * 
     * @param w The world BatlleShip is in
     */
    public void addedToWorld(World w)
    {
        this.w = w;
    }
    
    //This is the not needed abstract methdo from the ship class
    public void stopPlay()
    {
        
    }
}
