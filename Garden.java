import java.util.Scanner;

public class Garden<T extends Character>{
  FairyVillage<T> fairyVillage;
  T user;
  int upper_bound;
  int right_bound;

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
    Bumblebee user = new Bumblebee("Chloe");
    Garden<Bumblebee> myGarden = new Garden<>(user);
    //user input for what kind of character
    
    while(true){
      Boolean temp = false;
      myGarden.play(user);
      if(!temp){
        break;}
      }
    }
}
