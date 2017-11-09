/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.AppData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jared
 */
public class LoginViewController implements Initializable{
    
    AppController app;
    AppData data = AppData.getInstance();
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public Boolean requestAuthenticate(String usernameToCheck, char[] passwordToCheck){
        boolean result = data.getUserList().authenticate(usernameToCheck, passwordToCheck);
        return result;
    }
    
    @FXML 
    protected void handleLoginButtonAction() {
        char[] password = passwordField.getText().toCharArray();
        if (requestAuthenticate(usernameField.getText(), password)) {
            app.showMainMenu(usernameField.getText());
        } else {
            System.out.println("Invalid account info!");
        }
    }
    @FXML
    protected void handleSignUpButtonAction() {
        app.showSignUp();
    }

    void setUp(AppController app) {
        this.app = app;
    }
}