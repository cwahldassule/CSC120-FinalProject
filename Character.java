import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Character{
  String name;
  ArrayList<String> basket;
  int size;
  int user_pos_x;
  int user_pos_y;
  
  public Character(String name){
    this.name = name;
    this.basket = new ArrayList<String>();
    this.size = 1;
    this.user_pos_x = 0;
    this.user_pos_y = 0;
  }

public String getName(){
  return this.name;
}
  public void openBag(){
    System.out.println("Opening basket...");
    basket.sort(Comparator.naturalOrder());
    if(!basket.isEmpty()){
    for(int i = 0; i<basket.size(); i++){
      System.out.println("\t+"+basket.get(i));
        }}
    else{
      throw new RuntimeException("You don't have any flowers lol");
        }
    System.out.println("");}

//fix to include changes in user position
  public void walk(String direction) {
    if(direction.equals("N")){
      user_pos_y += 1;
    }
    else if(direction.equals("S")){
      user_pos_y -= 1;
    }
    else if(direction.equals("E")){
      user_pos_x -= 1;
    }
    else if(direction.equals("W")){
      user_pos_y += 1;
    }

  }

//fix fly to include changes in user position
//make so examine and shrink are not called
public void fly(int x, int y) {
  user_pos_x = x;
  user_pos_y = y;
}

  public void examine(String item) {
    System.out.println("\nyou've found a " +item+". What would you like to do?\n+Grab \n+Drop");
      try{Scanner in = new Scanner(System.in);
      String res = in.nextLine();
      res = res.toUpperCase();
      if(res.equals("GRAB")){
        System.out.println("Grabbing...");
        this.grab(item);}
      else if(res.equals("DROP")){
        System.out.println("Dropping...");
          this.drop(item);}
      else{
        throw new RuntimeException("You squished the object :0");}}
        catch(Exception e){
        System.out.println(e.getMessage());
              }
          }

  public void grab(String item) {
      this.basket.add(item);
      System.out.println("Bumblebee " + this.name + " has picked up: "+item+"\n");
  }
    

    public void drop(String item) {
        System.out.println(this.name + " has dropped: "+item+"\n");
    }
}