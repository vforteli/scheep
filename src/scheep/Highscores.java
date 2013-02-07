/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vforteli
 */
public class Highscores 
{
    private final String path = "C:\\highscores.txt";
    private ArrayList<Highscore> highscores = new ArrayList<Highscore>();
    
    public Highscores()
    {
        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            this.highscores = (ArrayList<Highscore>)input.readObject();
        } catch (Exception ex)
        {
            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
            this.highscores = new ArrayList<Highscore>();
        }
    }
    
    /**
     * Get a list of all saved highscores sorted by some algorithm to be created
     * 
     * @return ArrayList of highscores
     */
    public ArrayList<Highscore> getHighscores()
    {
        return this.highscores;
    }
    
    
    /**
     * Add a new score to the list
     * 
     * @param highscore
     */
    public void AddHighscore(Highscore highscore)
    {
        this.highscores.add(highscore);
    }            
    
    
    /**
     * Clears the highscores list. Remember to call save...     * 
     */
    public void ClearHighscores()
    {
        this.highscores.clear();
    }
    
    
    /**
     * Save the highscores to a file
     * 
     * @throws IOException
     */
    public void Save() throws IOException
    {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        output.writeObject(this.highscores);
        output.close();
    }
}
