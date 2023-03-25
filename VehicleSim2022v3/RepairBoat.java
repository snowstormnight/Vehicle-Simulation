import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class RepairBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RepairBoat extends Ship
{
    private GreenfootImage boat;
    private ArrayList<SupplyBoat> sb;
    public RepairBoat(VehicleSpawner origin)
    {
        super(origin);
        maxSpeed = 2.5;
        speed = maxSpeed;
        save = maxSpeed;
        boat = new GreenfootImage("Boat.png");
        sb = new ArrayList<SupplyBoat>();
    }
    
    
    public void act()
    {
        drive();
        damage();
        repair();
    }
    
    public void repair()
    {
        sb = (ArrayList<SupplyBoat>)(getIntersectingObjects(SupplyBoat.class));
        
        if(sb.size() > 0)
        {
            for(int i = 0; i < sb.size(); i++)
            {
                if(sb.get(i) != null && sb.get(i).getSink() == true)
                {
                    sb.get(i).setImage(boat);
                    sb.get(i).setSpeed(2);
                    sb.get(i).setSink(false);
                }
            }
        }
        
        /*if(sb!=null && sb.getSink() == true)
        {
            sb.setImage(boat);
            sb.setSpeed(2);
            sb.setSink(false);
        }
        */
    }
    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
