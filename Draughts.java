import java.io.*;
import java.lang.Object;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Draughts
 *
 * @author Michael Gennery
 * @version 03/10/2026
 */
public class Draughts
{
    
    /**
     * Draughts - main method
     *
     */
    public static void main(String[] args) 
    {
        System.out.println("DRAUGHTS");
        System.out.println("--------\n");
        
        // Make a board 8 squares by 8 squares
        Board aDraughts = new Board(8,8);
        Boolean aWhite = new Boolean(true);
       
        // Create Draughts Board
        for(int countY = 0; countY < 8; countY++)
        {        
            for(int countX = 0; countX < 8; countX++)
            {
                if(aWhite)
                {
                    if(countX != 7)
                    {
                        aWhite = false;
                    }
                    Section aSection = new Section("  - ",0,0,0);
                    aDraughts.setBoardSection(countY, countX, aSection);
                } else
                {
                    if(countX != 7)
                    {
                        aWhite = true;
                    }
                    Section aSection = new Section("  - ",255,255,255);
                    aDraughts.setBoardSection(countY, countX, aSection);
                }
            }
        }
                
        // Create the pieces and set the board
        
        // WHITE
        aDraughts.getBoardSection(0,1).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(0,3).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(0,5).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(0,7).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(1,0).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(1,2).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(1,4).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(1,6).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(2,1).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(2,3).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(2,5).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        aDraughts.getBoardSection(2,7).setContents(new Piece("  W ", "DRAUGHT", 0, 0, 0));
        
        // BLACK
        aDraughts.getBoardSection(5,0).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(5,2).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(5,4).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(5,6).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(6,1).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(6,3).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(6,5).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(6,7).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(7,0).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(7,2).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(7,4).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));
        aDraughts.getBoardSection(7,6).setContents(new Piece("  B ", "DRAUGHT", 255, 255, 255));   

        // Create Players
        
        Scanner whitePlayer = new Scanner(System.in);
        System.out.println("White - Enter name:");
        String whitePlayerName = whitePlayer.nextLine();
        Player white = new Player(whitePlayerName);
        Scanner whiteMoveX = new Scanner(System.in);
        Scanner whiteMoveY = new Scanner(System.in);

        Scanner blackPlayer = new Scanner(System.in);
        System.out.println("\nBlack - Enter name:");
        String blackPlayerName = blackPlayer.nextLine();
        Player black = new Player(blackPlayerName);
        Scanner blackMoveX = new Scanner(System.in);
        Scanner blackMoveY = new Scanner(System.in);
        
        
        // Play game
      
        boolean gameOver = false;
        
        do 
        {
            Boolean validMove = false;
           
            // Obtain White Move
           
            while (!validMove)
            {
                // Display Board
                System.out.println(aDraughts.toString());
               
                System.out.println("WHITE - " + white.getName());
                System.out.println("\nEnter Source co-ordinates");
                Integer whiteFromX = MJGfunctions.enterInteger("Row:", whiteMoveX, 0, 7);
                Integer whiteFromY = MJGfunctions.enterInteger("Column:", whiteMoveY, 0, 7);
                System.out.println("\nEnter Destination co-ordinates");
                Integer whiteToX = MJGfunctions.enterInteger("Row:", whiteMoveX, 0, 7);
                Integer whiteToY = MJGfunctions.enterInteger("Column:", whiteMoveY, 0, 7);
                
                // Check the correct piece has been selected
                if (aDraughts.getBoardSection(whiteFromX,whiteFromY).getContents().isEmpty())
                {
                    System.out.println("\nInvalid Move!\n");
                    validMove = false;
                    
                } else if (aDraughts.getBoardSection(whiteFromX,whiteFromY).getContents().get(0).getColour().getRed() == 0)
                {
                   
                    // Check if there is a piece at the destination
                    if (aDraughts.getBoardSection(whiteToX,whiteToY).getContents().isEmpty())
                    {

                        // Is White moving to a permitted square?
                        if (whiteToX % 2 == whiteToY % 2)
                        {
                            System.out.println("\nInvalid Move! Square not in use\n");
                            validMove = false;
                        } else
                        {
                            // Execute White move
                            validMove = aDraughts.movePiece(whiteFromX,whiteFromY,whiteToX,whiteToY);

                            // Has White reached the end of the board?
                            if (whiteToX == 7)
                            {
                                ArrayList<Piece> king = aDraughts.getBoardSection(whiteToX,whiteToY).getContents();
                                king.get(0).setName(" WW ");
                                king.get(0).setType("KING");
                            }
                        }
                        
                    } else if (aDraughts.getBoardSection(whiteToX,whiteToY).getContents().get(0).getColour().getRed() == 0)
                    {
                        // Is White trying to capture it's own piece?
                        System.out.println("\nInvalid Move!\n");
                        validMove = false;
                    } else 
                    {
                        if (whiteToX == 7 || whiteToX == 0)
                        {
                            // White can't capture a piece on the first or last row
                            System.out.println("\nInvalid Move!\n");
                            validMove = false;
                        } else
                        {
                            // Capture Black Piece i.e. remove from the board
                            aDraughts.getBoardSection(whiteToX,whiteToY).removeContents(aDraughts.getBoardSection(whiteToX,whiteToY).getContents().get(0));
                            // Replace with White Piece
                            validMove = aDraughts.movePiece(whiteFromX,whiteFromY,whiteToX,whiteToY);
                            // White needs to move again to place it's piece into the correct position after capture
                            validMove = false;
                        }
                    }

                } else
                {
                    System.out.println("\nSelect a White piece!\n");
                    validMove = false;
                }
                
            }
           
            // Quit game
            Boolean quitGame = MJGfunctions.enterYesOrNo("\nDo you wish to continue?");
            
            if (!quitGame)
            {
                gameOver = true;
                System.out.println(aDraughts.toString());
                System.out.println("\nThankyou for Playing!");    
            } else
            {
                gameOver = false;       
            }
 
           
            validMove = false;
           
            // Obtain Black Move

            while (!validMove && !gameOver)
            {
                // Display Board
                System.out.println(aDraughts.toString());     
               
                System.out.println("BLACK - " + black.getName());
                System.out.println("\nEnter Source co-ordinates");
                Integer blackFromX = MJGfunctions.enterInteger("Row:", blackMoveX, 0, 7);
                Integer blackFromY = MJGfunctions.enterInteger("Column:", blackMoveY, 0, 7);           
                System.out.println("\nEnter Destination co-ordinates");
                Integer blackToX = MJGfunctions.enterInteger("Row:", blackMoveX, 0, 7);
                Integer blackToY = MJGfunctions.enterInteger("Column:", blackMoveY, 0, 7);           
           
                // Check the correct piece has been selected
                if (aDraughts.getBoardSection(blackFromX,blackFromY).getContents().isEmpty())
                {
                    System.out.println("\nInvalid Move!\n");
                    validMove = false;
                } else if (aDraughts.getBoardSection(blackFromX,blackFromY).getContents().get(0).getColour().getRed() == 255)
                {
                   
                    // Check if there is a piece at the destination
                    if (aDraughts.getBoardSection(blackToX,blackToY).getContents().isEmpty())
                    {
                        
                        // Is Black moving to a permitted square?
                        if (blackToX % 2 == blackToY % 2)
                        {
                            System.out.println("\nInvalid Move! Square not in use\n");
                            validMove = false;
                        } else
                        {
                            // Execute Black move
                            validMove = aDraughts.movePiece(blackFromX,blackFromY,blackToX,blackToY);
                        
                            // Has Black reached the end of the board?
                            if (blackToX == 0)
                            {
                                ArrayList<Piece> king = aDraughts.getBoardSection(blackToX,blackToY).getContents();
                                king.get(0).setName(" BB ");
                                king.get(0).setType("KING");    
                            } 
                        }
                        
                    } else if (aDraughts.getBoardSection(blackToX,blackToY).getContents().get(0).getColour().getRed() == 255)
                    {
                        // Is Black trying to capture it's own piece?
                        System.out.println("\nInvalid Move!\n");
                        validMove = false;
                    } else
                    {
                        if (blackToX == 0 || blackToX == 7)
                        {
                            // Black can't capture a piece on the first or last row
                            System.out.println("\nInvalid Move!\n");
                            validMove = false;
                        } else
                        {
                            // Capture White Piece i.e. remove from the board
                            aDraughts.getBoardSection(blackToX,blackToY).removeContents(aDraughts.getBoardSection(blackToX,blackToY).getContents().get(0));
                            // Replace with Black Piece
                            validMove = aDraughts.movePiece(blackFromX,blackFromY,blackToX,blackToY);
                            // Black needs to move again to place it's piece into the correct position after capture
                            validMove = false;
                        }
                    }
                    
                } else
                {
                    System.out.println("\nSelect a Black piece!\n");
                    validMove = false;
                } 
           
                // Quit game
                if (!gameOver)
                {
                    quitGame = MJGfunctions.enterYesOrNo("\nDo you wish to continue?");
            
                    if (!quitGame)
                    {
                        gameOver = true;
                        System.out.println(aDraughts.toString());
                        System.out.println("\nThankyou for Playing!");    
                    } else
                    {
                        gameOver = false;       
                    }
                }    
           
            } while(!validMove && !gameOver);
        
        } while(!gameOver);

    }

}
