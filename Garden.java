import java.util.Scanner;

public class Garden{
  int user_pos_x; //move to character class
  int user_pos_y; //move to character class
  FairyVillage fairy_coord;
  Quest pond_coord;
  Quest treehouse_coord;
  //npc positions

  public Garden(){
    this.user_pos_x = 0;
    this.user_pos_y = 0;
    //this.fairy_village = //some randon coord; //move to fairy class
    //this.firefly_pond = //some randon coord; //move to pond class
    //this.elf_treehouse = //some randon coord; //move to elf class
    //need a way to make sure coords are not the same
    //quest class needs a method to change coord so garden can check
  }

  public void showOptions(){
    //options of input
  }

  public boolean play(){
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    throw new RuntimeException("Not set up");

    //create if/if else statement for each user option
    
    
  }

  public static void main(String[] args) {
    System.out.println("intro");
    Garden myGarden = new Garden();
    while(true){
      myGarden.play();
      if(!myGarden.play()){
        break;}
      }
    }
}
