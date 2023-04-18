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
      this.loc_x = Item.randNum(2);
      this.loc_y = Item.randNum(2); 
      this.complete = false;
    }
  
    public void printRecipe(){
      System.out.println("Quest items:");
      for(int i = 0; i<recipe.size(); i++){
        System.out.println("\t+"+recipe.get(i));
      }
    }
  }