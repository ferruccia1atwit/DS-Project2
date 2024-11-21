/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2024
 * 
 * Usage restrictions:
 * 
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 * 
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my 
 * sections of this course. Violation of these usage restrictions will be considered 
 * a violation of the Wentworth Institute of Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */


package edu.wit.scds.ds.lists.app.game ;

/**
 * Representation of a player
 *
 * @author Your Name    // TODO
 *
 * @version 1.0 2024-10-31 Initial implementation
 */
public class Player
    {
    
    /*
     * Data fields
     */
    
    String name = new String();
    Hand hand;
    int score;
    int balance;
    
    
    public Player(String username)
    {
    
    this.name = username;
    this.hand = new Hand();
    this.score = 0;
    this.balance = 500;
    
    }
    
    void resetHand()
    {
    this.hand = new Hand();
    } 
    
    
    //TODO add gambling!!!
   


    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        // OPTIONAL for testing and debugging

        }	// end main()

    }	// end class Player