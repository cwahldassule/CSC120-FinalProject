import java.util.Scanner;
import java.util.ArrayList;

/*
 * creates Garden location, where other three locations are found within
 */
public class Garden{
  FairyVillage fairyVillage;
  FireflyClearing fireflyClearing;
  ElfTreeHouse treeHouse;
  Character user;
  int upper_bound;
  int right_bound;
  Scanner in = new Scanner(System.in);
  Scanner in2 = new Scanner(System.in);

  /**
   * Creates Garden constructor
   * @param user character choosen
   */
  public Garden(Character user){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage("Fairy Village", 3, user);
    this.fireflyClearing = new FireflyClearing("Firefly Clearing", 3, user);
    this.treeHouse = new ElfTreeHouse("Elf TreeHouse", user);
    boolean temp = true;
    while(temp){
      temp = this.checkLoc();
    }
    
    this.user = user;
    }

    /**
     * Randomizes location of Fairy Village, Elf Treehouse and Firefly Clearing
     * @return false if all three locations are at different points, returns true if locaitons are at same point.
     */
  public boolean checkLoc(){
    int temp = 0;
    if(fairyVillage.loc_x == fireflyClearing.loc_x  &
     fairyVillage.loc_y == fireflyClearing.loc_y){
      fireflyClearing.loc_x = Item.randNum(4);
      fireflyClearing.loc_y = Item.randNum(4);
      temp += 1;
    }
    if(fairyVillage.loc_x == treeHouse.loc_x&
    fairyVillage.loc_y == treeHouse.loc_y){
      treeHouse.loc_x = Item.randNum(4);
      treeHouse.loc_y = Item.randNum(4);
      temp += 1;
    }
    if(fireflyClearing.loc_x == treeHouse.loc_x&
    fireflyClearing.loc_y == treeHouse.loc_y){
      treeHouse.loc_x = Item.randNum(4);
      treeHouse.loc_y = Item.randNum(4);
      temp += 1;
    }
    if(temp==0){
      return false;
    }
    else{
      return true;
    }
  }

  /**
   * Boolean to check if three quests are complete, if so, prints statement
   * @return true if three quests complete, false if not.
   */
  public boolean win(){
    if(user.quest_complete == 3){
      System.out.println("\t\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
      System.out.println("\t\tCongratulations! You've completed all the quests!");
      System.out.println("\t\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * play funciton, takes user input and calls according methods
   * @param user character selected
   * @return true to keep running the function, false to end the funciton, when user wins the game.
   */
  public boolean play(Character user){
    if(this.win()){
      return false;
    }
    //System.out.println("Fairy Village "+fairyVillage.loc_x+fairyVillage.loc_y); //testing
    //System.out.println("Firefly Clearing "+fireflyClearing.loc_x+fireflyClearing.loc_y); //testing
    //System.out.println("Treehouse: "+ treeHouse.loc_x +treeHouse.loc_y ); //testing
    int og_x = user.pos_x;
    int og_y = user.pos_y;
    System.out.println("\nWhat would you like to do? Enter HELP for options");
    String input = in.nextLine().toUpperCase();
    if(input.equals("FLY")){
      int x = -1983;
      int y = -2874;
      System.out.println("x coord? (int only)");
      try{x = in2.nextInt();}catch(Exception e){
        System.out.println("That's not an int -_-");
        return true;
      }

      System.out.println("y coord? (int only)");
      try{y = in2.nextInt();}catch(Exception e){
        System.out.println("That's not an int -_-");
        return true;
      }
      if(x != -198 & y != -2874){
        user.fly(x, y);
      }
      else{
        throw new RuntimeException("Game makers: I don't know how you messed it up this badly so we starting over...");
      }
      
    }
    else if(input.equals("STATS")){
      user.stats();
    }
    else if(input.equals("OPEN BASKET")){
      user.openBasket();
    }
    else if(input.equals("EMPTY BASKET")){
      user.empty();
    }
    else if(input.equals("RECIPE")){
      if(fairyVillage.started){
        fairyVillage.printRecipe();
      }
      else if(treeHouse.started){
        treeHouse.printRecipe();
      }
      else if(fireflyClearing.started){
        fireflyClearing.printRecipe();
      }
      else{
        throw new RuntimeException("You haven't started any quests...");
      }
    }
    else if(input.equals("SNACK")){
      user.snack();
    }
    
    else if(input.equals("HELP")){
      user.help();
    }
    else if(input.equals("SLEEP")){
      user.sleep(10000);
    }
    else if(input.equals("LEAVE")){
      return false;
    }

    if(og_x != user.pos_x | og_y != user.pos_y){
      if(user.pos_x < 0 | user.pos_y <0 | user.pos_x > right_bound | user.pos_y > upper_bound){
        System.out.println("\nThere's nothing here :0 Sending you back... ");
        user.pos_x = og_x;
        user.pos_y = og_y;
      }
      else{
        if(user.pos_x == fairyVillage.loc_x & user.pos_y == fairyVillage.loc_y){
            fairyVillage.intro();
            while(true){
              try{
                Boolean temp = fairyVillage.play();
                  if(!temp){
                    break;
                  }
              }catch(Exception e){System.out.println(e.getMessage());}
            }
        }

        else if(user.pos_x == treeHouse.loc_x & user.pos_y == treeHouse.loc_y){
          treeHouse.intro();
          while(true){
            try{
              Boolean temp = treeHouse.play();
                if(!temp){
                  break;
                }
            }catch(Exception e){System.out.println(e.getMessage());}
          }
        }

        else if(user.pos_x == fireflyClearing.loc_x & user.pos_y == fireflyClearing.loc_y){
          fireflyClearing.intro();
          while(true){
            try{
              Boolean temp = fireflyClearing.play();
                if(!temp){
                  break;
                }
            }catch(Exception e){System.out.println(e.getMessage());}
          }
        }

        else{
          System.out.println("\nYou've stumbled upon " +Item.randLocation());
          int temp = Item.randNum(3)+1;
          Item myItem = new Item();
          ArrayList<String> found = myItem.recipe(temp);
          for(int i = 0; i<found.size(); i++){
            user.examine(found.get(i));
          }
        }
      } 
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("\t\tWelcome to the Garden!");
    System.out.println("Your goal is to complete the three quests of the three hidden locations");
    System.out.println("Fly to different coords in the garden to search for the locations and pick up items");
    System.out.println("\t\t(if you are ever confused, type 'help' for options)");
    
    try{System.out.println("\nWhat character would you like to be?");
    System.out.println("\t+Ladybug (easy)\n\t+Butterfly (Medium) \n\t+Bumblebee (Hard)");
    Scanner in2 = new Scanner(System.in);
    String input = in2.nextLine().toUpperCase();
    System.out.println("What would you like your name to be?");
    String name = in2.nextLine();
    if(input.equals("BUMBLEBEE")){
      Character user = new Character(name, 20, 15);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            in2.close();
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }
    else if(input.equals("BUTTERFLY")){
      Character user = new Character(name, 40, 30);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            in2.close();
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }

    else if(input.equals("LADYBUG")){
      Character user = new Character(name, 100, 100);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            in2.close();
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }
    else{
      in2.close();
      throw new RuntimeException("You did not choose any valid options... try again...");
    }
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}