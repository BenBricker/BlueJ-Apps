
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String codeNumber;
    private String title;

    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNumber, String title)
    {
        // initialise instance variables
        this.codeNumber = codeNumber;
        this.title = title;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {
        // put your code here
        System.out.println("Code number is: " + codeNumber + 
        " and course title: " + title);
    }
}
