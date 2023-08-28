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
public class Bullet extends Vehicle{
    
    public Bullet(String path, int x, int y)
    {
        super(path,x,y);
        
    }
    public Bullet(String path, MyPoint p)
    {
	super(path, p);
    }
    public void Fire()
    {
        //
    }
    public void move()
    {
        moveTo(x,y-20);
    }
}
