
/**
 * Course class represents the course information, with code number and title 
 *
 * @author (Ben Bricker)
 * @version (2016.02.29)
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
     * prints out code number and course title
     */
    public void print()
    {
        // put your code here
        System.out.println("Code number is: " + codeNumber + 
        " and course title: " + title);
    }
}
