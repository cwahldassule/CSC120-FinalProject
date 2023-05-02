public class Butterfly extends Character {

    int flight_power;
    int flight_cap;
    int basket_cap;


    public Butterfly(String name) {
        super(name);
        this.flight_power = 20;
        this.flight_cap = 20;
        this.basket_cap = 15;
        


    }
    public void help(){
        System.out.println("\nOptions: ");
        System.out.println("FLY to a specific set of coordinates");
        System.out.println("\t-> Enter 'fly'");
        System.out.println("SEE CHARACTER STATS:");
        System.out.println("\t-> Enter 'stats'");
        System.out.println("SLEEP for 10 seconds to reset flight power");
        System.out.println("\t-> Enter 'sleep'");
        System.out.println("PRINT RECIPE to see needed quest items:");
        System.out.println("\t-> Enter 'recipe'");
        System.out.println("\tOPEN BASKET to see your items:");
        System.out.println("\t-> Enter 'open basket'");
        System.out.println("EMPTY BASKET of all items:");
        System.out.println("\t-> Enter 'empty basket'");
        System.out.println("EAT A SNACK for +3 flight power:");
        System.out.println("\t-> Enter 'snack'");
    }


    public static void main(String[] args) {
       Butterfly butter = new Butterfly("Butter");
       System.out.println(butter.flight_power);
    }


}