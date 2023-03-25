import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pedestrian that tries to walk across the street
 */
public abstract class VerticalObjects extends SuperSmoothMover
{
    protected double speed;
    protected double maxSpeed;
    protected int direction; // direction is always -1 or 1, for moving down or up, respectively
    protected boolean awake;
    public VerticalObjects(int direction) {
        // choose a random speed
        maxSpeed = 2;
        speed = maxSpeed;
        // start as awake 
        awake = true;
        this.direction = direction;
    }

    /**
     * Act - do whatever the Pedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        
    }

    public void move()
    {
        if (awake){
            if (getOneObjectAtOffset(0, (int)(direction * getImage().getHeight()/2 + (int)(direction * speed)), Ship.class) == null){
                setLocation (getX(), getY() + (int)(speed*direction));
            }
            
        }
    }
    
    /**
     * Method to cause this Pedestrian to become knocked down - stop moving, turn onto side
     */
    public void knockDown () {
        speed = 0;
        setRotation (90);
        awake = false;
    }

    /**
     * Method to allow a downed Pedestrian to be healed
     */
    public void healMe () {
        speed = maxSpeed;
        setRotation (0);
        awake = true;
    }
    
    public boolean isAwake () {
        return awake;
    }
}
