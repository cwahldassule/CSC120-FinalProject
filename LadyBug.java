
public class LadyBug extends Character{
    private int flight_power;
    private int flight_cap;
    private int basket_cap;

    public LadyBug (String name){
        super(name);
        this.flight_power = 20000000;
        this.flight_cap = 200000;
        this.basket_cap = 10000005;
    }
    //should make uniform one so prob can delete this soon
    public void help(){
        System.out.println("Fly: ");
        System.out.println("Choose the coordinates of where you want to go ");
        System.out.println("Grow");
        System.out.println("Double in size when you complete a quest!");
        System.out.println("Open Basket:");
        System.out.println("Opens basket, to examine items collected");
        System.out.println("Empty Basket: ");
        System.out.println("Emptys basket of all items.");
        System.out.println("Stats: ");
        System.out.println("Prints out important character stats");
    }



    /**
     * adds item to arraylist
     * @param item 
     */
    public void grab(String item) {
        this.basket.add(item);
        System.out.println("you have added "+ item+ " to your collection");
    }
  /**
   * removes item from arraylist
   * @param item of insect
   * @return insect removed
   */

    
    public String removeItem(String item) {
        this.basket.remove(item);
        System.out.println("you have dropped "+item+ " from your collection");
        return item;
    }

/*
 * prints list of insects
 */
    // public void examine() {
    //     if (basket.size()>1){
    //     System.out.println("Below is your list of items: ");
    //     System.out.println(basket);
    //     }
    //     else{
    //         throw new RuntimeException("Sorry, you currently do not have any items in your collection");
    //     }
    //     }

    public void empty() {
        this.basket.clear();
        System.out.println("You have bumped into a tree and lost all your insects, sorry!");
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
    }



