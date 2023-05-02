
import java.util.Scanner;

public class Bumblebee extends Character {
    private int basket_cap;
    Scanner in = new Scanner(System.in);

    public Bumblebee(String name){
        super(name);
        this.flight_power = 20;
        this.flight_cap = 20;
        this.basket_cap = 15;

    }
    public void help(){
        System.out.println("\nFly:");
        System.out.println("\t+Choose the coords of where you want to go\n\t+possibility of loosing 1-4 items or flight power\n\t+loose flight power based on coords");
        System.out.println("Snack:");
        System.out.println("\t+Eat 1 item to gain 3 flight power");
        System.out.println("Sleep:");
        System.out.println("\t+Sleep for 10 seconds to reset flight power");
        System.out.println("Open basket:");
        System.out.println("\t+Opens basket");
        System.out.println("Empty basket:");
        System.out.println("\t+Empties basaket");
        System.out.println("Recipe");
        System.out.println("\t+Shows needed Quest Items");
        System.out.println("Stats:");
        System.out.println("\t+Displays important character info");
    }

    public void fly(int x, int y) {
        float distance1 = (float)Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
        int distance = Math.round(distance1);
        if(flight_power >= distance){
            flight_power -= distance;
            this.pos_x = x;
            this.pos_y = y;
            Integer temp = Item.randNum(7);
            if(temp == 0){
                this.shake();
            }
        }
        else{
            throw new RuntimeException("You are too tired to do that...");
        }
    }

    public void grab(String item) {
        if(basket.size() != basket_cap){
            this.basket.add(item);
            System.out.println( this.name + " has picked up: "+item+"\n");
        }
        else{
            throw new RuntimeException("Basket is full :0");
        }
    }

    public void shake(){
    System.out.println("\nYou bumped into a tree and dropped a few items...");
        Integer temp = Item.randNum(4) +1 ;
        if(basket.size() >= (temp)){
            for(int i = 0; i < temp; i++){
                Integer temp1 = Item.randNum(basket.size());
                System.out.println("You dropped "+basket.get(temp1));
                this.basket.remove(basket.get(temp1));
            }
        }
        else{
            System.out.println("Uh oh...losing flight power...");
            this.flight_power = this.flight_power/2;
        }
    }

    public void snack() {
        System.out.println("What would you like to snack on?");
        this.openBasket();
        String input = in.nextLine();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        System.out.println("Munching on a yummy "+input+"...");
        if(basket.contains(input)){
            basket.remove(input);
            if(flight_power <= flight_cap){
                flight_power += 3;}
            else{
                throw new RuntimeException("you've reached your flight power cap :0");
            }}
        else{
            throw new RuntimeException("You don't have that item silly >_<");
        }
    }

    public void sleep() {
        System.out.println("Sleeping...please wait...");
        try {Thread.sleep(5000);
            System.out.println("Still sleeping...");
            Thread.sleep(5000);
            System.out.println("All rested :)");
        } catch (InterruptedException e) {
            System.out.println("You tried to cheat :0");
        }
        this.flight_power = flight_cap;
        this.print_stats();

    }

    public void grow(){
        this.basket_cap += 5;
        this.flight_cap += 5;
        this.size += 1;
      }

    public void print_stats(){
        System.out.println("\tName: " + this.name);
        System.out.println("\tFlight cap: "+this.flight_cap);
        System.out.println("\tFlight power: "+this.flight_power);
        System.out.println("\tSize: "+this.size);
        System.out.println("\tBasket size: "+basket_cap);
        System.out.println("\tNumber of items: "+basket.size());
        System.out.println("\tPosition: ("+pos_x+","+pos_y+")");
        System.out.println("\tNumber of Quests complete: "+quest_complete+"/3");
    }

    public static void main(String[] args) {
        
    }
}
