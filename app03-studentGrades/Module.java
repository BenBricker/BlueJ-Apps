/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String title;
    private String moduleCode;
    private int percentageMark;

    /**
     * Constructor for objects of class Module
     */
    public Module(String title,String moduleCode,int percentageMark)
    {
        // initialise instance variables
        this.title = title;
        this.moduleCode = moduleCode;
        this.percentageMark = percentageMark;
    }    
    public String getTitle()
    {
        return this.title;
        
    }
    public String setTitle()
    {
        return this.title;
        
    }
    public String getModuleCode()
    {
        return this.moduleCode;
        
    }
    public String setModuleCode()
    {
        return this.moduleCode;
        
    }
    public int getPercentageMark()
    {
        return this.percentageMark;
        
    }
    public void setPercentageMark(int percentageMark)
    {
        this.percentageMark = percentageMark;
        
    }
    /**
     * print module details
     */
    public void print()
    {
        System.out.println("module details: " + title + ":" + moduleCode + ":" + percentageMark);
        
    }
}