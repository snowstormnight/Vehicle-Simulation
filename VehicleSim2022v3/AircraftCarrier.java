import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AircraftCarrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AircraftCarrier extends Ship
{
    private SimpleTimer st;
    private SimpleTimer st1;
    private GreenfootImage[] animation;
    private int count;
    private GreenfootImage boat;
    public AircraftCarrier(VehicleSpawner origin, int lane)
    {
        super(origin, lane);
        maxSpeed = 1.5;
        speed = maxSpeed;
        st = new SimpleTimer();
        st1 = new SimpleTimer();
        st.mark();
        st1.mark();
        count = 0;
        boat = new GreenfootImage("Aircraft Carrier.png");
        animation = new GreenfootImage[10];
        for(int i = 0; i < 10; i++)
        {
            animation[i] = new GreenfootImage("Take In Animation/" + (i+1) + ".png");
        }
        hp = 9;
    }
    
    
    public void act()
    {
        drive();
        hitted();
        if(!exploded)
        {
           takeIn(); 
        }
        
        if(speed != 0 && !exploded && hp >0)
        {
            setImage(boat);
        }
        if(hp <= 0)
        {
            damage();
        }
        
    }
    
    
    
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
        //super.drive();
        if(st.millisElapsed() > 1000 && !VehicleWorld.raining)
        {
            maxSpeed = 1.5;
            speed = maxSpeed;
        }
    }
    
    public void takeIn()
    {
        
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
