import java.util.Scanner;

public class Garden{
  int user_pos_x;
  int user_pos_y;
  Quest fairy_village;
  Quest firefly_pond;
  Quest elf_treehouse;
  //npc positions

  public Garden(){
    this.user_pos_x = 0;
    this.user_pos_y = 0;
    //this.fairy_village = //some randon coord;
    //this.firefly_pond = //some randon coord;
    //this.elf_treehouse = //some randon coord;
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
