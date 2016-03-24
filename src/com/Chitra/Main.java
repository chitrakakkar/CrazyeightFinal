package com.Chitra;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public  class Main
{
    //main method starts
    // a discard deck object created, adds cards played on the table
    public static DiscardDeck DiscarDdeck = new DiscardDeck();

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the crazy eight game between a computer and a human player ");
        System.out.println("*******************************************************************");
        System.out.println("Would you be interested in playing with a computer?(Y/N)");
        String UserInput = scanner.nextLine();
        if (UserInput.equalsIgnoreCase("y")) {
            beginGame(); // a user defined method to begin the game
        } else {
            System.out.println("Come whenever you are Interested");
        }
    }

    public static void beginGame() throws Exception
    {
        // The game begins
        // creating two player objects
        Player HumanPlayer = new Player("Human", new Hand());
        Player ComputerPlayer = new Player("Computer", new Hand());
        System.out.println("Great ! Let the game begin !!!");
        System.out.println("Shuffling and Dealing cards...");
        TimeUnit.MILLISECONDS.sleep(2000); // stack-over flow to delay the print
        System.out.println(HumanPlayer.toString());
        System.out.println("Computer has " + ComputerPlayer.GetPlayerHandSize() + " Cards"); // prints number of cards in computer hand
        //System.out.println(ComputerPlayer.toString());
        System.out.println("The Current Card Played on the table is " + Hand.PlayedCard);

            // loop iterates till the players handsize or deck size becomes 0
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
                    // calculates point when the deck becomes empty and declares the winner with least point
                    else if (Hand.DeckOfCards.DeckSize().equals(0))
                    {
                        // calculate the points and declare winner
                        if (HumanPlayer.PlayerHand.CalculateHandTotalPoint(HumanPlayer.PlayerHand.CardsinHand)>ComputerPlayer.PlayerHand.CalculateHandTotalPoint(ComputerPlayer.PlayerHand.CardsinHand)) {
                            System.out.println("Computer Won!.. Better Luck Next Time and its points are " + ComputerPlayer.PlayerHand.CalculateHandTotalPoint(ComputerPlayer.PlayerHand.CardsinHand));
                        }
                        else{
                            System.out.println("You Won!! and your point is "+ HumanPlayer.PlayerHand.CalculateHandTotalPoint(HumanPlayer.PlayerHand.CardsinHand ));
                        }
                            break;

                    }
                     // continue the game if the deck size or handsize of the player not 0
                    else
                    {
                        // a method to read the human player's hand
                        HumanPlayer = READCARD(HumanPlayer);
                        Hand.PlayedCard = DiscarDdeck.DeckOfCard.pop(); // popping first card from the discard card to display the played card

                        System.out.println("You Played " + Hand.PlayedCard);
                        System.out.println("You got cards " + HumanPlayer.PlayerHand.CardsinHand);
                        ComputerPlayer = COMPUPLAY(ComputerPlayer); // a method to read computer player's hand
                        Hand.PlayedCard = DiscarDdeck.DeckOfCard.pop();
                        System.out.println("Computer Played " + Hand.PlayedCard);
                        //System.out.println("Computer got cards "+ComputerPlayer.PlayerHand.CardsinHand);
                }
            }
        }
    // method definition for Human player

    public static Player READCARD(Player P)
    {
        // ask the human which card he wants to play
        Boolean Flag = true;
        Card card1 = new Card("Spades_1");
        while (Flag)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("User Turn : Which Card do you want to play? OR type D to draw");
            String HumanInput = scanner.next();
            if (HumanInput.equalsIgnoreCase("D"))
            {
                // draw a card
                card1 = Hand.DeckOfCards.DealCard();
                P.PlayerHand.CardsinHand.add(card1); // adding card back to his hand
                System.out.println("you got " + card1);
                System.out.println("Your card set " + P.PlayerHand.CardsinHand); // printing the hand
                //System.out.println(Hand.DeckOfCards.DeckSize());

            } else
            {
                // play the card from the hand;not draw
                card1 = new Card(HumanInput);
                //Card HumanInput1 = new Card(HumanInput);
                // Validation of Human input
                // added hasmap. the Checlegal card was returning boolean. Modified to Hasmap to update the
                // handsplayed card
                //if (P.CheckCardinHand(card1))
                //{ // human picked a card from his hand
                    // again check if that is legal
                    if (card1.CheckLegalCard(card1,Hand.PlayedCard,P)) // check if the played card is legal to play
                    {
                        P.PlayerHand.RemoveCardFromHand(card1); // delete the card from hand
                        DiscarDdeck.AddCard(card1); // adding the deleted card in the discard deck in case wants to play again
                        Flag = false;
                    }

                    else
                    {
                        System.out.println("This is not a legal card");
                    }
                }


        }
        return P;
    }

    public static Player COMPUPLAY(Player ChOMOO)
    { // method to check computer play
        Boolean Flag = true;
        while (Flag)
        {
            for (Card CP : ChOMOO.PlayerHand.CardsinHand)
            {
                if (CP.CheckLegalCard(CP, Hand.PlayedCard,ChOMOO)) // check if compter plays a legal card
                {
                    ChOMOO.PlayerHand.RemoveCardFromHand(CP); // remove if yes
                    System.out.println("Computer has " + ChOMOO.GetPlayerHandSize() + " Cards"); // display the computer hand size
                    DiscarDdeck.AddCard(CP); // add the removed card to the discard deck
                    Flag = false;
                    break;
                }
            }

            if (Flag)
            {
                //when computer draws the card
                if (Hand.DeckOfCards.DeckSize() != 0) {
                    Card card11 = new Card("1_1");
                    card11 = Hand.DeckOfCards.DealCard();
                    ChOMOO.PlayerHand.CardsinHand.add(card11);
                    //System.out.println(Hand.DeckOfCards.DeckSize());
                    System.out.println("Computer drew " + card11); // for the reference.. need to be masked in real play

                } else
                {
                    Flag = false;
                }
            }
        }
        return ChOMOO;

    }

}

