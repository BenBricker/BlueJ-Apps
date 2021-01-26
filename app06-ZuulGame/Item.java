import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    
    private String name;    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name,Room room)
    {
        // initialise instance variables
        this.name = name;
        room.addItem(this);
    }
    
    public void pickUp(Player player,Room room) 
    {
        player.addItem(this);  
        room.removeItem(this.name);
    }    
    
    public void drop(Room room,Player player) 
    {
        room.addItem(this);
        player.dropItem(this.name);
    }    
    
    public String getName()
    {
        return name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod;
    {
        // put your code here
        
    }
}
