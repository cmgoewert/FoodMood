/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jared
 */
public class AppController {

    Stage stage;
    FXMLLoader loader;
    Parent root;
    private Serialize ser;
    LoginViewController loginControl;
    SignUpViewController signUpControl;
    MainMenuViewController mainControl;
    String currUser;

    public AppController(Stage stage) throws IOException {
        ser = new Serialize();
        this.stage = stage;
        showLogin();
    }

    public final void showLogin() {
        try {
            loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/LoginView.fxml"));
            root = loader.load();
            loginControl = (LoginViewController) loader.getController();
            loginControl.setUp(this);
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void showSignUp() {
        try {
            loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/SignUpView.fxml"));
            root = loader.load();
            signUpControl = (SignUpViewController) loader.getController();
            signUpControl.setUp(this);
            Scene scene = new Scene(root);
            stage.setTitle("Sign Up");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public final void hideSignUp(){
//
//    }
    public final void showMainMenu(String username) {
        try {
            
            currUser = username;
            loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainMenuView.fxml"));
            stage.show();
            root = loader.load();
            
           //mainControl = new MainMenuViewController(this);
            mainControl = (MainMenuViewController) loader.getController();
             mainControl.setUp(this);
             mainControl.setUpFoods();
            Scene scene = new Scene(root);
            //String css = AppController.class.getResource("foodMenu.css").toExternalForm();
            // scene.getStylesheets().add(css);
            stage.setTitle("Main Menu");
            stage.setScene(scene);

            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Serialize getSer() {
        return ser;
    }
    
    public String getCurrUser () {
        return currUser;
    }
}
