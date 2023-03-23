import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AB extends Weapon
{
    /**
     * Act - do whatever the AB wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!a.isEmpty())
            {
                getWorld().removeObject(this);
                //random = Greenfoot.getRandomNumber(a.size());
                //position[0] = (a.get(random)).getX();
                //if(position[0] != 0)
                //{
                    //getWorld().removeObject(this);
                //}
                //position[1] = (a.get(random)).getY();
                //x = position[0];
                //y = position[1];
            }
    }
    
    public AB(int damage, double speed)
    {
        super(damage, speed);
    }
}
