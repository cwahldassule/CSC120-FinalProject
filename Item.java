
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Item{
  static String[] flowers;
  static String[] fruits;
  static String [] gems;
  static String[] toxic_flowers;
  static String[] rusty_object; //change name
  static String[] poison_shroom;
  private static Random index = new Random();
  static String[] location;

  public Item(){
    flowers = new String[]{"Sunflower", "Peony", "Lavender", "Orchid", "Tulip"};
    fruits= new String [] {"Strawberry", "Blueberry", "Blackberry", "Raspberry", "Elderberry"};
    gems = new String[] {"Amethyst", "Pearl", "Emerald", "Sapphire", "Ruby"};
    toxic_flowers = new String[]{"Deadly Nightshade", "Foxglove","The Devil's Lettuce", "Angel's Trumpet", "Wolf’s Bane"};
    rusty_object = new String []{"thing 1", "thing 2", "thing 3", "thing 4", "thing 5"};
    poison_shroom = new String[]{"Death Cap", "False Parasol", "Fool's Mushroom", "Webcaps", "Destroying Angel"};
    location = new String[]{"a toadstool circle", "a mossy stump", "an acorn stash", "a berry bush", "a lilypad cluster"};
      }

  public static int randNum(){
    Integer num = index.nextInt(4);
    return num;
  }
  public static String randFlower(){
    return flowers[randNum()];
  }
  public static String randShroom(){
    return poison_shroom[randNum()];
  }
  
  public static String randRust(){
    return rusty_object[randNum()];
  }
  public static String randFruit(){
    return fruits[randNum()];
  }
  public static String randGem(){
    return gems[randNum()];
  }
    public static String randToxicFlower(){
    return toxic_flowers[randNum()];
  }
    public static String location(){
    return location[randNum()];
  }

   public ArrayList<String> recipe(){
     ArrayList<String> recipe = new ArrayList<>();
     for(int i = 0; i<3; i++){
        Integer num = index.nextInt(2);
       if (num == 0){
         recipe.add(randFlower());
       }
       else if (num == 1){
         recipe.add(randGem());
       }
       else if (num == 2){
         recipe.add(randFruit());
       }
     }
     return recipe;
    
  }

public static void main(String[] args) {
  Item myItem = new Item();
  ArrayList<String> recipe1 = myItem.recipe();
  for(int i = 0; i <recipe1.size(); i++){
    System.out.println(recipe1.get(i));
  }
}
}