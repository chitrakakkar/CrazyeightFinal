package com.Chitra;

import java.util.*;

/**
 * Created by chitrakakkar on 3/18/16.
 */
public class Card
{
    // Card's color(Suit) and Number(Value)

    protected String Suit;
    protected Integer Value;

    // constructor
    public Card(String suit, Integer value)
    {
        this.Suit = suit;

        this.Value = value;
    }
    public Card (String S)
    {
        //System.out.println(" H"+Arrays.toString(S.split("_")));
        String suitt  = S.split("_")[0].trim() +"_";
        Integer Rankk = Integer.parseInt(S.split("_")[1].trim());

        this.Suit= suitt;
        this.Value = Rankk;
    }
    //setters and getters
    public Integer getValue() {return Value;}

    public void setValue(Integer value) {Value = value;}

    public String getSuit() {return Suit;}

    public void setSuit(String suit) {Suit = suit;}

    public String toString()
    {
        return this.Suit + this.Value;
    }

    public boolean CheckLegalCard(Card card,Card PlayedCard,Player P)
    {
            boolean Flagg = true;
            if((card.Value.equals(8))|| ((card.Value.equals(PlayedCard.Value))||card.Suit.equals(PlayedCard.Suit)))
            {
               // System.out.println("legal check passed");
                Flagg=true;

            }

            else {
                //System.out.println("legal check failed");
                Flagg = false;
            }

        return Flagg;
    }
}
