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
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import scheep.Board.cellstate;

/**
 *
 * @author vforteli
 */
public class BoardTest
{
    
    public BoardTest()
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



    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /**
     * Test of AddShip method, of class Board. Diagonal ship
     */
    @Test
    public void testAddShipDiagonally() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 1;
        int y1 = 1;
        int x2 = 3;
        int y2 = 3;
        Board instance = new Board(10);
        exception.expect(Exception.class);
        boolean result = instance.AddShip(x1, y1, x2, y2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Ships cannot be placed diagonally");
    }
     /**
     * Test of AddShip method, of class Board. Negative ship
     */
    @Test
    public void testAddShipNegative() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 5;
        int y1 = 5;
        int x2 = 5;
        int y2 = 1;
        Board instance = new Board(10);
        exception.expect(Exception.class);
        boolean result = instance.AddShip(x1, y1, x2, y2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("No negative ships allowed");
    }
    
    /**
     * Test of AddShip method, of class Board. Started game
     */
    @Test
    public void testAddShipGameStarted() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 1;
        Board instance = new Board(10);
        exception.expect(Exception.class);
        instance.AddShip(x1, y1, x2, y2);
        instance.StartGame();
        
        boolean result = instance.AddShip(3,3,3,3);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("No ships can be added to started game");
    }
    
    
    /**
     * Test of AddShip method, of class Board. Out of bounds ship
     */
    @Test
    public void testAddShipOOB() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 10;
        int y1 = 10;
        int x2 = 10;
        int y2 = 10;
        Board instance = new Board(10);
        exception.expect(ArrayIndexOutOfBoundsException.class);
        boolean result = instance.AddShip(x1, y1, x2, y2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Ship cannot be placed out of bounds");
    }
    /**
     * Test of AddShip method, of class Board.
     */
    @Test
    public void testAddShip() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 9;
        int y1 = 9;
        int x2 = 9;
        int y2 = 9;
        Board instance = new Board(10);
        boolean expResult = true;
        boolean result = instance.AddShip(x1, y1, x2, y2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Ship could not be placed");
    }
    
    /**
     * Test of AddShip method, of class Board.
     */
    @Test
    public void testAddShipCollision() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 5;
        int y1 = 5;
        int x2 = 5;
        int y2 = 5;
        Board instance = new Board(10);
        boolean expResult = false;
        instance.AddShip(5, 5, 5, 5);
        boolean result = instance.AddShip(x1, y1, x2, y2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Ship could not be placed");
    }
    
    /**
     * Test fire game not started
     */
    @Test
    public void testFirenotStarted() throws Exception
    {
        System.out.println("Test fire game not started");
        exception.expect(Exception.class);
        Board instance = new Board(10);
        instance.AddShip(5, 5, 5, 5);
        instance.Fire(4, 4);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("Cannot fire on game not started");
    }
    
    @Test
    public void testStartGame()
    {
        Board instance = new Board(10);
        boolean expResult = false;
        boolean result = instance.StartGame();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStartGameWithShip() throws Exception
    {
        Board instance = new Board(10);
        boolean expResult = true;
        instance.AddRandomShip(5);
        boolean result = instance.StartGame();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStartGameDuplicate()
    {
        Board instance = new Board(10);
        boolean expResult = false;
        instance.StartGame();
        boolean result = instance.StartGame();
        assertEquals(expResult, result);
    }
    
}
