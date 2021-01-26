import java.util.ArrayList;

/**
 *  This is a comment
 */
public class Map
{
    private ArrayList<Room> rooms;

    public Map()
    {
        rooms = new ArrayList<Room>();
    }
    
    public void addRoom(Room room)
    {
        rooms.add(room);
    }
    
    public void display()
    {
        System.out.println
        ("-------------------------------Map-------------------------" + ".\n"  + 
         "|        ----------      ----------      ----------        |" + ".\n" +
         "|        | Health | -----| Library|      |   Gym  |        |" + ".\n" +
         "|        | Center |      ----------      ----------        |" + ".\n" +                                   
         "|        ----------           |               |            |" + ".\n" +
         "|                             |               |            |" + ".\n" +
         "|        ----------      ----------      ----------        |" + ".\n" +
         "|        |   Pub  |------| Outside|------| Theater|        |" + ".\n" + 
         "|        ----------      ----------      ----------        |" + ".\n" +
         "|                             |                            |" + ".\n" +
         "|                             |                            |" + ".\n" + 
         "|                        ----------      ----------        |" + ".\n" +
         "|                        |   Lab  |------| Office |        |" + ".\n" +
         "|                        ----------      ----------        |" + ".\n" +
         "------------------------------------------------------------" + ".\n");   
    }
    }

