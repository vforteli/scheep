/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vforteli
 */
public class Scheep 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);         
        
        int size = 0;
        while (size < 10 | size > 20)
        {
            System.out.print("Enter size between 10 and 20: ");
            try
            {
                size = in.nextInt();   
            }
            catch (InputMismatchException ex)
            {
                // Not a number...
                System.out.println("Thats not a number, this, is a number!");
            }
            System.out.println();
            in.nextLine();  // Get rid of the newline...
        }
        
        
        Board b = new Board(size);
        
        // Add some ships
        try 
        {
            b.AddRandomShip(5);
            b.AddRandomShip(4);
            b.AddRandomShip(3);
            b.AddRandomShip(3);
            b.AddRandomShip(2);
            //b.AddShip(1, 1, 1, 3);
            //b.AddShip(1, 5, 1, 7);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Scheep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        b.StartGame();
        
        PrintBoard(b.GetBoard());    
        System.out.println("Shipcells left: " + b.getShipcells());
        
        
        
        int i = 0;
        System.out.println("Fire in the hole!");
        while (b.getShipcells() > 0)
        {
            System.out.print("Enter coordinates between a1 and " + (char)(size+96) + "" + size + " to fire: ");
            
            /*
            String foo = in.nextLine();
            Coordinates c = ConvertCoordinates(foo);    // meh, tuples anyone?
            try
            {
                System.out.println(b.Fire(c.x, c.y));
            }
            catch (Exception ex)
            {
                System.out.println("Invalid coordinates, try again");
                continue;
            }
            
            PrintBoard(b.GetBoard());
            */
            
            ///*
            Random r = new Random();
            int x = r.nextInt(size);
            int y = r.nextInt(size);
            try           
            {
                System.out.println(b.Fire(x, y));
                PrintBoard(b.GetBoard());
            } catch (Exception ex)
            {
                Logger.getLogger(Scheep.class.getName()).log(Level.SEVERE, null, ex);
            }
            //*/
            //
            System.out.println("Ships left: " + b.getShipcells());
            i++;
        }
        System.out.println("All ships sunk in " + i + " turns");
        
        Highscores h = new Highscores();
        try
        {
            Highscore score = new Highscore();
            
            System.out.print("Enter name to be placed on highscores list: ");
            score.Name = in.nextLine();
            
            //score.ShipLengths = 10;
            score.Turns = i;
            score.Size = size;
                   
            h.AddHighscore(score);
            h.Save();
            
            System.out.println("Highscores: ");
            for (Highscore s : h.getHighscores())
            {
                System.out.println(s.Name + ": " + s.Turns);                
            }
        } catch (IOException ex)
        {
            System.out.println("Could not access highscores file");
            Logger.getLogger(Scheep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }           
    
    
 
    /**
     * Print the board to system.out
     * 
     * @param board
     */
    public static void PrintBoard(Board.cellstate[][] board)    
    {       
        System.out.print("\t");
        for (int x = 0; x < board[0].length; x++)
        {
             System.out.print(" " + (char)(x + 97) + " ");
        }
        System.out.println();
        System.out.println();
        
        int i = 0;
        for (Board.cellstate[] row : board)
        {
            System.out.print(++i + "\t");
            for (Board.cellstate cell : row)
            {
               if (cell == Board.cellstate.Ship)         
               {
                   System.out.print(" # ");
               }
               else if (cell == Board.cellstate.Hit)         
               {
                   System.out.print(" X ");
               }
               else if (cell == Board.cellstate.Miss)         
               {
                   System.out.print(" O ");
               }
               else if (cell == null)
               {
                   System.out.print(" ~ ");
               }     
            }
            System.out.println();
        }
    }       
    
 
    /**
     * Converts human coordinates like A14 to zero based x and y coordinates
     * 
     * @param humanform
     * @return zero based x and y coordinates
     */
    private static Coordinates ConvertCoordinates(String humanform)
    {
        humanform = humanform.toLowerCase();    // Lowercase means not having to check two ascii values...
        Coordinates c = new Coordinates();
        
        try
        {
            c.x = ((int)humanform.charAt(0)) - 97;  // ASCII a is 97
            c.y = Integer.parseInt(humanform.substring(1)) - 1; // Humans are stupid and count coordinates from 1
        }
        catch (Exception ex)
        {
            // Just return null if parsing fails...
            c = null;
        }        
        return c;
    }
    
    
    /**
     * Encapsulate x and y coordinates
     */
    private static class Coordinates
    {
        public int x;
        public int y;
    }                     
}
