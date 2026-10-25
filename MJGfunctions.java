import java.util.Scanner;
import java.util.ArrayList;

/**
 * MJG Functions
 * 
 * A Series of useful functions and re-useable code for use in software
 *
 * @author Michael Gennery
 * @version 18/07/2026
 */
public abstract class MJGfunctions
{

    /**
     * 
     * Enter an Integer
     *
     */
    public static int enterInteger(String qText, Scanner scanObj, int min, int max)
    {
        Boolean validInput = false;
        String errorMessage = "Please enter a valid number between " + min + " and " + max;
        Integer anInteger = 0;
        
        System.out.println(qText); // Ask a question
        
        while (!validInput) // Perform code until valid number is entered
        {
            
            validInput = true; // Input is valid until proven otherwise
                
            // Check a valid number has been entered
            try
            {
                anInteger = Integer.parseInt(scanObj.nextLine());
            }
            catch(Exception NumberFormatException)
            {
                validInput = false;
            }
                
            // Check number is in the correct range
            if (validInput && anInteger >= min && anInteger <= max)
            {
                validInput = true;          
            } else
            {
                System.out.println(errorMessage);
                validInput = false;                        
            }

        }
            
        return anInteger; // Return value when a valid integer is entered
    }

    /**
     * 
     * Enter a Float (Decimal number)
     *
     */
    public static float enterFloat(String qText, Scanner scanObj, float min, float max)
    {
        Boolean validInput = false;
        String errorMessage = "Please enter a valid number between " + min + " and " + max;
        float aFloat = 0;
        
        System.out.println(qText); // Ask a question
        
        while (!validInput) // Perform code until valid number is entered
        {
            
            validInput = true; // Input is valid until proven otherwise
                
            // Check a valid number has been entered
            try
            {
                aFloat = scanObj.nextFloat();
            }
            catch(Exception NumberFormatException)
            {
                validInput = false;
            }
                
            // Check number is in the correct range
            if (validInput && aFloat >= min && aFloat <= max)
            {
                validInput = true;          
            } else
            {
                System.out.println(errorMessage);
                validInput = false;                        
            }

        }
            
        return aFloat; // Return value when a valid decimal number is entered
    }
    
    /**
     * 
     * Enter a Value from a list of valid values
     *
     */
    public static String enterValue(String qText, ArrayList<String> values)
    {   
        Boolean validInput = false;
        Scanner scanObj = new Scanner(System.in);
        String errorMessage = "Please make a valid selection from the following list: - " + values.toString();
        String selection = "";
        
        System.out.println(qText); // Ask a question
        System.out.println(values.toString()); // Display list
        
        while (!validInput) // Perform code until valid number is entered
        {       
            
            validInput = true; // Input is valid until proven otherwise
            
            // Obtain input from user
            selection = scanObj.nextLine(); 
            selection = selection.trim();
            
            // Check a valid value has been selected
            if (values.contains(selection))
            {
                validInput = true;
            } else
            {
                System.out.println(errorMessage);
                validInput = false;                     
            }
            
        }
        
        return selection;
    }

    /**
     * 
     * Enter Yes or No
     *
     */
    public static boolean enterYesOrNo(String qText)
    {     
        Boolean validInput = false;
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> yesValues = new ArrayList<String>();
        Boolean answer = false;
        
        // Create a list of valid inputs
        
        values.add("YES");
        values.add("Y");
        values.add("yes");
        values.add("y");
        
        values.add("NO");
        values.add("N");
        values.add("no");
        values.add("n");
        
        yesValues.add("YES");
        yesValues.add("Y");
        yesValues.add("yes");
        yesValues.add("y");
        
        System.out.println(qText); // Ask a question
        String reply = enterValue("Please select:", values);

        if (yesValues.contains(reply))
        {
            answer = true;
        } else
        {
            answer = false;
        }
       
        return answer;
    }
}
