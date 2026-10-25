import java.lang.Object;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Section
 * An area of the game board
 *
 * @author Michael Gennery
 * @version 16/11/2025
 */
public class Section
{
    private String name;                // Name of section
    private Color colour;               // Colour of section
    private ArrayList<Piece> contents;  // Contents of section
    
    /**
     * Constructor for objects of class section - For new game boards
     */
    public Section(String aName, int R, int G, int B)
    {
        name = aName;
        colour = new Color(R,G,B);
        contents = new ArrayList<Piece>();
    }
    
    /**
     * Constructor for objects of class section - for new sections
     */
    public Section(String aName, int R, int G, int B, ArrayList<Piece> aContents)
    {
        name = aName;
        colour = new Color(R,G,B);
        contents = aContents;      
    }

    /**
     * Constructor for objects of class section - for testing
     */
    public Section()
    {
 
        Piece cross = new Piece("X","CROSS",0,0,0);
        Piece circle = new Piece("O","CIRCLE",0,0,0);
        contents = new ArrayList<Piece>();
        
        name = "Noughts and Crosses";
        colour = new Color(0,0,0);
        contents.add(cross);
        contents.add(circle);
        
    }

    /**
     * Get Name of section
     *
     * @return      name of section
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get Section Colour
     *
     * @return      colour of section
     */
    public Color getColour()
    {
        return colour;
    }
    
    /**
     * Get Contents of section
     *
     * @return      section contents
     */
    public ArrayList<Piece> getContents()
    {
        return contents;
    }

    /**
     * Get Contents of section
     *
     * @return      section contents
     */
    public String displayContents()
    {
        String displayString = "";
        for(Piece aPiece : contents)
        {
            displayString += aPiece.getName();
        }
        return displayString;
    }
    
    /**
     * Get Contents of section as a string
     *
     * @return      section contents
     */
    @Override
    public String toString()
    {
        String contentsText = "";
        
        for(Piece aPiece : getContents())
        {
            contentsText += aPiece.toString();
        }
        
        return getName() + " / " + getColour() + " / " + contentsText;
    }
    
    /**
     * Set Name of section
     *
     * @param       name of section
     */
    public void setName(String aName)
    {
        name = aName;
    }
    
    /**
     * Set Section Colour
     *
     * @param       colour of section
     */
    public void setColour(int R, int G, int B)
    {
        colour = new Color(R,G,B);
    }
    
    /**
     * Set Contents of section
     *
     * @param       section contents
     */
    public void setContents(Piece aPiece)
    {
        contents.add(aPiece);
    }

    /**
     * Remove Contents of section
     *
     * @param       section contents
     */
    public void removeContents(Piece aPiece)
    {
        contents.remove(aPiece);
    }
    
}
