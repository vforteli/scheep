/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vforteli
 */
public class Highscores 
{
    private final String path = System.getProperty("user.dir") + "\\highscores.txt";
    private ArrayList<Highscore> highscores = new ArrayList<Highscore>();
    
    /**
     * Create a high scores list object and load the high scores from file
     */
    public Highscores()
    {
        try
        {
            File test = new File(path);
            if (test.isFile() && test.canWrite())
            {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
                this.highscores = (ArrayList<Highscore>)input.readObject();
                // wuuh
            }
        } 
        catch (Exception ex)
        {
            Logger.getLogger(Highscores.class.getName()).log(Level.INFO, null, ex);
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
        
        Collections.sort(this.highscores,new Comparator<Highscore>() { 
            @Override
            public int compare(Highscore o1, Highscore o2)
            {
                return o1.Score - o2.Score;
            }
        });
        
        Collections.reverse(this.highscores);
        
        output.writeObject(this.highscores);
        output.close();
    }    
}
