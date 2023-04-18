import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Character{
  String name;
  int flight_power;
  int flight_cap;
  int basket_cap;
  ArrayList<String> basket;
  int size;
  
  public Character(String name){
    this.name = name;
    this.flight_power = 20;
    this.flight_cap = 20;
    this.basket_cap = 15;
    this.basket = new ArrayList<String>();
    this.size = 1;
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

  public boolean walk(String direction) {
    //if user_import
    if(flight_power >= 2){
    System.out.println("Walking to "+direction+"...");
    flight_power -= 2;
    this.examine(Item.randFlower());}
    else{
        throw new RuntimeException("You are too tired to do that...");
    }
    return true;
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
    if(basket.size() <basket_cap){
        this.basket.add(item);
        System.out.println("Bumblebee " + this.name + " has picked up: "+item+"\n");}
    else{
        throw new RuntimeException("Your basket is full >_<");
    }
    }
  public String drop(String item) {
        System.out.println(this.name + " has dropped: "+item+"\n");
        return item;
    }
}