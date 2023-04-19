
public class Bumblebee extends Character {
    private int flight_power;
    private int flight_cap;
    private int basket_cap;

    public Bumblebee(String name){
        super(name);
        this.flight_power = 20;
        this.flight_cap = 20;
        this.basket_cap = 15;

    }
    public void help(){
        System.out.println("Fly:");
        System.out.println("\t+Choose the coords of where you want to go\n\t+possibility of loosing 1-4 items or flight power\n\t+loose 2 flight power");
        System.out.println("Walk:");
        System.out.println("\t+Choose where you want to go\n\t+Lose 1 flight power");
        System.out.println("Snack:");
        System.out.println("\t+Eat 1 item to gain 3 flight power");
        System.out.println("Sleep:");
        System.out.println("\t+Sleep for 20 seconds to reset flight power");
        System.out.println("Grow:");
        System.out.println("\t+Increase your size when you have completed a quest");
        System.out.println("\t+for each size up, flight cap increases by 10 and bag size is increased by 5");
        System.out.println("Open Flower Bag:");
        System.out.println("\t+Opens flower bag");
        System.out.println("Empty Flower Bag:");
        System.out.println("\t+Empties flower bag");
        System.out.println("Stats:");
        System.out.println("\tDisplays important character info");
    }
    public void shake(){
    System.out.println("You bumped into a tree...");
        Integer temp = Item.randNum(4) +1 ;
        if(basket.size() >= (temp)){
            System.out.println("Uh oh...dropping items...");
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

    public void snack(String item) {
        System.out.println("Munching on a yummy "+item+"...");
        if(basket.contains(item)){
            basket.remove(item);
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

    public void empty() {
        System.out.println("Emptying bag...");
        basket.clear();
        this.print_stats();
    }

    public void print_stats(){
        System.out.println("\tName: " + this.name);
        System.out.println("\tFlight cap: "+this.flight_cap);
        System.out.println("\tFlight power: "+this.flight_power);
        System.out.println("\tSize: "+this.size);
        System.out.println("\tFlower bag size: "+basket_cap);
        System.out.println("\tNumber of flowers: "+basket.size());
        System.out.println("\tPosition: ("+pos_x+","+pos_y+")");
        System.out.println("\tNumber of Quests complete: "+quest_complete+"/3");
    }

    public static void main(String[] args) {
        
    }
}
