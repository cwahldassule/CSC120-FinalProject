import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * creates quest class Elf Treehouse
 */
public class ElfTreeHouse extends Quest {
  Scanner in ;
  int where_x;
  int where_y;
  int left_bound;
  int right_bound;
  int upper_bound;
  Character user;
  String option1;

  String option2;
  String option3;

  /**
   * constructs treehouse object
   * @param name of treehouse
   * @param user user in treehouse
   */
  public ElfTreeHouse(String name, Character user) {
    super("ElfTreeHouse", 3);
    this.in = new Scanner(System.in);
    this.where_x = 0;
    this.where_y = 0;
    this.left_bound = 0;
    this.right_bound = 2;
    this.upper_bound = 2;
    this.user = user;
    this.option1 = "null";
    this.option2 = "null";
    this.option3 = "null";
  }

  /**
   * introduces Elf Treehouse
   */
  public void intro() {
    System.out.println("Welcome to the ElfTreeHouse");
    System.out.println("Fly around to explore and look for items!");
    System.out.println("Flying around the Treehouse will not affect flight power, make sure to check North and East!");
  }

  /**
   * mailbox, gives user 50/50 chance of gaining access to quest and item able to be found in treehouse
   */
  public void mailbox() {
    System.out.println("You have found the mailbox!");
    System.out.println("Enter YES to open the mailbox, but risk losing an item, OR enter NO to keep moving");
    System.out.println("  ");
    System.out.println("Hint: the mailbox lists the items you can find in the ElfTreeHouse, and recieve your quest recipe!");
    String input = in.nextLine().toUpperCase();
    if (input.equals("YES")) {
      int open_close = Item.randNum(2);
      if (open_close == 0) { 
        System.out.println("Congrats! you have opend the mailbox!");
        System.out.println("In the ElfTreehouse you will find: \n\t Gem: Emerald \n\t Flower: Peony \n\t Fruit: Blackberry ");
        if (!this.complete & !user.busy) {
          System.out.println("Here is your treehouse quest:");
          this.started = true;
          user.busy = true;
          this.printRecipe();
        }
      } else if (open_close == 1) {
        System.out.println("You have lost the odds, and will now lose an item");
        if (user.basket.size() >= 1) {
          Integer temp1 = Item.randNum(user.basket.size());
          System.out.println("You dropped " + user.basket.get(temp1));
          this.user.basket.remove(user.basket.get(temp1));
        } else {
          System.out.println("Whoops you don't have any items to drop, keep on moving!");
        }
      } else if (input.equals("NO")) {
        System.out.println("Great, you decided to play it safe, keep moving in the treehouse");
      } else {
        throw new RuntimeException("Not a valid option");
      }
    }
  }

  /**
   * Oakdoor, asks user to unscramble message to gain blackberry
   */
  public void oakDoor() { 
    System.out.println("Welcome to the Oak Leaf Door");
    System.out.println("Would you like to unscramble the message to gain a reward? YES or NO:");
    String input = in.nextLine().toUpperCase();

    if (input.equals("YES")) {
      System.out.println("lcokun ofr rerblacybk");
      input = in.nextLine().toUpperCase();
      if (input.equals("UNLOCK FOR BLACKBERRY")) {
        System.out.println("Congrats! You cracked the code!");
        System.out.println("You have recieved one Blackberry");
        user.basket.add("Blackberry");
      } else {
        Boolean riddle = true;
        while (riddle) {
          System.out.println("Whoops, that is incorrect, would you like to try again or recieve a Hint? Try or Hint:");
          input = in.nextLine().toUpperCase();
          if (input.equals("TRY")) {
            input = in.nextLine().toUpperCase();

            if (input.equals("UNLOCK FOR BLACKBERRY")) {
              System.out.println("Congrats! You cracked the code!");
              System.out.println("You have recieved one Blackberry");
              user.basket.add("Blackberry");
              riddle = false;
            }

          } else if (input.equals("HINT")) {
            System.out.println("You have chosen to recieve a hint, read the clue below and try again:");
            ArrayList < String > hints = new ArrayList < String > ();
            hints.add("The first word usually needs a key");
            hints.add("This fruit has a color in its name");
            hints.add("This fruit is two seperate words out together");

            Random randHint = new Random();
            int index = randHint.nextInt(hints.size());
            String hint = hints.get(index);
            System.out.println(hint);
            input = in.nextLine().toUpperCase();

            if (input.equals("UNLOCK FOR BLACKBERRY")) {
              System.out.println("Congrats! You cracked the code!");
              System.out.println("You have recieved one Blackberry");
              user.basket.add("Blackberry");
              riddle = false;
            }
          }
        }
      }
    } else if (input.equals("NO")) {
      System.out.println("Keep moving then!");
    } else {
      throw new RuntimeException("Invalid input!!");
    }
  }

  /**
   * Flimsy floorboard, if user chooses yes, user gains item, if no, they lose item.
   */
  public void flimsyFloorboardGain() {
    System.out.println("Uh-oh you have bumped into a flimsy Floorboard, would you like the lift it and see whats underneath?");
    System.out.println("When you chose, you have a 50/50 chance of either losing or gaining at item!");
    System.out.println(" ");
    System.out.println("Would you like to lift? Yes or No");
    String input = in.nextLine().toUpperCase();

    if (input.equals("YES")) {

      ArrayList < String > items = new ArrayList < String > ();
      items.add("Blackberry");
      items.add("Emerald");
      items.add("Peony");

      Random randItem = new Random();
      int index = randItem.nextInt(items.size());
      String item = items.get(index);
      System.out.println("Congrats! you have gained an: " + item);
      this.user.basket.add(item);

    } else if (input.equals("NO")) {
      System.out.println("Whoops, you have lost the odds, and will now lose an item");
      if (user.basket.size() >= 1) {
        Integer temp1 = Item.randNum(user.basket.size());
        System.out.println("You dropped " + user.basket.get(temp1));
        this.user.basket.remove(user.basket.get(temp1));
      }
    } else {
      throw new RuntimeException("invalid input");
    }
  }

  /**
   * Flimsy floorboard, if user chooses no, user gains item, if yes, they lose item.
   */
  public void flimsyFloorboardDrop() {
    System.out.println("Uh-oh you have bumped into a flimsy Floorboard, would you like the lift it and see whats underneath?");
    System.out.println("When you chose, you have a 50/50 chance of either losing or gaining at item!");
    System.out.println(" ");
    System.out.println("Would you like to lift? Yes or No");
    String input = in.nextLine().toUpperCase();

    if (input.equals("NO")) {

      ArrayList < String > items = new ArrayList < String > ();
      items.add("Blackberry");
      items.add("Emerald");
      items.add("Peony");

      Random randItem = new Random();
      int index = randItem.nextInt(items.size());
      String item = items.get(index);
      System.out.println("Congrats! you have gained an: " + item);
      this.user.basket.add(item);

    } else if (input.equals("YES")) {
      System.out.println("Whoops, you have lost the odds, and will now lose an item");
      if (user.basket.size() >= 1) {
        Integer temp1 = Item.randNum(user.basket.size());
        System.out.println("You dropped " + user.basket.get(temp1));
        this.user.basket.remove(user.basket.get(temp1));
      } else {
        throw new RuntimeException("Your basket is currently empty.");
      }
    } else {
      throw new RuntimeException("invalid input");
    }
  }


  /**
   * Ambersunroom, asks user to pick a type of jewelry, if correct, they gain item, if not, they lose an item.
   */
  public void amberSunroom() {
    System.out.println("Welcome to the Amber Sunroom!");
    System.out.println("There is a tiara, necklace and ring on display");
    System.out.println("Choose the correct jewelery piece and win a gem, choose wrong and drop an item");
    System.out.println(" ");
    System.out.println("Would you like to play? Yes or No");

    String input = in.nextLine().toUpperCase();

    if (input.equals("YES")) {
      System.out.println("Place you guess below");
      input = in.nextLine().toUpperCase();
      //rand picking of jewelery
      ArrayList < String > jewels = new ArrayList < String > ();
      jewels.add("TIARA");
      jewels.add("RING");
      jewels.add("NECKLACE");

      Random randJewel = new Random();
      int index = randJewel.nextInt(jewels.size());
      String jewel = jewels.get(index);
      if (input.equals(jewel)) {
        System.out.println("Congrats! You guessed right, and have won an Emerald");
        user.basket.add("Emerald");
      } else if (!input.equals(jewel)) {
        System.out.println("Whoops you picked wrong...");
        if (user.basket.size() >= 1) {
          Integer temp1 = Item.randNum(user.basket.size());
          System.out.println("You dropped " + user.basket.get(temp1));
          this.user.basket.remove(user.basket.get(temp1));
        } else {
          throw new RuntimeException("Your basket is currently empty.");
        }
      } else {
        throw new RuntimeException("invalid input");
      }
    } else if (input.equals("NO")) {
      System.out.println("Okay, way to play it safe, keep moving");
    } else {
      throw new RuntimeException("invlalid input");
    }
  }

/**
 * Chestnut Goblet, asks user to pick correct three ingredients they win an item, if incorrect they lose an item.
 */
  public void chestnutGoblet() {
    System.out.println("You have reached the Chestnut Goblet");
    System.out.println(" ");
    System.out.println("In order to recieve the coveted Peony flower you must play a game of Pick Your Poision");
    System.out.println("Pick the three correct indredients to make a potion and win a Peony");
    System.out.println("But be warned if you choose wrong three times, you will lose all the items in your basket");
    System.out.println(" ");
    System.out.println("Are you willing to take that risk? Yes or No?");

    String input = in.nextLine().toUpperCase();

    if (input.equals("YES")) {
      for (int i = 0; i < 3; i++) {
        System.out.println("Your ingredient options for the potion are: \n\t A. snails \n\t B. fairy toes \n\t C. maple \n\t D. rosehips \n\t E. glitter \n\t F. bird eggs");
        System.out.println("Enter the letter for the indregients for the potion, remember, choose wisely, there is a right answer");
        System.out.println("Option 1: ");

        String input1 = in.nextLine().toUpperCase();
        if (input1.equals("B") || input1.equals("D") || input1.equals("E")) {
          System.out.println("Correct!");
          option1 = "yay";
        } else {
          System.out.println("wrong answer");
          option1 = "null";
        }

        System.out.println("Option 2: ");
        String input2 = in.nextLine().toUpperCase();

        if (input2.equals("B") || input2.equals("D") || input2.equals("E")) {
          System.out.println("Correct!");
          option2 = "ye";
        } else {
          System.out.println("wrong answer");
          option2 = "null";
        }

        System.out.println("Option 3: ");
        String input3 = in.nextLine().toUpperCase();

        if (input3.equals("B") || input3.equals("D") || input3.equals("E")) {
          System.out.println("Correct!");
          option3 = "y";
        } else {
          System.out.println("wrong answer");
          option3 = "null";
        }

        if (!option1.equals("yay") || !option2.equals("ye") || !option3.equals("y")) {
          System.out.println("Whoops wrong answer, try again!");
        }
        if (option1.equals("yay") && option2.equals("ye") && option3.equals("y")) {
          System.out.println("Congrats! You guessed all three potions correctly!!! You get a Peony");
          user.basket.add("Peony");
          break;
        }
      }
    } else if (input.equals("NO")) {
      System.out.println("Way to play it safe, keep moving");
    } else {
      throw new RuntimeException("Invalid input");
    }
  }

  /**
   * checks number of items user has collected in recipe, when item in recipe collected, its removed from user basket, tells user when all items in recipe have been collected.
   * @param user
   * @return
   */
  public Boolean finishQuest(Character user) {
    for (int i = 0; i < user.basket.size(); i++) {
      String item = user.basket.get(i);
      for (int j = 0; j < this.recipe.size(); j++) {
        String same = recipe.get(j);
        if (item.equals(same)) {
          this.recipe.remove(item);
          user.basket.remove(item);
          System.out.println("\t-" + item);
          break;
        }
      }
    }
    if (recipe.size() == 0) {
      System.out.println("\nThank you for collecting all the items!");
      this.complete = true;
      this.started = false;
      user.busy = false;
      user.size += 1;
      user.quest_complete += 1;
      return true;
    } else {
      System.out.println("\nYou don't have all the necessary items to complete this quest:(");
      System.out.print("\nRemaining ");
      this.printRecipe();
      return false;
    }
  }

  /**
   * Entrance to treehouse, checks if user has completed quest, or recieved quest yet.
   */
  public void treehouseBase() {
    if (this.started | this.complete) {
      System.out.println("\nWelcome back to the ElfTreehouse entrance");
      this.finishQuest(user);

      if (this.complete) {
        System.out.println("\nGreat work, you have successfully collected your items Quest complete!");
      } else if (!this.started) {
        System.out.println("Looks like you have not recieved you quest yet!");
      }
    }
  }

  /**
   * method to collect user input, and move around locations within treehouse/ access different methods to play the game.
   * @return true or false, true if user wants to continue playing, false if user would like to exit Elf Treehouse
   */
  public boolean play() {
    System.out.println("\n\t\t\tPress enter to continue");
    in.nextLine();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    int og_x = where_x;
    int og_y = where_y;
    System.out.println(" ");
    System.out.println("Where would you like to go/do? (N, E, S, W, HELP)");

    String input = in.nextLine().toUpperCase();
    if (input.equals("N")) {
      where_y += 1;
    } else if (input.equals("S")) {
      where_y -= 1;
    } else if (input.equals("E")) {
      where_x += 1;
    } else if (input.equals("W")) {
      where_x -= 1;
    } else if (input.equals("STATS")) {
      user.stats();
    } else if (input.equals("RECIPE")) {
      this.printRecipe();
    } else if (input.equals("OPEN BASKET")) {
      user.openBasket();;
    } else if (input.equals("HELP")) {
      user.help();
    } else {
      throw new RuntimeException("That's not a valid option :/");
    }
    if (og_x != where_x | og_y != where_y) {

      if (where_x == 0 & where_y == 0) {
        this.treehouseBase();
        System.out.println("You have reached the entrance of the Elf Treehouseould you like to enter? Yes or No");

        input = in.nextLine().toUpperCase();
        if (input.equals("NO")) {
          return false;
        }                
      } else if (where_y < 0 | where_x < left_bound | where_x > right_bound | where_y > upper_bound) {
        where_x = 0;
        where_y = 0;
        System.out.println("There's nothing here :0");
        System.out.println("Sending you to the Treehouse Base");
        System.out.println(" ");
        System.out.println("Would you like to exit the Elf Treehouse? YES or NO");
        input = in.nextLine().toUpperCase();
        if (input.equals("YES")) {
          return false;
        }  
      } else if (where_x == 0 && where_y == 1) {
        System.out.println("You are at the moss staircase");
      } else if (where_x == 0 && where_y == 2) {
        System.out.println("You have reached the Crystal lookout");
      } else if (where_x == 1 && where_y == 0) {
        this.mailbox();
      } else if (where_x == 2 && where_y == 0) {
        this.oakDoor();
      } else if (where_x == 1 && where_y == 1) {
        this.flimsyFloorboardGain();
      } else if (where_x == 2 && where_y == 1) {
        this.flimsyFloorboardDrop();
      } else if (where_x == 1 && where_y == 2) {
        this.amberSunroom();
      } else if (where_x == 2 && where_y == 2) {
        this.chestnutGoblet();
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Character me = new Character("Ashby", 100, 100);
    ElfTreeHouse myTreehouse = new ElfTreeHouse("ElfTreehouse", me);
    myTreehouse.intro();

    while (true) {

      try {
        myTreehouse.play();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}