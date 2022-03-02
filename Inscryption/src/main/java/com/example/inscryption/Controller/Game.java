package com.example.inscryption.Controller;

import com.example.inscryption.Model.Deck;
import com.example.inscryption.Model.Card;
import com.example.inscryption.View.Menu;

import java.util.ArrayList;

//TODO
/*
add creatures
get board set up
Blank card
attacks
player hp / enemy hp
spells
mana mechanics
energy system -- maybe add more later.
card specials + symbols
winning/losing
points? - in case we need persistent high score
card packs? - if we have time and want to -- tied to persistent player deck
turn order
deck size
?bosses with pre-built decks? -> levels?? -> Boss unique cards?

 */

public class Game {
    Menu menu = new Menu();
    Deck masterDeck = new Deck();

    ArrayList<Card> playerHand = new ArrayList<>();
    ArrayList<Card> computerHand = new ArrayList<>();

    public void start(){
        createCreatures();

        switch(menu.startMenu()) {
            case 1:
                initGame();
                break;
            case 5:
                System.out.println("Exit successful, this time...");
                break;
        }
    }

    public void initGame(){
        Boolean gameIsRunning = true;
        Boolean playerTurn = true;
        masterDeck.shuffle();
        while (playerHand.size() < 3){
            playerHand.add(masterDeck.drawCard());
        }
        while(gameIsRunning){
            if (playerTurn) {
                playerHand.add(masterDeck.drawCard());
                playCards();
                endTurn();
                //show board at end
                playerTurn = false;
            } else {
                computerHand.add(masterDeck.drawCard());
                playCards();
                endTurn();
                //show board
                playerTurn = true;
            }
        }
    }

    public void printCards(ArrayList<Card> cards) {
        //Prints cards next to each other line by line.

        String CardTop = "";
        String firstLine = "";
        String blankSpace = "";
        String specialLine = "";
        String secondLine = "";
        String thirdLine = "";
        String cardBottom = "";
        for (int i = 0; i < cards.size(); i++) {


            CardTop += "┌──────────┐";
            firstLine += "│" + cards.get(i).getName();
            blankSpace += "│          │";
            specialLine += "│" + cards.get(i).getSpecial1() + "   " + cards.get(i).getSpecial2() + " │";
            secondLine += "│" + cards.get(i).getAtk() + "/" + cards.get(i).getHp() + "       │";
            thirdLine += "│" + cards.get(i).getCost() + "         │";
            cardBottom += "└──────────┘";

            //╚══════╝


            for (int j = 0; j < (10 - cards.get(i).getName().length()); j++) {
                firstLine += " ";
            }

            firstLine += "│";
        }
        CardTop += "\n";
        firstLine += "\n";
        blankSpace += "\n";
        specialLine += "\n";
        secondLine += "\n";
        thirdLine += "\n";


        System.out.println(CardTop + firstLine + blankSpace + specialLine + secondLine + thirdLine + cardBottom);
    }




    public void createCreatures(){
        //Creatures to be used in the game
        Card goblin = new Card(1, "Goboboblin", "Goblin", 2, 1, "   ", "   ");
        Card HUNYBUNZ = new Card(4, "Beast", "Hunter", 0, 6, "   ", "   ");
        Card lizard = new Card(1, "Beast", "Lizard", 1, 1, "   "/*Poison? */, "   ");
        Card darren = new Card(6, "Beast", "Homeless", 0, 6, "   ", "   ");
        Card zombie = new Card(1, "Beast", "Zombie", 1, 2, "   ", "   ");

        masterDeck.addCard(goblin);
        masterDeck.addCard(HUNYBUNZ);
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();
        masterDeck.addCard();

    }

    public void playCards() {
        boolean turn = true;
        while (turn) {
                printCards(playerHand);
            }

    }
    public void endTurn(){

    }
}
