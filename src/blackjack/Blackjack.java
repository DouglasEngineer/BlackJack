/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author DouglasD
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        boolean humanHasBlackjack = false;
        boolean dealerHasBlackjack = false;
        while (true) {
            //check if dealer or human has blackjack
//         Create and shuffle a deck of cards
            Deck aDeck = new Deck();
//         Create two BlackjackHands, userHand and dealerHand
//         Deal two cards into each hand
            Human aHuman = new Human(aDeck);
            Dealer aDealer = new Dealer(aDeck);
            System.out.println(" ");
            System.out.println("Human hand is: " + aHuman.getHand() + ": " + aHuman.getFirstValue() + " or " + aHuman.getSecondValue());
            System.out.println(" ");
            System.out.println("Dealer hand is: " + aDealer.getHand() + ": " + aDealer.getFirstValue() + " or " + aDealer.getSecondValue());
//         Check if they game is tied because both have 21. = tie = game resets
//         Check if either human has 21. = human win = game resets
//         Check if dealer has 21. = dealer wins = game resets
            if (((aHuman.getFirstValue() == 21) || (aHuman.getSecondValue() == 21)) && ((aDealer.getFirstValue() == 21) || (aDealer.getSecondValue() == 21))) {
                System.out.println("Game is a tie");     //restart
                humanHasBlackjack = true;
                dealerHasBlackjack = true;
            } else if ((aHuman.getFirstValue() == 21) || (aHuman.getSecondValue() == 21)) {
                System.out.println("Human has won");     //game restarts
                humanHasBlackjack = true;
            } else if ((aDealer.getFirstValue() == 21) || (aDealer.getSecondValue() == 21)) {
                System.out.println("Dealer has won");    //game restarts
                dealerHasBlackjack = true;
            } else {

//         User draws cards (if user goes over 21, game ends)
                String userChoice = "";
                do {
                    System.out.println("Would you like to Hit h or Stand s: ");
                    userChoice = scanner.next();
                    if (userChoice.equals("h")) {
                        aHuman.hit(aDeck);
                        System.out.println("Your hand is: " + aHuman.getHand() + " value is: " + aHuman.getFirstValue() + " or " + aHuman.getSecondValue());
                    }
                } while (!userChoice.equals("s") && (aHuman.getFirstValue() < 21 || aHuman.getSecondValue() < 21));
//         Dealer draws cards
                System.out.println("Dealers turn");
                System.out.println("Dealer hand is: " + aDealer.getHand() + " value is: " + aDealer.getFirstValue() + " or " + aDealer.getSecondValue());
                while (aDealer.getFirstValue() < 17 || aDealer.getSecondValue() < 17) {
                    aDealer.hit(aDeck);
                    System.out.println("The dealer hits");
                    System.out.println("Dealer hand is: " + aDealer.getHand() + " value is: " + aDealer.getFirstValue() + " or " + aDealer.getSecondValue());
                }
                System.out.println("Dealer stands");
//         Check for winner 
//         if both bust, then dealers wins
                if (((aHuman.getFirstValue() > 21) && (aHuman.getSecondValue() > 21)) && ((aDealer.getFirstValue() > 21) && (aDealer.getSecondValue() > 21))) {
                    //both bust and dealer wins
                    System.out.println("Dealer has won");
                } else if (((aDealer.getFirstValue() > 21) && (aDealer.getSecondValue() > 21)) && ((aHuman.getFirstValue() <= 21) || (aHuman.getSecondValue() <= 21))) {
                    //dealer bust and human wins
                    System.out.println("Human has won");
                } else if ((aHuman.getFirstValue() <= 21) || (aHuman.getSecondValue() <= 21)) {
                    //check if the human's cards that value under 21 is greater than dealer
                    if ((aHuman.getFirstValue() <= 21) && (aHuman.getFirstValue() > aDealer.getFirstValue()) || (aHuman.getFirstValue() <= 21) && (aHuman.getFirstValue() > aDealer.getSecondValue())) {
                        System.out.println("Human has won");
                    } else if ((aHuman.getSecondValue() <= 21) && (aHuman.getSecondValue() > aDealer.getFirstValue()) || (aHuman.getSecondValue() <= 21) && (aHuman.getSecondValue() > aDealer.getSecondValue())) {
                        System.out.println("Human has won");
                    } else {
                        System.out.println("It is a tie");
                    }
                } else {
                    System.out.println("Dealer has won");
                }

            }

        }
    }

}
