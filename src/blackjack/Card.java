/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author DouglasD
 */
public class Card {
    /**
     * The suit of the card
     */
    private Suit suit;
     /**
     * The number on the card
     */
    private Value value;

    /**
     * Constructor
     * @param suit the suit of the card
     * @param number the number on the card
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    public String toString() {
        return this.value.toString()+ " of " +this.suit.toString();
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    


}
