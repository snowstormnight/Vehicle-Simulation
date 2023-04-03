import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the border class, will remove all the touching actors
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Border extends Actor
{
    /**Constructor of border
     * 
     * @param direction Means the direction this border should face
     */
    
    public Border(boolean direction)
    {
        if(direction)
        {
            setRotation(270);
        }
    }
    
    //Check if an actor is touching. If touch, remove it
    public void act()
    {
        if(isTouching(SuperSmoothMover.class))
        {
            removeTouching(Actor.class);
        }
    }
}
