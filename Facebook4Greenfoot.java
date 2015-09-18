import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
import facebook4j.Media;
import facebook4j.PhotoUpdate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javafx.application.Platform;

public class Facebook4Greenfoot extends Application {

    private static final String APP_ID = "949945011733982";
    private static final String SCOPE = "publish_actions";
    private static final String REDIRECT_URL = "https://www.facebook.com/connect/login_success.html";
    private static final String RESPONSE_TYPE = "token";
    private Scene scene;
    private static String accessToken;
    private static boolean isApplicationCreated = false;
    
    
    public static void showLogInWindow() {
        try {           
           if (!isApplicationCreated) {     
              launch(Facebook4Greenfoot.class, new String[] {});
              isApplicationCreated = true;    
           }
        } catch (Exception ex) {
            System.err.println("Cannot display Login window");
            ex.printStackTrace();
        }
    }   
    
    public static String getAccessToken() {
        return accessToken;
    }    
    
    public static void createPost(String msg) {
        try {          
         Facebook facebook = new FacebookFactory().getInstance();
         facebook.setOAuthAppId(APP_ID, "");
         facebook.setOAuthPermissions(SCOPE);
         facebook.setOAuthAccessToken(new AccessToken(accessToken, null));
         facebook.postStatusMessage(msg);        
        } catch (Exception ex) {
            System.err.println("Post cannot be created.");
            ex.printStackTrace();
        }
       
    }    
    
    public static void postPhoto(String msg) {
        try {         
             Facebook facebook = new FacebookFactory().getInstance();
             facebook.setOAuthAppId(APP_ID, "");
             facebook.setOAuthPermissions(SCOPE);
             facebook.setOAuthAccessToken(new AccessToken(accessToken, null));
             Media media = new Media(takeScreenShot());
             PhotoUpdate update = new PhotoUpdate(media);
             update.message(msg);
             facebook.postPhoto(update);  
         
        } catch (Exception ex) {
            System.err.println("Post cannot be created.");
            ex.printStackTrace();
        }
    }
    
    private static File takeScreenShot() {
            File screenShot = null;
            try {
                screenShot = new File("aquaView.png");
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
                    .getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            ImageIO.write(capture, "png", screenShot);
            } catch (Exception ex) {
                   System.err.println("Error during image creation.");
                   ex.printStackTrace();
            }
            return screenShot;
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final String url = "https://www.facebook.com/dialog/oauth?client_id="
                + APP_ID + "&scope=" + SCOPE + "&response_type="
                + RESPONSE_TYPE + "&oauth_callback=oob&redirect_uri="
                + REDIRECT_URL;
        BorderPane borderPane = new BorderPane();
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load(url);
        borderPane.setCenter(browser);
        webEngine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            public void handle(WebEvent<String> event) {
                if (event.getSource() instanceof WebEngine) {
                    WebEngine we = (WebEngine) event.getSource();
                    String location = we.getLocation();
                    if (location.startsWith(REDIRECT_URL)
                            && location.contains("access_token")) {
                        try {
                            URL url = new URL(location);
                            String[] params = url.getRef().split("&");
                            Map<String, String> map = new HashMap<String, String>();
                            for (String param : params) {
                                String name = param.split("=")[0];
                                String value = param.split("=")[1];
                                map.put(name, value);
                            }
                            accessToken = map.get("access_token");
                            stage.hide();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        // create scene
        stage.setTitle("Login to Facebook");
        scene = new Scene(borderPane, 750, 500);
        stage.setScene(scene);
        stage.setHeight(800);
		stage.setWidth(1000);
        stage.show();
    }
}
