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
public  class projectilefactory extends AbstractFactory
{

    @Override
   public  Vehicle getVehicle(String veh) {
         if(veh.equalsIgnoreCase("Bullet"))
         {
             return new Bullet("src/Images/Sprites/PlayerFire/",0,0);
         }
         else if (veh.equalsIgnoreCase("Enemyfire"))
         {
              return new EnemyFire("src/Images/Sprites/EnemyFire/",0,0);
         }
         else if(veh.equalsIgnoreCase("Explosion"))
         {
             return new Explosion("src/Images/Sprites/Explosion/",0,0);
         }
         else{
             
             return null;
         }
    }
 
    
}
