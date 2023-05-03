import java.util.ArrayList;
/**
 * creates class Quest, with recipe of items needed to be collected
 */
public class Quest{
    String name;
    ArrayList<String> recipe;
    int loc_x;
    int loc_y;
    boolean complete;
    boolean started;
  
    /**
     * Constructor of Quest
     * @param name of quest
     * @param size of quest
     */
    public Quest(String name, int size){
      this.name = name;
      Item myItem = new Item();
      this.recipe = myItem.recipe(size);
      this.complete = false;
      while(true){
        this.loc_x = Item.randNum(4);
        this.loc_y = Item.randNum(4); 
        if(this.checkLoc()){
          break;
        }
      }
    }

    /*
     * default method help, each individual location can override and create its own help method.
     */
    public void help(){
      throw new RuntimeException("Not a valid option :/");
    }
    
    /**
     * checks user location, 
     * @return true or false, false if locatoin is 0,0
     */
    public boolean checkLoc(){
      if(loc_x == 0 & loc_y == 0){
        return false;
      }
      else{
        return true;
      }
    }

    /**
     * if quest has been started, prints out items in quest
     */
    public void printRecipe(){
      if(this.started){
        System.out.println("Quest items:");
        for(int i = 0; i<recipe.size(); i++){
          System.out.println("\t+"+recipe.get(i));
        }
      }
      else{
        throw new RuntimeException("You're already working on another quest...");
      }
      
    }
    public static void main(String[] args) {
      Quest myQuest = new Quest("wow!", 3);
      myQuest.printRecipe();
  }
}