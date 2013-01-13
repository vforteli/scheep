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

    /**
     * Test of getShipcells method, of class Board.
     */
    @Test
    public void testGetShipcells()
    {
        System.out.println("getShipcells");
        Board instance = null;
        int expResult = 0;
        int result = instance.getShipcells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of AddShip method, of class Board. Diagonal ship
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
     * Test of AddShip method, of class Board. Out of bounds ship
     */
    @Test
    public void testAddShipOOB() throws Exception
    {
        System.out.println("AddShip");
        int x1 = 6;
        int y1 = 6;
        int x2 = 6;
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
        int x1 = 1;
        int y1 = 1;
        int x2 = 4;
        int y2 = 1;
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
        instance.AddShip(5, 5,5,5);
        boolean result = instance.AddShip(x1, y1, x2, y2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Ship could not be placed");
    }

    /**
     * Test of AddRandomShip method, of class Board.
     */
    @Test
    public void testAddRandomShip() throws Exception
    {
        System.out.println("AddRandomShip");
        int length = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.AddRandomShip(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetBoard method, of class Board.
     */
    @Test
    public void testGetBoard()
    {
        System.out.println("GetBoard");
        Board instance = null;
        cellstate[][] expResult = null;
        cellstate[][] result = instance.GetBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Fire method, of class Board.
     */
    @Test
    public void testFire() throws Exception
    {
        System.out.println("Fire");
        int x = 0;
        int y = 0;
        Board instance = null;
        cellstate expResult = null;
        cellstate result = instance.Fire(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
