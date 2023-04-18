import java.util.ArrayList;

public class Quest{
    String name;
    ArrayList<String> recipe;
    int loc_x;
    int loc_y;
    //completed quest
  
    public Quest(String name){
      this.name = name;
      Item myItem = new Item();
      this.recipe = myItem.recipe();
      this.loc_x = Item.randNum
      //call randnum twice for x and y
      
    }
  
    //completed quest check
   
  
  
  
    
  }