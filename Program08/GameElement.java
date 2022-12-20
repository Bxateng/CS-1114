// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Interface that reflects the initial characteristics of a unit.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.10.25
 */
public interface GameElement
{
    /**
     * Get this GameElement's name.
     *
     * @return This object's name as a string.
     */
    public String getName();
    /**
     * Get this GameElement's cost in points.
     *
     * @return The number of points for this object.
     */
    public int getPoints();
}
