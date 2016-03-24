package com.Chitra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public  class Deck
{
    // stack of the card to create deck
  protected Stack<Card> DeckOfCard;

    public Stack<Card> getDeckOfCard() {
        return DeckOfCard;
    }

    public void setDeckOfCard(Stack<Card> deckOfCard) {
        DeckOfCard = deckOfCard;
    }

    //Constructor
    Deck()
    {
        this.DeckOfCard = new Stack<>();
        List<String> CardSuit = new ArrayList<>();
        CardSuit.add("Hearts_");CardSuit.add("Diamonds_");CardSuit.add("Clubs_");CardSuit.add("Spades_");


        //creating a deck from 1 to 13 ..making it simple than ACE, Jack, Queen and King
        // to make the calculation of the points easy
        for (String st:CardSuit)
        {
           for(int i =1;i<14;i++)
           {
               Card card = new Card(st,i);
               DeckOfCard.add(card);
           }
        }
        // shuffles the deck
        Collections.shuffle(DeckOfCard);
    }

    // gives the deckSize
    public  Integer DeckSize()
    {
        return this.DeckOfCard.size();
    }
    // deal cards
    public Card DealCard()
    {
        return DeckOfCard.pop();
    }

}
