package com.Chitra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class Hand
{
    // a list of card that make up hands for player
    protected List<Card> CardsinHand;
    private static final Integer NumberOfCardsInHand = 7; // a constant for cards for two players
    public static Deck DeckOfCards = new Deck();
    public static Card PlayedCard;
    //getter and setter
    public List<Card> getCardsinHand() {return CardsinHand;}

    public void setCardsinHand(List<Card> cardsinHand) {CardsinHand = cardsinHand;}

    //constructor;deals 7 card to each player if two players are playing
    public Hand()
    {
        this.CardsinHand = new ArrayList<Card>();
        for (int i = 0; i < NumberOfCardsInHand; i++) {
                // this.CardsinHand.add(new Deck().DealCard());
            this.CardsinHand.add(DeckOfCards.DealCard());
            }
            this.PlayedCard = DeckOfCards.DealCard();
        // need to work on first card with 8 value..will add it back to the deck,shuffle it and deal it again
//        if(PlayedCard.getValue() ==8)
//        {
//            DeckOfCards.
//        }
        }


    // method to print cards in hand
    public String toString()
    {

        return CardsinHand.toString();
    }
    //  amethod to remove card from hand becasue the simple remove for list class was not working
    public void RemoveCardFromHand(Card card)

    {
        Integer I =0;

        Card C = new Card("1_1");
        while (I<this.CardInHandSize()) {
            C = this.CardsinHand.get(I);
            ///System.out.println(C);
            // removes the card from hand ;comparing the played hand and the card inside the list
            if ((C.Suit.equals(card.Suit)) && C.Value.equals(card.Value)) {
                //System.out.println("found " + card + " @ " + this.CardsinHand.indexOf(C));
                this.CardsinHand.remove(C);
            }
            I++;

        }
    }

    public Integer CardInHandSize()
    {
        return CardsinHand.size();
    }
    public void AddCardAgain(Card card)
    {
        CardsinHand.add(card);
    }

    // method to calcukate the point.. kept the value simple;as per the rank value;
    public Integer CalculateHandTotalPoint(List<Card> CardsInHand)
    {
        int TotalPoint = 0;
        for (Card C:CardsInHand)
        {

            TotalPoint += C.Value;
        }
        return TotalPoint;
    }

}

