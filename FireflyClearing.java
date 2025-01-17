import java.util.Scanner;

/**
 * Class FireflyClearing is in charge of a quest with specific locations and challenges
 */

public class FireflyClearing extends Quest {
    Scanner in;
    int where_x;
    int where_y;
    int left_bound;
    int right_bound;
    int upper_bound;
    int lower_bound;
    Character user;
  
   /**
   * Constructor for FireflyClearing
   * @param name, String
   * @param size, int
   * @param user, Character
   */

    public FireflyClearing(String name, int size, Character user) {
        super(name, size);
        this.in = new Scanner(System.in);
        this.where_x = 0;
        this.where_y = 0;
        this.left_bound = 0;
        this.right_bound = 2;
        this.upper_bound = 2;
        this.lower_bound = 0;
        this.user = user;

    }

   /**
   * Prints introductory welcome message
   */  
    
    public void intro(){
        System.out.println("\nWelcome to the Firefly Clearing! You are currently at the Starlight Pond");
        System.out.println("Walk around to explore the clearing (walking does not use flight power)");
    }

    /**
   * Explains user command options
   */  
    
    public void help(){
        System.out.println("\nOptions: ");
        System.out.println("WALK North, South, East, or West");
        System.out.println("\t-> Enter 'n', 'e', 's', or 'w'");
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

    /**
   * Returns false if the quest is not complete, true if it is
   * @param user, Character
   * @return Boolean
   */  

    public Boolean finishQuest(Character user){
        for(int i = 0; i<this.recipe.size(); i++){
            String item = this.recipe.get(i);
            for(int j = 0; j<user.basket.size(); j++){
                if(item.equals(user.basket.get(j))){
                    this.recipe.remove(item);
                    user.basket.remove(item);
                    System.out.println("\t-"+item);
                }
            }
        }
        if(recipe.size() == 0){
        System.out.println("\nThank you for collecting all the items!");
        this.complete = true;
        this.started = false;
        user.busy = false;
        user.quest_complete += 1;
        return true;
        }
        else{
        System.out.println("\nYou don't have all the necessary items to complete this quest:(");
        System.out.print("\nRemaining ");
        this.printRecipe();
        return false;
        }
    }

    /**
   * Gives user option to begin quest, starts quest, and gives user recipe
   */  

    public void walnutTree(){
        if(this.started | this.complete){
            System.out.println("\nWelcome back to the walnut tree!");
            this.finishQuest(user);
        
            if(this.complete){
                System.out.println("\nThank you for all your help! The fireflies swarm around you in gratitude and then begin making their potion.");
            }
        }
        else if(!this.complete & !this.started & !user.busy){
            System.out.println("You come across a majestic walnut tree.");
            System.out.println("Tonight is the full moon, so all the fireflies will be gathering to make a special potion in an empty walnut shell.");
            System.out.println("Will you help them by collecting a few items for the potion?");
            String input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                System.out.println("\nWonderful! You will need to collect the following items:");
                this.started = true;
                user.busy = true;
                this.printRecipe();
                System.out.println("\nReturn to the walnut tree when you have collected all of the items");
                
            }
            else if(input.equals("NO")){
                System.out.println("\nOkay :(");
            }
            else{
                throw new RuntimeException("\nNot a valid option >_<");
            }
        }        
        else if(user.busy){
            System.out.println("Welcome to the walnut tree!");
            System.out.println("Come back when you've finished your current quest");
            System.out.println("Feel free to explore the rest of the clearing...");
        }
    
    }



    /**
   * Takes in user's commands and calls appropriate functions/moves user's position accordingly, including controling specific locations and outer boundaries, all within the Firefly Clearing
   * @return boolean
   */  
    
    public boolean play(){
        System.out.println("\n\t\t\tPress enter to continue");
        in.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int og_x = where_x;
        int og_y = where_y;
        System.out.println("\nWhere would you like to go/do? (n, e, s, w, help)");
        String input = in.nextLine().toUpperCase();
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
        else if(input.equals("STATS")){
            user.stats();
        }
        else if(input.equals("HELP")){
            this.help();
        }
        else if(input.equals("SLEEP")){
            user.sleep(10000);
        }
        else if(input.equals("RECIPE")){
            this.printRecipe();
        }
        else if(input.equals("OPEN BASKET")){
            user.openBasket();
        }
        else if(input.equals("EMPTY BASKET")){
            user.empty();
        }
        else if(input.equals("SNACK")){
            user.snack();
        }
        else{
            throw new RuntimeException("That's not a valid option :/");
        }
        if(og_x != where_x | og_y != where_y){
            System.out.println("ENTERED");
            if(where_x == 0 & where_y == 0){
                System.out.println("You are at the Starlight Pond");
                System.out.println("Would you like to leave the Firefly Clearing?");
                input = in.nextLine().toUpperCase();
                if(input.equals("YES")){
                    return false;
                }
            }
            else if(where_y <lower_bound | where_x < left_bound | where_x > right_bound | where_y > upper_bound){
                System.out.println("There's nothing here :0");
                System.out.println("Would you like to leave the Firefly Clearing?");
                input = in.nextLine().toUpperCase();
                if(input.equals("YES")){
                    return false;
                }
                else {
                    System.out.println("\nSending you back...");
                    if (where_y < lower_bound) {
                        where_y += 1;
                    }
                    if (where_y > upper_bound) {
                        where_y -= 1;
                    }
                    if (where_x < left_bound) {
                        where_x += 1;
                    }
                    if (where_x > right_bound) {
                        where_x -= 1;
                    }
                }
            }
            else if (where_x==2 && where_y==0){
                this.cloverPatch();
            }
            else if (where_x==0 && where_y==2){
                this.cozyKnothole();
            }
            else if (where_x==1 && where_y==2){
                this.ornateMirror();
            }
            else if (where_x==2 && where_y==1){
                this.pineconeShrine();
            }
            else if (where_x==1 && where_y==0){
                this.birchBridge();
            }
            else if (where_x==1 && where_y==1){
                this.desertedBurrow();
            }
            else if (where_x==0 && where_y==1){
                this.walnutTree();
            }    
            else if (where_x==2 && where_y==2){
                this.leafHammock();
            }               

    }

    return true;
}

    /**
   * Clover Patch location, possibility of +2 flight power
   */  

    public void cloverPatch() {
        System.out.println("You find yourself in the middle of a large patch of clover");
        System.out.println("You know that four leaf clovers are lucky. Do you want to look for one?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            int num = Item.randNum(3);
            if (num == 1){
                System.out.println("You found a lucky four leaf clover! You feel energized");
                System.out.println("\t+2 flight power");
                user.flight_power += 2;
            }
            else {
                System.out.println("No luck this time :/");
            }
        }
        else if(input.equals("NO")){
            System.out.println("\nYou can try your luck another time");
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }       

    }

    /**
   * Cozy Knothole location, possibility of +Blueberry
   */  

    public void cozyKnothole() {
        System.out.println("You enter a cozy knothole in one of the clearing's trees");
        System.out.println("A small owlet startles when you enter");
        System.out.println("Parsnip: Oh! I wasn't expecting company. My name is Parsnip! And yours is..?");
        String input = in.nextLine().toUpperCase();
        System.out.println("Parsnip: Very nice to meet you, " + input + ". Can I interest you in a riddle to pass the time?");
        String input2 = in.nextLine().toUpperCase();
        if(input2.equals("YES")){
            System.out.println("Parsnip: When I am young, I am tall. As I age, I become shorter and shorter. I only become useful to you when you begin my process of dying. What am I?");
            String input3 = in.nextLine().toUpperCase();
            if(input3.equals("A PENCIL") | input3.equals("PENCIL") | input3.equals("A CANDLE") | input3.equals("CANDLE")){
                System.out.println("Parsnip: Wow, you're smart! Here, have this Blueberry as a token of my admiration");
                user.grab("Blueberry");
            }
            else {
                System.out.println("Hmmm... That's not the answer I was thinking of...");
            }
        }
        else if(input2.equals("NO")){
            System.out.println("\nParsnip sighs sadly and retreats to a shadowy corner of the knothole");
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }       

    }

    /**
   * Ornate Mirror location, gives user a message
   */  

    public void ornateMirror() {
        System.out.println("You stumble upon an ornate mirror lying in the grass...");
        System.out.println("Wow, what a beautiful mirror! And an even more beautiful bug reflected in it!");
        System.out.println("Oh wait, that's you :)");
    }

    /**
   * Pinecone Shrine location, possibility of -3 flight power, -4 flight power, or +Gold Key
   */  

    public void pineconeShrine() {
        System.out.println("You've discovered a shrine built from pinecones and willow branches");
        System.out.println("You don't know who the shrine is to. Do you want to give an offering?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            String flower = Item.randFlower();
            System.out.println("You look around for something to give and find a " + flower);
            if (flower.equals("Peony") | (flower.equals("Tulip"))) {
                System.out.println("When you lay the " + flower + " at the shrine, the air around it begins to shimmer, and the " +flower+ " dissapears");
                System.out.println("A small Gold Key appears where the " +flower+ " once was. Whoever the shrine is to must be pleased with your offering!");
                user.grab("Gold Key"); 
            }
            else {
                System.out.println("When you lay the " + flower + " at the shrine, it instantly bursts into flames, singeing one of your wings.");
                System.out.println("\t-4 flight power");
                user.flight_power -= 4;
                System.out.println("Who doesn't like a pretty " +flower+ "? Turns out whoever this shrine is to doesn't!");
            }
             
        }
        else if(input.equals("NO")){
            System.out.println("\nThat's not very respectful...");
            user.flight_power -= 3;
            System.out.println("\t-3 flight power");
                
            
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }       

    }

    /**
   * Birch Bridge location, gives user a message
   */ 

    public void birchBridge() {
        System.out.println("You find yourself standing on a bridge made from the fallen limb of a birch tree");
        System.out.println("The view is beautiful from here!");

    }

    /**
   * Deserted Burrow location, possibility of +Sapphire
   */ 

    public void desertedBurrow() {
        System.out.println("You discover a deserted burrow, maybe used by a bunny family once upon a time.");
        System.out.println("Looking around, you spot an intricately painted treasure chest. Do you want to open it?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){    
            if (user.basket.contains("Gold Key")) {
            System.out.println("\nYou use your Gold Key to unlock and open the chest");
            user.basket.remove("Gold Key");
            System.out.println("\nInside, you find a pile of Sapphires!");
            user.grab("Sapphire");
            }
            else {
                System.out.println("The chest is locked! You need a key to open it...");
            }
        }
        else if(input.equals("NO")){
            System.out.println("\nYou do you, I guess :I");
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }       

    }

    /**
   * Leaf Hammock location, possibility of +Lavender
   */ 
    
    public void leafHammock() {
        System.out.println("You come across a patch of tall Lavender stalks with tree leaves tied between to make little hammocks");
        System.out.println("There is plenty of Lavender here, and only a small section of it holds the hammocks. Would you like to take a little bit of Lavender?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            user.grab("Lavender");
            
        }
        else if(input.equals("NO")){
            System.out.println("\nNo problem :]");   
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }   
    }


    
    public static void main(String[] args) {
        Character me = new Character("Matilda", 40, 30);
        FireflyClearing myClearing = new FireflyClearing("Firefly Clearing", 3, me);


        while(true){
            try{myClearing.play();}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


    

        
  
        

