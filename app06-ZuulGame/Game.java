import java.util.Random;
/**
 *  This class is the main class of the "World of Bucks" application. 
 *  "World of Bucks" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Derek and Andrei
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private ConsoleColours colours;
    private Item items;
    private Map map;
    private boolean userQuits;
    private String formattedCode;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        map = new Map();
        createRoomsAndItems();
        parser = new Parser();
        player = new Player("paul");
        userQuits = false;
        play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRoomsAndItems()
    {
        Room outside, theater, pub, lab, office, gym, library, healthCenter;
        Item potion, key, questBook, map, vodka, weights;
        // create the rooms
        outside = new Room("outside the main entrance of the university" + ".\n",
        "You are quite confused so you look around and see doors that you can go through.",false,true);
        theater = new Room("in a lecture theater" + ".\n",
        "Sometimes in a quest you need to pickup an item in one room and use it in another.",false,false);
        pub = new Room("in the campus pub" + ".\n",
        "Drinking is vital to life, so feel free to have a drink just beware of the side-effects.",false,false);
        lab = new Room("in a computing lab" + ".\n",
        "Experimentation is the key to life.",false,false);
        office = new Room("in the office" + ".\n",
        "The incriminating evidence is somewhere in this room." +  
        "You see a safe with a lock." + ".\n" +
        "I wonder what is inside?",true,false);
        gym = new Room("in the gym" + ".\n",
        "This is a good place to build my strength" +
        ",in case I need to lift heavy objects in other rooms",false,false);
        library = new Room("in the library" + ".\n",
        "Knowledge is power.",false,false);
        healthCenter = new Room("in the health center" + ".\n",
        "When you are feeling a bit low on health, there might be something here that can help.",false,false);
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", library);
        
        theater.setExit("west", outside);
        theater.setExit("north", gym);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        healthCenter.setExit("east", library);
        
        library.setExit("west", healthCenter);
        library.setExit("south", outside);
        
        gym.setExit("south",theater);

        currentRoom = outside;  // start game outside
        
        // create the items
        key = new Item("key",theater);
        potion = new Item("potion",healthCenter);
        vodka = new Item("vodka",pub);
        questBook = new Item("quest-book",library);
        map = new Item("map",library);
        weights = new Item("weights",gym);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        generateCode();        
        boolean finished = false;
        while (! finished) 
        {
            player.print();
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        if (userQuits)
            System.out.println("You quit the game. Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Bucks!");
        System.out.println("The World of Bucks is a new adventure game to " +
        "try to get your principle fired.");
        System.out.println("Be careful where you go and try to find the map " +
        "to help show you the way to win.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                wantToQuit = goRoom(command);
                break;
            case PICKUP:
                pickup(command);
                break;
            
            case DROP:
                drop(command);
                break;
            
            case USE:
                use(command);
                break;
            
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private boolean goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
            return false;
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            nextRoom.enteredRoom();
            return player.move(currentRoom.winningRoom());
        }
    }
    
    private void pickup(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know which item
            System.out.println("Pick up what?");
            return;
        }

        String item = command.getSecondWord();
        
        Item pickedItem = currentRoom.getItem(item);

        if (pickedItem == null) {
            System.out.println("There is no " + item + " in this room !");
        }
        else {
            
            if (player.itemBagFull())
            {
                System.out.println("Your item bag is full");
            }
            else
            {
                if (pickedItem.getName() == "quest-book" && player.getSuperStrength() == false)
                {
                    System.out.println("You are not strong enough to pick up the book");
                }
                else
                {
                   pickedItem.pickUp(player,currentRoom);
                }
            }
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    private void drop(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know which item
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();
        
        Item pickedItem = player.getItem(item);

        if (pickedItem == null) {
            System.out.println("There is no " + item + " in your bag!");
        }
        else {
            pickedItem.drop(currentRoom,player);
            System.out.println(currentRoom.getLongDescription());
        }

    }
    
    private void use(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know which item
            System.out.println("Use what?");
            return;
        }
        
        String item = command.getSecondWord();
        
        Item pickedItem = player.getItem(item);

        if (pickedItem == null) {
            System.out.println("You cannot use an " + item + " that is nor in your bag!");
        }
        else {
            if (pickedItem.getName() == "potion")
            {
                player.restoreHealth();
            }    
            else if (pickedItem.getName() == "vodka")
            {
                player.drainHealth();
            }
            else if (pickedItem.getName() == "weights")
            {
                player.workout();
            }
            else if (pickedItem.getName() == "map")
            {
                map.display();
            }
            else if (pickedItem.getName() == "key")
            {
                if (currentRoom.canUseKey())
                {
                    System.out.println("Enter the 5 digit quest code in the safe");
                    String enteredCode = parser.getCode();
                    System.out.println(enteredCode);
                    System.out.println(formattedCode);
                    if (enteredCode.equals(formattedCode))
                    {  System.out.println("Well done, go outside to win.");
                      player.setQuestComplete();
                    }
                    else
                        System.out.println("bad luck maybe you should spend more time in the library");
                }
            }
            else if (pickedItem.getName() == "quest-book")
            {
                questBookDisplay();
            }
            pickedItem.drop(currentRoom,player);
        }

    }
    
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            userQuits = true;
            return true;  // signal that we want to quit
        }
    }
    
    private void questBookDisplay()
    {
        System.out.println
        ("-----------------------Quest Book---------------------------" + ".\n"  + 
         "|well done for using super strength to pick up the Quest Book " + ".\n" +
         "|                                                          |" + ".\n" +
         "| Objectives:                                              |" + ".\n" +
         "| -----------                                              |" + ".\n" +
         "| - Get the key from the Theater for the safe in the Office|" + ".\n" +                                   
         "| - Use the code in the book to unlock safe                |" + ".\n" +
         "| - Go outside to win the game                             |" + ".\n" +
         "|                                                          |" + ".\n" + 
         "|                                                          |" + ".\n" +
         "|   Quest Code:" + formattedCode +
                             "                                       |" + ".\n" + 
         "|                                                          |" + ".\n" +
         "|                                                          |" + ".\n" +
         "|                                                          |" + ".\n" +
         "------------------------------------------------------------" + ".\n");
    }
    
    public void generateCode()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(100000);
        formattedCode = String.format("%05d", randomNum);
    }
}
