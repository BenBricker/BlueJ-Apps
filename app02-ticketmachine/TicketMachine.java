import java.util.*;
import java.text.*;
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
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    private Ticket AylesburyTicket;
    private Ticket HighWycombeTicket;
    private Ticket AmershamTicket;
    private Ticket issuedTicket;
    /**
     * Create a machine that issues tickets for destinations.
     */
    public TicketMachine()
    {
        price = 0;
        balance = 0;
        total = 0;
        
        AylesburyTicket = new Ticket("Aylesbury", 220,"no date");
        AmershamTicket = new Ticket("Amersham", 300,"no date");
        HighWycombeTicket = new Ticket("High Wycombe", 330,"no date");
        issuedTicket = null;
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
    public int getBalance()
    {
        return balance;
    }
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        boolean coinOkay = false;
        for (Coin myCoin : Coin.values())
        {
            if (myCoin.getValue() == amount)
            { 

                balance = balance + myCoin.getValue(); 
                coinOkay = true;
            }
        }
        if (!coinOkay)
        {
            System.out.println("This machine only takes 10p, 20p, £1 and £2 coins, rather than: " + 

                               amount ); 

        } 
        printTicket();
        }
    public void selectAylesburyTicket()
    {
        issuedTicket = AylesburyTicket;
        //issuedTicket.setDate(SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        issuedTicket.setDate(timeStamp);
    }
    public void selectAmershamTicket()
    {
        issuedTicket = AmershamTicket;
        //issuedTicket.setDate(SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        issuedTicket.setDate(timeStamp);
    }
    public void selectHighWycombeTicket()
    {
        issuedTicket = HighWycombeTicket;
        //issuedTicket.setDate(SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        issuedTicket.setDate(timeStamp);
    }
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("################################"); 

            System.out.println("# The BlueJ Line"); 

            System.out.println("# Ticket destination: " + issuedTicket.getDestination());   


            System.out.println("# " + price + " pence."); 

            System.out.println("# Date issued:  "+ issuedTicket.getDate()); 

            System.out.println("################################"); 

            System.out.println(); 

 

            // Update the total collected with the price. 

            total = total + price; 

            
        } 

        else  

        { 

            System.out.println("You must insert at least: " + 

                               (price - balance) + " more pence."); 

                     

        } 
    } 
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    public void runTicketMachine()
    {
        Scanner sc = new Scanner(System.in);
        int ticketSelection = 0;
        while (true)
        {
            System.out.println("Welcome to the ticket machine");
            System.out.println("select destination");
            System.out.println("1: Aylesbury");
            System.out.println("2: Amersham");
            System.out.println("3: High Wycombe");
            System.out.println("4: Quit");
            System.out.println("Enter selected destination:");
            
            try
            {
               ticketSelection = sc.nextInt();
               //ticketSelection++;
               if (ticketSelection == 1)
                this.selectAylesburyTicket();
               if (ticketSelection == 2) 
                this.selectAmershamTicket();
               if (ticketSelection == 3) 
                this.selectHighWycombeTicket();
               if (ticketSelection == 4) 
                break;
               System.out.println("for this ticket please enter " + issuedTicket.getPrice() + " pence");
               price = issuedTicket.getPrice();
               while (balance < price)
               {
                   System.out.println("Enter a coin value: ");
                   int amount = sc.nextInt();
                   this.insertMoney(amount);
               }
               // Reduce the balance by the price. 

               balance = balance - price; 
               int refundAmount = refundBalance();
               if (refundAmount > 0)
               {
                   System.out.println("refund available: " + refundAmount);
               }
               
            }    
            catch(Exception e)
            {
                
            }
    }
}
}
