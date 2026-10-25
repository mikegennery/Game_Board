import java.io.*;
import java.lang.Object;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TicTacToe 
 * aka. Noughts and Crosses
 *
 * @author Michael Gennery
 * @version 27/09/26
 */
public class TicTacToe
{

    /**
     * TicTacToe - main method
     *
     */
    public static void main(String[] args) 
    {
        System.out.println("Tic Tac Toe");
        System.out.println("-----------\n");
        
        // Make a board 3 squares by 3 squares
        Board aTicTacToe = new Board(3,3);     
        
        for(int countY = 0; countY < 3; countY++)
        {
            
            for(int countX = 0; countX < 3; countX++)
            {
                aTicTacToe.setBoardSection(countY, countX, new Section("  - ",0,0,0,new ArrayList<Piece>()));
            }
            
        }

        
        // Create Players
        
        Scanner playerX = new Scanner(System.in);
        System.out.println("X - Enter name:");
        String playerXName = playerX.nextLine();
        Player X = new Player(playerXName);
        Scanner playerXMoveX = new Scanner(System.in);
        Scanner playerXMoveY = new Scanner(System.in);

        Scanner playerO = new Scanner(System.in);
        System.out.println("O - Enter name:");
        String playerOName = playerO.nextLine();
        Player O = new Player(playerOName);
        Scanner playerOMoveX = new Scanner(System.in);
        Scanner playerOMoveY = new Scanner(System.in);
        
        
        // Play Game
        
        boolean gameOver = false;
        boolean gameIsDrawn = false;
        boolean gameIsWon = false;
        boolean quitGame = false;
        String checkWin = aTicTacToe.getBoardSection(0, 0).getName(); // This is needed to check if section is empty
        
        do 
        {
           
           Boolean validMove = false;

           // Display Board
           System.out.println(aTicTacToe.toString());
               
           // Obtain X Move
           while (!validMove && !gameIsDrawn && !gameIsWon)
           {        
               
               // Check for draw
               gameIsDrawn = checkForDraw(aTicTacToe);
               
               if(!gameIsDrawn)
               {
                   System.out.println("X - " + X.getName());
                   System.out.println("\nEnter co-ordinates");
                   Integer X_X = MJGfunctions.enterInteger("Row:", playerXMoveX, 0, 2);
                   Integer X_Y = MJGfunctions.enterInteger("Column:", playerXMoveY, 0, 2);
               
                   // Execute X move
                   if (aTicTacToe.getBoardSection(X_X, X_Y).getName().contains("X") ||
                   aTicTacToe.getBoardSection(X_X, X_Y).getName().contains("O") )
                   {
                   
                       // Don't allow move if section is occupied
                       System.out.println("Invalid Move!");
                   
                   } else
                   {

                        aTicTacToe.setBoardSection(X_X, X_Y, new Section("  X ",255,255,255,new ArrayList<Piece>()));
                        validMove = true;
                   
                   }
 
               }
               
               // Check for win
               gameIsWon = checkForWin(aTicTacToe, checkWin);
                  
           }
        
           // Display Board
           System.out.println(aTicTacToe.toString());
               
           validMove = false;
           
           // Obtain O Move
           while (!validMove && !gameIsDrawn && !gameIsWon)
           {
               
               // Check for draw
               gameIsDrawn = checkForDraw(aTicTacToe);    

               if(!gameIsDrawn)
               {
                   System.out.println("O - " + O.getName());
                   System.out.println("\nEnter co-ordinates");
                   Integer O_X = MJGfunctions.enterInteger("Row:", playerOMoveX, 0, 2);
                   Integer O_Y = MJGfunctions.enterInteger("Column:", playerOMoveY, 0, 2);

                   // Execute O move
                   if (aTicTacToe.getBoardSection(O_X, O_Y).getName().contains("X") ||
                       aTicTacToe.getBoardSection(O_X, O_Y).getName().contains("O") )
                   {
                   
                       // Don't allow move if section is occupied
                       System.out.println("Invalid Move!");
                   
                   } else
                   {
               
                       aTicTacToe.setBoardSection(O_X, O_Y, new Section("  O ",0,0,0,new ArrayList<Piece>()));                   
                       validMove = true;
                   
                   }
                   
                   // Check for win
                   gameIsWon = checkForWin(aTicTacToe, checkWin);    
               
                   if (!gameIsWon)
                   {
                        // Quit game
                        quitGame = MJGfunctions.enterYesOrNo("\nDo you wish to continue?");
            
                        if (!quitGame)
                        {
                            gameOver = true;
                            System.out.println("\nThankyou for Playing!");    
                        } else
                        {
                            gameOver = false;
                        }  
                   } else
                   {
                       // Display Board
                       System.out.println(aTicTacToe.toString());
                   }
               
               }
           
           }
        
        } while(!gameOver && !gameIsDrawn && !gameIsWon);
        
    }
    
    
    // Check for win 
    private static Boolean checkForWin(Board aBoard, String checkWin)
    {
        
        // Check each row
        for(int countY = 0; countY < 3; countY++)
        {
            
            if (aBoard.getBoardSection(countY, 0).getName() ==
                aBoard.getBoardSection(countY, 1).getName() &&
                aBoard.getBoardSection(countY, 0).getName() ==
                aBoard.getBoardSection(countY, 2).getName() &&
                aBoard.getBoardSection(countY, 0).getName() != checkWin)
                {
                    
                    // The Game is won if all sections in a row match
                    System.out.println(aBoard.getBoardSection(countY, 0).getName() + "has WON!");
                    return true;
                    
                }
                         
        }

        // Check each column
        for(int countX = 0; countX < 3; countX++)
        {
            if (aBoard.getBoardSection(0, countX).getName() ==
                aBoard.getBoardSection(1, countX).getName() &&
                aBoard.getBoardSection(0, countX).getName() ==
                aBoard.getBoardSection(2, countX).getName() &&
                aBoard.getBoardSection(0, countX).getName() != checkWin)
                {
                    
                    // The Game is won if all sections in a column match
                    System.out.println(aBoard.getBoardSection(0, countX).getName() + "has WON!");
                    return true;
                    
                }            
        }
            
        // Check diagonals
        if (aBoard.getBoardSection(0, 0).getName() ==
            aBoard.getBoardSection(1, 1).getName() &&
            aBoard.getBoardSection(0, 0).getName() ==
            aBoard.getBoardSection(2, 2).getName() &&
            aBoard.getBoardSection(0, 0).getName() != checkWin)
        {
            
            // The Game is won if all sections in a diagonal match
            System.out.println(aBoard.getBoardSection(0, 0).getName() + "has WON!");
            return true;
                    
        } else if (aBoard.getBoardSection(0, 2).getName() ==
            aBoard.getBoardSection(1, 1).getName() &&
            aBoard.getBoardSection(0, 2).getName() ==
            aBoard.getBoardSection(2, 0).getName()&&
            aBoard.getBoardSection(0, 2).getName() != checkWin)
        {
            
            // The Game is won if all sections in a diagonal match
            System.out.println(aBoard.getBoardSection(0, 2).getName() + "has WON!");
            return true;
            
        }
        
        // No win detected
        return false;
          
    }
    
    
    // Check for draw
    private static Boolean checkForDraw(Board aBoard)
    {
        
        for(int countY = 0; countY < 3; countY++)
        {
            for(int countX = 0; countX < 3; countX++)
            {

                if (!aBoard.getBoardSection(countX, countY).getName().contains("X") &&
                    !aBoard.getBoardSection(countX, countY).getName().contains("O") )
                {
                    // The Game is not drawn if an empty section is found
                    return false;
                }

            }
        }
        
        // The Game is drawn if an empty section is found
        System.out.println("Game is a Draw!");
        return true;
    }
    
}
