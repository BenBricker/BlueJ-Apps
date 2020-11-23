/**
 * creates a ticket.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Student Name
 */
public class Ticket
{
    // The destination of a ticket. 
    private String destination;
    // The price of a ticket.
    private int price;
    // The date of a ticket.
    private String date;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public Ticket(String destination, int price, String date)
    {
        this.destination = destination;
        this.price = price;
        this.date = date;
    }
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }
    /**
     * Get the destination of the ticket.
     */
    public String getDestination()
    {
        return destination;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
       this.date = date; 
    }
}