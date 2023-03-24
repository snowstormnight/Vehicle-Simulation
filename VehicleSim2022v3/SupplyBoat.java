import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SupplyBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SupplyBoat extends Pedestrian
{
    private boolean sink;
    GreenfootImage sinking = new GreenfootImage("sinking.png");
    GreenfootImage notsinking = new GreenfootImage("supply boat.png");
    public SupplyBoat(int direction) {
        super(direction);
        sink = false;
        if(direction == -1)
        {
            setRotation(180);
        }
        else
        {
            setRotation(0);
        }
    }
    
    public void act()
    {
        sink();
        setLocation (getX(), getY() + (int)(speed*direction));
        if (direction == -1 && getY() < 100){
            getWorld().removeObject(this);
        } else if (direction == 1 && getY() > 550){
            getWorld().removeObject(this);
        }
    }
    
    
    
    public void sink()
    {
        AC ac = (AC)(getOneIntersectingObject(AC.class));
        B b = (B)(getOneIntersectingObject(B.class));
        D d = (D)(getOneIntersectingObject(D.class));
        
        if(ac != null || b != null || d != null)
        {
            sink = true;
            setImage(sinking);
            speed = 0;
        }
        
        if(isTouching(HealBoat.class))
        {
            setImage(notsinking);
            speed = 2.5;
        }
       
    }
}
