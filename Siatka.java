import greenfoot.*;
import java.util.*;

/**
 * Write a description of class FishCatcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Siatka extends Actor
{
    private static Siatka siatka = null;
    
    private List<Rybka> listaRybek = null;
    
    public static Siatka getFishCatcher() {
        if(siatka == null) {
            siatka = new Siatka();
            siatka.getImage().rotate(-90);  
            siatka.listaRybek = new ArrayList<Rybka>();
        }
        return siatka;
    }
    
    public List<Rybka> wezListeRybek() {
        return listaRybek;
    }
    
    
    
    /**
     * Act - do whatever the FishCatcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        wezListeRybek().addAll(getObjectsInRange(200, Rybka.class));
        if(wezListeRybek().size() > 0) {            
            getWorld().removeObjects(wezListeRybek());
            wezListeRybek().clear();
            getWorld().removeObject(this);          
        }
        
    }    
}
