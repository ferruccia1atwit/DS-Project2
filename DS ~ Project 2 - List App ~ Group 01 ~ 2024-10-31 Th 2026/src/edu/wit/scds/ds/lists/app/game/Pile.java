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

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.Collections ;
import java.util.List ;

/**
 * Representation of a pile of card
 * <p>
 * the bottom card is at position 0
 *
 * @author Anthony Ferrucci
 *
 * @version 1.0 2024-10-31 Initial implementation
 */
public class Pile
    {

    // data fields
    /** the list of cards - directly accessible by subclasses */
    protected List<Card> cards ;    // instantiate an ArrayList in the constructor
    
    //initial capacity for Pile arraylist
    private static final int INITIAL_CAPACITY = 104;

    
    /**
     * No-arg Constructor
     * Use initial capacity
     */
    public Pile()
    {
    this.cards = new ArrayList<>(INITIAL_CAPACITY);
    }
    
    /**
     * Constructor
     * @param capacity
     * NOTE: Might not need this in our application
     */
    public Pile(int capacity)
    {
    this.cards = new ArrayList<>(capacity);
    }
    

    /**
     * Print out all cards in the ArrayList
     */
    @Override
    public String toString()            // debugging aid
        {
        return this.cards.toString() ;

        }	// end toString()
    
    
    
    /**
     * Add a card to the pile
     * 
     * @param card
     * @return
     */
    public boolean add(Card card) 
    {
    
    return this.cards.add( card );
    
    }
    
    
    /**
     * Merge two piles into this one
     * 
     * @param anotherPile
     * @return
     */
    public boolean add(Collection<Card> anotherPile)
    {
    return this.cards.addAll( anotherPile );
    }
    
    
    /**
     * 
     * Remove a card from the pile
     * 
     * @param card
     * @return whether a card could be removed
     */
    public boolean remove(Card card) 
    {
    if (this.isEmpty())
        {
        return false;
        }
    return this.cards.remove( card );
    
    }
    
    
    /**
     * Remove a card from the top of the deck
     * 
     * @return removed card
     * Null if no cards in Pile
     */
    public Card remove()
    {
    
    if (this.isEmpty())
        {
        return null;
        }
    
    Card toRemove = this.cards.get( 0 );
    
    this.remove(toRemove);
    
    return toRemove;
    
    }
    
    /**
     * Whether a pile contains a card
     * 
     * @param card
     * @return
     */
    public boolean contains(Card card)
    {
    
    return this.cards.contains( card );
    
    }
    
    /**
     * Shuffle the cards
     * 
     */
    public void shuffle()
    {
    
    Collections.shuffle( cards );
    
    }
    
    /**
     * Sort the cards using the cards compareTo implementation
     * 
     */
    public void sort()
    {
    
    Collections.sort( cards );
    
    }
    
    /**
     * Return if cards is empty
     * 
     * @return
     */
    public boolean isEmpty()
    {
    return this.cards.isEmpty();
    }
    


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

    }	// end class Pile