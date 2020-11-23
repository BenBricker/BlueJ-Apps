import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
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
        stock.add(item);
    }
    public void sellProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null)
         
        
        {
            product.printProduct();
            product.sellOne();
            product.printProduct();
        }
        else
            System.out.println("product id does not exist:"+ id);
    } 
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
    public void remove(int id)
    {
       Product product = findProduct(id);
        
        if(product != null) 
        {
          stock.remove(product);  
            
            
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
                  System.out.println("ID found:"+id);
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
        System.out.println("list of products with low stock");
        for(Product product: stock)
        {
            if (product.getQuantity() <= lowStockLevel)
                product.printProduct();
        }
    }
}
