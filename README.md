# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.


Design Justification:

We began with the parent class Garden to have a central class, in which the child classes could run through. This is where the game runs in the main function. We made item as a shortcut for out random object needed to be found in the game. We made a quest class to standardize the basic strucutre of each hidden location. We made a Character class, with specifc methods and attributes that could then be called within the different locations. Characters in the game needed specific attributes, like the ability to pick up and put down items they encounter. We made   Chatbot a separate class to simplify our code and locations, it was an attemp to make our code cleaner and easeir to read. 
    
The classes Firefly Clearing, Fairy Village, and Elf Treehouse are all child classes of Quest, all inherting the basic strucutre and simply functionality of the Quest Class. We made the three locatons seperate classes rather than instances of Quest becuase each location is significantly differnet in functionality and attributes. Each seperate locations has its own maps, rules, and challegnes, it would not be as simple as changing the name or value of a parameter to create each location in the way we wanted to. 

An alternative design we considered was making child classes of character for each character option, Ladybug, Bumblebee, and Butterfly. Then we realized that we only wanted to change a few characteristics of each character, it could easily be done by making each character option an instance of Character class, rather than an entire child class. Additionally, we considered making the locations at set cordinate points, but instead we decided to make each locatoin at a randomized point in garden, to prevent the player from being able to figure out where all the locations are after one play, thus making the game more fun and engaging for multiple plays. 

Additional Reflection Questions:

Overall Approach:
We built off of homework assignment 8, which made conceptualizing the code strucutre. We each wanted to create our own locations. We decided to peer program our parent classes, so each group member was clear on the overall strcuture of the code. Then we separated and each member created a child location of their own, so we could get create with our methods and decide individually how to make the seperate locations run. 

New Things:
We all learned how to better utilize the random function, simplifying our code by creating a seperate class to give us random numbers. We also learned more about how to strucutre mulitple seperate classes and how to get them to work together. We all also got a lot more comfotable using scanners and understanding how they work, this was a huge improvement from previous homework assignments where we maybe used scanners but did not fully understand how or why. 

Implemented Differently?
Our user interface was very simple, it invoved typeing preset commands into the console. We could have implemented more freedom in commands the user could enter, or a grpahcial interface where graphic and buttons could be involved for the user.

Unlimited Time
With unlimited time, we would have liked to create more location classes and thus more quests to complete. We also would have like to create Characters that were different enough that they did nessesistate seperate classes, meaning the different attributes and functions of characters were sizable. We also wanted to implement "bad" or "poisionous" objects whcih we did not have time to do. Finally with unlimited time we would have loved to have created graphics to add to our game.

Feedback:
One of our classmates told us that they were unclear on what to type to get the commands in the console. This informed us that we needed to present the options of commands for the user in a more understandable way.

In class Jordan gave the feedback that if sometihing can be made an instance of a class rather than a sub class, it should be. This caused us to shfit from implementing our three characters as seperate classes and instead we turned them into instances of the character class. 

Advice:
Test early and test a lot, there will be bugs than you expect, so give yourself plenty of time to debug. 

Also create an architecture diagram and seudocode before you begin coding, it will make the organziation of your project much clearer and easier to follow.

Finally make sure you are communicating with your group members throughout the entire project. 

Team Dynamcis:
Different schedules made it difficult to find common times to meet, so that made it harder to stay on the same page. But because we had three members in our group we were able to create a much larger and robust game which was wonderful. In addition it was very smart that we decided to have each memebr create their own location individually becuase it allowed poeple to work within thier own schedules and timeframes while still all under the same structure and organization of the parent classes that we all coded together.