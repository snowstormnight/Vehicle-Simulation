import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the superclass forShips. It contains basic methods like move and explode animation method. 
 * It also contains method to decrease its own hp and check the objects intersect with it.
 * 
 * 
 * @author George Lu
 * @version final 2023/4/1
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
    protected GreenfootSound explode;
    protected boolean oneTime;
    
    /**This is the constructor for Ships
     * 
     * @param origin This is the spawner the ship will spawn on
     * @param lane This will let the Ships know which lane they are on
     */
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
        
        //All the code below is to set up the animation for explosion
        sank = new GreenfootImage("Sink Boat.png");
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        st = new SimpleTimer();
        st.mark();
        count = 0;
        
        //This is to set up the variables to decide the sound effect
        exploded = false;
        explode = new GreenfootSound("explode.mp3");
        explode.setVolume(25);
        oneTime = false;
    }
    
    //This will decrease the speed of the ship
    public void rainSlow()
    {
        maxSpeed = 0.5;
    }
    
    //This will make teh ship returns to its original speed
    public void getBack()
    {
        maxSpeed = save;
    }
    
    //Abstract method to make sure every sub-class has it
    public abstract void stopPlay();
    
    //This will play the explosion sound effect when the ships' hp reach zero
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
    
    //This is the method to decrease the hp of the ships
    public void decreaseHP()
    {
        hp--;
    }
    
    //This is the method taht pauses the explosion sound effect for ships
    public void stopExplode()
    {
        explode.stop();
    }
    
    /**This is the method determines whether the ship shoudl explode or not. 
     * When the hp reaches zero, it will play the explosion animtiona and sound effect
     */
    public void damage()
    {
        if(hp <= 0)
        {
            maxSpeed = 0;
            speed = 0;
            exploded = true;
            oneTime = true;
            if(oneTime)
            {
                explode.play();
            }
            
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
    
    public abstract boolean checkHitPedestrian();
}
