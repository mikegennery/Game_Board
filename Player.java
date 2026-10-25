import java.lang.Object;

/**
 * Player
 *
 * @author Michael Gennery
 * @version 14/06/2026
 */
public class Player
{
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String aName)
    {
        name = aName;
    }

    /**
     * Get Name
     *
     * @return      name of piece
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set Name
     *
     * @return      name of piece
     */
    public void setName(String aName)
    {
        name = aName;
    }
    
}
