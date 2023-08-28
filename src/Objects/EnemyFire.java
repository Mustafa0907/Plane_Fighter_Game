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
public class EnemyFire extends Vehicle 
{
    private int speed;

    
    public EnemyFire(String path,int x,int y)
    {
        super(path,x,y);
        setSpeed(new Random().nextInt(3)+5);
    }
    public void Fire()
    {
        
    }
    public void move()
    {
        
        super.moveTo(this.x,this.getY()+speed);
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
