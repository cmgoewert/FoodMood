
package foodMood.model;

import java.util.ArrayList;


public class MoodList {
    private ArrayList<Mood> listOfMoods = new ArrayList();
    
    
    /**
     * Default constructor for the MoodList model class
     */
    public MoodList(){
        
    }
    /**
     * This method adds moods item to the @param listOfMoods
     * 
     * @param newMood
     */
    public void addMood(Mood newMood) {
        this.getListOfMoods().add(newMood);
    }
     /**
     * This method prints mood items in the @param listOfMoods
     * 
     */
    public void printMood(){
        for(int i = 0; i < getListOfMoods().size(); i++){
            Mood currentMood = (Mood) getListOfMoods().get(i);
            System.out.println("Mood Name: " + currentMood.getMoodName());
            
        }
    }

    /**
     * @return the listOfMoods
     */
    public ArrayList<Mood> getListOfMoods() {
        return listOfMoods;
    }

    /**
     * @param listOfMoods the listOfMoods to set
     */
    public void setListOfMoods(ArrayList<Mood> listOfMoods) {
        this.listOfMoods = listOfMoods;
    }
}
