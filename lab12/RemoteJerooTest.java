import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;
import java.util.Scanner;
import student.IOHelper;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
// -------------------------------------------------------------------------
/**
 *  Tests for the RemoteJeroo class.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.11
 */
public class RemoteJerooTest
    extends TestCase
{
    private RemoteJeroo jeroo;
    /**
     * Creates a new RemoteJerooTest test object.
     */
    public RemoteJerooTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        Island island = new Island();
        jeroo = new RemoteJeroo();
        island.addObject(jeroo, 3, 3);
    }
    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        // Set the built-in scanner's contents
        setIn("forward forward forward");
        
        // Could provide multiple lines to setIn(), which has the
        // same effect as if each string included a line terminator at
        // the end:
        setIn(
            "forward",
            "forward",
            "forward");

        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    /**
     * Test RemoteJeroo with a scanner containing a "left" command.
     */
    public void testLeft()
    {
        setIn("left");
        jeroo.interpretCommand(in());
        assertThat(jeroo.isFacing(NORTH)).isTrue();
    }
    /**
     * Test RemoteJeroo with a scanner containing a "right" command.
     */
    public void testRight()
    {
        setIn("right");
        jeroo.interpretCommand(in());
        assertThat(jeroo.isFacing(SOUTH)).isTrue();    
    }
    /**
     * Test for myProgram with a scanner containing multiple commands.
     */
    public void testMyProgram()
    {  
        Scanner input = IOHelper.createScannerForURL(
            "https://courses.cs.vt.edu/~cs1114/Fall2021/" +
            "jeroo-commands.txt");
        jeroo.interpretAllCommands(input);
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.getY()).isEqualTo(9);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
}
