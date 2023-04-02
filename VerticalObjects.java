import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * A Pedestrian that tries to walk across the street
 */
public abstract class VerticalObjects extends SuperSmoothMover
{
    protected double speed;
    protected double maxSpeed;
    protected int direction; // direction is always -1 or 1, for moving down or up, respectively, have ,count before
    protected SimpleTimer timer;
    
    public VerticalObjects(int direction) {
        maxSpeed = 2;
        speed = maxSpeed;
        this.direction = direction;
        
    }

    
    public void checkLightning()
    {
        if(isTouching(Lightning.class))
        {
            speed = 0;
            maxSpeed = 0;
        }
    }
    

    public void move()
    {
        setLocation (getX(), getY() + (int)(speed*direction));
    }
    
    public void hitShip()
    {
        ArrayList<Ship> s = (ArrayList<Ship>)(getIntersectingObjects(Ship.class));
        if(s.size() > 0)
        {
            for(int i = 0; i < s.size(); i++)
            {
                if(s.get(i) != null)
                {
                    s.get(i).decreaseHP();
                }
            }
            getWorld().removeObject(this);
        }
        
    }
        
}
    
    

