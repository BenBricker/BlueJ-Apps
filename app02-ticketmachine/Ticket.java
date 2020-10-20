/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Student Name
 */
public class Ticket
{
    // The price of a ticket from this machine.
    private String destination;
    // The amount of money entered by a customer so far.
    private int price;
    // The total amount of money collected by this machine.
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
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public String getDestination()
    {
        return destination;
    }

    
}