
package edu.wit.scds.ds.lists.app.game;
import java.util.Scanner;


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
    Player player;
    Scanner input = new Scanner(System.in);
    
    Deck deck;
    
    
    //AKA initialize new round
    void reset()
    {
    this.deck = new Deck();
    this.player.resetHand();
    this.dealer.resetHand();
    }
    
    String getMove(Scanner s)
    {
    String move;
    do
        {
        System.out.println( "Hit or stand?" ) ;
        move = s.nextLine();
        } while (!move.toLowerCase().equals( "hit" ) && !move.toLowerCase().equals( "stand" ));
    return move.toLowerCase();
    }
    
    void dealerMove()
    {
    this.dealer.hand.cards.get(0).reveal();
    while (this.dealer.score < 17)
        {
        this.dealer.hand.hit( deck );
        this.dealer.score = dealer.hand.getScore();
        this.dealer.hand.cards.get(this.dealer.hand.cards.size() - 1).reveal();
        }
    if (this.dealer.score > 21)
        {
        this.dealer.busted = true;
        }
    }
    
    
    void run()
    {
    createPlayer();
    while (true)
        {
        reset();
        
        //deal cards to dealer first, then player
        
        this.dealer.hand.hit( this.deck );
        this.dealer.hand.hit( this.deck );
        this.dealer.hand.cards.get(1).reveal();
        
        
        this.player.hand.hit( this.deck );
        this.player.hand.hit( this.deck );
        this.player.hand.cards.get(0).reveal();
        this.player.hand.cards.get(1).reveal();
        
        this.player.score = this.player.hand.getScore();
        this.dealer.score = this.dealer.hand.getScore();
        
        showScores();
        
        
        while (this.player.score <= 21)
            {
            if (this.player.score == 21)
                {
                System.out.println( "Blackjack!" ) ;
                break;
                }
            String move = getMove(this.input);
            if (move.equals( "hit" ))
                {
                this.player.hand.hit( this.deck );
                this.player.score = this.player.hand.getScore();
                this.player.hand.cards.get( this.player.hand.cards.size() - 1 ).reveal();
                showScores();
                }
            else if (move.equals( "stand" ))
                {
                break;
                }
            if (this.player.score > 21)
                {
                this.player.busted = true;
                break;
                }
            }
        
        dealerMove();
        System.out.printf( "%s hand: %s%n", this.dealer.name, this.dealer.hand );
        System.out.printf( "%s hand: %s%n", this.player.name, this.player.hand ) ;
        
        //get the winner
        if ( !this.player.busted && ( this.player.score > this.dealer.score || this.dealer.busted ))
            {
            System.out.printf( "%s wins!%n", this.player.name) ;
            }
        else if (this.player.score < this.dealer.score || this.player.busted)
            {
            System.out.printf( "%s wins!%n", this.dealer.name ) ;
            }
        else
            {
            System.out.println( "Push!" ) ;
            }
        
        }
    
    
    }
    
    // shows players' hands and human's score
    private void showScores()
    {
    System.out.printf( "%n%s hand: %s%n", this.dealer.name, this.dealer.hand );
    System.out.printf( "%s hand: %s%n", this.player.name, this.player.hand ) ;
    System.out.printf( "%s's score: %d%n%n", this.player.name, this.player.score) ;
    }
    
    // creates a player using the player's name
    private void createPlayer()
    {
    System.out.println( "What's your name?" ) ;
    this.player = new Player(this.input.nextLine());
    }
    
    
    
    //main game driver
    public static void main(String[] args)
    {
    
    Blackjack game = new Blackjack();
    game.run();
    
    }

    }
   // end class Blackjack