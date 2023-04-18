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


    public static void main(String[] args) {
       Butterfly butter = new Butterfly("Butter");
       System.out.println(butter.flight_power);
    }


}