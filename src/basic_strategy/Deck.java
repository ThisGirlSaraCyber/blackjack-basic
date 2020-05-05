package basic_strategy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sarad
 */
public class Deck {

    // instance for deck array list [52 cards]
    public ArrayList<Card> cards;

    // constructor for deck array list [52 cards]
    public Deck() {

        this.cards = new ArrayList<Card>();

    }

    // method which creates a full deck of cards 
    // public void is used because it is not returning anything
    public void createFullDeck() {
        // generate cards
        for (Suit cardSuit : Suit.values()) {
            // but we don't want 4 cards, we want 52 cards
            // this will add the 13 different value types [4*13=52]
            for (Value cardValue : Value.values()) {
                // add a new card to the deck
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    // this will shuffle the deck, randomly
    public void shuffle() {
        // then, take each value and put them into a temporary deck 
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        // use Random object [Library] to generate random numbers 
        Random random = new Random();
        // represent card being pulled out 
        int randomCardIndex = 0;
        // get the size of the actual deck because indexes will be added & removed
        int originalSize = this.cards.size();
        // get the 52 indices 
        for (int i = 0; i < originalSize; i++) {
            // generate random card index 
            // [classic method]-->rand.nextInt((max - min) - 1) + min;
            // remove from actual deck & add it temporary deck
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;

    }

    // this will return the string with all of the cards in the deck
    @Override
    public String toString() {
        String cardListOutput = "";

        // testing var to check if we do have 52 cards 
//        int i = 0;
        // loop for all the cards in ArrayList
        for (Card aCard : this.cards) {
//            cardListOutput += "\n" + i + " - " + aCard.toString();
            cardListOutput += "\n " + aCard.toString();
            // placing each index using the i integer 
//            i++;
        }

        // return the card list output
        return cardListOutput;
    }

    // remove an index from ArrayList of cards 
    public void removeCard(int i) {
        this.cards.remove(i);
    }

    // manipulator 
    public Card getCard(int i) {
        return this.cards.get(i);
    }

    // add an index to ArrayList of cards 
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    // draws from deck
    // use this method to move from one deck to another 
    // have a param be the deck it is coming from 
    public void draw(Deck comingFrom) {
        // getting cards from top of ArrayList of cards 
        this.cards.add((comingFrom.getCard(0)));
        comingFrom.removeCard(0);
    }

    // method that returns amount of cards in the deck
    public int deckSize() {
        return this.cards.size();
    }

    // move all of the players cards back into the deck 
    // move all of the dealers cards back into the deck
    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.cards.size();

        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }

        // keep moving until there ain't no more cards left
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }

    // create method that returns the cards in the players deck 
    // OR
    // the dealer's deck
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;

        // for every card, check every value
        // face value 
        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }

        // ace can be 1 or 11, depending if the total value is greater than 10
        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }
        return totalValue;
    }

}
