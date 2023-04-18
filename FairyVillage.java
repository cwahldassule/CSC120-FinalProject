import java.util.Scanner;

public class FairyVillage extends Quest{
    Scanner in;
    int where_x;
    int where_y;
    int left_bound;
    int right_bound;
    int upper_bound;

    public FairyVillage(String name){
        super("Fairy Village", 2);
        this.in = new Scanner(System.in);
        this.where_x = 0;
        this.where_y = 0;
        this.left_bound = -2;
        this.right_bound = 2;
        this.upper_bound = 2;
    }

    public boolean play(){
        System.out.println("What direction would you like to walk in? (N/S/E/W)");
        String input = in.nextLine();
        if(input.equals("N")){
            where_y += 1;
        }
        else if(input.equals("S")){
            where_y -=1;
        }
        else if(input.equals("E")){
            where_x += 1;
        }
        else if(input.equals("W")){
            where_x -= 1;
        }
        else{
            throw new RuntimeException("That's not a direction you can walk in :/");
        }
        if(where_x == 0 & where_y ==0){
            System.out.println("You are at the front gate!");
            System.out.println("Would you like to leave the Fairy Village?");
            input = in.nextLine();
            if(input.equals("yes")){
                return false;
            }
        }
        else if(where_y <0 | where_x < left_bound | where_x > right_bound | where_y > upper_bound){
            System.out.println("There's nothing here :0");
            System.out.println("Would you like to leave the Fairy Village?");
            input = in.nextLine();
            if(input.equals("yes")){
                return false;
            }
        }
        else if(where_x == 0 & where_y == 1){
            System.out.println("Welcome to the Village Square!");
            this.villageSquare();
        }
        else if(where_x == 0 & where_y == 2){
            System.out.println("Welcome to the Potions Shop!");
            //mix gems for sunflowers
        }
        else if(where_x == 1 & where_y == 0){
            System.out.println("Wow this is a nice cobblestone street!");
        }
        else if(where_x == 2 & where_y == 0){
            System.out.println("Welcome to the Bakery!");
            //mix fruits for pearl
        }
        else if(where_x == -1 & where_y == 0){
            System.out.println("Welcome to the Dress Shop!");
            //mix flowers for strawberry
        }
        else if(where_x == -2 & where_y == 0){
            System.out.println("Gosh this is a great view of the sunset!");
        }
        else if(where_x == -1 & where_y == 1){
            System.out.println("Welcome to the Mirabel's Cottage!");
        }
        else if(where_x == -2 & where_y == 1){
            System.out.println("Welcome to the Music Corner!");
            //guess the next note for +0.25 flight power
        }
        else if(where_x == 1 & where_y == 1){
            System.out.println("Awww theres a cute cat napping in some flowers");
        }
        else if(where_x == 2 & where_y == 1){
            System.out.println("Welcome to the Angel Fountain");
        }
        else if(where_x == -1 & where_y == 2){
            System.out.println("A soft breeze is making some nearby windchimes play beautiful melody!");
        }
        else if(where_x == -2 & where_y == 2){
            System.out.println("Welcome to Blaze's Cottage!");
            //game of chance
        }
        else if(where_x == 1 & where_y == 2){
            System.out.println("Welcome to the Fairydust Inn!");
        }
        else if(where_x == 2 & where_y == 2){
            System.out.println("Welcome to Elida's Cottage!");
        }
        return true;
    }
    public void villageSquare(){
        if(!this.complete){
            System.out.println("It looks like the village is preparing for a festival and need your help!");
            System.out.println("Will you help them by collecting a few items?");
            String input = in.nextLine();
            if(input.equals("yes")){
                System.out.println("Wonderful! Heres the list of items they need:");
                this.printRecipe();
                this.started = true;
            }
            else{
                System.out.println("Okay :(");
            }
        }
        else if(this.complete){
            System.out.println("Thank you for all your help! The festival is in full swing!");
        }

    }
    public void intro(){
        System.out.println("Welcome to the Fairy Village!");
        System.out.println("Walk around to explore the village");
        System.out.println("(Walking in the fairy village does not use flight power)");
    }
}
