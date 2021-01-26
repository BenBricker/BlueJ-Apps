/**
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class Player
{
    private final String name;
    private int score;
    private int count;
    private boolean superStrength;
    private List<Item> itemBag = new ArrayList<>();
    private int health;
    private boolean questComplete;
    /**
     * Added another comment
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
        score = 100;
        questComplete = false;
        superStrength = false;
        health = 10; 
    }

    /**
     * It prints the name, health and the score of the player
     * I tried to use this line: 
     * (System.out.println(ConsoleColours.ANSI_RED +  "10" + ConsoleColours.ANSI_RESET);) 
     * to get colours but extra complicated things were needed 
     */
    public void print()
    {
        System.out.println("Player : " + name);
        System.out.println("Health: " + health );
        System.out.println("Score: " + score);
        if (superStrength)
        {
            System.out.println("obtained super strength");
        } 
        System.out.println(getItemString());
    }
    
    private String getItemString()
    {
        String returnString = "Items:";
        if (itemBag.size() == 0)
        {
            returnString += " none";
        }    
        else
        {
            for (Item item:itemBag)
            {
                returnString += " " + item.getName();
            }
        
        }
        return returnString;
    }
    
    public void addItem(Item item) 
    {
        itemBag.add(item);   
    }    
    
    public void dropItem(String item) 
    {
        Iterator < Item > itr = itemBag.iterator();
        while (itr.hasNext()) {
            String name = itr.next().getName();
            if (name.equals(item)) {
                itr.remove();         
      
            }
        }
    }    
        
    public int getHealth()
    {
        return health;
    }
    
    public boolean getSuperStrength()
    {
        return superStrength;
    }
    
    public boolean move(boolean winningRoom)
    {
        if (winningRoom && questComplete)
        {
            System.out.println("Well done, you won the game with a score of" + score);
            return true;
        }
        else
        { 
            health -= 1; score -= 1;
            if (health == 0)
                System.out.println("You ran out of health. You lost the game, good bye.");
            return health == 0;
        }
    }
    
    public void workout()
    {
        superStrength = true;
    }
    
    public Item getItem(String item) 
    {
        Item returnedItem = null;
        for (Item itemToCheck:itemBag)
            {
                if (itemToCheck.getName().equals(item))
                {
                    returnedItem = itemToCheck;
                }    
            }
        return returnedItem;
    }    
    
    public void restoreHealth()
    {
        health = 10;
    }
    
    public void drainHealth()
    {
        if (superStrength)
        {
            superStrength = false;
        }
        else
        {
            health = 1;
        }
    }
    
    public boolean itemBagFull()
    {
        return itemBag.size() == 2;
    }
    
    public boolean questComplete()
    {
        return questComplete;
    }
    
    public void setQuestComplete()
    {
        questComplete = true;
    }
    
    
}
