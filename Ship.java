import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the superclass for Vehicles.
 * 
 */
public abstract class Ship extends SuperSmoothMover
{
    protected double maxSpeed, speed;
    protected int direction; // 1 = right, -1 = left
    protected boolean moving, exploded;
    protected int yOffset;
    protected VehicleSpawner origin;
    private GreenfootImage sank;
    protected double save;
    protected int lane, hp, count;
    private GreenfootImage[] animation;
    private SimpleTimer st;
    private GreenfootSound explode;
    

    public Ship (VehicleSpawner origin, int lane) {
        this.origin = origin;
        moving = true;
        this.lane = lane;
        if (origin.facesRightward()){
            direction = 1;
            
        } else {
            direction = -1;
            getImage().mirrorHorizontally();
        }
        sank = new GreenfootImage("Sink Boat.png");
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        st = new SimpleTimer();
        st.mark();
        count = 0;
        exploded = false;
        explode = new GreenfootSound("explode.mp3");
    }
    
    public void rainSlow()
    {
        maxSpeed = 0.5;
    }
    
    public void getBack()
    {
        maxSpeed = save;
    }
    
    public void explodeMusic()
    {
        if(hp == 0)
        {
            explode.play();
        }
        
    }

    //This method is used to check if a supply boat is hit with ship class, if yes, set the image to sink
    public void hitted()
    {
        ArrayList<SupplyBoat> sb = (ArrayList<SupplyBoat>)(getIntersectingObjects(SupplyBoat.class));
        if(sb!=null)
        {
            for(int i = 0; i < sb.size(); i++)
            {
                sb.get(i).setImage(sank);
                sb.get(i).setSpeed(0);
                sb.get(i).setSink(true);
            }
        }
        
        
    }
        

    /**
     * Method that deals with movement. Speed can be set by individual subclasses in their constructors
     */
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't know what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        //Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        if (ahead == null)
        {
            speed = maxSpeed;

        } else {
            speed = ahead.getSpeed();
        }
        move (speed * direction);
        
    }   
    
    public void decreaseHP()
    {
        hp--;
    }
    
    public void damage()
    {
        
        if(hp <= 0)
        {
            maxSpeed = 0;
            speed = 0;
            exploded = true;
            
            if(st.millisElapsed() < 50)
            {
                return;
            }
            else if(st.millisElapsed() >= 50)
            {
                setImage(animation[count]);
                count++;
                if(count == 20)
                {
                    ArrayList<Ship> s = (ArrayList<Ship>)(getObjectsInRange(150,Ship.class));
                    for(int i = 0; i < s.size(); i++)
                    {
                        s.get(i).decreaseHP();
                    }
                    count = 0;
                    getWorld().removeObject(this);
                }
                st.mark();
            }
        }
    }

    /**
     * An accessor that can be used to get this Vehicle's speed. Used, for example, when a vehicle wants to see
     * if a faster vehicle is ahead in the lane.
     */
    public double getSpeed(){
        return speed;
    }
}
