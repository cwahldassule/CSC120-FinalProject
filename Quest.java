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
    public boolean finishQuest(){
      if(this.started){
        int temp = 0;
        for(int i = 0; i<this.recipe.size(); i++){
          for(int j = 0; j<user.basket.size(); j++){
            if(this.recipe.get(i).equals(user.basket.get(j))){
              temp += 1;
            }
          }
        }
        if(temp == this.recipe.size()){
          this.complete = true;
          for(int i = 0; i<this.recipe.size(); i++){
            user.basket.remove(this.recipe.get(i));
          return true;
          }
        }
        else{
          return false;
        }
      }
      return false;
    }
  }