import greenfoot.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/*
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;

import javax.imageio.ImageIO;
*/
/**
 * Write a description of class Aquarium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Akwarium extends World
{

    /**
     * Constructor for objects of class Aquarium.
     * 
     */
    public Akwarium()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1366, 768, 1);
        //addObject(new PostButton(), 1255, 50);
    }
    
    public void act() {
        dodajRybke();        
    }
    
    public void dodajRybke() {

     if(Greenfoot.mousePressed(this)) {
         int random = Greenfoot.getRandomNumber(3);
         FabrykaRybek fabrykaRybek = new FabrykaRybek();
         int x = Greenfoot.getRandomNumber(1366);
         int y = Greenfoot.getRandomNumber(438)+330;// zmienna y podzielona ze wzgledu na wysokosc tafli wody
         Rybka rybka = fabrykaRybek.stworzRybke(random);
         addObject(rybka, x, y);                
     }
    }
                 
}
