package Objects;

import Main.Board;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import Objects.MyPoint;
import Objects.Bullet;

public class Player extends Vehicle
{
    
        private Vehicle v;
        private AbstractFactory absfact;
        private  static Player player;
    
        private ArrayList<Vehicle> list;
        
	public Player(String path, int x, int y)
	{
		super(path, x, y);
	}
	
	public Player(String path, MyPoint p)
	{
		super(path, p);
	}
	
        public static Player getInstance()
        {
            if(player==null)
            {
            player=new Player("src/Images/Sprites/BF-109E/Type-1/Animation/", 0, 0);
           
            }
           return player;
        }
        
	public void move()
	{
		this.x += dx;
		this.y += dy;
	}
        public void givelist(ArrayList<Vehicle> a)
        {
            list=a;
        }
	
	public void keyPressed(KeyEvent e) 
	{
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -8;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 8;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -8;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 8;
        }
        if (key == KeyEvent.VK_SPACE) {
            Fire();
        }
    }
	public void Fire()
	{
               
            
            absfact=Factorycreator.getfactory(false);
            v=absfact.getVehicle("Bullet");
            v.moveTo(super.getX(), super.getY());
            list.add(v);
		
                
                
	}

        
                
    public void keyReleased(KeyEvent e) 
    {        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
