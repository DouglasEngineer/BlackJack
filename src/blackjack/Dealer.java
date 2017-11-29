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
public class Dealer extends Player {

    private final String NAME = "Dealer";
    private LinkedList<Card> hand;

    public Dealer(Deck gameDeck) {
        this.hand = hand;
        this.hand = new LinkedList<>();
        hit(gameDeck);
        hit(gameDeck);  
    }
    

    @Override
    void hit(Deck gameDeck) {
        this.hand.add(gameDeck.dealNextCard());
    }


    @Override
    void emptyHand() {
         this.hand.clear();
    }


    @Override
    LinkedList<Card> getHand() {
        return hand;
    }


    @Override
    int getFirstValue() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total = total + hand.get(i).getValue().getFIRSTVALUE();
        }
        return total;
    }

    @Override
    int getSecondValue() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total = total + hand.get(i).getValue().getSECONDVALUE();
        }
        return total;
    }


}
