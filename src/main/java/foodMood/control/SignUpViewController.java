/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import java.net.URL;
import java.util.ResourceBundle;

import foodMood.model.AppData;
import foodMood.model.FoodList;
import foodMood.model.User;
import foodMood.model.UserList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jared
 */
public class SignUpViewController implements Initializable {

    AppController app;
    AppData data = AppData.getInstance();

    @FXML private PasswordField passwordField1;
    @FXML private PasswordField passwordField2;
    @FXML private TextField usernameField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    protected void handleCancelButtonAction() {
       app.showLogin();
    }
    
    @FXML 
    protected void handleSubmitButtonAction() {
        if(passwordField1.getText().equals(passwordField2.getText())){
            //System.out.println("equals");
            UserList newList = data.getUserList();
            newList.addUser(new User(usernameField.getText(),passwordField1.getText().toCharArray(),"", new FoodList()));
            app.showLogin();
        }
        else
            System.out.println("Passwords don't match!");
    }

    void setUp(AppController app) {
        this.app = app;
    }
}
