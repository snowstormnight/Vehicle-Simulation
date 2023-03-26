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
    private int time;
    public RepairBoat(VehicleSpawner origin)
    {
        super(origin);
        maxSpeed = 3;
        speed = maxSpeed;
        save = maxSpeed;
        boat = new GreenfootImage("Boat.png");
        sb = new ArrayList<SupplyBoat>();
        w = getWorld();
        add = false;
        down = new CheckLane(298, 50, maxSpeed);
        up = new CheckLane(298, 50, maxSpeed);
        time = 0;
    }
    
    
    public void act()
    {
        drive();
        damage();
        repair();
        if(!add && time > 2)
        {
            w.addObject(up, getX(), getY() + 49);
            w.addObject(down, getX(), getY() + 49);
        }
        if(add)
        {
            down.setSpeed(maxSpeed);
            up.setSpeed(maxSpeed);
            System.out.println(up.checkSide());
        }
        time++;
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
