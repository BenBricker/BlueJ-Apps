/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Ben Bricker
 * @version 0.1
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockDemo demo;
    private StockManager manager;
    /**
     * Constructor for objects of class StockApp.
     */
    public StockApp()
    {
        input = new InputReader();
        this.manager = new StockManager();
        //this.demo = new StockDemo(manager);
    }

    /**
     * Running the heading and menu choices.
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * Getting the menu choices.
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
            
            String choice = input.getInput();
            finished = executeMenuChoice(choice);
        }
    }
    
    /**
     * Execute menu choices.
     */
    public boolean executeMenuChoice(String choice)
    {
        boolean quitCalled = false;
        if (choice.equals("PrintAll"))
        {
            manager.printProductDetails();
        }
        else if (choice.equals("Remove"))
        {
            executeRemove();
        }
        else if(choice.equals("Add"))
        {
            executeAdd();
        } 
        else if(choice.equals("Deliver"))
        {
            executeDeliver();
        } 
        else if(choice.equals("Sell"))
        {
            executeSell();
        } 
        else if(choice.equals("Print"))
        {
            executePrint();
        } 
        else if(choice.equals("PrintLowStock"))
        {
            executePrintLowStock();
        } 
        else if(choice.equals("Restock"))
        {
            executeRestock();
        }
        else if(choice.equals("Quit"))
        {
            quitCalled = true;
        } 
        return quitCalled; 
    }
    
    /**
     * Remove an item from the list.
     */
    public void executeRemove()
    {
        System.out.println("enter product ID: ");
        int id = Integer.parseInt(input.getInput());
        manager.remove(id);
    }
    
    /**
     * Adds an item to the list.
     */
    public void executeAdd()
    {
        System.out.println("enter product ID: ");
        int id = Integer.parseInt(input.getInput());
        System.out.println("enter product Name: ");
        String name = input.getInput();
        
        if (name.isEmpty())
        {
            System.out.println("Cannot have a product with no name.");
        }
        else
        {
            Product myProduct = new Product(id,name,0);
            manager.addProduct(myProduct);
  
        }
    }
    
    /**
     * Delivers a number of stock of a product in the list.
     */
    public void executeDeliver()
    {
        System.out.println("enter product ID: ");
        int id = Integer.parseInt(input.getInput());
        System.out.println("enter product quantity: ");
        int quantity = Integer.parseInt(input.getInput());
        if (quantity < 0)
        {
            System.out.println("Deliver Product Fail - negative quantity not" 
            + " allowed");                 
        }
        else
        {
            manager.delivery(id,quantity);
        }
    }

    /**
     * Sell a set quantity of a product.
     */
    public void executeSell()
    {
        System.out.println("enter product ID: ");
        int id = Integer.parseInt(input.getInput());
        System.out.println("enter product quantity: ");
        int quantity = Integer.parseInt(input.getInput());
        if (quantity < 0)
        {
            System.out.println("Sell Product Fail - negative quantity not" + 
                               " allowed");
        }
        else
        {
            manager.sellProduct(id,quantity);
        }
    }
    
    /**
     * Print items with a specific name.
     */
    public void executePrint()
    {
        System.out.println("enter name: ");
        String name = input.getInput();
        manager.printProductDetailsNamePart(name);
    }
    
    /**
     * Print items with a low stock level.
     */
    public void executePrintLowStock()
    {
        System.out.println("enter low stock level: ");
        int lowLevelStock = Integer.parseInt(input.getInput());
        manager.printProductDetailsLowStock(lowLevelStock);
    }

    /**
     * Re-stock all the low stock items up to a set minimum level.
     */
    public void executeRestock()
    {
        System.out.println("enter low stock level: ");
        int lowStockLevel = Integer.parseInt(input.getInput());
        System.out.println("enter product re-stock level: ");
        int reStockLevel = Integer.parseInt(input.getInput());
        manager.reStockLowStock(reStockLevel,lowStockLevel);
    }

    /**
     * Print out a menu of operation choices.
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:                Add a new product");
        System.out.println("    Remove:             Remove an old product");
        System.out.println("    Deliver:            Deliver a product");
        System.out.println("    Sell:               Sell a product");
        System.out.println("    Print(Name Part):   Print name part of product");
        System.out.println("    PrintLowStock:      Print low stock products");
        System.out.println("    Restock:            Restock product");
        System.out.println("    PrintAll:           Print all products");
        System.out.println("    Quit:               Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name.
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Ben Bricker");
        System.out.println("******************************");
    }
}
