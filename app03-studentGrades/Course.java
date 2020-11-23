
import java.util.*;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String codeNo;
    private String title;
    ArrayList<Module> modules = new ArrayList<Module>();
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;
    }
    /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
        System.out.println("Course module details");
        for (Module module : modules)
        {
            module.print();
        }
    }
    /**
     * Adds a module.
     */
    public boolean addModule(Module module)
    {
        int size = modules.size();
        boolean moduleAdded = false;
        if (size < 4)
        {
            
            modules.add(module);
            moduleAdded = true;
            
        }
        return moduleAdded;
    }
    public String finalGrade()
    {
        int runningTotal = 0;
        for (Module module : modules)
        {
            runningTotal += module.getPercentageMark();
        }
        //running total is the sum of the four modules
        //e.g. 400 = 100%, 200 = 50%
        //find the grade
        String grade = "F"; 
        if (runningTotal >= 280)
            {grade = "A";}
        else if (runningTotal >= 240)
            {grade = "B";}
        else if (runningTotal >= 200)
            {grade = "C";}
        else if (runningTotal >= 160)
            {grade = "D";}
        else 
            {grade = "F";}
        return grade;
    }
    public void printFinalGrade()
    {
        System.out.print("Module marks: ");
        for (Module module : modules)
        {
            System.out.print(module.getPercentageMark() + ": ");
        }
        System.out.print("final grade = " + this.finalGrade());
    }
}