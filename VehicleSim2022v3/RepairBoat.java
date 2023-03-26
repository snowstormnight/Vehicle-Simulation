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
    private World w;
    private CheckLane down, up;
    private boolean add;
    private int location;
    public RepairBoat(VehicleSpawner origin)
    {
        super(origin);
        
        maxSpeed = 3;
        speed = maxSpeed;
        save = maxSpeed;
        boat = new GreenfootImage("Boat.png");
        sb = new ArrayList<SupplyBoat>();
        
        down = new CheckLane(298, 50, maxSpeed);
        up = new CheckLane(298, 50, maxSpeed);
        
        
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
        if(w != null)
        {
            //System.out.println("yes");
            down = new CheckLane(298, 50, maxSpeed);
            up = new CheckLane(298, 50, maxSpeed);
            w.addObject(up, location, 0);
        }
        else if(w == null)
        {
            //System.out.println("fuck");
        }
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
        
        
    }
    

    
    public boolean checkHitPedestrian ()
    {
        return false;
    }
}
