public class Butterfly extends Character {



    public Butterfly(String Name) {
        super(name);
        flight_power = 20;
        flight_cap = 20;
        basket_cap = 15;
        


    }


    public static void main(String[] args) {
       Butterfly butter = new Butterfly("Butter");
       System.out.println(butter.flight_power);
    }


}