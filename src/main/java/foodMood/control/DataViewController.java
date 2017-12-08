/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;

import foodMood.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DataViewController implements Initializable {

    MainMenuViewController main;
    AppData data = AppData.getInstance();
    AppController app;
    @FXML
    PieChart chart;
    @FXML
    ArrayList<Food> foods;
    ArrayList<String> moods;
    ArrayList<Integer> occurrences;
    HashMap<String, Double> moodData;
    ObservableList<PieChart.Data> pieChartData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public PieChart setUp(AppController app) {
        moodData = new HashMap();
        foods = data.getUserList().getCurrUser(app.currUser).getFoodList().getListOfFood();
        moods = new ArrayList();
        for (Food food : foods) {
            if (!moods.contains(food.toString())) {
                moods.add(food.getMoodForThisFood());
            }
        }
        for (String mood : moods) {
            double frequency = Collections.frequency(moods, mood);
            moodData.put(mood, frequency);
        }
        pieChartData = FXCollections.observableArrayList();
        Iterator it = moodData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            pieChartData.add(new PieChart.Data(pair.getKey().toString(), (double) pair.getValue()));
        }
        chart = new PieChart(pieChartData);
        return chart;
    }

}
