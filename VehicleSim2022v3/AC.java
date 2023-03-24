import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AC extends Vehicle
{
    SimpleTimer st = new SimpleTimer();
    
    
    public AC(VehicleSpawner origin, int x){
        super (origin); // call the superclass' constructor first
        
        maxSpeed = 2.5;
        speed = maxSpeed;
        st.mark();
        
    }
    
    public void act()
    {
        drive1();
        damage();
        
        // Add your action code here.
    }
    
    
    public void drive1()
    {
        if(!checkHitPedestrian())
        {
            super.drive();
        }
        if(checkHitPedestrian())
        {
            checkHitPedestrian();
        }
        if(st.millisElapsed() > 1000)
        {
            maxSpeed = 2.5;
            speed = maxSpeed;
        }
         
    }
    
    public boolean checkHitPedestrian () {
        Supply s = (Supply)(getOneIntersectingObject(Supply.class));
        HB hb = (HB)(getOneIntersectingObject(HB.class));
        
        if(s!=null)
        {
            getWorld().removeObject(s);
            maxSpeed = 0;
            speed = maxSpeed;
            st.mark();
            return true;
        }
        return false;
    }
    
    
    
    
}
