import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Bucks" application. 
 * "World of Bucks" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String longDescription;
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private List<Item> items = new ArrayList<>();
    private boolean keyWorks,winningRoom,firstTimeInRoom;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String longDescription, boolean keyWorks, boolean winningRoom) 
    {
        this.keyWorks = keyWorks;
        this.winningRoom = winningRoom;
        this.description = description;
        this.longDescription = longDescription;
        this.firstTimeInRoom = true;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getDescription()
    {
        if (firstTimeInRoom = true)
            return description + longDescription;
        else
            return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west " You notice things laying around"
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + getDescription() + "\n" + getExitString() + "\n" + 
        getItemString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }
     
    private String getItemString()
    {
        String returnString = "Items:";
        if (items.size() == 0)
        {
            returnString += " none";
        }    
        else
        {
            for (Item item:items)
            {
                returnString += " " + item.getName();
            }
        }
        return returnString;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void addItem(Item item) 
    {
        items.add(item);   
    }    
    
    public void removeItem(String item) 
    {
        Iterator < Item > itr = items.iterator();
        while (itr.hasNext()) {
            String name = itr.next().getName();
            if (name.equals(item)) {
                itr.remove();         
      
            }
        }
    }   
    
    public Item getItem(String item) 
    {
        Item returnedItem = null;
        for (Item itemToCheck:items)
            {
                if (itemToCheck.getName().equals(item))
                {
                    returnedItem = itemToCheck;
                }    
            }
        return returnedItem;
    }
    
    public boolean canUseKey()
    {
        return keyWorks;
    }
    
    public boolean winningRoom()
    {
        return winningRoom;
    }
    
    public void enteredRoom()
    {
        firstTimeInRoom = false;
    }
}

