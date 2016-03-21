package com.Chitra;

import java.util.Stack;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class DiscardDeck extends Deck
{
    public DiscardDeck()
    {
        this.DeckOfCard = new Stack<Card>();
    }

    public void AddCard(Card card)
    {
       DeckOfCard.add(card);
    }

}
