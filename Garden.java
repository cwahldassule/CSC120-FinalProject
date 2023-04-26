import java.util.Scanner;
import java.util.ArrayList;

public class Garden{ //made abstract class so that any child class of character can be used without specifying which
  FairyVillage fairyVillage;
  Character user;
  int upper_bound;
  int right_bound;
  Scanner in = new Scanner(System.in);
  Scanner in2 = new Scanner(System.in);

  public Garden(Character user){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage("Fairy Village", user);
    this.user = user;
    }

  public void checkLoc(){

    
  }

  public void showOptions(){
    //options of input
  }

  public boolean play(Character user){
    System.out.println("Fairy Village "+fairyVillage.loc_x+fairyVillage.loc_y); //testing
    int og_x = user.pos_x;
    int og_y = user.pos_y;
    System.out.println("\nWhat would you like to do?");
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
    else if(input.equals("RECIPE")){
      if(fairyVillage.started){
        fairyVillage.printRecipe();
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
        else{
          System.out.println("\nYou've stumbled upon " +Item.randLocation());
          int temp = Item.randNum(3)+1;
          Item myItem = new Item();
          ArrayList<String> found = myItem.recipe(temp);
          for(int i = 0; i<found.size(); i++){
            user.examine(found.get(i));
          }
        }
    //create if else statement for each user option
      } 
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("\t\tWelcome to the garden!");
    System.out.println("\t\tFly around to explore and pick up objects!");
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
          myGarden.play(user);
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
          myGarden.play(user);
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------------------");
        }
    }
    
    
    //user input for what kind of character


    }
}
