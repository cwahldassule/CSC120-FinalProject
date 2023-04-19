import java.util.Scanner;
import java.util.ArrayList;

public class Garden<T extends Character>{ //made abstract class so that any child class of character can be used without specifying which
  FairyVillage<T> fairyVillage;
  T user;
  int upper_bound;
  int right_bound;
  Scanner in = new Scanner(System.in);
  Scanner in2 = new Scanner(System.in);

  public Garden(T user){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage<T>("Fairy Village", user);
    this.user = user;
    }

  public void checkLoc(){

    
  }

  public void showOptions(){
    //options of input
  }

  public boolean play(T user){
    System.out.println("Fairy Village "+fairyVillage.loc_x+fairyVillage.loc_y);
    int og_x = user.pos_x;
    int og_y = user.pos_y;
    System.out.println("\nWhat would you like to do?");
    String input = in.nextLine().toUpperCase();
    if(input.equals("FLY")){
      System.out.println("What x coord would you like to fly to? (int only)");
      int x = in2.nextInt();
      System.out.println("What y coord would you like to fly to? (int only)");
      int y = in2.nextInt();
      user.fly(x, y);
    }
    else if(input.equals("STATS")){
      user.stats();
    }


    if(og_x != user.pos_x | og_y != user.pos_y){
      if(user.pos_x < 0 | user.pos_y <0 | user.pos_x > right_bound | user.pos_y > upper_bound){
        System.out.println("\nThere's nothing here :0 Sending you back... ");
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
    System.out.println("intro");
    Bumblebee user = new Bumblebee("Chloe");
    Garden<Bumblebee> myGarden = new Garden<>(user);
    //user input for what kind of character

    while(true){
      myGarden.play(user);
      System.out.println("----------------------------------------------------------");
      }
    }
}
