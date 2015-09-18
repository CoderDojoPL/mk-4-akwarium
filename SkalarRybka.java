import greenfoot.*;

/**
 * Write a description of class SkalarRybka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkalarRybka extends Rybka
{
    /**
     * Act - do whatever the SkalarRybka wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        ruchLewoPrawo();
        zlapRybke();

    }    
}
