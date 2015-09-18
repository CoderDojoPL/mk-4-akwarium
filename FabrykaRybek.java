import greenfoot.*;

/**
 * Write a description of class FabrykaRybek here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FabrykaRybek extends Actor
{
    /**
     * Act - do whatever the FabrykaRybek wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    public Rybka stworzRybke(int type) {
      
        switch(type) {
        case 0: 
            return new ZlotaRybka();
        case 1:
            return new ZielonaRybka();
        case 2:
            return new SkalarRybka();
        default:
            return new ZlotaRybka();
        }   
    }
}
