
package foodMood.model;

import java.util.ArrayList;


public class FoodList {
    
    private ArrayList<Food> listOfFood;
    
    /**
     * Default constructor for the FoodList model class
     */
    public FoodList(){
        listOfFood = new ArrayList<>();
    }
    
    public FoodList(ArrayList<Food> food){
        listOfFood = food;
    }
    /**
     * This method adds food item to the @param listOfFood
     * 
     */
    public void addFood(Food newFood) {
        getListOfFood().add(newFood);
    }
    
    public Food findFood(int id){
        for(int i = 0; i < listOfFood.size(); i++){
            if(id == listOfFood.get(i).getID()){
                return listOfFood.get(i);
            }
        }
        
        return null;
    }
     /**
     * This method prints food items in the @param listOfFood
     * 
     */
    public void printFood(){
        for(int i = 0; i < getListOfFood().size(); i++){
            Food currentFood =(Food) getListOfFood().get(i);
            System.out.println("Food Name: " + currentFood.getFoodName());
            
        }
    }

    /**
     * @return the listOfFood
     */
    public ArrayList<Food> getListOfFood() {
        return listOfFood;
    }

    /**
     * @param listOfFood the listOfFood to set
     */
    public void setListOfFood(ArrayList<Food> listOfFood) {
        this.listOfFood = listOfFood;
    }
    
}
