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


package edu.wit.scds.ds.lists.app.game;

/**
 * Representation of a deck of cards
 *
 * @author //TODO
 *
 * @version 1.0 2024-10-31 Initial implementation
 */
public class Deck extends Pile
    {
    
    /**
     * Constructor
     * 
     */
    public Deck()
    {
    
    final Suit[] suits = Suit.values() ;
    final Rank[] ranks = Rank.values() ;
    
    for ( final Suit suit : suits )
        {

        // skip placeholder suit
        if ( Suit.NONE.equals( suit ) )
            {
            continue ;
            }

        for ( final Rank rank : ranks )
            {

            // skip non-playing card(s) - Joker
            if ( Rank.JOKER.equals( rank ) )
                {
                continue ;
                }

            // build a card
            final Card newCard = new Card( suit, rank ) ;
            System.out.printf( " %s", newCard ) ;

            // keep track of it
            this.cards.add( newCard ) ;
            }

        }
    
    this.shuffle();
    
    }
    
    
    
    /**
     * Deal ONE card
     * 
     * @return card
     */
    public Card deal()
    {
    
    return this.remove();
    
    }


    /**
     * (optional) test driver
     * 
     * @param args
     *     -unused-
     */
    public static void main( String[] args )
        {
        // OPTIONAL for testing and debugging
        
        Deck myDeck = new Deck();
        
        //these are all hidden
        System.out.println( myDeck.toString() );
        
        //flip them over
        
        for (Card card : myDeck.cards)
            {
            card.flip();
            }
        
        System.out.println( myDeck.toString() ) ;
            
        System.out.println(myDeck.deal());
        
        System.out.println( myDeck ) ;
        

        }   // end main()

    }   // end class Deck