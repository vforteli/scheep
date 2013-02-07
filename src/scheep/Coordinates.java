/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

/**
 * Encapsulates two dimensional coordinates
 * @author vforteli
 */
public class Coordinates
{
    public int x;
    public int y;
    
    
      /**
     * Converts human coordinates like A14 to zero based x and y coordinates
     * 
     * @param humanform
     * @return zero based x and y coordinates
     */
    public static Coordinates ParseCoordinates(String humanform)
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
}  