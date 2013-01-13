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
    
    
    public ArrayList<Highscore> getHighscores()
    {
        return this.highscores;
    }
    
    
    public void AddHighscore(Highscore highscore) throws IOException
    {
        this.highscores.add(highscore);
    }            
    
    
    public void Save() throws IOException
    {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
        output.writeObject(this.highscores);
        output.close();
    }
}