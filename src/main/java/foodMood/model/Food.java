package foodMood.model;

public class Food {

    private int ID;
    private String foodName;
    private int calories;
    private String moodForThisFood;

    /**
     * Default constructor for the Food model class
     */
    public Food() {
        moodForThisFood = new String();
    }
    
    public Food(String mood){
        moodForThisFood = mood;
    }

    /**
     * Constructor that initializes attributes
     * @param ID is the id number associated with the food item
     * @param foodName is the name of the food item as a String
     * @param calories is the calories of food item
     */
    public Food(int ID, String foodName, int calories, String moodForThisFood){
        this.ID = ID;
        this.foodName = foodName;
        this.calories = calories;
        this.moodForThisFood = moodForThisFood;


    }
    
    public String getMoodForThisFood() {
        return moodForThisFood;
    }
    
    

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food Number: " + " " + this.ID + " " +  "Food Name: " + " " + this.foodName + " " + "Calories" + " " + this.calories + "Mood Name: " + " " + this.moodForThisFood;
    }
    
            
}
