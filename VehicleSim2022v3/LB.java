import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LB extends Pedestrian
{
    private int direction1;
    private SimpleTimer st;
    public LB(int direction)
    {
        super(direction);
        direction1 = Greenfoot.getRandomNumber(100)+40;
        setRotation(direction1);
        if(direction == -1)
        {
            setRotation(direction1+180);
        }
        st = new SimpleTimer();
        st.mark();
    }
    
    public void act()
    {
        //setLocation (getX(), getY() + (int)(speed*direction));
        if(st.millisElapsed() > 1000)
        {
            direction1 = Greenfoot.getRandomNumber(100)+40;
            setRotation(direction1);
            if(direction == -1)
            {
                setRotation(direction1+180);
            }
            st.mark();
        }
        move(2);
        if (direction == -1 && getY() < 100){
            getWorld().removeObject(this);
        } else if (direction == 1 && getY() > 550){
            getWorld().removeObject(this);
        }
    }
}
