import java.util.Scanner;

public class FairyVillage<T extends Character> extends Quest{
    Scanner in;
    int where_x;
    int where_y;
    int left_bound;
    int right_bound;
    int upper_bound;
    T user;

    public FairyVillage(String name, T user){
        super("Fairy Village", 3);
        this.in = new Scanner(System.in);
        this.where_x = 0;
        this.where_y = 0;
        this.left_bound = -2;
        this.right_bound = 2;
        this.upper_bound = 2;
        this.user = user;
    }


    public void angelfountain(){
        int num = Item.randNum(4);
        if(num == 0){
            user.flight_power += 1;
        }
    }

    public void blaze(){
        System.out.println("Hey! Do you want to play a game?");
        String input = in.nextLine().toUpperCase();
        if(input.equals("NO")){
            System.out.println("No I think you do...");
        }
        System.out.println("At this moment in time whatith stuckith up my anusith");
        String input1 = in.nextLine().toUpperCase();
        System.out.println("Sorry "+input1+" wrong :(");
        user.flight_power -= 2;
        System.out.println("\t-2 Flight power");

    }

    public void musicCorner(){
        String[] notes = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        String note = notes[Item.randNum(7)];
        System.out.println("*You see the town bard looking ditressed...*");
        System.out.println("Please help me! I forgot the next natural note in my song T-T");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            System.out.println("What note do you think it is?");
            input = in.nextLine().toUpperCase();
            if(input.equals(note)){
                System.out.println("Thank goodness! Let me play you a lively tune and increase your flight power");
                System.out.println("la la la lee la");
                user.flight_power += 1;
                System.out.println("\t+1 FLight power");
            }
            else{
                System.out.println("Nooooooo that doesn't sound right");
                System.out.println("*The bard smashes their guitar and scramble away*");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void dressShop(){
        String flower = Item.randFlower();
        System.out.println("The dress maker needs your help...");
        System.out.println("Oh Hi! I desperately need a "+flower+" to finish this dress.\nDo you happen to have one?");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(flower)){
                user.basket.remove(flower);
                System.out.println("Thank you so much for your help. Have a Strawberry");
                user.basket.add("Strawberry");
                System.out.println("\t+Strawberry");
            }
            else{
                throw new RuntimeException("You don't have that item >_<");
            }
        }
        else{
            throw new RuntimeException("Okay T-T");
        }
    }

    public void bakery(){
        String fruit = Item.randFruit();
        System.out.println("The baker needs your help making cakes...");
        System.out.println("Hey There! Could you help me out? I need a "+fruit+" to finish baking this cake");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine().toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(fruit)){
                user.basket.remove(fruit);
                System.out.println("Thanks! Have a Pearl!");
                System.out.println("\t+Pearl");
                user.basket.add("Pearl");
            }
            else{
                throw new RuntimeException("You don't havae the right fruit");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void potionsShop(){
        String gem = Item.randGem();
        System.out.println("The potion master needs help brewing potions...");
        System.out.println("Hi friend! I just ran out of "+gem+"s");
        System.out.println("Will you help me?");
        System.out.println("\t+Yes\n\t+No");
        String input = in.nextLine();
        input = input.toUpperCase();
        if(input.equals("YES")){
            if(user.basket.contains(gem)){
                user.basket.remove(gem);
                System.out.println("Thank you so much for your help!");
                System.out.println("Here's a Sunflower to show my gratitude :)");
                user.basket.add("Sunflower");
                System.out.println("\t+Sunflower");
            }
            else{
                throw new RuntimeException("You don't have a "+gem+ " in your basket :/");
            }
        }
        else if(input.equals("NO")){
            System.out.println("Okay T-T");
        }
        else{
            throw new RuntimeException("Not a valid option >_<");
        }
    }

    public void intro(){
        System.out.println("Welcome to the Fairy Village!");
        System.out.println("Walk around to explore the village");
        System.out.println("(Walking in the fairy village does not use flight power)");
    }

    public Boolean finishQuest(T user){
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
        user.size += 1;
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
        if(this.started){
            System.out.println("\nWelcome back to the Village Square!");
            this.finishQuest(user);
        
            if(this.complete){
                System.out.println("\nThank you for all your help! The festival is in full swing!");
            }
        }
        else if(!this.complete & !this.started){
            System.out.println("\nIt looks like the village is preparing for a festival and needs your help!");
            System.out.println("Will you help them by collecting a few items?");
            String input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                System.out.println("\nWonderful! Heres the list of items they need:");
                this.printRecipe();
                this.started = true;
            }
            else if(input.equals("NO")){
                System.out.println("\nOkay :(");
            }
            else{
                throw new RuntimeException("\nNot a valid option >_<");
            }
        }
    
    }
    
    public boolean play(){
        System.out.println("Where would you like to go/do?");
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
        else if(input.equals("SLEEP")){
            //user.sleep();
        }
        else if(input.equals("QUEST")){
            this.printRecipe();
        }
        else if(input.equals("OPEN BASKET")){
            user.openBag();
        }
        else{
            throw new RuntimeException("That's not a valid option :/");
        }
        if(where_x == 0 & where_y ==0){
            System.out.println("You are at the front gate!");
            System.out.println("Would you like to leave the Fairy Village?");
            input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                return false;
            }
        }
        else if(where_y <0 | where_x < left_bound | where_x > right_bound | where_y > upper_bound){
            System.out.println("There's nothing here :0");
            System.out.println("Would you like to leave the Fairy Village?");
            input = in.nextLine().toUpperCase();
            if(input.equals("YES")){
                return false;
            }
        }
        else if(where_x == 0 & where_y == 1){
            this.villageSquare();
        }
        else if(where_x == 0 & where_y == 2){
            System.out.println("Welcome to the Potions Shop!");
            this.potionsShop();
            //mix gems for sunflowers
        }
        else if(where_x == 1 & where_y == 0){
            System.out.println("Wow this is a nice cobblestone street!");
        }
        else if(where_x == 2 & where_y == 0){
            System.out.println("Welcome to the Bakery!");
            this.bakery();
            //mix fruits for pearl
        }
        else if(where_x == -1 & where_y == 0){
            System.out.println("Welcome to the Dress Shop!");
            this.dressShop();
            //mix flowers for strawberry
        }
        else if(where_x == -2 & where_y == 0){
            System.out.println("Gosh this is a great view of the sunset!");
        }
        else if(where_x == -1 & where_y == 1){
            System.out.println("Welcome to the Mirabel's Cottage!");
            //useless chat bot
        }
        else if(where_x == -2 & where_y == 1){
            System.out.println("Welcome to the Music Corner!");
            this.musicCorner();
        }
        else if(where_x == 1 & where_y == 1){
            System.out.println("Awww theres a cat napping in some flowers");
        }
        else if(where_x == 2 & where_y == 1){
            System.out.println("Welcome to the Angel Fountain");
            this.angelfountain();
            //chat bot
            //randomly gives 0.5 flight power
        }
        else if(where_x == -1 & where_y == 2){
            System.out.println("A soft breeze is making some nearby windchimes play beautiful melody!");
        }
        else if(where_x == -2 & where_y == 2){
            System.out.println("Welcome to Blaze's Cottage!");
            this.blaze();
        }
        else if(where_x == 1 & where_y == 2){
            System.out.println("Welcome to the Fairydust Inn!");
            //fast sleep
        }
        else if(where_x == 2 & where_y == 2){
            System.out.println("Welcome to Elida's Cottage!");
        }
        return true;
    }
    
    public static void main(String[] args) {
        Bumblebee me = new Bumblebee("Chloe");
        FairyVillage<Bumblebee> myVillage = new FairyVillage<Bumblebee>("Fairy Village", me);

        while(true){
            try{myVillage.play();}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
