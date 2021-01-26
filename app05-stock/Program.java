/**
 * It creates and runs an instance of the StockApp class.
 *
 * @author (Ben Bricker)
 * @version (19/01/2021)
 */
public class Program
{
    private static StockApp app;
    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        app = new StockApp();
        app.run();
    }
}
