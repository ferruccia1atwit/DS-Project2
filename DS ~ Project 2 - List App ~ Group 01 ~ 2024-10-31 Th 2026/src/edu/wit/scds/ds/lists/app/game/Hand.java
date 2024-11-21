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
 * Representation of a hand of cards
 *
 * @author Your Name    // TODO
 *
 * @version 1.0 2024-10-31 Initial implementation
 */
public class Hand extends Pile
    {
    
    public Card hit(Deck deck)
    {
    Card newCard = deck.deal();
    
    this.add(newCard);
    
    
    return newCard;
    }
    
    public int getScore()
    {
    return this.eval();
    }
    
    
    /*
     * Helper methods
     */
    
    private static int evalAce(int score) 
        {
    if (score <= 10) 
        {
        return 11;
    } 
    return 1;
        }
    
    private int eval()
    {
    int numAces = 0;
    int score = 0;
    
    for (Card card : this.cards)
        {
        if (card.rank == Rank.ACE)
            {
            numAces++;
            }
        else
            {
            score += card.rank.getPoints();
            }
        }
    
    for (int k = 0; k < numAces; k++)
        {
        score += evalAce(score);
        }
    return score;
    }
    
    
    
    /**
     * (optional) test driver
     *
     * @param args
     *     -unused-
     */
    public static void main( final String[] args )
        {
        
        Deck deck = new Deck();
        Hand hand = new Hand();
        
        hand.hit( deck );
        
        System.out.println( hand.getScore() ) ;
        
        hand.hit( deck );
        
        System.out.println( hand.getScore() ) ;
        
        for (Card card : hand.cards)
            {
            card.flip();
            }
        
        System.out.println( deck.cards.size() ) ;
        
        System.out.println( hand ) ;

        }	// end main()

    }	// end class Hand