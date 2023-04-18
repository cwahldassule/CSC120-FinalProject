import java.util.Scanner;

public class Garden{
  FairyVillage fairyVillage;
  Bumblebee user = null;
  int upper_bound;
  int right_bound;

  public Garden(String name, String type){
    this.upper_bound = 3;
    this.right_bound = 3;
    this.fairyVillage = new FairyVillage("Fairy Village");
    if(type.equals("BUMBLEBEE")){
      this.user = new Bumblebee(name);
    }
  }

  public void checkLoc(){

    
  }

  public void showOptions(){
    //options of input
  }



  public boolean play(){
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
   
    if(user.user_pos_x == fairyVillage.loc_x & user.user_pos_y == fairyVillage.loc_y){
      while(true){
        boolean temp = false;
        temp = fairyVillage.play();
        if(!temp){
          break;
        }
      }
    }
    //create if/if else statement for each user option
    
    return true;
  }

  public static void main(String[] args) {
    System.out.println("intro");
    Garden myGarden = new Garden("Chloe", "BUMBLEBEE" );
    //user input for what kind of character
    
    while(true){
      myGarden.play();
      if(!myGarden.play()){
        break;}
      }
    }
}
