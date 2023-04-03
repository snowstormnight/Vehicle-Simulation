import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the AircraftCarrier class
 * It will pick up the heal bag and take them in with sound effect and animation
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class AircraftCarrier extends Ship
{
    private SimpleTimer st;
    private SimpleTimer st1;
    private GreenfootImage[] animation;
    private int count;
    private GreenfootImage boat;
    private GreenfootSound elevator;
    
    /**
     * This is the constructor of the AircraftCarrier class
     * 
     * @param origin This is the spawner it will spawn on
     * @param lane This is the lane it will moves on
     */
    public AircraftCarrier(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        
        //The code below is used to set up the take in animation
        st = new SimpleTimer();
        st1 = new SimpleTimer();
        st.mark();
        st1.mark();
        count = 0;
        animation = new GreenfootImage[10];
        for(int i = 0; i < 10; i++)
        {
            animation[i] = new GreenfootImage("Take In Animation/" + (i+1) + ".png");
        }
        
        
        boat = new GreenfootImage("Aircraft Carrier.png");
        hp = 6;
        
        //The code below is to set the sound effect when the AircraftCarrier takes in a heal bag
        elevator = new GreenfootSound("elevator.mp3");
        elevator.setVolume(15);
    }
    
    //This is the act method of the AircraftCarrier
    public void act()
    {
        drive();
        hitted();
        if(!exploded)
        {
           takeIn(); 
        }
        stableImage();
        if(hp <= 0)
        {
            explodeMusic();
            damage();
        }
        
    }
    
    //This method meant to make sure the image of the ship will not change if it is moving and hp is great than zero
    public void stableImage()
    {
        if(speed != 0 && !exploded && hp >0)
        {
            setImage(boat);
        }
    }
    
    
    /**This is teh edited drive method for drive(). 
     * This time, it will chnage its speed according to the whether condition
     */
    public void drive()
    {
        if(!checkHitPedestrian())
        {
            super.drive();
        }
        else
        {
            checkHitPedestrian();
        }
        if(st.millisElapsed() > 1000 && !VehicleWorld.raining)
        {
            maxSpeed = 1.5;
            speed = maxSpeed;
        }
    }
    
    //This stops the sound effect of AircraftCarrier
    public void stopPlay()
    {
        elevator.stop();
    }
    
    //This is the method where the take in aniamtion is created
    public void takeIn()
    {
        if(speed == 0)
        {
            elevator.play();
        }
        
        if(speed == 0 && st1.millisElapsed() < 100)
        {
            return;
        }
        else if(speed == 0 && st1.millisElapsed() > 100)
        {
            
            setImage(animation[count]);
            st1.mark();
            count++;
            if(count == 10)
            {
                count = 0;
            }
        }
        
    }
    
    public void increaseHP()
    {
        hp++;
    }
    
    public boolean checkHitPedestrian () {
        Supply s = (Supply)(getOneIntersectingObject(Supply.class));
        
        if(s!=null)
        {
            getWorld().removeObject(s);
            maxSpeed = 0;
            speed = maxSpeed;
            st.mark();
            st1.mark();
            return true;
        }
        return false;
    }
    
    
}
