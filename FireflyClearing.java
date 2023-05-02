import java.util.Scanner;

public class FireflyClearing extends Quest {
    Scanner in;
    int where_x;
    int where_y;
    int left_bound;
    int right_bound;
    int upper_bound;
    int lower_bound;
    Character user;
  

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
    
    public void intro(){
        System.out.println("\n**Welcome to the Firefly Clearing!**");
        System.out.println("**Walk around to explore the clearing**");
        System.out.println("**(Walking in the Firefly Clearing does not use flight power)**");
    }

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
        user.grow();
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

    public void fireflyPond(){
        if(this.started | this.complete){
            System.out.println("\nWelcome back to the Starlight Pond!");
            this.finishQuest(user);
        
            if(this.complete){
                System.out.println("\nThank you for all your help! The fireflies swarm around you in gratitude and then begin making their potion.");
            }
        }
        else if(!this.complete & !this.started){
            System.out.println("\nTonight is the full moon, so all the fireflies will be gathering to make a special potion.");
            System.out.println("Will you help them by collecting a few items for the potion?");
            String input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                System.out.println("\nWonderful! You will need to collect the following items:");
                this.printRecipe();
                this.started = true;
                user.busy = true;
            }
            else if(input.equals("NO")){
                System.out.println("\nOkay :(");
            }
            else{
                throw new RuntimeException("\nNot a valid option >_<");
            }
        }        
        else if(user.busy){
            System.out.println("Welcome to the Starlight Pond!");
            System.out.println("Come back when you've finished your current quest");
            System.out.println("Feel free to explore the rest of the clearing...");
        }
    
    }




    
    public boolean play(){
        System.out.println("\n\t\t\tPress enter to continue");
        in.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int og_x = where_x;
        int og_y = where_y;
        System.out.println("\nWhere would you like to go/do?");
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
            if(where_x == 0 & where_y ==0){
                System.out.println("You are at the Starlight Pond.");
                System.out.println("Would you like to leave the Firefly Clearing?");
                input = in.nextLine().toUpperCase();
                if(input.equals("YES")){
                    return false;
                }
            }
            else if(where_y <0 | where_x < left_bound | where_x > right_bound | where_y > upper_bound){
                System.out.println("There's nothing here :0");
                System.out.println("Would you like to leave the Firefly Clearing");
                input = in.nextLine().toUpperCase();
                if(input.equals("YES")){
                    return false;
                }
            }
            else if (where_x==1 && where_y==0){
                this.cloverPatch();
            }
            else if (where_x==2 && where_y==0){
                this.cozyKnothole();
            }
            else if (where_x==1 && where_y==1){
                this.ornateMirror();
            }
            else if (where_x==2 && where_y==1){
                this.pineconeShrine();
            }
            else if (where_x==0 && where_y==1){
                this.birchBridge();
            }
            else if (where_x==1 && where_y==2){
                this.desertedBurrow();
            }
            else if (where_x==2 && where_y==2){
                this.leafHammock();
            }             
    }

    return true;
}

    public void cloverPatch() {
        System.out.println("You find yourself in the middle of a large patch of clover");
        System.out.println("You know that four leaf clovers are lucky. Do you want to look for one?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            int num = Item.randNum(3);
            if (num == 3){
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
                user.basket.add("Blueberry");
                System.out.println("\t+Blueberry");
            }
            else {
                System.out.println("Hmmm... That's not the answer I was thinking of...");
            }
        }
        else if(input.equals("NO")){
            System.out.println("\nParsnip sighs sadly and retreats to a shadowy corner of the knothole");
        }
        else{
            throw new RuntimeException("\nNot a valid option >_<");
        }       

    }

    public void ornateMirror() {
        System.out.println("You stumble upon an ornate mirror lying in the grass...");
        System.out.println("Wow, what a beautiful mirror! And an even more beautiful bug reflected in it!");
        System.out.println("Oh wait, that's you :)");
    }

    public void pineconeShrine() {
        System.out.println("You've discovered a shrine built from pinecones and willow branches");
        System.out.println("You don't know who the shrine is to. Do you want to give an offering?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            String flower = Item.randFlower();
            while (true){
                flower = Item.randFlower();
                if (flower.equals("Lavender")) {
                    continue;
                }else{
                    break;}
                }
            System.out.println("You look around for something to give and find a " + flower);
            if (flower.equals("Peony") | (flower.equals("Tulip"))) {
                System.out.println("When you lay the " + flower + " at the shrine, the air around it begins to shimmer, and the " +flower+ "dissapears");
                System.out.println("A small gold key appears where the " +flower+ " once was. Whoever the shrine is to must be pleased with your offering!");
                user.basket.add("gold key");
                System.out.println("\t+gold key"); 
            }
            else {
                System.out.println("When you lay the " + flower + " at the shrine, it instantly bursts into flames, singing one of your wings.");
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

    public void birchBridge() {
        System.out.println("birch bridge test");
    }
    public void desertedBurrow() {
        System.out.println("birch bridge test");
    }
    public void leafHammock() {
        System.out.println("birch bridge test");
    }


    
    public static void main(String[] args) {
        Bumblebee me = new Bumblebee("Matilda");
        FireflyClearing myClearing = new FireflyClearing("Firefly Clearing", 2, me);

        while(true){
            try{myClearing.play();}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


    

        
  
        

