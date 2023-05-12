
import java.util.Random;
import java.util.ArrayList;

/**
 * Class Item is in charge of randomization, collectible items, and random location descriptions
 */

public class Item{
  static String[] flowers;
  static String[] fruits;
  static String [] gems;
  static String[] toxic_flowers;
  static String[] rusty_object; //change name
  static String[] poison_shroom;
  private static Random index = new Random();
  static String[] location;

   /**
   * Constructor for Item
   * @param flowers, string array
   * @param fruits, string array
   * @param gems, string array
   * @param location, string array
   */

  public Item(){
    flowers = new String[]{"Sunflower", "Peony", "Lavender", "Orchid", "Tulip"};
    fruits= new String [] {"Strawberry", "Blueberry", "Blackberry", "Raspberry", "Elderberry"};
    gems = new String[] {"Amethyst", "Pearl", "Emerald", "Sapphire", "Ruby"};
    // toxic_flowers = new String[]{"Deadly Nightshade", "Foxglove","The Devil's Lettuce", "Angel's Trumpet", "Wolf’s Bane"};
    // rusty_object = new String []{"thing 1", "thing 2", "thing 3", "thing 4", "thing 5"};
    // poison_shroom = new String[]{"Death Cap", "False Parasol", "Fool's Mushroom", "Webcap", "Destroying Angel"};
    location = new String[]{"a toadstool circle", "a mossy stump", "an acorn stash", "a berry bush", "a lilypad cluster"};
      }

   /**
   * Returns a random integer
   * @param num1, int
   * @return num, int
   */  

  public static int randNum(int num1){
    Integer num = index.nextInt(num1);
    return num;
  }

   /**
   * Returns a random flower name from the flowers array
   * @return flowers[randNum(4)], String
   */  

  public static String randFlower(){
    return flowers[randNum(4)];
  }
  
  // public static String randShroom(){
  //   return poison_shroom[randNum(4)];
  // }
  
  // public static String randRust(){
  //   return rusty_object[randNum(4)];
  // }

  /**
   * Returns a random fruit name from the fruits array
   * @return fruits[randNum(4)], String
   */ 

  public static String randFruit(){
    return fruits[randNum(4)];
  }

  /**
   * Returns a random gem name from the gems array
   * @return gems[randNum(4)], String
   */ 

  public static String randGem(){
    return gems[randNum(4)];
  }
  // public static String randToxicFlower(){
  //   return toxic_flowers[randNum(4)];
  // }

  /**
   * Returns a random location name from the location array
   * @return location[randNum(4)], String
   */ 

    public static String randLocation(){
    return location[randNum(4)];
  }

  /**
   * Creates a recipe array list with the designated number of randomized items
   * @param size, int
   * @return recipe, ArrayList<String>
   */ 

   public ArrayList<String> recipe(int size){
     ArrayList<String> recipe = new ArrayList<>();
     for(int i = 0; i<size; i++){
        Integer num = index.nextInt(3);
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
  ArrayList<String> recipe1 = myItem.recipe(2);
  for(int i = 0; i <recipe1.size(); i++){
    System.out.println(recipe1.get(i));
  }
}
}