import java.util.Scanner;


public class MushroomCastle extends Quest {
    int x;
    int y;
    int east_bound;
    int north_bound;
    Character user;
    Scanner in;
    int recipe_x;
    int recipe_y;
    int reward_x;
    int reward_y;

    public MushroomCastle(String name, int size, Character user) {
        super(name, size);
        this.in = new Scanner(System.in);
        this.user = user;
        this.x = 0;
        this.y = 0;
        this.east_bound = 3;
        this.north_bound = 3;
        this.recipe_x = Item.randNum(4)-1;
        this.recipe_y =Item.randNum(4)-1;
        this.reward_x = Item.randNum(4)-1;
        this.reward_y = Item.randNum(4)-1;
    }

    public void help(){
        System.out.println("Movement:");
        System.out.println("\t+N, E, S, W, Up, Down");
      }
      

    public void printRecipe(){
        System.out.println("Quest items:");
        for(int i = 0; i<recipe.size(); i++){
        System.out.println("\t+"+recipe.get(i));
        }
    }

    public void maze(String direction){
        System.out.println(this.x+this.y);
            if(this.x == 0 & this.y == 0){
                System.out.println("**You are in the grand foyer...**");
                if(direction.equals("N")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            if(this.x == 1 & this.y == 0){
                System.out.println("**You are in Throne Room**");
                if(direction.equals("N")|direction.equals("E")|direction.equals("W")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            if(this.x == 2 & this.y == 0){
                System.out.println("**You are in Dining Hall**");
                if(direction.equals("N")|direction.equals("E")|direction.equals("W")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 3 & this.y == 0){
                System.out.println("**You are in Sitting Room**");
                if(direction.equals("N")|direction.equals("W")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 0 & this.y == 1){
                System.out.println("**You are in Cook's quarters**");
                if(direction.equals("N")|direction.equals("S")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 1 & this.y == 1){
                System.out.println("**You are in bed chamber**");
                if(direction.equals("N")|direction.equals("S")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 2 & this.y == 1){
                System.out.println("**You are in the game room**");
                if(direction.equals("N")|direction.equals("W")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 3 & this.y == 1){
                System.out.println("**You are in the bathroom**");
                if(direction.equals("W")|direction.equals("S")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 0 & this.y == 2){
                System.out.println("**You are in the storage closet**");
                if(direction.equals("N")|direction.equals("S")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 1 & this.y == 2){
                System.out.println("**You are in bed chamber**");
                if(direction.equals("W")|direction.equals("S")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 2 & this.y == 2){
                System.out.println("**You are at the spiral staircase**");
                if(direction.equals("N")|direction.equals("S")|direction.equals("E")|direction.equals("W")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 3 & this.y == 2){
                System.out.println("**You are in the library**");
                if(direction.equals("N")|direction.equals("W")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 0 & this.y == 3){
                System.out.println("**You are in the gardens**");
                if(direction.equals("S")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
            else if(this.x == 1 & this.y == 3){
                System.out.println("**You are in the patio**");
                if(direction.equals("W")|direction.equals("E")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 2 & this.y == 3){
                System.out.println("**You are in ballroom**");
                if(direction.equals("W")|direction.equals("S")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
        
            }
            else if(this.x == 3 & this.y == 3){
                System.out.println("**You are in a sunlit corner**");
                if(direction.equals("S")){
                    this.move(direction);
                }
                else{
                    throw new RuntimeException("You can't go that way...");
                }
            }
        }

    public void move(String d){
        int og_x = this.x;
        int og_y = this.y;
        if(d.equals("N")){
            this.y += 1;
        }
        else if(d.equals("E")){
            this.x += 1;
        }
        else if(d.equals("S")){
            this.y -= 1;
        }
        else if(d.equals("W")){
            this.x -= 1;
        }
        if(this.x > east_bound | this.x<0 | this.y > north_bound | this.y <0){
            System.out.println("You ran into the wall...");
            System.out.println("...maybe go a different way");
            this.x = og_x;
            this.y = og_y;
        }
        
    }

    public boolean play(){
        String input = in.nextLine();
        if(input.equals("RECIPE")){
            this.printRecipe();
            return true;
        }
        else if(input.equals("HELP")){
            this.help();
            return true;
        }
        else if(input.equals("LEAVE")){
            if(this.x == 0 & this.y == 0){
                return false;
            }
            else{
                throw new RuntimeException("You can only leave from the Grand Foyer :/");
            }
        }
        else if(input.equals("N")|input.equals("E")|input.equals("S")|input.equals("W")){
            this.maze(input);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
        Character user = new Bumblebee("Bettie");
        MushroomCastle myCastle = new MushroomCastle("Mushroom Castle", 6, user);
        while(true){
            boolean temp = true;
            try{
                temp = myCastle.play();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            if(!temp){
                break;
            }
        }
    }
}
