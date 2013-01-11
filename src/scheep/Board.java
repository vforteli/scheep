/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

/**
 *
 * @author vforteli
 */
import java.util.Random; 

public class Board 
{    
    public enum cellstate {
        Ship,
        Hit,
        Miss        
    }
    
    // Row major, ie yx. Not xy!
    private cellstate[][] board;
    private int size;
    
    public int getShipcells() {
        return this.shipcells;
    }
    private int shipcells = 0;
    
    
    
    
    public Board(int Size) 
    {
        this.size = Size;
        this.board = new cellstate[size][size];
    }
    
    
    public boolean AddShip(int x1, int y1, int x2, int y2) throws Exception 
    {
        // No negative 4th dimension quantum ships allowed
        if (x1 > x2 || y1 > y2)
        {
            throw new Exception("x1 and y1 must be bigger than x2 and y2");
        }
        
        // Make sure the ship isnt diagional
        if (!(x1 == x2 | y1 == y2))
        {
            throw new Exception("Ships cannot be diagonally placed");  
        }
        
        // Check adjecent cells, apparently ships are not allowed to touch, not even diagonally
        if (CheckAdjecentCells(x1, y1, x2, y2)) {
            return false;
        }
        
        // Place the ship
        if (x1 == x2)   // Vertical
        {
            for (int i = y1; i <= y2; i++)
            {
                board[i][x1] = cellstate.Ship;
                shipcells++;
            } 
        }
        else    // Horizontal
        {
            for (int i = x1; i <= x2; i++)
            {
                board[y1][i] = cellstate.Ship;
                shipcells++;
            } 
        }        
        return true;
    }
      
    
    /**
     *
     * @param length
     * @return
     * @throws Exception
     */
    public boolean AddRandomShip(int length) throws Exception 
    {
        // Loop forever until a ship has successfully been placed... :p
        while (true)
        {
            Random r = new Random();
            int i = r.nextInt(this.size - length + 1);
            int j = r.nextInt(this.size); 
            
            if (r.nextBoolean())    // Horizontal
            {                
                if (this.AddShip(i, j, i + length - 1, j))
                {
                    return true;                    
                }
            }
            else    // Vertical
            {
                if (this.AddShip(j, i, j, i + length - 1))
                {
                    return true;
                }
            }
        }               
    }
    
    
    public cellstate[][] GetBoard() 
    {
        return this.board;        
    }
    
    
    public cellstate Fire(int x, int y) throws Exception 
    {
        if (!this.isValidCoordinates(x, y))
        {
            throw new Exception("Invalid coordinates");
        }
        
        if (board[y][x] == cellstate.Ship)
        {
            shipcells--;
            return board[y][x] = cellstate.Hit;
        }       
        else if (board[y][x] == cellstate.Hit)
        {
            return cellstate.Hit;            
        }
        return board[y][x] = cellstate.Miss;
    }
    
    
    private boolean isValidCoordinates(int x, int y) 
    {
        if ((x > board[0].length | x < 0) | (y > board.length | y < 0))
        {
            return false;
        }
        return true;
    }
    
    
    private boolean CheckAdjecentCells(int x1, int y1, int x2, int y2) 
    {
        int box1x = x1 - 1;
        box1x = box1x < 0 ? 0 : box1x;
        int box1y = y1 - 1;
        box1y = box1y < 0 ? 0 : box1y;
        int box2x = x2 + 1;
        box2x = box2x >= size - 1 ? size - 1 : box2x;
        int box2y = y2+1;
        box2y = box2y >= size - 1 ? size - 1 : box2y;
        for (int i = box1x; i <= box2x; i++) {
            for (int j = box1y; j <= box2y; j++) {
                if (board[j][i] == cellstate.Ship) {
                    return true;
                }
            }
        }
        return false;
    }
}

