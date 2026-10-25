import java.lang.Object;
import java.awt.Color;

/**
 * Piece
 * A piece used in the game
 *
 * @author Michael Gennery
 * @version 16/11/2025
 */
public class Piece
{
    private String name;    // Name of piece
    private String type;    // Type of piece
    private Color colour;   // Colour of piece

    /**
     * Constructor for objects of class Piece
     */
    public Piece(String aName, String aType, int R, int G, int B)
    {
        name = aName;
        type = aType;
        colour = new Color(R,G,B);     
    }

    /**
     * Get Name of piece
     *
     * @return      name of piece
     */
    public String getName()
    {
        return name;
    }
  
    /**
     * Get type of piece
     *
     * @return      Type of piece
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Get piece Colour
     *
     * @return      colour of piece
     */
    public Color getColour()
    {
        return colour;
    }

    /**
     * Get Contents of piece as a string
     *
     * @return      piece details
     */
    @Override
    public String toString()
    {
        return getName() + " / " + getType() + " / " + getColour();
    }
    
    /**
     * Set Name of piece
     *
     * @param       name of piece
     */
    public void setName(String aName)
    {
        name = aName;
    }
 
    /**
     * Set type of piece
     *
     * @param       type of piece
     */
    public void setType(String aType)
    {
        type = aType;
    }
    
    /**
     * Set piece Colour
     *
     * @param       colour of piece
     */
    public void setColour(int R, int G, int B)
    {
        colour = new Color(R,G,B);
    }
    
}
