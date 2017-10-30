/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.model;

/**
 *
 * @author Jared
 */
public final class AppData {
    
    private static final AppData INSTANCE = new AppData();
    private FoodList foodList = new FoodList();
    private MoodList moodList = new MoodList();
    private UserList userList = new UserList(); 
    
    private AppData() {
        
    }
    
    public Boolean isEmpty() {
        if (userList.getUserList().isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static AppData getInstance() {
        return INSTANCE;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }

    public MoodList getMoodList() {
        return moodList;
    }

    public void setMoodList(MoodList moodList) {
        this.moodList = moodList;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }
}
