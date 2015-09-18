import greenfoot.*;

/**
 * Write a description of class ZlotaRybka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZlotaRybka extends Rybka
{
    /**
     * Act - do whatever the ZlotaRybka wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(2);
        ruchLewoPrawo();
        zlapRybke();
    }    
}
