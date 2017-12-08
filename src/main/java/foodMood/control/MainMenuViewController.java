/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.AppData;
import foodMood.model.Food;
import foodMood.model.Mood;
import foodMood.model.MoodList;
import foodMood.model.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainMenuViewController implements Initializable {

    AppController app;
    AppData data = AppData.getInstance();
    ObservableList<Food> foods;
    ObservableList<Mood> moods;
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
    @FXML
    private ComboBox moodComboBox;
    @FXML
    private TableColumn colMood;
    @FXML
    private TextField emailField;
    @FXML
    private TableColumn caloriesColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        foodColumn.setCellValueFactory(new PropertyValueFactory("foodName"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory("calories"));
        colMood.setCellValueFactory(new PropertyValueFactory("moodForThisFood"));
    }
    
    //this nolonger functions to strictly set up foods, also sets up the moods tab
    public void setUpFoods(){
        System.out.println(data.getUserList().getCurrUser(app.currUser).getName() + " here is the currUser");
        foods = FXCollections.observableArrayList(data.getUserList().getCurrUser(app.currUser).getFoodList().getListOfFood());
        moods = FXCollections.observableArrayList(data.getUserList().getCurrUser(app.currUser).getMoodList().getListOfMoods());
        System.out.println();
        moodComboBox.setItems(moods);
        moodComboBox.setEditable(true);
        System.out.println(foods.toString());
        historyTable.setItems(foods);
        historyTable.refresh();
        
    }
    
   

    @FXML
    protected void handleEnterButtonAction() {
        boolean duplicate = false;
        for(int x = 0; x < moods.size(); x++)
        {
            if(moods.get(x).getMoodName().matches(moodField.getText()))
            {
                duplicate = true;
            }
        }
        if (!moodField.getText().isEmpty() && !duplicate) {
            /*Mood newMood = new Mood(1, moodField.getText());
            //THIS REALLY NEEDS TO BE FIXED, YOU WILL NEVER ENTER A MOOD WITHOUT AN ASSOCIATED FOOD!
            //Disagree, you would enter a mood to be used with a food later or else that's a really 
            //major change and we're short a use case.
            Food food = new Food(99,"dummy",999);
            FoodList foodList= data.getUserList().getCurrUser(app.currUser).getFoodList();

            Food foundFood = foodList.findFood(food.getID());
            if(foundFood != null){
                foundFood.getMoodList().addMood(newMood);
            } else {
                food.getMoodList().addMood(newMood);
                foodList.addFood(food);
            }*/
            //app.getSer().write();
            int x = moods.size();
            Mood newMood = new Mood(x, moodField.getText());
            moods.add(newMood);
            UserList theList = data.getUserList();
            theList.getCurrUser(app.currUser).getMoodList().addMood(newMood);
            moodField.clear();
            app.getSer().write();
        }
        else
        {
            System.out.println("Cannot save null or duplicate mood");
        }
//        for (Mood m : data.getMoodList().getListOfMoods()) {
//            System.out.println(m.toString());
//        }
    }

    @FXML
    protected void handleShareButtonAction () {
        UserList theList = data.getUserList();
        ExportController.share(emailField.getText(), theList.getCurrUser(app.currUser).getFoodList());
    }

    @FXML
    protected void foodEnterButtonAction() {
        if (validateFields()) {
            int index = foods.size();
            int cal = Integer.parseInt(caloriesField.getText());
            Mood enteredMood = new Mood(moodComboBox.getValue().toString());
            System.out.println("Verify Mood Entry: " + enteredMood.toString());
            Food newFood = new Food(index, foodField.getText(), cal, enteredMood.getMoodName());
            foods.add(newFood);
            moods.add(enteredMood);
            UserList theList = data.getUserList();
            theList.getCurrUser(app.currUser).getFoodList().addFood(newFood);
            theList.getCurrUser(app.currUser).getMoodList().addMood(enteredMood);
            data.setUserList(theList);
            System.out.println(data.getUserList().getCurrUser(app.currUser).getFoodList().getListOfFood().toString());
            app.getSer().write();
            
            System.out.println(foods.toString() + " here is foods?");
            historyTable.refresh();
            historyTable.setItems(foods);
            moodComboBox.setItems(moods);
            foodField.clear();
            caloriesField.clear();            
            
//            for (Food f : data.getFoodList().getListOfFood()) {
//
//                System.out.println(f.toString());
//            }

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

    
