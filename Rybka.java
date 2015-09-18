import greenfoot.*;

/**
 * Write a description of class Rybka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rybka extends Actor
{
    /**
     * Act - do whatever the Rybka wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(3);
    }
    
    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public int czyKoniecEkranu()
    {
        if(getX() < 10)
            return 1;
        if(getX() > getWorld().getWidth() - 10)
            return 0;
        else
            return 2;
    }
    
    public void ruchLewoPrawo(){
        if(czyKoniecEkranu() == 0) {
           setRotation(180);
           getImage().mirrorVertically();
          
        } else if (czyKoniecEkranu() == 1) {
          turnTowards(getWorld().getWidth(),getY());
          getImage().mirrorVertically();
        }
    }
    
    public void zlapRybke(){
        Siatka catcher = null;
        if(Greenfoot.mousePressed(this)) {
         catcher = Siatka.getFishCatcher();
         World world = getWorld();
         world.addObject(catcher, this.getX(), 0);         
         catcher.turnTowards(this.getX(), this.getY());
                
        } 
        catcher = null;
       
    }
}
