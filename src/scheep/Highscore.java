/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

import java.io.Serializable;

/**
 *
 * @author vforteli
 */
public class Highscore implements Serializable
{
    public String Name;
    public int Turns;
    public int[] ShipLengths;
    public int Size;

    public int getScore()
    {
        // Figure out some fair formula for calculating the score
        return 0;
    }
} 
