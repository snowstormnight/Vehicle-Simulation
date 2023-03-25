import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RepairBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RepairBoat extends Ship
{
    private GreenfootImage boat;
    public RepairBoat(VehicleSpawner origin)
    {
        super(origin);
        maxSpeed = 2.5;
        speed = maxSpeed;
        boat = new GreenfootImage("Boat.png");
    }
    
    
    public void act()
    {
        drive();
        damage();
        repair();
    }
    
    public void repair()
    {
        SupplyBoat sb = (SupplyBoat)(getOneIntersectingObject(SupplyBoat.class));
        
        if(sb!=null)
        {
            sb.setImage(boat);
            sb.setSpeed(2);
            sb.setSink(false);
        }
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
