import java.lang.Object;
import java.util.ArrayList;

/**
 * Game Board
 *
 * @author Michael Gennery
 * @version 02/08/2026
 */
public class Board
{ 
    // Sections of the game board arranged into a grid or 2D array
    private Section[][] boardGrid;
    
    /**
     * Constructor for objects of class board
     * 
     * @param X-axis
     * @param Y-axis
     */
    public Board(int X, int Y)
    {
        boardGrid = new Section[X][Y];
        populateBoard(X,Y);
    }

    /**
     * Constructor for objects of class board - Testing purposes
     * 
     * @param X-axis
     * @param Y-axis
     */
    public Board()
    {
        boardGrid = new Section[3][3];
        populateTestBoard(3,3);
    }
    
    /**
     * Populate board
     * 
     * @param X-axis
     * @param Y-axis
     */
    public void populateBoard(int X, int Y)
    {
        
        for(int countY = 0; countY < Y; countY++)
        {
 
            for(int countX = 0; countX < X; countX++)
                {
                    boardGrid[countX][countY] = new Section("BLANK",0,0,0);
                }

        }      
        
    }
  
    /**
     * Populate board
     * 
     * @param X-axis
     * @param Y-axis
     */
    public void populateTestBoard(int X, int Y)
    {
        
        for(int countY = 0; countY < Y; countY++)
        {
 
            for(int countX = 0; countX < X; countX++)
                {
                    boardGrid[countY][countX] = new Section();
                }

        }      
        
    }
    
    /**
     * Display Board
     *
     */
    @Override
    public String toString()
    {
        String boardString = "";
        Section[][] aBoard = getBoard();
        
        boardString += "\n |   ";
        
        for (int x = 0; x < aBoard[0].length; x++)
        {
            boardString += x;
            boardString += "  |   ";
        }
        
        boardString += "\n";
        
        int y = 0;
        
        for(Section[] row : aBoard)
        {
            boardString += y + "| ";

            for(Section column : row)
            {
                if(column.getContents().size() == 0)
                {
                    boardString += column.getName() + " | ";
                } else
                {
                    ArrayList<Piece> aContents = column.getContents();
                    boardString += column.displayContents() + " | ";
                }
            }
                
            y++;
            boardString += "\n";
        }
        
        return boardString;
    }
    
    /**
     * Get Board
     *
     * @return Game board
     *
     */
    public Section[][] getBoard()
    {
        return boardGrid;
    }
   
    /**
     * Get Board Section
     *
     * @param X-axis
     * @param Y-axis
     * @return Section of the game board
     */
    public Section getBoardSection(int Y, int X)
    {
        return boardGrid[Y][X];
    }
   
    /**
     * Set Board Section
     *
     * @param X-axis
     * @param Y-axis
     * @return Section of the game board
     */
    public void setBoardSection(int Y, int X, Section aSection)
    {
        boardGrid[Y][X] = aSection;
    }

    /**
     * Move piece
     *
     * @param X-axis
     * @param Y-axis
     */
    public boolean movePiece(int aY, int aX, int bY, int bX)
    {
        
        // Obtain details of source of piece to be moved
        Section aSection = getBoardSection(aY,aX);
        ArrayList<Piece> aSectionContents = aSection.getContents();
        Piece aPiece = new Piece("","",0,0,0);
        Boolean validMove = true;
        
        try
        {
            aPiece = aSectionContents.get(aSectionContents.size()-1);
        }
        catch (Exception ArrayIndexOutOfBoundsException)
        {
            System.out.println("\nThere is no piece on that section!\n");
            validMove = false;
        }
        
        // Move piece to destination
        if (validMove)
        {
            Section bSection = getBoardSection(bY,bX);
            bSection.setContents(aPiece);
            aSection.removeContents(aPiece);
        }
        
        return validMove;
    }
    
}
