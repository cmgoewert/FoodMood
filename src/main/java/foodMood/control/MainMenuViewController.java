/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.AppData;
import foodMood.model.Mood;
import foodMood.model.Food;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainMenuViewController implements Initializable {

    AppController app;
    AppData data = AppData.getInstance();
    @FXML private TextField moodField;
    @FXML private TextField foodField;
    @FXML private TableView historyTable;
    @FXML private TableColumn foodColumn;

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
        if (!foodField.getText().isEmpty()) {
            Food newFood = new Food(1, foodField.getText(),5);
                data.getFoodList().addFood(newFood);
                app.getSer().write();
                foodField.clear();

            }
            for (Food f : data.getFoodList().getListOfFood()){

                System.out.println(f.toString());
            }
        }



    
    void setUp(AppController app) {
       this.app = app;
   }

    public void resetCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    
