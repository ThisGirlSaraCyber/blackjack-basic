package basic_strategy;

/**
 *
 * @author sarad
 */
public class Card {

    // calling on the enum classes
    private Suit suit;
    private Value value;

    // constructor for card object
    public Card(Suit suit, Value value) {

        this.value = value;
        this.suit = suit;

    }

    // return the suit and the value 
    @Override
    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    // return getValue() for checking the deck class when we need to see
    // what the actual value of the card (this is how the player knows their hand)
    public Value getValue() {

        return this.value;

    }

}
