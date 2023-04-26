import java.util.Scanner;

public class MushroomCastle extends Quest {
    int x;
    int y;
    int z;
    int east_bound;
    int north_bound;
    int up_bound;
    Character user;
    Scanner in;

    public MushroomCastle(String name, int size, Character user) {
        super(name, size);
        this.user = user;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.east_bound = 2;
        this.north_bound = 2;
        this.up_bound = 1;
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

    public boolean play(){
        System.out.println("What would you like to do/go");
        String input = in.nextLine().toUpperCase();
        if(input.equals("N")){
            this.y += 1;
        }
        else if(input.equals("E")){
            this.x += 1;
        }
        else if(input.equals("S")){
            this.y -= 1;
        }
        else if(input.equals("W")){
            this.x -= 1;
        }
        else if(input.equals("UP")){
            this.z += 1;
        }
        else if(input.equals("DOWN")){
            this.z -= 1;
        }
        else if(input.equals("RECIPE")){
            this.printRecipe();
        }
        else if(input.equals("HELP")){
            this.help();
        }
        else if(input.equals("LEAVE")){
            if(this.x == 0 & this.y == 0 & this.z == 0){
                return false;
            }
            else{
                throw new RuntimeException("You can only leave from the Grand Foyer :/");
            }
        }
        
        int og_x = this.x;
        int og_y = this.y;
        int og_z = this.z;
        if(og_x != this.x | og_y != this.y | og_z != this.z){
            if(this.x == 0 & this.y == 0 & this.z == 0){
                System.out.println("**You are in the grand foyer...**");
            }
            if(this.x == 1 & this.y == 0 & this.z == 0){
        
            }
            if(this.x == 2 & this.y == 0 & this.z == 0){
        
            }
            if(this.x == 0 & this.y == 1 & this.z == 0){
        
            }
            if(this.x == 1 & this.y == 1 & this.z == 0){
        
            }
            if(this.x == 2 & this.y == 1 & this.z == 0){
        
            }
            if(this.x == 0 & this.y == 2 & this.z == 0){
        
            }
            if(this.x == 1 & this.y == 2 & this.z == 0){
        
            }
            if(this.x == 2 & this.y == 2 & this.z == 0){
        
            }
            if(this.x == 0 & this.y == 0 & this.z == 1){
        
            }
            if(this.x == 1 & this.y == 0 & this.z == 1){
        
            }
            if(this.x == 2 & this.y == 0 & this.z == 1){
        
            }
            if(this.x == 0 & this.y == 1 & this.z == 1){
        
            }
            if(this.x == 1 & this.y == 1 & this.z == 1){
        
            }
            if(this.x == 2 & this.y == 1 & this.z == 1){
        
            }
            if(this.x == 0 & this.y == 2 & this.z == 1){
        
            }
            if(this.x == 1 & this.y == 2 & this.z == 1){
        
            }
            if(this.x == 2 & this.y == 2 & this.z == 1){
        
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Character user = new Bumblebee("Bettie");
        MushroomCastle myCastle = new MushroomCastle("Mushroom Castle", 5, user);
        boolean temp = true;
        while(temp){
            try{
                temp = myCastle.play();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
