/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author CapToxic
 */
public class Enemy extends Vehicle{
    
    public Enemy(String path, int x, int y)
    {
        super(path,x,y);
    }
    public Enemy(String path, MyPoint p)
    {
	super(path, p);
    }
    public void Fire()
    {
        
    }
    public void move()
    {
        moveTo(x,y+3);
    }
    
}
