import java.util.Scanner;

public class Garden{
  FairyVillage fairyVillage;
  Bumblebee user = null;

  public Garden(String name, String type){
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
   
    if(user.user_pos_x == fairyVillage.loc_x){

    }
    //create if/if else statement for each user option
    
    return true;
  }

  public static void main(String[] args) {
    System.out.println("intro");
    Garden myGarden = new Garden("Chloe", );
    //user input for what kind of character
    
    while(true){
      myGarden.play();
      if(!myGarden.play()){
        break;}
      }
    }
}
