/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.LinkedList;

/**
 *
 * @author DouglasD
 */
public abstract class Player {



    abstract void hit(Deck gameDeck);


    abstract void emptyHand();

    //method to get users hand
    abstract LinkedList<Card> getHand();

    abstract int getFirstValue();
    
    abstract int getSecondValue();
    
    
}
