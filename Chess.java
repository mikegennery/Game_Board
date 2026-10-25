import java.io.*;
import java.lang.Object;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Chess
 *
 * @author Michael Gennery
 * @version 03/10/2026
 */
public class Chess
{
    
    /**
     * Chess - main method
     *
     */
    public static void main(String[] args)
    {
        System.out.println("CHESS");
        System.out.println("-----\n");
        
        // Make a board 8 squares by 8 squares
        Board aChess = new Board(8,8);
        Boolean aWhite = new Boolean(true);
        
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
                    Section aSection = new Section(" -  ",0,0,0);
                    aChess.setBoardSection(countY, countX, aSection);
                } else
                {
                    if(countX != 7)
                    {
                        aWhite = true;
                    }
                    Section aSection = new Section(" -  ",255,255,255);
                    aChess.setBoardSection(countY, countX, aSection);
                }
            }
                
        }
        
        // Create the pieces  and set the board
        
        // WHITE
        aChess.getBoardSection(7,0).setContents(new Piece("(W)R", "ROOK", 0, 0, 0));
        aChess.getBoardSection(7,1).setContents(new Piece("(W)N", "KNIGHT", 0, 0, 0));
        aChess.getBoardSection(7,2).setContents(new Piece("(W)B", "BISHOP", 0, 0, 0));
        aChess.getBoardSection(7,3).setContents(new Piece("(W)Q", "QUEEN", 0, 0, 0));
        aChess.getBoardSection(7,4).setContents(new Piece("(W)K", "KING", 0, 0, 0));
        aChess.getBoardSection(7,5).setContents(new Piece("(W)B", "BISHOP", 0, 0, 0));
        aChess.getBoardSection(7,6).setContents(new Piece("(W)N", "KNIGHT", 0, 0, 0));
        aChess.getBoardSection(7,7).setContents(new Piece("(W)R", "ROOK", 0, 0, 0));
        aChess.getBoardSection(6,0).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,1).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,2).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,3).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,4).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,5).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,6).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        aChess.getBoardSection(6,7).setContents(new Piece("(W)p", "PAWN", 0, 0, 0));
        
        // BLACK
        aChess.getBoardSection(0,0).setContents(new Piece("(B)R", "ROOK", 255, 255, 255));
        aChess.getBoardSection(0,1).setContents(new Piece("(B)N", "KNIGHT", 255, 255, 255));
        aChess.getBoardSection(0,2).setContents(new Piece("(B)B", "BISHOP", 255, 255, 255));
        aChess.getBoardSection(0,3).setContents(new Piece("(B)Q", "QUEEN", 255, 255, 255));
        aChess.getBoardSection(0,4).setContents(new Piece("(B)K", "KING", 255, 255, 255));
        aChess.getBoardSection(0,5).setContents(new Piece("(B)B", "BISHOP", 255, 255, 255));
        aChess.getBoardSection(0,6).setContents(new Piece("(B)N", "KNIGHT", 255, 255, 255));     
        aChess.getBoardSection(0,7).setContents(new Piece("(B)R", "ROOK", 255, 255, 255));
        aChess.getBoardSection(1,0).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,1).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,2).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,3).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,4).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,5).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,6).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));
        aChess.getBoardSection(1,7).setContents(new Piece("(B)p", "PAWN", 255, 255, 255));

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

        Boolean whiteHasCastled = false;
        Boolean blackHasCastled = false;
        
        // Play game
        
        boolean gameOver = false;
        
        do 
        {
           
           Boolean validMove = false;
           
           // Obtain White Move
           while (!validMove)
           {
               
               // Display Board
               System.out.println(aChess.toString());
               
               System.out.println("WHITE - " + white.getName());
               System.out.println("\nEnter Source co-ordinates");
               Integer whiteFromX = MJGfunctions.enterInteger("Row:", whiteMoveX, 0, 7);
               Integer whiteFromY = MJGfunctions.enterInteger("Column:", whiteMoveY, 0, 7);
               System.out.println("\nEnter Destination co-ordinates");
               Integer whiteToX = MJGfunctions.enterInteger("Row:", whiteMoveX, 0, 7);
               Integer whiteToY = MJGfunctions.enterInteger("Column:", whiteMoveY, 0, 7);
                 
               // Check the correct piece has been selected
               if (aChess.getBoardSection(whiteFromX,whiteFromY).getContents().isEmpty()) 
               {
                   System.out.println("\nInvalid Move!\n");
                   validMove = false;
                   
               } else if (aChess.getBoardSection(whiteFromX,whiteFromY).getContents().get(0).getColour().getRed() == 0)
               {
                   
                   // Check if there is a piece at the destination
                   if (aChess.getBoardSection(whiteToX,whiteToY).getContents().isEmpty())  
                   {
                       // Execute White move
                       validMove = aChess.movePiece(whiteFromX,whiteFromY,whiteToX,whiteToY);
                       
                       // Has White Castled?
                       if (!whiteHasCastled)
                       {
                           
                           // O - O
                           if (whiteFromX == 7 && whiteFromY == 4 
                           && whiteToX == 7 && whiteToY == 6 && 
                           aChess.getBoardSection(7,6).getContents().get(0).getName().equals("(W)K") &&
                           aChess.getBoardSection(7,7).getContents().get(0).getName().equals("(W)R") &&
                           aChess.getBoardSection(7,5).getContents().isEmpty())
                           {
                               // Move the Rook behind the King
                               validMove = aChess.movePiece(7,7,7,5);
                               whiteHasCastled = true;

                           } // O - O - O
                           else if (whiteFromX == 7 && whiteFromY == 4 
                           && whiteToX == 7 && whiteToY == 2 && 
                           aChess.getBoardSection(7,2).getContents().get(0).getName().equals("(W)K") &&
                           aChess.getBoardSection(7,0).getContents().get(0).getName().equals("(W)R") &&
                           aChess.getBoardSection(7,3).getContents().isEmpty() && 
                           aChess.getBoardSection(7,1).getContents().isEmpty())
                           {
                               // Move the Rook behind the King
                               validMove = aChess.movePiece(7,0,7,3);
                               whiteHasCastled = true;
                               
                           }
                       }
                           
                   } else if (aChess.getBoardSection(whiteToX,whiteToY).getContents().get(0).getColour().getRed() == 0)
                   {
                       System.out.println("\nInvalid Move!\n");
                       validMove = false;
                       
                   } else
                   {
                       // Capture Black Piece i.e. remove from the board
                       aChess.getBoardSection(whiteToX,whiteToY).removeContents(aChess.getBoardSection(whiteToX,whiteToY).getContents().get(0));
                       // Replace with White Piece
                       validMove = aChess.movePiece(whiteFromX,whiteFromY,whiteToX,whiteToY);
                       
                   }

                   // Promote white pawn that has reached the end of the board
                   if (whiteToX == 0 && aChess.getBoardSection(whiteToX,whiteToY).getContents().get(0).getType().equals("PAWN"))
                   {
                       System.out.println("\nThe Pawn has reached the end of the board!");
                       
                       ArrayList<String> newPieceSelection = new ArrayList<String>();
                       newPieceSelection.add("Q"); // Queen
                       newPieceSelection.add("q");
                       newPieceSelection.add("B"); // Bishop
                       newPieceSelection.add("b");
                       newPieceSelection.add("N"); // Knight
                       newPieceSelection.add("n");
                       newPieceSelection.add("R"); // Rook
                       newPieceSelection.add("r");

                       String newPiece = MJGfunctions.enterValue(
                       "\n\nPlease select which piece to promote pawn to: -" +
                       "\nQ q - Queen" + "\nB b - Bishop" +
                       "\nN n - Knight" + "\nR r - Rook",newPieceSelection).trim();                       
                       
                       HashMap<String, String> newPieceText1 = new HashMap<>();
                       HashMap<String, String> newPieceText2 = new HashMap<>();
                       
                       newPieceText1.put("Q", "(W)Q");
                       newPieceText2.put("Q", "QUEEN");
                       newPieceText1.put("q", "(W)Q");
                       newPieceText2.put("q", "QUEEN");
                       
                       newPieceText1.put("B", "(W)B");
                       newPieceText2.put("B", "BISHOP");
                       newPieceText1.put("b", "(W)B");
                       newPieceText2.put("b", "BISHOP");
                       
                       newPieceText1.put("N", "(W)N");
                       newPieceText2.put("N", "KNIGHT");
                       newPieceText1.put("n", "(W)N");
                       newPieceText2.put("n", "KNIGHT");  
                       
                       newPieceText1.put("R", "(W)R");
                       newPieceText2.put("R", "ROOK");
                       newPieceText1.put("r", "(W)R");
                       newPieceText2.put("r", "ROOK");  
                       
                       // Remove white pawn from the board
                       aChess.getBoardSection(whiteToX,whiteToY).removeContents(aChess.getBoardSection(whiteToX,whiteToY).getContents().get(0));
                       // Replace with new White Piece
                       aChess.getBoardSection(whiteToX,whiteToY).setContents(new Piece(newPieceText1.get(newPiece), newPieceText2.get(newPiece), 0, 0, 0));
                       
                       System.out.println("\nThe Pawn has been promoted to " 
                       + newPieceText1.get(newPiece) + " - " + newPieceText2.get(newPiece));
                       
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
               System.out.println(aChess.toString());
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
               System.out.println(aChess.toString());       
           
               System.out.println("BLACK - " + black.getName());
               System.out.println("\nEnter Source co-ordinates");
               Integer blackFromX = MJGfunctions.enterInteger("Row:", blackMoveX, 0, 7);
               Integer blackFromY = MJGfunctions.enterInteger("Column:", blackMoveY, 0, 7);           
               System.out.println("\nEnter Destination co-ordinates");
               Integer blackToX = MJGfunctions.enterInteger("Row:", blackMoveX, 0, 7);
               Integer blackToY = MJGfunctions.enterInteger("Column:", blackMoveY, 0, 7);  
                              
               // Check the correct piece has been selected
               if (aChess.getBoardSection(blackFromX,blackFromY).getContents().isEmpty())
               {
                   System.out.println("\nInvalid Move!\n");
                   validMove = false;           
                   
               } else if (aChess.getBoardSection(blackFromX,blackFromY).getContents().get(0).getColour().getRed() == 255)
               {
                   
                   // Check if there is a piece at the destination
                   if (aChess.getBoardSection(blackToX,blackToY).getContents().isEmpty())
                   {
                       // Execute Black move
                       validMove = aChess.movePiece(blackFromX,blackFromY,blackToX,blackToY);

                       // Has Black Castled?
                       if (!blackHasCastled)
                       {
                           
                           // O - O
                           if (blackFromX == 0 && blackFromY == 4 
                           && blackToX == 0 && blackToY == 6 && 
                           aChess.getBoardSection(0,6).getContents().get(0).getName().equals("(B)K") &&
                           aChess.getBoardSection(0,7).getContents().get(0).getName().equals("(B)R") &&
                           aChess.getBoardSection(0,5).getContents().isEmpty())
                           {
                               // Move the Rook behind the King
                               validMove = aChess.movePiece(0,7,0,5);
                               blackHasCastled = true;

                           } // O - O - O
                           else if (blackFromX == 0 && blackFromY == 4 
                           && blackToX == 0 && blackToY == 2 && 
                           aChess.getBoardSection(0,2).getContents().get(0).getName().equals("(B)K") &&
                           aChess.getBoardSection(0,0).getContents().get(0).getName().equals("(B)R") &&
                           aChess.getBoardSection(0,3).getContents().isEmpty() && 
                           aChess.getBoardSection(0,1).getContents().isEmpty())
                           {
                               // Move the Rook behind the King
                               validMove = aChess.movePiece(0,0,0,3);
                               whiteHasCastled = true;
                           }
                       }
                       
                   } else if (aChess.getBoardSection(blackToX,blackToY).getContents().get(0).getColour().getRed() == 255)
                   {
                       System.out.println("\nInvalid Move!\n");
                       validMove = false;
                       
                   } else
                   {
                       // Capture White Piece i.e. remove from the board
                       aChess.getBoardSection(blackToX,blackToY).removeContents(aChess.getBoardSection(blackToX,blackToY).getContents().get(0));
                       // Replace with Black Piece
                       validMove = aChess.movePiece(blackFromX,blackFromY,blackToX,blackToY);
                       
                   }
                   
                   // Promte black pawn that has reached the end of the board
                   if (blackToX == 7 && aChess.getBoardSection(blackToX,blackToY).getContents().get(0).getType().equals("PAWN"))
                   {
                       System.out.println("\nThe Pawn has reached the end of the board!");
                       
                       ArrayList<String> newPieceSelection = new ArrayList<String>();
                       newPieceSelection.add("Q"); // Queen
                       newPieceSelection.add("q");
                       newPieceSelection.add("B"); // Bishop
                       newPieceSelection.add("b");
                       newPieceSelection.add("N"); // Knight
                       newPieceSelection.add("n");
                       newPieceSelection.add("R"); // Rook
                       newPieceSelection.add("r");

                       String newPiece = MJGfunctions.enterValue(
                       "\n\nPlease select which piece to promote pawn to: -" +
                       "\nQ q - Queen" + "\nB b - Bishop" +
                       "\nN n - Knight" + "\nR r - Rook",newPieceSelection).trim();                       
                       
                       HashMap<String, String> newPieceText1 = new HashMap<>();
                       HashMap<String, String> newPieceText2 = new HashMap<>();
                       
                       newPieceText1.put("Q", "(B)Q");
                       newPieceText2.put("Q", "QUEEN");
                       newPieceText1.put("q", "(B)Q");
                       newPieceText2.put("q", "QUEEN");
                       
                       newPieceText1.put("B", "(B)B");
                       newPieceText2.put("B", "BISHOP");
                       newPieceText1.put("b", "(B)B");
                       newPieceText2.put("b", "BISHOP");
                       
                       newPieceText1.put("N", "(B)N");
                       newPieceText2.put("N", "KNIGHT");
                       newPieceText1.put("n", "(B)N");
                       newPieceText2.put("n", "KNIGHT");  
                       
                       newPieceText1.put("R", "(B)R");
                       newPieceText2.put("R", "ROOK");
                       newPieceText1.put("r", "(B)R");
                       newPieceText2.put("r", "ROOK");  
                       
                       // Remove black pawn from the board
                       aChess.getBoardSection(blackToX,blackToY).removeContents(aChess.getBoardSection(blackToX,blackToY).getContents().get(0));
                       // Replace with new White Piece
                       aChess.getBoardSection(blackToX,blackToY).setContents(new Piece(newPieceText1.get(newPiece), newPieceText2.get(newPiece), 255, 255, 255));
                       
                       System.out.println("\nThe Pawn has been promoted to " 
                       + newPieceText1.get(newPiece) + " - " + newPieceText2.get(newPiece));
                   
                   }     
                   
               } else
               {
                   System.out.println("\nSelect a Black piece!\n");
                   validMove = false;
               }
               
           }
           
           // Quit game
           if (!gameOver)
           {
               quitGame = MJGfunctions.enterYesOrNo("\nDo you wish to continue?");
            
               if (!quitGame)
               {
                   gameOver = true;
                   System.out.println(aChess.toString());
                   System.out.println("\nThankyou for Playing!");    
               } else
               {
                   gameOver = false;       
               }
           }
           
        } while(!gameOver);
        
    }
}
