package com.Chitra;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public  class Main {

    public static DiscardDeck DiscarDdeck = new DiscardDeck();
    //public static Card PlayedCard;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the crazy eight game between a computer and a human player ");
        System.out.println("*******************************************************************");
        System.out.println("Would you be interested in playing with a computer?(Y/N)");
        String UserInput = scanner.nextLine();
        if (UserInput.equalsIgnoreCase("y")) {
            beginGame();
        } else {
            System.out.println("Come whenever you are Interested");
        }
    }

    public static void beginGame() throws Exception {
        // The game begins
        Player HumanPlayer = new Player("Human", new Hand());
        Player ComputerPlayer = new Player("Computer", new Hand());
        System.out.println("Great ! Let the game begin !!!");
        System.out.println("Shuffling and Dealing cards...");
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println(HumanPlayer.toString());
        System.out.println("Computer has " + ComputerPlayer.GetPlayerHandSize() + " Cards");
        //System.out.println(ComputerPlayer.toString());
        System.out.println("The Current Card Played on the table is " + Hand.PlayedCard);
        //System.out.println(Hand.DeckOfCards.DeckSize());
//        for (Card C : HumanPlayer.PlayerHand.CardsinHand
//                ) {
//            //sSystem.out.println("Checking...");
//            if (ComputerPlayer.PlayerHand.CardsinHand.contains(C)) {
//                System.out.println("Stop program , error in Dealing Card" + C.toString() + "common in boths");
//
//            }

            while (true)
                // check if you already have a winner
                {
                    if (HumanPlayer.PlayerHand.CardInHandSize() == 0) // HUman won
                    {
                        System.out.println("You Won!!");
                        break;
                    }
                    else if ((ComputerPlayer.PlayerHand.CardInHandSize() == 0)) // computer won
                    {
                        System.out.println("Computer Won!.. Better Luck Next Time");
                        break;
                    }
                    else if (Hand.DeckOfCards.DeckSize() == 0)
                    {
                        // calculate the points and declare winner
                        if (HumanPlayer.PlayerHand.CalculateHandTotalPoint(HumanPlayer.PlayerHand.CardsinHand)<ComputerPlayer.PlayerHand.CalculateHandTotalPoint(ComputerPlayer.PlayerHand.CardsinHand)) {
                            System.out.println("Computer Won!.. Better Luck Next Time");
                        }
                        else{
                            System.out.println("You Won!!");
                        }
                            break;

                    }
                     // continue the game
                    else {
                        HumanPlayer = READCARD(HumanPlayer);
                        Hand.PlayedCard = DiscarDdeck.DeckOfCard.pop();

                        System.out.println("You Played " + Hand.PlayedCard);
                        System.out.println("You got cards " + HumanPlayer.PlayerHand.CardsinHand);
                        ComputerPlayer = COMPUPLAY(ComputerPlayer);
                        Hand.PlayedCard = DiscarDdeck.DeckOfCard.pop();
                        System.out.println("Computer Played " + Hand.PlayedCard);
                        System.out.println("Computer got cards "+ComputerPlayer.PlayerHand.CardsinHand);

                        //


                }


            }
        }


    public static Player READCARD(Player P) {
        // ask the human which card he wants to play
        Boolean Flag = true;
        Card card1 = new Card("Spades_1");
        while (Flag) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("User Turn : Which Card do you want to play? OR type D to draw");
            String HumanInput = scanner.next();
            if (HumanInput.equalsIgnoreCase("D")) {
                // draw a card
                card1 = Hand.DeckOfCards.DealCard();
                P.PlayerHand.CardsinHand.add(card1);
                System.out.println("you got " + card1);
                System.out.println("Your card set " + P.PlayerHand.CardsinHand);
                System.out.println(Hand.DeckOfCards.DeckSize());

            } else {
                card1 = new Card(HumanInput);
                //Card HumanInput1 = new Card(HumanInput);
                // Validation of Human input
                // added hasmap. the Checlegal card was returining boolean. Modified to Hasmap to update the
                // handsplayed card
                //if (P.CheckCardinHand(card1))
                //{ // human picked a card from his hand
                    // again check if that is legal
                    if (card1.CheckLegalCard(card1,Hand.PlayedCard,P))
                    {
                        P.PlayerHand.RemoveCardFromHand(card1);
                        DiscarDdeck.AddCard(card1);
                        Flag = false;
                    }

                    else
                    {
                        System.out.println("This is not a legal card");
                    }
                   // return card1;

                }
//                else
//                {
//                    System.out.println("Card is not in ur current  Hand, please input valid card... Dont cheat ");
//                }

//            }

        }
        return P;
    }


    public static Player COMPUPLAY(Player ChOMOO) {
        Boolean Flag = true;
        while (Flag) {
            for (Card CP : ChOMOO.PlayerHand.CardsinHand) {
                if (CP.CheckLegalCard(CP, Hand.PlayedCard,ChOMOO)) {
                    ChOMOO.PlayerHand.RemoveCardFromHand(CP);
                    DiscarDdeck.AddCard(CP);
                    //System.out.println(ChOMOO.PlayerHand.CardsinHand);
                    Flag = false;
                    break;
                }
            }

            if (Flag)

            {
                if (Hand.DeckOfCards.DeckSize() != 0) {
                    Card card11 = new Card("1_1");
                    card11 = Hand.DeckOfCards.DealCard();
                    ChOMOO.PlayerHand.CardsinHand.add(card11);
                    System.out.println(Hand.DeckOfCards.DeckSize());
                    System.out.println("Computer drew " + card11);
                    //System.out.println("Computer card set " + ChOMOO.PlayerHand.CardsinHand);

                } else {
                    Flag = false;
                    // calculate points
                }
            }
        }
        return ChOMOO;


    }

}

