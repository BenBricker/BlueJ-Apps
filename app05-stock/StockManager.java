import java.util.ArrayList;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Ben Bricker) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        Product product = findProduct(item.getID());
        if(product == null)
        { 
            stock.add(item);
        }
        else
        {
            System.out.println("Add Fail - Product ID already exists.");
        }
    }
    
    /**
     * Sells product using id and quantity.
     */
    public void sellProduct(int id,int quantity)
    {
        Product product = findProduct(id);
        if(product != null)
         
        
        {
            product.printProduct();
            for (int counter=1;counter<=quantity;counter++)
            {
                product.sellOne();
            }
            product.printProduct();
        }
        else
            System.out.println("product id does not exist:"+ id);
    }
    
    /**
     * Renaming product using id and name.
     */
    public void renameProduct(int id,String name)
    {
        Product product = findProduct(id);
        if(product != null) 
        {
            product.printProduct();
            product.rename(name);
            product.printProduct();
        }
    } 
    
    /**
     * Removing product using id.
     */
    public void remove(int id)
    {
       Product product = findProduct(id);
       if(product != null) 
       {
          stock.remove(product);   
       }
       else
       {
           System.out.println("Remove Fail - product doesn't exist");
       }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
         Product product = findProduct(id);
        
        if(product != null)
    
        {
            System.out.println("increase amount");      
            product.increaseQuantity(amount);
        }
        else
            System.out.println("product id does not exist:"+ id);
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product:stock)
            if (product.getID() == id)
              {      
                  return product;
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }
    
    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product: stock)
        {
            product.printProduct();
        }
    }
    
    /**
     * Print details of all the products with low stock.
     */
    public void printProductDetailsLowStock(int lowStockLevel)
    {
        System.out.println("List of products with low stock.");
        for(Product product: stock)
        {
            if (product.getQuantity() <= lowStockLevel)
                product.printProduct();
        }
    }
    
    /**
     * Print product details with a specific name.
     */
    public void printProductDetailsNamePart(String name)
    {
        System.out.println("list of products containing " + name +
                           " in their names.");
        for(Product product: stock)
        {
            if (product.getName().contains(name))
                product.printProduct();
        }
    }
    
    /**
     * Re-stock low stock items up to a set minimum level using 
     * re-stock level and low stock level.
     */
    public void reStockLowStock(int reStockLevel,int lowStockLevel)
    {
       for(Product product: stock)
       {
           int currentStock = product.getQuantity(); 
           if (currentStock <= lowStockLevel)
                product.increaseQuantity(reStockLevel - currentStock);
       } 
    }
}
