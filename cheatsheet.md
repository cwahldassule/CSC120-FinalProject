This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

Overall:
    The goal of the game is for the user to complete the three quests at the three hidden locations. The garden map is randomly generated each time so the three hidden locations are at different coordinates each time the game is played. The user will FLY to coordinates (0-3) and pick up items or enter a hidden location. Each hidden location contains it's own map and challenges. Movement in each hidden location has no impact on position in the garden.
    
    If the user "gets tired" after flying a lot, they will have to SLEEP or SNACK. At any point in the garden the user can call STATS and OPEN BASKET to see important progress information. Any of the commands can be called at any time. 

    The three game "modes", easy, medium and hard, correspond to how much flight power and basket size the user has.
    Ladybug: 100 flight power, 100 basket size
    Butterfly: 40 flight power, 30 basket size
    Bumblebee: 20 fight power, 15 basket size

    Available commands
    FLY, SLEEP, OPEN BASKET, EMPTY BASKET, SNACK, HELP, RECIPE, STATS

Elf Treehouse:
    (0,0) Entrance to Elftreehouse
        -user returns here to finish quest
        -Where user gets sent when they go out of bounds
        -Where  user can enter and exit treehouse
    (1,0) Mailbox
        -User can take 50/50 chance to get quest, and see items found in elftreehouse
        -If they lose game, they lose a random item in basket
    (2,0) Oak Leaf Door
        -user given a code to unscramble
        -If they unscramble code within three tries they recieve a blackberry
        -If user guesses incorrectly, they can try again or recieve a hint
    (0,1) Nothing here
    (0,2) Nothing here
    (1,1) Flimsy Floorboard gain
        -if user enters yes to play the game, they gain a random item, if they enter no they lost an item
    (2,1) Flimsy Floorboard gain
        -if user enters NO to play the game, they gain a random item, if they enter YES they lost an item
    (1,2) Amber SunRoom
        -Asks user to pick a item of jewelry, jewelery is randomly selected as correct answer each time user plays
        -If user guesses the randomly choosen jewerly correctly, they gain an emerald
        -if they guess incorrectly, they lose an item.
    (2,2) Chestnut Goblet
        -Asks user to pick three indgreidents from list of six items. 
        -User recieves three attempts to guess all three correct items, and are told when a guess is correct
        -If user guesses correctly, they recieve a peony, if incorrect, they lose all items in their basket 

Firefly CLearing:
    (0,0) Starlight Pond
        -Automatic starting location
        -Gives the option to leave the Firefly Clearing
    (0,1) Walnut Tree
        -Asks the user to help the fireflies make a potion by collecting items
        -If yes, quest begins and doesn't end until user returns to the Walnut Tree with all required items
    (0,2) Cozy Knothole
        -An owlet asks if the user would like to hear a riddle
        -If yes, owlet asks riddle
        -If user answers correctly, they are given a blueberry
    (2,2) Leaf Hammocks
        -User finds leaf hammocks in a lavender patch and is asked if they would like to take some lavender
        -If yes, they receive a lavender
    (1,2) Ornate Mirror
        -User receives a nice message
    (1,1) Deserted Burrow
        -User finds a chest and is asked if they want to open it
        -If yes, program checks whether a gold key is in their basket
        -If no, they are told they cannot open the chest without a key
        -If yes, they find sapphires inside the chest and are given a sapphire
    (1,0) Birch Bridge
        -User enjoys a nice view
    (2,0) Clover Patch
        -Asks the user if they would like to look for a 4 leaf clover
        -If yes, there is a 1 in 3 chance that they will find a 4 leaf clover which gives +2 flight power
    (2,1) Pinecone Shrine
        -Shrine asks if user wants to give an offering
        -If no, user loses 3 flight power for disrespect
        -If yes, user finds a randomized flower and puts it on the shrine
        -If the flower is a peony or tulip, user loses 4 flight power, otherwise, they receive a gold key

Fairy Village:
    (-2, 0) Nothing here
    (-1, 0) Dress shop
        -User can trade a randomly selected flower for strawberry
    (0, 0) Front gate
        -Where user enters and exits from
    (1, 0) Nothing here
    (2, 0) Bakery
        -User can trade a randlomly selected fruit for pearl
    (-2, 1) Music corner
        -User can try to guess a letter (A-G) and get +10 flight power
        -If the user loses they drop one random item from inventory
    (-1, 1) Chatbot
    (0, 1) Village square
        -User accepts the randomly generated quest if they are not already doing a quest
        -User comes back here to finish quest
    (1, 1) Nothing here
    (2, 1) Angel fountain
        -Randomly gives user +4 flight power
    (-2, 2) Blaze
        -USer is forced to play game which has no right answer and lose an item from inventory
    (-1, 2) Nothing here
    (0, 2) Potion shop
        -User can trade a randomly selected gem for Sunflowers
    (1, 2) Fairydust inn
        -User can sleep for a shorter amount of time and reset flight power to 1.5*cap
    (2, 2) Chatbot
        -gives user +1 flight power when leaving the conversation