
package edu.wit.scds.ds.lists.app.game;


/**
 * 
 * 
 * @author antho
 * @version 1.0.0 2024-11-21 Initial implementation
 *
 */
public class Blackjack
    {
    
    Player dealer = new Player("Dealer");
    Player player = new Player("Anthony");
    
    Deck deck;
    
    
    //AKA initialize new round
    void reset()
    {
    deck = new Deck();
    player.resetHand();
    dealer.resetHand();
    }
    
    void run()
    {
    
    while (true)
        {
        reset();
        
        //deal cards to dealer first, then player
        dealer.hand.hit( deck );
        dealer.hand.cards.get(0).reveal();
        dealer.hand.hit( deck );
        
        player.hand.hit( deck );
        player.hand.hit( deck );
        player.hand.cards.get(0).reveal();
        player.hand.cards.get(0).reveal();
        
        System.out.printf( "%s hand: %s", dealer.name, dealer.hand );
        System.out.printf( "%s hand: %s", player.name, player.hand ) ;
        
        
        
        }
    
    }
    
    
    
    //main game driver
    public static void main(String[] args)
    {
    
    Blackjack game = new Blackjack();
    game.run();
    
    }

    }
   // end class Blackjack