package basic_strategy;

import java.util.Scanner;

/**
 *
 * @author sarad
 */
public class Main {

    public static void main(String[] args) {

        // welcome message
        System.out.println("Welcome to a game of Blackjack - Basic Strategy");

        // create playing deck, drawing from this deck (single deck)
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        // create the cards the player has 
        Deck playerDeck = new Deck();
        // create the cards the dealer has
        Deck dealerDeck = new Deck();

        // index 0 - 52 deck of cards 
//        System.out.println(playingDeck);
        // cash flow
        // BTW: if this was for a real bank roll system, use big decimals 
        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

        // game loop using while loop 
        // this is for each turn the player has until they run out of cash flow
        while (playerMoney > 0) {
            // keep playing and till you broke, this ain't a joke
            System.out.println("Bank roll cash flow: $" + playerMoney
                    + ", how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            // "you can't do that..." if you don't have the cash - you're slashed
            if (playerBet > playerMoney) {
                System.out.println("You can't do that... bye");
                break;
            }

            // end round
            boolean endRound = false;

            // start dealing 
            // player gets 2 cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            //dealer gets 2 cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            // another while loop for hitting 
            while (true) {
                // display player hand
                System.out.println("\n Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("\nYour hand is valued at: "
                        + playerDeck.cardsValue());

                // display dealer hand
                System.out.println("Dealer hand is valued at: "
                        + dealerDeck.getCard(0).toString() + " and [Hidden]");

                // let the player choose what they want to do
                System.out.println("Enter 1 to HIT or 2 to STAND");
                int response = userInput.nextInt();

                // player chooses  to HIT
                if (response == 1) {
                    playerDeck.draw(playingDeck);
                    // this is in one base, do -1 to get proper index
                    System.out.println("\n You draw a: "
                            + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    // BUST if over 21
                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("BUST" + "\n Currently valued at: "
                                + playerDeck.cardsValue());
                        // cash flow money loss 
                        playerMoney -= playerBet;
                        // that's it
                        endRound = true;
                        break;

                    }
                }

                // player chooses  to STAND
                if (response == 2) {
                    break;
                }
            }

            // reveal dealer hand 
            System.out.println("Dealer Hand: " + dealerDeck.toString());

            // whatif the dealer reaches closer to 21 before the player?
            if ((dealerDeck.cardsValue() > playerDeck.cardsValue())
                    && endRound == false) {
                System.out.println("House wins");
                playerMoney -= playerBet;
                endRound = true;
            }
            // dealer draws at 16, dealer stands at 17
            while ((dealerDeck.cardsValue() < 17) && endRound == false) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws: "
                        + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            // display total value for dealer
            System.out.println("Dealer's Hand is valued "
                    + dealerDeck.cardsValue());
            // determine if dealer BUSTS
            if ((dealerDeck.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer BUSTS! You win!");
//                playerMoney += playerBet * 1.5;
                playerMoney += playerBet;
                endRound = true;
            }

            // determine if DRAW
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue())
                    && endRound == false) {
                System.out.println("DRAW");
                endRound = true;
            }

            // whatif the player reaches closer to 21 before the dealer?
            if ((playerDeck.cardsValue() > dealerDeck.cardsValue())
                    && endRound == false) {
                System.out.println("You win the hand!");
                playerMoney += playerBet;
                endRound = true;
            } // the dealer won
            else if (endRound == false) {
                System.out.println("You lose the hand!");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.");
        }
        System.out.println("No more cash flow, ciao!");

    }

}
