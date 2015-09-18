import greenfoot.*;

/**
 * Write a description of class ZielonaRybka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZielonaRybka extends Rybka
{
    /**
     * Act - do whatever the ZielonaRybka wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        move(3);
        ruchLewoPrawo();
        zlapRybke();
        
    }
    
    
}
