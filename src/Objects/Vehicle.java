package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Vehicle 
{
	protected Image image;
	protected int x;
	protected int y;
	protected int w;
        protected int h;
	protected int dx, dy;
	Image[] img = new Image[3];
		
	protected long count = 0;
	public Vehicle()
        {
        }
        
	public Vehicle(String path, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		
		for(int i = 1; i <= img.length; i++) 
                {
			
			ImageIcon imageIcon = new ImageIcon(path + i + ".png");
			img[i - 1] = imageIcon.getImage();	
		}
				
		w = img[0].getWidth(null);
                h = img[0].getHeight(null);
	
        }
	
	public Vehicle(String path, MyPoint p)
	{
		x = p.x;
		y = p.y;
		
		ImageIcon imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		
		w = image.getWidth(null);
                h = image.getHeight(null);
	}
	
	public Rectangle getBounds() {
	    return new Rectangle(x-w/2, y-w/2, w, h);
	}
	
	
	
	
	
	public void paintComponent(Graphics2D g) 
	{
		int num = (int)(count%3);
		g.drawImage(img[num], x - img[num].getWidth(null)/2, y - img[num].getHeight(null)/2, null);
		g.setColor(new Color(255,0,0));
		//g.drawRect(x-w/2, y-w/2, w, h);//Only to show image bounds, can be removed
		/*g.drawRect(x , y-w/2 + w/4  , w / 2 , h );
	    g.drawRect(x - w / 2  , y-w/2 + w/4  , w / 2 , h );
		  */
		count++;
		
		
		
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public abstract void move();
	public abstract void Fire();
	
	
	public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image getImage() {
        
        return image;
    }
    public long getCount()
    {
        return count;
    }
    	
	
}