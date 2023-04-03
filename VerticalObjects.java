import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the VerticalObjects class
 * The object will move vertically accorss the world
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public abstract class VerticalObjects extends SuperSmoothMover
{
    protected double speed;
    protected double maxSpeed;
    protected int direction; // direction is always -1 or 1, for moving down or up, respectively, have ,count before
    protected SimpleTimer timer;
    
    /**This is teh constructor of the VerticalObjects class
     * 
     * @param direction This is the direction the VerticalObjects move
     */
    public VerticalObjects(int direction) {
        maxSpeed = 2;
        speed = maxSpeed;
        this.direction = direction;
        
    }

    //This is the method that checkes if a lightning hit the object. It it is hitted, the speed will be set to zero.
    public void checkLightning()
    {
        if(isTouching(Lightning.class))
        {
            speed = 0;
            maxSpeed = 0;
        }
    }
    
    //This is the changed move method
    public void move()
    {
        setLocation (getX(), getY() + (int)(speed*direction));
    }
    
    //This is the method to decrease the hp of Ship classes when it is in contact with Ship
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
    
    

