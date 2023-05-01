import java.util.Scanner;

public class FairyVillage extends Quest{
    Scanner in;
    int where_x;
    int where_y;
    int left_bound;
    int right_bound;
    int upper_bound;
    Character user;

    public FairyVillage(String name, int size, Character user){
        super(name, size);
        this.in = new Scanner(System.in);
        this.where_x = 0;
        this.where_y = 0;
        this.left_bound = -2;
        this.right_bound = 2;
        this.upper_bound = 2;
        this.user = user;
    }

    public void help(){
        System.out.println("\nOptions: ");
        System.out.println("Walk directions:");
        System.out.println("\t+N, E, S, W");
        System.out.println("Stats:");
        System.out.println("\t+Character stats");
        System.out.println("Sleep:");
        System.out.println("\t+Sleep for 10 seconds and reset flight power");
        System.out.println("Recipe:");
        System.out.println("\t+See quest items");
        System.out.println("\tOpen Basket:");
        System.out.println("\t+Opens Basket");
        System.out.println("Empty Basket:");
        System.out.println("\t+Empties Basket");
        System.out.println("Snack:");
        System.out.println("\t+Eat 1 item for 3 flight power");
    }
    public void elida(){
        System.out.println("\n**Elida is ding a little spring cleaning...**\n");
        Chatbot elida = new Chatbot("Elida");
        String[] elida_talk = new String[]{"I have to clean up this mess!", "So many pots and pans everywhere", 
        "I can't remember where I put my teapot", "It's spring cleaning time", "ahh I lost my crystal ball again",
        "Avert your eyes!! my house is so messy", "One day this house will be clean..."};
        elida.play(elida_talk);
        int num = Item.randNum(4);
        if(num == 0){
            System.out.println("Elida: wait before you go have some of this old chocolate to boost your energy");
            System.out.println("\t+1 flight power");
            user.flight_power += 1;
        }
    }

    public void fairyInn(){
        System.out.println("\nIf you're feeling tired you can sleep here in our cozy rooms");
        System.out.println("Would you like to sleep?\n\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            user.sleep(5000);
            user.flight_power += user.flight_cap*0.5;
        }
        else if(input.equals("NO")){
            System.out.println("Okay :(");
        }
        else{
            throw new RuntimeException("Not a valid option :/");
        }
    }

    public void angelfountain(){
        System.out.println("\n**You see a few fairies washing laundry \nand overhear them chatting...**");
        String[] gossip = new String[]{"Did you hear about Nadia??",
        "I heard they found him three days later...", "I wonder what they're going to do now...", "Well I think he deserved it...",
        "Crazy that something like that would happen here!", "I wonder how long it had been going on...", "Did they ever find it?", 
        "Well life is certainly going to be different now..."};
        int num = Item.randNum(4);
        int num2 = Item.randNum(gossip.length);
        while(true){
            int num3 = Item.randNum(gossip.length);
            if(num3 != num2){
                break;
            }
        }
        System.out.println("\nFountain Fiaries: "+gossip[num]);
        System.out.println("Fountain Fiaries: "+gossip[num2]);
        System.out.println("\n**The fairies at the fountain notice you listening...**");
        if(num == 0){
            System.out.println("\nFountain fairies: Hello! You seem like a nice young bug, have some caramels for energy");
            System.out.println("\t+1 Flight power");
            user.flight_power += 1;
        }
        else{
            System.out.println("\nFountain fairies: Shoo it's not nice to eavesdrop");
        }
    }

    public void blaze(){
        System.out.println("\n**Blaze invites you in...**");
        System.out.println("\nBlaze: Hey! Do you want to play a game?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("NO")){
            System.out.println("Blaze: No I think you do...");
        }
        System.out.println("Blaze: If you have 82 diced watermelons\n and are moving at a velocity of 12.3 bluebirds per week, \nwhat is the circumfrence of the sun? ");
        String input1 = in.nextLine().toUpperCase();
        System.out.println("Blaze: Sorry '"+input1+"' wrong :(");
        user.flight_power -= 2;
        System.out.println("\t-2 Flight power");
    }

    public void musicCorner(){
        String[] notes = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        String note = notes[Item.randNum(7)];
        System.out.println("\n**You see the town bard looking ditressed...**");
        System.out.println("\nBard: Please help me! I forgot the next natural note in my song T-T");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            System.out.println("Bard: What note do you think it is?");
            input = in.nextLine().toUpperCase();
            if(input.equals(note)){
                System.out.println("Bard: Thank goodness! Let me play you a lively tune and increase your flight power");
                System.out.println("\tla la la lee la");
                user.flight_power += 10;
                System.out.println("\t+10 FLight power");
            }
            else{
                System.out.println("\nBard:Nooooooo that doesn't sound right");
                System.out.println("\n**The bard smashes their guitar and scrambles away**");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Bard: Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void dressShop(){
        String flower = Item.randFlower();
        System.out.println("\n**The dress maker needs your help...**");
        System.out.println("\nDress Maker: Oh Hi! I desperately need a "+flower+" to finish this dress.\nDo you happen to have one?");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(flower)){
                user.basket.remove(flower);
                System.out.println("Dress Maker: Thank you so much for your help. Have a Strawberry :)");
                user.basket.add("Strawberry");
                System.out.println("\t+Strawberry");
            }
            else{
                throw new RuntimeException("You don't have that item >_<");
            }
        }
        else{
            throw new RuntimeException("Dress Maker: Okay T-T");
        }
    }

    public void bakery(){
        String fruit = Item.randFruit();
        System.out.println("\n**The baker needs your help making cakes...**");
        System.out.println("\nBaker: Hey There! Could you help me out? I need a "+fruit+" to finish baking this cake");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(fruit)){
                user.basket.remove(fruit);
                System.out.println("Baker: Thanks! Have a Pearl!");
                System.out.println("\t+Pearl");
                user.basket.add("Pearl");
            }
            else{
                throw new RuntimeException("You don't havae the right fruit");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Baker: Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void potionsShop(){
        String gem = Item.randGem();
        System.out.println("\n**The potion master needs help brewing potions...**");
        System.out.println("\nPotion Master: Hi friend! I just ran out of "+gem+"s");
        System.out.println("Potion Master: Will you help me?");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine();
        input = input.toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(gem)){
                user.basket.remove(gem);
                System.out.println("Potion Master: Thank you so much for your help!");
                System.out.println("Potion Mater: Here's a Sunflower to show my gratitude :)");
                user.basket.add("Sunflower");
                System.out.println("\t+Sunflower");
            }
            else{
                throw new RuntimeException("You don't have a "+gem+ " in your basket :/");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Potion Master: Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void intro(){
        System.out.println("\n**Welcome to the Fairy Village!**");
        System.out.println("**Walk around to explore the village**");
        System.out.println("**(Walking in the fairy village does not use flight power)**");
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
    
      public void villageSquare(){
        if(this.started | this.complete){
            System.out.println("\nWelcome back to the Village Square!");
            this.finishQuest(user);
        
            if(this.complete){
                System.out.println("\nThank you for all your help! The festival is in full swing!");
            }
        }
        else if(!this.complete & !this.started & !user.busy){
            System.out.println("\nIt looks like the village is preparing for a festival and needs your help!");
            System.out.println("Will you help them by collecting a few items?");
            String input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                System.out.println("\nWonderful! Heres the list of items they need:");
                this.started = true;
                this.printRecipe();  
            }
            else if(input.equals("NO")){
                System.out.println("\nOkay :(");
            }
            else{
                throw new RuntimeException("\nNot a valid option >_<");
            }
        }
        else if(user.busy){
            System.out.println("Welcome to the Village Square!");
            System.out.println("Come back when you've finished your current quest");
            System.out.println("Feel free to explore the rest of the village...");
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
            if(where_x == 0 & where_y ==0){
                System.out.println("\nYou are at the front gate!");
                System.out.println("Would you like to leave the Fairy Village?");
                input = in.nextLine().toUpperCase();
                if(input.equals("YES")){
                    return false;
                }
            }
            else if(where_y <0 | where_x < left_bound | where_x > right_bound | where_y > upper_bound){
                System.out.println("\nThere's nothing here :0");
                System.out.println("Sending you back...");
                where_x = og_x;
                where_y = og_y;
            }
            else if(where_x == 0 & where_y == 1){
                this.villageSquare();
            }
            else if(where_x == 0 & where_y == 2){
                System.out.println("\nWelcome to the Potions Shop!");
                this.potionsShop();
                //mix gems for sunflowers
            }
            else if(where_x == 1 & where_y == 0){
                System.out.println("\nWow this is a nice cobblestone street!");
            }
            else if(where_x == 2 & where_y == 0){
                System.out.println("\nWelcome to the Bakery!");
                this.bakery();
                //mix fruits for pearl
            }
            else if(where_x == -1 & where_y == 0){
                System.out.println("\nWelcome to the Dress Shop!");
                this.dressShop();
                //mix flowers for strawberry
            }
            else if(where_x == -2 & where_y == 0){
                System.out.println("\nGosh this is a great view of the sunset!");
            }
            else if(where_x == -1 & where_y == 1){
                System.out.println("\nWelcome to the Mirabel's Cottage!\n");
                String [] Mirabel = new String[]{"OOps, my muffins are burning", "I like flowers  :p", "Oh dear :0", "You have really shiny hair", "thats...interesting..."};
                Chatbot myBot = new Chatbot("Mirabel");
                myBot.play(Mirabel);
            }
            else if(where_x == -2 & where_y == 1){
                System.out.println("\nWelcome to the Music Corner!");
                this.musicCorner();
            }
            else if(where_x == 1 & where_y == 1){
                System.out.println("\nAwww theres a cat napping in some flowers");
            }
            else if(where_x == 2 & where_y == 1){
                System.out.println("\nWelcome to the Angel Fountain");
                this.angelfountain();
                //randomly gives 0.5 flight power
            }
            else if(where_x == -1 & where_y == 2){
                System.out.println("\nA soft breeze is making some nearby windchimes play a beautiful melody!");
            }
            else if(where_x == -2 & where_y == 2){
                System.out.println("\nWelcome to Blaze's Cottage!");
                this.blaze();
            }
            else if(where_x == 1 & where_y == 2){
                System.out.println("\nWelcome to the Fairydust Inn!");
                this.fairyInn();

            }
            else if(where_x == 2 & where_y == 2){
                System.out.println("\nWelcome to Elida's Cottage!");
                this.elida();
            }
        }
        return true; 
    }
    
    public static void main(String[] args) {
        Bumblebee me = new Bumblebee("Chloe");
        FairyVillage myVillage = new FairyVillage("Fairy Village", 3, me);

        while(true){
            try{myVillage.play();}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
