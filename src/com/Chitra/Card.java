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

//    public boolean CheckLegalCard(Card card,Card PlayedCard,Player P)
//    {
//            boolean Flagg = true;
//            if(card.Value.equals( 8))
//            {
//                PlayedCard = PickSuit(P,PlayedCard);
//                System.out.println("after 8, the new suit is "+ PlayedCard.Suit);
//                Flagg=true;
//            }
//            else if ((card.Value.equals(PlayedCard.Value))||card.Suit.equals(PlayedCard.Suit))
//            {
//               // System.out.println("legal check passed");
//                Flagg=true;
//
//            }
//
//            else {
//                //System.out.println("legal check failed");
//                Flagg = false;
//            }
//
//        return Flagg;
//    }

    public HashMap<Integer,Card> CheckLegalCard(Card card,Card PlayedCard,Player P)
    {
        HashMap<Integer,Card> Test = new HashMap<>();
        Integer Flagg = 1;
        if(card.Value.equals( 8))
        {
            PlayedCard = PickSuit(P,PlayedCard);
            System.out.println("after 8, the new suit is "+ PlayedCard.Suit);
            Flagg=1;
        }
        else if ((card.Value.equals(PlayedCard.Value))||card.Suit.equals(PlayedCard.Suit))
        {
             System.out.println("legal check passed , not 8");
            Flagg=1;

        }

        else {
            System.out.println("legal check failed");
            Flagg = 0;
        }
        Test.put(Flagg,PlayedCard);
        return Test;
    }

    public Card PickSuit(Player player,Card CardOnTable)
    {
        if(player.Name.equals("Human"))
        {
            String UserInput ="";
            while (true)
            {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Which suit do you want to choose(Hearts_ /Spades_ /Diamonds_ /Clubs_ ?");
                    UserInput = scanner.next();

                    break;
                }
                catch (InputMismatchException ime)
                {
                    System.out.println("Please enter a String");
                }
                CardOnTable.setSuit(UserInput);
                System.out.println("you changed card on table to "+ CardOnTable);
            }

        }
        // computer
        else
        { HashMap<String,Integer> Tracker = new HashMap<>();
            Tracker.put("Hearts_",0);Tracker.put("Clubs_",0);Tracker.put("Diamonds_",0);Tracker.put("Spades_",0);
            int HeartCounter =0,SpadeCounter=0,DiamondCounter =0,ClubCounter=0;
            for (Card s:player.PlayerHand.CardsinHand
                 )
            {
                if(s.Suit.equals("Hearts_"))
                {
                    HeartCounter++;
                    Tracker.put(s.Suit,HeartCounter);
                }
                if(s.Suit.equals("Clubs_"))
                {
                    ClubCounter++;
                    Tracker.put(s.Suit,ClubCounter);
                }
                if(s.Suit.equals("Diamonds_"))
                {
                    DiamondCounter++;
                    Tracker.put(s.Suit,DiamondCounter);
                }
                else
                {
                    SpadeCounter++;
                    Tracker.put(s.Suit,SpadeCounter);
                }
                int maxIndex = Tracker.get("Hearts_");
                String Suitttt = "Hearts_";
                for (String k:Tracker.keySet()
                     ) {

                    if (maxIndex > Tracker.get(k))
                    {
                        Suitttt = k;
                        maxIndex = Tracker.get(k);
                    }


                }
                CardOnTable.setSuit(Suitttt);

            }



        }
        System.out.println(player.Name + " wants  " + CardOnTable.Suit + " Now because ");
        return CardOnTable;
    }




}
