/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;


import java.util.Random;

/**
 *
 * @author CapToxic
 */

public class Bomber extends Vehicle
{
 
 
    public Bomber(String path, int x, int y)
    {
        super(path,x,y);
    }
    
    public Bomber(String path, MyPoint p)
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
    public void dodgeright()
    {
       
       moveTo(x+5,y);
       
       
    }
    public void dodgeleft()
    {
        
        moveTo(x-5,y);
    }

    
    
    
    
}
