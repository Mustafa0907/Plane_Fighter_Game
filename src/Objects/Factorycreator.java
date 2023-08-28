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
public abstract class Factorycreator {
    public static AbstractFactory getfactory(boolean flag)
    {
        if(flag)
        {
                return  new PlaneFactory();
        }
        else if(!flag)
        {
            return new projectilefactory();
        }
        else{
            
            return null;
        }
    }
}
