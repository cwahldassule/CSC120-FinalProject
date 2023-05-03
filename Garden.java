import java.util.Scanner;
import java.util.ArrayList;

public class Garden{
  FairyVillage fairyVillage;
  FireflyClearing fireflyClearing;
  ElfTreeHouse treeHouse;
  Character user;
  int upper_bound;
  int right_bound;
  Scanner in = new Scanner(System.in);
  Scanner in2 = new Scanner(System.in);

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

  public boolean play(Character user){
    if(this.win()){
      return false;
    }
    System.out.println("Fairy Village "+fairyVillage.loc_x+fairyVillage.loc_y); //testing
    System.out.println("Firefly Clearing "+fireflyClearing.loc_x+fireflyClearing.loc_y); //testing
    System.out.println("Treehouse: "+ treeHouse.loc_x +treeHouse.loc_y ); //testing
    int og_x = user.pos_x;
    int og_y = user.pos_y;
    System.out.println("\nWhat would you like to do? Enter HELP for options");
    String input = in.nextLine().toUpperCase();
    if(input.equals("FLY")){
      System.out.println("x coord? (int only)");
      int x = in2.nextInt();
      System.out.println("y coord? (int only)");
      int y = in2.nextInt();
      user.fly(x, y);
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
    System.out.println("\t\tWelcome to the garden!");
    System.out.println("Your goal is to complete the three quests of the three hidden locations");
    System.out.println("Fly to different coords in the garden to search for the locations and pick up items");
    System.out.println("\t\t(if you are ever confused, type 'help' for options)");
    
    System.out.println("\nWhat character would you like to be?");
    System.out.println("\t+Bumblebee\n\t+Butterfly\n\t+Ladybug");
    Scanner in2 = new Scanner(System.in);
    String input = in2.nextLine().toUpperCase();
    System.out.println("What would you like your name to be?");
    String name = in2.nextLine();
    if(input.equals("BUMBLEBEE")){
      Character user = new Bumblebee(name);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }
    else if(input.equals("BUTTERFLY")){
      Character user = new Butterfly(name);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }

    else if(input.equals("LADYBUG")){
      Character user = new LadyBug(name);
      Garden myGarden = new Garden(user);
      while(true){
        try{
          boolean temp = myGarden.play(user);
          if(!temp){
            System.out.println("Exiting game...");
            break;
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }


    }
}
