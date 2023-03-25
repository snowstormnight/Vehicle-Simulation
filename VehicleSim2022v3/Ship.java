import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the superclass for Vehicles.
 * 
 */
public abstract class Ship extends SuperSmoothMover
{
    protected double maxSpeed;
    protected double speed;
    protected int direction; // 1 = right, -1 = left
    protected boolean moving;
    protected int yOffset;
    protected VehicleSpawner origin;
    private GreenfootImage sank;
    protected double save;
    
    protected abstract boolean checkHitPedestrian ();

    public Ship (VehicleSpawner origin) {
        this.origin = origin;
        moving = true;
        
        if (origin.facesRightward()){
            direction = 1;
            
        } else {
            direction = -1;
            getImage().mirrorHorizontally();
        }
        sank = new GreenfootImage("Sink Boat.png");
        
    }
    
    public void rainSlow()
    {
        maxSpeed = 0.5;
    }
    
    public void getBack()
    {
        maxSpeed = save;
    }
    
    
    
    
    public void hitted()
    {
        SupplyBoat sb = (SupplyBoat)(getOneIntersectingObject(SupplyBoat.class));
        
        if(sb!=null)
        {
            sb.setImage(sank);
            sb.setSpeed(0);
            sb.setSink(true);
        }
    }
    
    public void addedToWorld (World w){
        setLocation (origin.getX() - (direction * 100), origin.getY() - yOffset);
    }

    /**
     * A method used by all Vehicles to check if they are at the edge.
     * 
     * Note that this World is set to unbounded (The World's super class is (int, int, int, FALSE) which means
     * that objects should not be stopped from leaving the World. However, this introduces a challenge as there
     * is the potential for objects to disappear off-screen but still be fully acting and thus wasting resources
     * and affecting the simulation even though they are not visible.
     */
    protected boolean checkEdge() {
        if (direction == 1)
        { // if moving right, check 200 pixels to the right (above max X)
            if (getX() > getWorld().getWidth() + 500){
                return true;
            }
        } 
        else 
        { // if moving left, check 200 pixels to the left (negative values)
            if (getX() < -500){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that deals with movement. Speed can be set by individual subclasses in their constructors
     */
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't know what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        Ship ahead = (Ship) getOneObjectAtOffset (direction * (int)(speed + getImage().getWidth()/2 + 4), 0, Ship.class);
        if (ahead == null)
        {
            speed = maxSpeed;

        } else {
            speed = ahead.getSpeed();
        }
        move (speed * direction);
        
    }   
    
    public void damage()
    {
        Bullet b = (Bullet)(getOneIntersectingObject(Bullet.class));
        if(b!=null)
        {
            getWorld().removeObject(b);
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
