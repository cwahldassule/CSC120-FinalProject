import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Class Character is in charge of all characters, their attributes, and their methods
 */

class Character{
  String name;
  ArrayList<String> basket;
  int basket_cap;
  int size;
  int pos_x;
  int pos_y;
  int quest_complete;
  int flight_power;
  int flight_cap;
  boolean busy;
  Scanner in;
  
  /**
   * constructor for character class
   * @param name name of character
   * @param flight_cap max flight capacity
   * @param basket_cap max basket capacity
   */
  public Character(String name, int flight_cap, int basket_cap){
    this.name = name;
    this.in = new Scanner(System.in);
    this.basket = new ArrayList<String>();
    this.size = 1;
    this.flight_power = flight_cap;
    this.flight_cap = flight_cap;
    this.pos_x = 0;
    this.pos_y = 0;
    this.quest_complete = 0;
    this.busy = false;
    this.flight_cap = flight_cap;
    this.basket_cap = basket_cap;
  }

  /**
   * resets flight power to max
   * @param num how long to sleep for
   */
  public void sleep(int num) { //normal time is 10000
    System.out.println("Sleeping...please wait...");
    try {Thread.sleep(num/2);
        System.out.println("Still sleeping...");
        Thread.sleep(num/2);
        System.out.println("All rested :)");
    } 
    catch (InterruptedException e) {
        System.out.println("You tried to cheat :0");
    }
    this.flight_power = flight_cap;
    this.stats();
  }

  /**
   * empties basket
   */
  public void empty(){
    System.out.println("\nEmptying basket...");
    basket.clear();
    this.stats();
  }

  /*
   * prints statements explaining options
   */
  public void help(){
    System.out.println("\n'Fly':");
    System.out.println("\t->Choose the coords of where you want to go (0-3) \n\t->possibility of losing 1-4 items or flight power\n\t->lose flight power based on coords");
    System.out.println("'Snack':");
    System.out.println("\t->Eat 1 item to gain 3 flight power");
    System.out.println("'Sleep':");
    System.out.println("\t->Sleep for 10 seconds to reset flight power");
    System.out.println("'Open basket':");
    System.out.println("\t->Opens basket");
    System.out.println("'Empty basket':");
    System.out.println("\t->Empties basaket");
    System.out.println("'Recipe':");
    System.out.println("\t->Shows needed Quest Items");
    System.out.println("'Stats':");
    System.out.println("\t->Displays important character info");
    System.out.println("\nStruggling to find a particular item? Here's a key:");
    System.out.println("\t->Fairy Village has: Sunflower, Strawberry, Pearl");
    System.out.println("\t->Fairy Village has: Lavender, Blueberry, Sapphire");
    System.out.println("\t->Fairy Village has: Peony, Blackberry, Emerald");
    System.out.println("\t->All items can be found in the Garden");

  }

  /**
   * moves user to a new coordinate point
   * @param x x coord
   * @param y y coord
   */
  public void fly(int x, int y) {
    float distance1 = (float)Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
    int distance = Math.round(distance1);
    if(flight_power >= distance){
        flight_power -= distance;
        this.pos_x = x;
        this.pos_y = y;
        Integer temp = Item.randNum(7);
        if(temp == 0){
            this.shake();
        }
    }
    else{
        throw new RuntimeException("You are too tired to do that...take a nap or eat a snack");
    }
  }

  /**
   * adds item to basket
   * @param item the item to be added
   */
  public void grab(String item) {
    if(basket.size() != basket_cap){
        this.basket.add(item);
        System.out.println( this.name + " has picked up: "+item+"\n");
    }
    else{
        throw new RuntimeException("Basket is full :0");
    }
  }

  /**
   * prints a list of basket items
   */
  public void openBasket(){
    System.out.println("\nOpening basket...");
    basket.sort(Comparator.naturalOrder());
    if(!basket.isEmpty()){
      for(int i = 0; i<basket.size(); i++){
        System.out.println("\t+"+basket.get(i));
      }
    }
    else{ 
      throw new RuntimeException("You don't have any items");
    }
    System.out.println("");
  }

  /**
   * has random item and allows user to grab or drop
   * @param item random item
   */
  public void examine(String item) {
    System.out.println("\nyou've found a " +item+". What would you like to do?\n+Grab \n+Drop");
    try{Scanner in = new Scanner(System.in);
      String res = in.nextLine();
      res = res.toUpperCase();
      if(res.equals("GRAB")){
        System.out.println("Grabbing...");
        this.grab(item);
      }
      else if(res.equals("DROP")){
        System.out.println("Dropping...");
        this.drop(item);
      }
      else{
        throw new RuntimeException("You squished the object :0");
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  /**
   * randomly drops item(s) from basket
   */
  public void shake(){
    System.out.println("\nYou bumped into a tree!"); 
        Integer temp = Item.randNum(4) +1 ;
        if(basket.size() >= (temp)){
            for(int i = 0; i < temp; i++){
                Integer temp1 = Item.randNum(basket.size());
                System.out.println("You dropped "+basket.get(temp1));
                this.basket.remove(basket.get(temp1));
            }
        }
        else{
            System.out.println("Uh oh...losing flight power...");
            this.flight_power = this.flight_power/2;
        }
  }
    

  /**
   * prints a statement saying item has been dropped
   * @param item item to drop
   */
  public void drop(String item) {
      System.out.println(this.name + " has dropped: "+item+"\n");
  }

  /**
   * eat one of the items for +3 flight power
   */
  public void snack() {
    System.out.println("What would you like to snack on?");
    this.openBasket();
    String input = in.nextLine();
    input = input.substring(0, 1).toUpperCase() + input.substring(1);
    System.out.println("Munching on a yummy "+input+"...");
    if(basket.contains(input)){
        basket.remove(input);
        if(flight_power <= flight_cap){
            flight_power += 3;}
        else{
            throw new RuntimeException("you've reached your flight power cap :0");
        }}
    else{
        throw new RuntimeException("You don't have that item silly >_<");
    }
  }
  /**
   * prints important user info
   */
  public void stats(){
    System.out.println("\tName: " + this.name);
    System.out.println("\tFlight cap: "+this.flight_cap);
    System.out.println("\tFlight power: "+this.flight_power);
    System.out.println("\tSize: "+this.size);
    System.out.println("\tBasket size: "+basket_cap);
    System.out.println("\tNumber of items: "+basket.size());
    System.out.println("\tPosition: ("+pos_x+","+pos_y+")");
    System.out.println("\tNumber of Quests complete: "+quest_complete+"/3");
  }
}