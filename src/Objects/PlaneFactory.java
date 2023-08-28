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
public class PlaneFactory extends AbstractFactory {
    
    
     @Override
     public Vehicle getVehicle(String veh)
     {
         if(veh.equalsIgnoreCase("Enemy"))
         {
             return new Enemy("src/Images/Sprites/B-17/Type-1/Animation/",0,0);
         }
         
          if (veh.equalsIgnoreCase("Bomber"))
         {
             return new Bomber("src/Images/Sprites/FighterSprite/",0,0);
         }
          else{
             
              return null;
          }
     
     }

    
}
