package Main;


import Objects.AbstractFactory;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import java.util.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import Objects.Player;
import Objects.Enemy;
import java.util.ArrayList;
import Objects.Bullet;
import Objects.Bomber;
import Objects.EnemyFire;
import Objects.Explosion;
import Objects.Factorycreator;
import Objects.Vehicle;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;


public class Board extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int DELAY = 10;
       // private int midpt;
        int count_2 = 0;
	private Player player;
	private int w = 1024;
	private int h = 768;
	int count = 0;
	private Timer timer;
        
    
        private AbstractFactory absfact;
    
        private boolean GameOver;
        private int score;
        
        protected static ArrayList < Vehicle > l1;
        
        
    public Board() 
    {    	
        initBoard();
    }
    
    public int getScore() {
        return score;
    }
    private void initBoard() //Initializes all the game objects
    {	
        l1 = new ArrayList < > ();
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
	
        player = Player.getInstance();
        player.givelist(l1);
        Player p = Player.getInstance();
        setPreferredSize(new Dimension((int)w, (int)h));   //Set the size of Window     
        player.moveTo((int)w/2, (int)h *3/4);
        timer = new Timer(DELAY, this); //Timer with 10 ms delay 
        timer.start();
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) //Draws all the components on screen
    {  
        
        Graphics2D g2d = (Graphics2D) g;  
        if (GameOver) {
            GameOverp(g2d);
        }
       
        if (!GameOver){
    	g.setColor(getBackground());		//get the background color
        g.clearRect(0 , 0, (int)w, (int)h);	//clear the entire window
    	Dimension size = getSize();  //get the current window size  	
        w = (int)size.getWidth();
        h = (int)size.getHeight();

        
        for(int i = 0 ; i<l1.size();i++)
        {
            Vehicle v = l1.get(i);
            v.paintComponent(g2d);
                
        }
        player.paintComponent(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void GameOverp(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, w, h);
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) instanceof Explosion) {
                l1.get(i).paintComponent(g2d);

                if (l1.get(i).getCount() >= 4) {
                    g.clearRect(0, 0, w, h);
                    timer.stop();
                                     
                    
                    Gameoverwindow go = new Gameoverwindow(getScore());
                    go.show();
                    
                    break;
                }
            }
        }
    }

    
    public void actionPerformed(ActionEvent e) {
        
        step();
        count++;
        count_2++;
    }
    
    private void step() 
    {    
        Random r = new Random();
        int spawn_x =r.nextInt(w-150) + 50;
        int r1 = new Random().nextInt(10);
        if (count > 200)
        {
            absfact = Factorycreator.getfactory(true);
            Vehicle enemy = absfact.getVehicle("Enemy");
            enemy.moveTo(spawn_x, 0);

            l1.add(enemy);
            count = 0;
            if (r1 < 5) {
                absfact = Factorycreator.getfactory(false);
                Vehicle enemyfire = absfact.getVehicle("Enemyfire");
                enemyfire.moveTo(enemy.getX(), enemy.getY() + 3);
                l1.add(enemyfire);
            }
        }
        if (count_2 > 400)
        {
            absfact = Factorycreator.getfactory(true);
            Vehicle bomber = absfact.getVehicle("Bomber");
            bomber.moveTo(spawn_x, 0);

            l1.add(bomber);
            if (r1 < 7) {
                absfact = Factorycreator.getfactory(false);
                Vehicle enemyfire = absfact.getVehicle("Enemyfire");
                enemyfire.moveTo(bomber.getX(), bomber.getY() + 3);
                l1.add(enemyfire);
            }
            count_2 = 100;
        }
        player.move();
        
        
        
        for(int i=0;i<l1.size();i++)
         {      
               if( l1.get(i)instanceof Bomber)
               {
                   Bomber bomber=(Bomber)l1.get(i);
                  for(int j=0;j<l1.size();j++)
                {  
                    
                 if(l1.get(j) instanceof Bullet)
                 {    
                     Bullet bullet=(Bullet)l1.get(j);
                      
                     int bullet_X = (int)bullet.getBounds().getX();
                     int bomber_X = (int)bomber.getBounds().getX();                     
                     int bullethalf=(int)(bullet.getBounds().getWidth()/2+bullet.getBounds().getX());
                     int bomberhalf=(int)(bomber.getBounds().getWidth()/2+bomber.getBounds().getX());
                     int bomberwidth = (int)(bomber.getBounds().getX()+bomber.getBounds().getWidth());
                     int screenwidth = w;
                        if((bullet_X>bomber_X) &&  ((bullet_X<=bomberwidth)))
                        {      
                    
                        if(bomberwidth + 20 > 1024)
                        {
                            bomber.dodgeleft();
                        }
                        else if(bomber_X - 20 < 0)
                        {
                            bomber.dodgeright();
                        }
                        else if( bullethalf>bomberhalf) 
                        {
                            
                            //bomber.moveTo(bomber.getX()-5,bomber.getY());
                            bomber.dodgeleft();
                        }
                        else if(bullethalf<bomberhalf)
                            
                        {  
                            //bomber.moveTo(bomber.getX()+5, bomber.getY()); 
                            bomber.dodgeright();
                        }
                        
                    }
                   }     
                   }
                   
                 }     	
               }
         
            
        
        for(int i = 0; i < l1.size();i++)
        {
            Vehicle enemy = l1.get(i);
            enemy.move();
        }
        
        checkCollisions();
        repaint();
        
        Cleanup();	//clean the list from unwanted objects
    }    
    
    private void Cleanup()
    {
        
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) instanceof Explosion) {
                if (l1.get(i).getCount() >= 4) {
                    l1.remove(i);
                }
            }
        }

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) instanceof EnemyFire) {
                if (l1.get(i).getY() > 850) {
                    l1.remove(i);

                }
            }
        }

        
        
        
        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i)instanceof Bomber || l1.get(i)instanceof Enemy)
            {
            Vehicle enemy = l1.get(i);
            
            if (enemy.getY() > 850 || enemy.getY() < 0)
            {
                l1.remove(i);
            }
            }
        }
        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i)instanceof Bullet)
            {
            Vehicle bullet = l1.get(i);
            
            if (bullet.getY() > 850 || bullet.getY() < 0)
            {
                l1.remove(i);
            }
            }
        }
        
    }
    
    public void checkCollisions() {

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) instanceof EnemyFire) {
                if (player.getBounds().intersects(l1.get(i).getBounds())) {
                    GameOver = true;
                    
                    absfact = Factorycreator.getfactory(false);
                    Vehicle ex = absfact.getVehicle("explosion");
                    ex.moveTo(player.getX(), player.getY() - 60);
                    l1.add(ex);
                    l1.remove(l1.get(i));
                }
            }
        }
        
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) instanceof Bomber || l1.get(i) instanceof Enemy ) {
                if (player.getBounds().intersects(l1.get(i).getBounds())) {
                    GameOver = true;
                    
                    absfact = Factorycreator.getfactory(false);
                    Vehicle ex = absfact.getVehicle("explosion");
                    ex.moveTo(player.getX(), player.getY() - 60);
                    l1.add(ex);
                    l1.remove(l1.get(i));
                }
            }
        }
        
        
        
        
        for(int j = 0; j < l1.size();j++)
        {
            if(l1.get(j) instanceof Bomber || l1.get(j) instanceof Enemy)
            {
                Vehicle vehicle = l1.get(j);
            
            
            
            for(int i = 0; i < l1.size();i++)
            {
                if(l1.get(i) instanceof Bullet)
                {
                Vehicle bullet = l1.get(i);
                
                if(vehicle.getBounds().intersects(bullet.getBounds()))
                {
                    absfact = Factorycreator.getfactory(false);
                    Vehicle ex = absfact.getVehicle("explosion");
                    ex.moveTo(vehicle.getX(), vehicle.getY());
                    l1.add(ex);
                    l1.remove(i);
                    l1.remove(j);
                    score++;
                }
            }
            }
            }
    }
    }
        
        
    

    
    


    private class TAdapter extends KeyAdapter 
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            player.keyPressed(e);
        }
    }

}