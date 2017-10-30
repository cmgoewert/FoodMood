/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.control;


import com.google.gson.Gson;
import foodMood.model.*;
import foodMood.model.UserList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author cmg5831
 */
public class Serialize {
    
    Gson gson = new Gson();
    private AppData data = AppData.getInstance();
    
    public Serialize(){
        read();
        if (data.isEmpty()) {
            System.out.println("No File");
            data.getUserList().buildTestUserList();
            write();
        } else {
            System.out.println("File Found");
        }
        read();
    }

    public void write() {
        String userOutput = gson.toJson(data.getUserList());
        String moodOutput = gson.toJson(data.getMoodList());
        String foodOutput = gson.toJson(data.getFoodList());
        try {
            PrintWriter pw = new PrintWriter(new File("users.json"));
            pw.write(userOutput);
            pw.close();
            pw = new PrintWriter(new File("moods.json"));
            pw.write(moodOutput);
            pw.close();
            pw = new PrintWriter(new File("foods.json"));
            pw.write(foodOutput);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void read(){
        UserList tempUserList;
        MoodList tempMoodList;
        FoodList tempFoodList;
        String input = "";
        String thisLine = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader("users.json"));
            while((thisLine = in.readLine()) != null){
                input = input.concat(thisLine);
            }
            System.out.println("Read: " + input);
            tempUserList = gson.fromJson(input, UserList.class);
            input = "";
            
            in = new BufferedReader(new FileReader("moods.json"));
            while((thisLine = in.readLine()) != null){
                input = input.concat(thisLine);
            }
            tempMoodList = gson.fromJson(input, MoodList.class);
            input = "";
            
            in = new BufferedReader(new FileReader("foods.json"));
            while((thisLine = in.readLine()) != null){
                input = input.concat(thisLine);
            }
            tempFoodList = gson.fromJson(input, FoodList.class);
            
            data.setUserList(tempUserList);
            data.setMoodList(tempMoodList);
            data.setFoodList(tempFoodList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public AppData getData() {
        return data;
    }
}
