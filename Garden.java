import java.util.Scanner;

public class Garden{

  public Garden(){
  }

  public void checkLoc(){
    
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
