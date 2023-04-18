import java.util.ArrayList;

public class Quest{
    String name;
    ArrayList<String> recipe;
    int loc_x;
    int loc_y;
    boolean complete;
  
    public Quest(String name){
      this.name = name;
      Item myItem = new Item();
      this.recipe = myItem.recipe();
      this.loc_x = Item.randNum(2);
      this.loc_y = Item.randNum(2); 
      this.complete = false;
    }
  
    //completed quest check
   
  
  
  
    
  }