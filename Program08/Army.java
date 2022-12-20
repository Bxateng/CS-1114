// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aaron Boateng (9065-47342)
//-------------------------------------------------------------------------
/**
 *  Class that includes various squads and units.
 *
 *  @author Aaron Boateng (9065-47342)
 *  @version 2022.11.01
 */
public class Army
    extends Squad
{
    private String playerName;
    private String faction;
    /**
     * Initializes a newly created Army object.
     */
    public Army(String armyN, String armyF, String playerN)
    {
        super(armyN);
        faction = armyF;
        playerName = playerN;
    }
    /**
     * Returns the name of the player who controls
     * the army.
     * @return the name of the player
     */
    public String getPlayerName()
    {
        return playerName;
    }
    /**
     * Names the player who controls the army.
     * @param pn the new name of the player
     */
    public void setPlayerName(String pn)
    {
        playerName = pn;
    }
    /**
     * Returns the name of the army's faction.
     * @return the army's faction
     */
    public String getFaction()
    {
        return faction;
    }
    /**
     * Names the faction where the army originates.
     * @param fact the new name for the faction
     */
    public void setFaction(String fact)
    {
        faction = fact;
    }
    /**
     * Overrides the toString method to return the 
     * player name, faction and army of the unit
     * @return the player name, faction and army of the unit
     */
    public String toString()
    {
        String army = "player: " + playerName + ", faction: " +
        faction + ", army: " + super.toString();
        return army;
    }
}
