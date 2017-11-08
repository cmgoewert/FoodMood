/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.AppData;
import foodMood.model.Food;
import foodMood.model.Mood;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuViewController implements Initializable {

    AppController app;
    AppData data = AppData.getInstance();
    @FXML
    private TextField moodField;
    @FXML
    private TextField foodField;
    @FXML
    private TextField caloriesField;
    @FXML
    private TableView historyTable;
    @FXML
    private TableColumn foodColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    protected void handleEnterButtonAction() {
        if (!moodField.getText().isEmpty()) {
            Mood newMood = new Mood(1, moodField.getText());
            data.getMoodList().addMood(newMood);
            app.getSer().write();
        }
        for (Mood m : data.getMoodList().getListOfMoods()) {
            System.out.println(m.toString());
        }
    }

    @FXML
    protected void foodEnterButtonAction() {
        //!foodField.getText().isEmpty() && !caloriesField.getText().isEmpty()
        if (validateFields()) {
            int cal = Integer.parseInt(caloriesField.getText());
            Food newFood = new Food(1, foodField.getText(), cal);
            data.getFoodList().addFood(newFood);
            app.getSer().write();
            foodField.clear();
            caloriesField.clear();


            for (Food f : data.getFoodList().getListOfFood()) {

                System.out.println(f.toString());
            }


        }
    }


    private boolean validateFields() {
        if (foodField.getText().isEmpty() | caloriesField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please enter food and calorie count");
            alert.showAndWait();

            return false;
        }
        return true;
    }













    
    void setUp(AppController app) {
       this.app = app;
   }

    public void resetCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    
