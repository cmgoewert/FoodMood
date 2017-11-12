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
    private AppData data;
    
    public Serialize(){
        data = AppData.getInstance();
        read();
        if (data.isEmpty()) {
            System.out.println("No File");
            data.getUserList().buildTestUserList();
            write();
        } else {
            System.out.println("File Found");
        }

    }

    public void write() {
        String userOutput = gson.toJson(data.getUserList());
        try {
            PrintWriter pw = new PrintWriter(new File("users.json"));
            pw.write(userOutput);
            pw.close();
            System.out.println("wrote successfully?");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void read(){
        UserList tempUserList;
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
            
            data.setUserList(tempUserList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public AppData getData() {
        return data;
    }
}
