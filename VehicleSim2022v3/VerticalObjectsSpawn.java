import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalObjectsSpawnPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalObjectsSpawn extends SuperSmoothMover
{
    private int hp;
    public void VerticalObjectsSpawn()
    {
        hp = 20;
    }
    
    public void act()
    {
        if(isTouching(Weapon.class))
        {
            hp--;
        }
        if(hp == 0)
        {
            
        }
    }
}
