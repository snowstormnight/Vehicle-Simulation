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
    private GreenfootImage boat,bus;
    private ArrayList<SupplyBoat> sb;
    private World w;
    private CheckLane down, up;
    private boolean add, inWorld, oneTime;
    private int location, y, time, direction1, coolTime, direction2;
    public RepairBoat(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        if(origin.facesRightward())
        {
            location = 0;
        }
        else if(!origin.facesRightward())
        {
            location = 1100;
        }
        maxSpeed = 3;
        speed = maxSpeed;
        save = maxSpeed;
        boat = new GreenfootImage("Boat.png");
        sb = new ArrayList<SupplyBoat>();
        bus = new GreenfootImage("ambulance.png");
        inWorld = true;
        time = 100;
        oneTime = true;
        coolTime = 60;
        direction1 = 0;
        direction2 = 12;
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
        y = getY();
        
        down = new CheckLane(500, 40, maxSpeed, direction);
        up = new CheckLane(500, 40, maxSpeed, direction);
        w.addObject(up, location + (150*direction), y - 51);
        w.addObject(down, location + (150*direction), y + 51);
        hp = 5;
    }
    
    
    public void act()
    {
        if(inWorld == true && (getX() > 1100 || getX() < 0))
        {
            inWorld = false;
        }
        if(inWorld && (lane == 0 || lane == 4))
        {
                if(lane == 4 && !down.checkSide()  && time > 0 && oneTime && changeLane())
                {
                    setRotation(direction2);
                    direction1 = direction2;
                    oneTime = false;
                }
                if(lane == 0 && !down.checkSide()  && time > 0 && oneTime  && changeLane())
                {
                    setRotation(-1*direction2);
                    direction1 = -1*direction2;
                    oneTime = false;
                }
            
        }
        if(inWorld && (lane == 3 || lane == 7))
        {
            if(lane == 3 && !up.checkSide()  && time > 0 && oneTime && changeLane())
                {
                    setRotation(direction2);
                    direction1 = direction2;
                    oneTime = false;
                }
            if(lane == 7 && !up.checkSide()  && time > 0 && oneTime  && changeLane())
            {
                setRotation(-1*direction2);
                direction1 = -1*direction2;
                oneTime = false;
            }
        }
        if(inWorld && (lane == 1 || lane == 2))
        {
            if(!up.checkSide() && !down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(-1*direction2);
                direction1 = -1*direction2;
                oneTime = false;
            }
            else if(!up.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(direction2);
                direction1 = direction2;
                oneTime = false;
            }
            else if(!down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(-1*direction2);
                direction1 = -1*direction2;
                oneTime = false;
            }
        }
        
        if(inWorld && (lane == 5 || lane == 6))
        {
            if(!up.checkSide() && !down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(-1*direction2);
                direction1 = -1*direction2;
                oneTime = false;
            }
            else if(!up.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(-direction2);
                direction1 = -direction2;
                oneTime = false;
            }
            else if(!down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                setRotation(1*direction2);
                direction1 = 1*direction2;
                oneTime = false;
            }
        }
            
            
        if(direction1 == -12 || direction1 == 12)
        {
            time--;
        }
        
        if(time == 0)
        {
            setRotation(0);
            direction1 = 0;
            speed = 3;
            coolTime = 0;
        }
        drive();
        repair();
        up.setSpeed(speed);
        down.setSpeed(speed);
        coolTime--;
        damage();
    }
    
    public boolean changeLane()
    {
        Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        if(ahead != null && ahead.getSpeed() < speed)
        {
            return true;
        }
        
        return false;
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
    
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't know what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        if (ahead == null)
        {
            
            speed = maxSpeed;
        } else if(ahead != null && direction1 == 0){
            speed = ahead.getSpeed();
        }
        else if(direction1 != 0)
        {
            speed = 2;
        }
        move (speed * direction);
        
    }   
    
}
