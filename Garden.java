import java.util.Scanner;

public class Garden{
  FairyVillage fairyVillage;
  Bumblebee user_bee = null;
  Butterfly user_fly = null;
  //Ladybug user_lady = null;
  int upper_bound;
  int right_bound;

  public Garden(Bumblebee user){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage("Fairy Village", user);
    this.user_bee = user;
    }

  public Garden(Butterfly user){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage("Fairy Village", user);
    this.user_fly = user;
    }

  public void checkLoc(){

    
  }

  public void showOptions(){
    //options of input
  }

  public boolean play(Bumblebee user){
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
   
    if(user.user_pos_x == fairyVillage.loc_x & user.user_pos_y == fairyVillage.loc_y){
        fairyVillage.play();
      }
    //create if/if else statement for each user option
    return true;
  }

  public static void main(String[] args) {
    System.out.println("intro");
    Bumblebee user1 = new Bumblebee("Chloe");
    Garden myGarden = new Garden(user1);
    //user input for what kind of character
    
    while(true){
      Boolean temp = false;
      myGarden.play(user1);
      if(!temp){
        break;}
      }
    }
}
