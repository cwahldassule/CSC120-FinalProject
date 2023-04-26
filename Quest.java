import java.util.ArrayList;

public class Quest{
    String name;
    ArrayList<String> recipe;
    int loc_x;
    int loc_y;
    boolean complete;
    boolean started;
  
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

    public void help(){
      throw new RuntimeException("Not a valid option :/");
    }
    
    public boolean checkLoc(){
      if(loc_x == 0 & loc_y == 0){
        return false;
      }
      return true;
    }
    public void printRecipe(){
      System.out.println("Quest items:");
      for(int i = 0; i<recipe.size(); i++){
        System.out.println("\t+"+recipe.get(i));
      }
    }
    public static void main(String[] args) {
      Quest myQuest = new Quest("wow!", 3);
      myQuest.printRecipe();
  }
}