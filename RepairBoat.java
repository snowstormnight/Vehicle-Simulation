import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This is the RepairBoat class
 * This boat class will repair any boat taht is sink and will not crash them when they are in contact.
 * When this class see the front ship is slower, they will try to change lane.
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class RepairBoat extends Ship
{
    private GreenfootImage boat,bus;
    private ArrayList<SupplyBoat> sb;
    private World w;
    private CheckLane down, up;
    private boolean add, inWorld, oneTime;
    private int location, y, time, direction1, coolTime, direction2;
    private GreenfootSound speedUp;
    private GreenfootSound healUp;
    
    /**
     * This is the constructor of the RepairBoat class
     * 
     * @param origin This is the spawner it will spawn on
     * @param lane This is teh lane it will move on
     */
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
        
        //Below is the variables to help change lane
        boat = new GreenfootImage("Boat.png");
        sb = new ArrayList<SupplyBoat>();
        inWorld = true;
        time = 100;
        oneTime = true;
        coolTime = 60;
        
        direction1 = 0;
        direction2 = 12;
        
        speedUp = new GreenfootSound("boat speedup.mp3");
        healUp = new GreenfootSound("heal.mp3");
        healUp.setVolume(8);
    }
    
    /**
     * This method will be called when teh object is added to world
     * It is mainly used to set up the checklane method
     * 
     * @param w This is the world the RepairBoat in
     */
    public void addedToWorld(World w)
    {
        this.w = w;
        y = getY();
        down = new CheckLane(500, 40, maxSpeed, direction);
        up = new CheckLane(500, 40, maxSpeed, direction);
        w.addObject(up, location + (150*direction), y - 51);
        w.addObject(down, location + (150*direction), y + 51);
        hp = 4;
    }
    
    //This method stops the sound effect of the RepairBoat sound effect
    public void stopPlay()
    {
        speedUp.stop();
        healUp.stop();
    }
    
    //This is the act methdo of the RepairBoat class
    public void act()
    {
        
        checkInWorld();
        drive();
        repair();
        damage();
        
    }
    
    //This method will check if the object is in the world
    public void checkInWorld()
    {
        if(inWorld == true && (getX() > 1100 || getX() < 0))
        {
            inWorld = false;
        }
    }
    
    //This is the main method that will decide when the chnage the lane of the ship
    public void changeLaneWay()
    {
        //The codes down below is used to make sure repair ship can change lane accrutely in every lane
        if(inWorld && (lane == 0 || lane == 4))
        {
            if(lane == 4 && !down.checkSide()  && time > 0 && oneTime && changeLane())
            {
                changeLane2();
            }
            if(lane == 0 && !down.checkSide()  && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
            
        }
        if(inWorld && (lane == 3 || lane == 7))
        {
            if(lane == 3 && !up.checkSide()  && time > 0 && oneTime && changeLane())
            {
                changeLane2();
            }
            if(lane == 7 && !up.checkSide()  && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
        }
        if(inWorld && (lane == 1 || lane == 2))
        {
            if(!up.checkSide() && !down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
            else if(!up.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane2();
            }
            else if(!down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
        }
        
        if(inWorld && (lane == 5 || lane == 6))
        {
            if(!up.checkSide() && !down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
            else if(!up.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane1();
            }
            else if(!down.checkSide() && time > 0 && oneTime  && changeLane())
            {
                changeLane2();
            }
        }
        
        
        //The code below is what happened after the change lane is done. In this case, the direction and speed will set to original. 
        //Cool down will be set to true;
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
        
        up.setSpeed(speed);
        down.setSpeed(speed);
        coolTime--;
    }
    
    //This is the boolean that checks whether it is possible to change lane
    public boolean changeLane()
    {
        Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        if(ahead != null && ahead.getSpeed() < speed)
        {
            return true;
        }
        
        return false;
    }
    
    //This is the chnage lane method for the boat is changing lane to the above
    public void changeLane1()
    {
        setRotation(-1*direction2);
        direction1 = -1*direction2;
        oneTime = false;
        speedUp.play();
    }
    
    //This is the change lane method for the boat that is changing lane below
    public void changeLane2()
    {
        setRotation(direction2);
        direction1 = direction2;
        oneTime = false;
        speedUp.play();
    }
    
    //This is the method that will repair the sank supplyboat
    public void repair()
    {
        sb = (ArrayList<SupplyBoat>)(getIntersectingObjects(SupplyBoat.class));
        
        if(sb.size() > 0)
        {
            healUp.play();
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
    
    //This is the method that will decide whether to check lane or not and change the speed according to the situation.
    public void drive() 
    {
        changeLaneWay();
        
        //changed to make sure the speed will always be 2 when the lane change
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
    
    
    public boolean checkHitPedestrian()
    {
        return false;
    }
}
