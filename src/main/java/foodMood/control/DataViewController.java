/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class DataViewController implements Initializable {

    MainMenuViewController main;
    AppData data = AppData.getInstance();
    AppController app;
    @FXML
    PieChart chart;
    @FXML
    ArrayList<Food> foods;
    ArrayList<String> moods;
    ObservableList<PieChart.Data> pieChartData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
    }    
    
    public void setUp(AppController app) {
        foods = data.getUserList().getCurrUser(app.currUser).getFoodList().getListOfFood();
        moods = new ArrayList();
        for (Food food : foods) {
            if (!moods.contains(food.toString())) {
                moods.add(food.toString());
            }
        }
        for (String mood : moods) {
            System.out.println(mood);
        }
        /*
        pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Test 1", 100),
        new PieChart.Data("Test 2", 200),
        new PieChart.Data("Test 3", 300));
        chart = new PieChart(pieChartData);*/
    }
    
}
