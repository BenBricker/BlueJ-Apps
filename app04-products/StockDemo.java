/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
        manager.addProduct(new Product(24,  "fridge"));
        manager.addProduct(new Product(25,  "spoon"));
        manager.addProduct(new Product(27,  "fork"));
        manager.addProduct(new Product(26,  "plate"));
        manager.addProduct(new Product(29,  "toaster"));
        manager.addProduct(new Product(28,  "laptop"));
        manager.addProduct(new Product(22,  "freezer"));
    }
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 5);
        manager.delivery(37, 6);
        manager.delivery(23, 7);
        manager.delivery(24, 8);
        manager.delivery(25, 9);
        manager.delivery(27, 10);
        manager.delivery(26, 11);
        manager.delivery(29, 12);
        manager.delivery(28, 13);
        manager.delivery(22, 14);
        manager.printProductDetails();
        this.sellQuantity(3, 132);
        this.sellQuantity(3, 37);
        this.sellQuantity(3, 23);
        this.sellQuantity(3, 24);
        this.sellQuantity(3, 25);
        this.sellQuantity(3, 27);
        this.sellQuantity(3, 26);
        this.sellQuantity(3, 29);
        this.sellQuantity(3, 28);
        this.sellQuantity(3, 22);
        manager.printProductDetails();
        manager.renameProduct(37, "paul");
        manager.remove(22);
        manager.printProductDetails();
        manager.printProductDetailsLowStock(5);
        this.sellQuantity(3,132);
        manager.delivery(22,5);
    }
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    public void sellQuantity(int number, int id)
    {
      Product product = getProduct(id);
      if(product != null)
      {
         showDetails(id);
         for(int i = 0; i<number;i++)
            product.sellOne(); 
        }
    }
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }
    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}