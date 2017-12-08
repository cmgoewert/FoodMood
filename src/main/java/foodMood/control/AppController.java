/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    DataViewController dataControl;
    String currUser;

    public AppController(Stage stage) throws IOException {
        ser = new Serialize();
        this.stage = stage;
        Image img = new Image("file:foodmoodicon.png");
        stage.getIcons().add(img);

        showLogin();
    }

    public final void showLogin() {
        loader = createStage("fxml/LoginView.fxml", "Login");
        loginControl = (LoginViewController) loader.getController();
        loginControl.setUp(this);
    }

    public final void showSignUp() {
        loader = createStage("fxml/SignUpView.fxml", "Sign Up");
        signUpControl = (SignUpViewController) loader.getController();
        signUpControl.setUp(this);
    }

//    public final void hideSignUp(){
//
//    }
    
    public final void showMainMenu(String username) {
        currUser = username;
        loader = createStage("fxml/MainMenuView.fxml", "Main Menu");
        mainControl = (MainMenuViewController) loader.getController();
        mainControl.setUp(this);
        mainControl.setUpFoods();
        //String css = AppController.class.getResource("foodMenu.css").toExternalForm();
        // scene.getStylesheets().add(css);
    }
    
    public final void showDataView() {
        loader = createStage("fxml/DataView.fxml", "Data View");
        dataControl = (DataViewController) loader.getController();
        Stage dataStage = new Stage();
        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().add(dataControl.setUp(this));
        stage.setScene(scene);
        stage.show();
    }
    
    private FXMLLoader createStage(String fxml, String title) {
        try {
            loader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loader;
    }
    

    public Serialize getSer() {
        return ser;
    }

    public String getCurrUser() {
        return currUser;
    }
}
