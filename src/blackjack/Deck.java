/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author DouglasD
 */
public class Deck {

    private LinkedList<Card> deck;//an array of all the cards from createdeck

    public Deck() {
        this.deck = new LinkedList<>();
        createDeck();
        shuffle();

        //this to print deck
//        Iterator cardIterator = deck.iterator();
//        while (cardIterator.hasNext()) {
//            Card aCard = (Card) cardIterator.next();
//            System.out.print(aCard.getValue().getFIRSTVALUE() + " of " + aCard.getSuit()+ "\n");
//        }
    }

    public void createDeck() {
        //for each suit get a value for it 1-4
        for (Suit suit : Suit.values()) {
            for (Value valueOfCard : Value.values()) {
                this.deck.add(new Card(suit, valueOfCard));
            }
        }

    }

    public String toString() {
        String cardList = "";
        int i = 0;
        for (Card card : this.deck) {
            cardList += "\n" + i + "-" + cardList.toString();
            i++;
        }
        return cardList;
    }
 
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public Card dealNextCard() {
        //get the first card
        Card temp = new Card(Suit.SPADE, Value.ACE);
        temp = this.deck.get(0);
        this.deck.pop();
        return temp;
    }

    public int size() {
        return deck.size();
    }
}
