package com.example.inscryption.Controller;

import com.example.inscryption.Model.Board;
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
    Board board = new Board();

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
        boolean gameIsRunning = true;
        boolean playerTurn = true;
        masterDeck.shuffle();
        while (playerHand.size() < 3){
            playerHand.add(masterDeck.drawCard());
        }
        while(gameIsRunning){
            if (playerTurn) {
                playerHand.add(masterDeck.drawCard());
                takeTurn();
                endTurn();
                //show board at end
                playerTurn = false;
            } else {
                computerHand.add(masterDeck.drawCard());
                //playCards();
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
//Beast creatures.
        Card goblin = new Card(1, "Beast", "Goblin", 2, 1, "   ", "   ");
        Card HUNYBUNZ = new Card(4, "Beast", "Hunter", 0, 6, "   ", "   ");
        Card lizard = new Card(1, "Beast", "Lizard", 1, 1, "   "/*Poison? */, "   ");
        Card darren = new Card(6, "Beast", "Homeless", 0, 6, "   ", "   ");
        Card hogRidah = new Card(1, "Beast", "Zombie", 1, 2, "   ", "   ");

        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);
        masterDeck.addCard(goblin);


//my undead army is pogg and cute and i'm tired of the backlash
        Card zombie = new Card(1, "Undead", "Zombie", 1, 2, "   ", "   ");
        Card skeleton = new Card(2, "Undead", "Skeleton", 2, 1, "   ", "   ");
        Card skeletonArcher = new Card(2, "Undead", "Skeleton Archer", 3, 1, "   ", "   ");
                    //special needed
        Card necromancer = new Card(4, "Unundead", "Necromancer", 0, 1, "   ", "   ");
                    //could have flying or some ghost ability
        Card ghost = new Card(3, "Undead", "Ghost", 2, 2, "   ", "   ");
        Card wraith = new Card(4, "Undead", "Wraith", 4, 2, "   ", "   ");
                    //maybe add that revenant resurrects after died, but like, weaker. or kills what killed it.
        Card revenant = new Card(5, "Undead", "Revenant", 2, 5, "   ", "   ");
        Card ghoul = new Card(5, "Undead", "Ghoul", 2, 5, "   ", "   ");
        Card lich = new Card(5, "Undead", "Lich", 2, 5, "   ", "   ");
        Card mummy = new Card(5, "Undead", "Mummy", 2, 5, "   ", "   ");

        masterDeck.addCard(zombie);
        masterDeck.addCard(skeleton);
        masterDeck.addCard(skeletonArcher);
        masterDeck.addCard(necromancer);
        masterDeck.addCard(ghost);
        masterDeck.addCard(wraith);
        masterDeck.addCard(revenant);
        masterDeck.addCard(ghoul);
        masterDeck.addCard(lich);
        masterDeck.addCard(mummy);


//unnatural horrors
        Card angryBread = new Card(1, "Horror", "AngryBread", 1, 2, "   ", "   ");
        Card noodleFarmMassacure = new Card(1, "Horror", "Noodle", 1, 2, "   ", "   ");
        Card crookedPicture = new Card(1, "Horror", "Picture", 1, 2, "   ", "   ");
        Card aDogThatLooksLikeACat = new Card(1, "Horror", "CatDog", 1, 2, "   ", "   ");
        Card gearlessBike = new Card(1, "Horror", "Bike", 1, 2, "   ", "   ");
        Card combedSpeghetti = new Card(1, "Horror", "Spahgetti", 1, 2, "   ", "   ");
        Card wetSocks = new Card(1, "Horror", "WetSocks", 1, 2, "   ", "   ");
        Card whiteOreos = new Card(1, "Horror", "WhiteOreos", 1, 2, "   ", "   ");
        Card fingersThatAreTooLong = new Card(1, "Horror", "Fingers", 1, 2, "   ", "   ");
        Card wipingYourButtSideways = new Card(1, "Horror", "ButtHole", 1, 2, "   ", "   ");

        masterDeck.addCard(angryBread);
        masterDeck.addCard(noodleFarmMassacure);
        masterDeck.addCard(crookedPicture);
        masterDeck.addCard(aDogThatLooksLikeACat);
        masterDeck.addCard(gearlessBike);
        masterDeck.addCard(combedSpeghetti);
        masterDeck.addCard(wetSocks);
        masterDeck.addCard(whiteOreos);
        masterDeck.addCard(fingersThatAreTooLong);
        masterDeck.addCard(wipingYourButtSideways);

//Techno "creatures"? idk but they use tecknowlogy
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//        Card robot = new Card(1, "Tech", "Zombie", 1, 2, "   ", "   ");
//
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//
////The classic magic deck... maybe not suck this time?
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//        Card mage = new Card(1, "Magic", "Mage", 1, 2, "   ", "   ");
//
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);
//        masterDeck.addCard(robot);


    }

    public void takeTurn() {
        boolean turn = true;
        while (!playerHand.isEmpty() && turn) {
                printBoard();
                printCards(playerHand);
                switch(menu.turnMenu()) {
                    case 1:
                        playCard();
                        break;
                    case 5:
                        turn = false;
                        break;
                }
            }
    }

    private void playCard() {

    }

    private void printBoard() {
        printCards(board.getComputerBoard());
        printCards(board.getPlayerBoard());
    }

    public void endTurn(){

    }
}