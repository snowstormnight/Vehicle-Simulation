import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pedestrian that tries to walk across the street
 */
public abstract class VerticalObjects extends SuperSmoothMover
{
    protected double speed;
    protected double maxSpeed;
    protected int direction,count; // direction is always -1 or 1, for moving down or up, respectively
    
    public VerticalObjects(int direction) {
        // choose a random speed
        maxSpeed = 2;
        speed = maxSpeed;
        
        this.direction = direction;
        
        count = 0;
    }

    /**
     * Act - do whatever the Pedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        
    }
    
    
    public void check()
    {
        if(isTouching(Lightning.class))
        {
            speed = 0;
            maxSpeed = 0;
        }
    }
    

    public void move()
    {
        
        if (getOneObjectAtOffset(0, (int)(direction * getImage().getHeight()/2 + (int)(direction * speed)), Ship.class) == null){
        setLocation (getX(), getY() + (int)(speed*direction));
        }
            
        
    }
    
    
        
}
    
    

