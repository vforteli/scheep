/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheep;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vforteli
 */
public class CoordinatesTest
{
    
    public CoordinatesTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * Test of AddShip method, of class Board. Diagonal ship
     */
    @Test
    public void testParseCoordinatesMin() throws Exception
    {
        Coordinates c = Coordinates.ParseCoordinates("A1");
        
        int x = 0;
        int y = 0;
     
        assertEquals(c.x, x);
        assertEquals(c.y, y);
    }
    
    
    @Test
    public void testParseCoordinatesMax() throws Exception
    {
        Coordinates c = Coordinates.ParseCoordinates("Z99");
        
        int x = 25;
        int y = 98;
     
        assertEquals(c.x, x);
        assertEquals(c.y, y);
    }
    
      @Test
    public void testParseInvalidCoordinates() throws Exception
    {
        Coordinates c = Coordinates.ParseCoordinates("Zu899a");

        assertNull(c);
    }
}
