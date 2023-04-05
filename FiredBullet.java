import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the class where the BattleShip can shoot to destroy the VerticalObjectSpawn objects
 * It will spawn on the BattleShip and change its direction to aim for the VerticalObjectSpawn objects every act.
 * Once it hits the VerticalObjectSpawn objects, it will decrease their hp
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class FiredBullet extends SuperSmoothMover
{
    private int random, goX, goY;
    private World w;
    private ArrayList<VerticalObjectSpawn> wos;
    
    //This is the constructor of the FireBullet
    public FiredBullet()
    {
        random = Greenfoot.getRandomNumber(6);
    }
    
    //This is the act method for FiredBullet class
    public void act()
    {
        moveToTarget();
        move(2);
    }
    
    
    //This is the method that gives direction the FiredBullet should head to
    public void moveToTarget()
    {
        goX = wos.get(random).getX();
        goY = wos.get(random).getY();
        turnTowards(goX, goY);
        setRotation(getRotation());
    }
    
    
    /**
     * This is the method gets call when it is added to world. It will create an arraylist to let the FiredBullet know where to aim
     * 
     * @param w This is the world FiredBullet is in
     */
    public void addedToWorld(World w)
    {
        this.w = w;
        wos = (ArrayList<VerticalObjectSpawn>)(w.getObjects(VerticalObjectSpawn.class));
        
    }
    
}
