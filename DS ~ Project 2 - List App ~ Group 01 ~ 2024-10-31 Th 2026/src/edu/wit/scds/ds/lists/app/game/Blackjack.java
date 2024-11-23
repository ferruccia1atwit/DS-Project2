
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
    Player player = new Player("Anthony");
    Scanner input = new Scanner(System.in);
    
    Deck deck;
    
    
    //AKA initialize new round
    void reset()
    {
    this.deck = new Deck();
    this.player.resetRound();
    this.dealer.resetRound();
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
    this.dealer.hand.cards.get(1).reveal();
    while (this.dealer.score < 17)
        {
        this.dealer.hand.hit( deck );
        this.dealer.score = dealer.hand.getScore();
        this.dealer.hand.cards.get(this.dealer.hand.cards.size() - 1).reveal();
        }
    }
    
    
    void run()
    {
    
    while (true)
        {
        reset();
        
        //deal cards to dealer first, then player
        
        this.dealer.hand.hit( this.deck );
        this.dealer.hand.cards.get(0).reveal();
        this.dealer.hand.hit( this.deck );
        
        
        this.player.hand.hit( this.deck );
        this.player.hand.hit( this.deck );
        this.player.hand.cards.get(0).reveal();
        this.player.hand.cards.get(1).reveal();
        
        this.player.score = this.player.hand.getScore();
        this.dealer.score = this.dealer.hand.getScore();
        
        System.out.printf( "%s hand: %s%n", this.dealer.name, this.dealer.hand );
        System.out.printf( "%s hand: %s%n", this.player.name, this.player.hand ) ;
        System.out.printf( "%s's score: %d%n", this.player.name, this.player.score) ;
        
        
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
                System.out.printf( "%s hand: %s%n", this.dealer.name, this.dealer.hand );
                System.out.printf( "%s hand: %s%n", this.player.name, this.player.hand ) ;
                System.out.printf( "%s's score: %d%n", this.player.name, this.player.score) ;    
                }
            else if (move.equals( "stand" ))
                {
                break;
                }
            }
        dealerMove();
        System.out.printf( "%s hand: %s%n", this.dealer.name, this.dealer.hand );
        System.out.printf( "%s hand: %s%n", this.player.name, this.player.hand ) ;
        
        //get the winner
        if (( this.player.score > this.dealer.score || this.dealer.isBust ) && !this.player.isBust)
            {
            System.out.printf( "%s wins!", this.player.name) ;
            }
        else if (( this.player.score < this.dealer.score || this.player.isBust ) && !this.dealer.isBust)
            {
            System.out.printf( "%s wins!", this.dealer.name ) ;
            }
        else
            {
            System.out.println( "Push!" ) ;
            }
        
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