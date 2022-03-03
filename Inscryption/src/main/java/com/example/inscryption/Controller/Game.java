package com.example.inscryption.Controller;

import com.example.inscryption.Model.Board;
import com.example.inscryption.Model.Deck;
import com.example.inscryption.Model.Card;
import com.example.inscryption.Model.Player;
import com.example.inscryption.View.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

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
    Player player = new Player();
    Player computer = new Player();


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
        while (player.getHand().size() < 3){
            player.addCardToHand(masterDeck.drawCard());
        }
        while(gameIsRunning){
            if (playerTurn) {
                player.addCardToHand(masterDeck.drawCard());
                player.setMana(player.getMana() + 1);
                player.setCurrentMana(player.getMana());
                takeTurn();
                endTurn(1);
                playerTurn = false;
            } else {
                computer.addCardToHand(masterDeck.drawCard());
                computer.setMana(computer.getMana() + 1);
                computer.setCurrentMana(computer.getMana());

                compTurn();
                //playCards();
                endTurn(2);
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
        Card lizard = new Card(1, "Beast", "Lizard", 1, 1, "   ", "   ");
        Card wolf = new Card(6, "Beast", "Wolf", 0, 6, "   ", "   ");
        Card hogRider = new Card(1, "Centaur", "Hog Rider", 1, 2, "   ", "   ");
        Card squirl = new Card(1, "Beast", "Squirl", 1, 2, "   ", "   ");
        Card bear = new Card(1, "Beast", "Bear", 1, 2, "   ", "   ");
        Card gremlin = new Card(1, "Beast", "Gremlin", 1, 2, "   ", "   ");
        Card turtle = new Card(1, "Beast", "Turtle", 1, 2, "   ", "   ");
        Card porcupine = new Card(1, "Beast", "Porcupine", 1, 2, "   ", "   ");
        Card bird = new Card(1, "Beast", "Bird", 1, 2, "   ", "   ");

        masterDeck.addCard(goblin);
        masterDeck.addCard(HUNYBUNZ);
        masterDeck.addCard(lizard);
        masterDeck.addCard(wolf);
        masterDeck.addCard(hogRider);
        masterDeck.addCard(squirl);
        masterDeck.addCard(bear);
        masterDeck.addCard(gremlin);
        masterDeck.addCard(turtle);
        masterDeck.addCard(porcupine);
        masterDeck.addCard(bird);


//my undead army is pogg and cute and i'm tired of the backlash
        Card zombie = new Card(1, "Undead", "Zombie", 1, 2, "   ", "   ");
        Card skeleton = new Card(2, "Undead", "Skeleton", 2, 1, "   ", "   ");
        Card skeletonArcher = new Card(2, "Undead", "Skel Arch", 3, 1, "   ", "   ");
                    //special needed
        Card necromancer = new Card(4, "Unundead", "Necromanca", 0, 1, "   ", "   ");
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
        Card mopMan = new Card(1, "Horror", "Mop Man", 1, 2, "   ", "   ");
        Card bread = new Card(1, "Horror", "Bread?", 1, 2, "   ", "   ");
        Card yourMom = new Card(1, "Horror", "YOUR MOM", 1, 2, "   ", "   ");
        Card coldPockets = new Card(1, "Horror", "Cold Pockets", 1, 2, "   ", "   ");
        Card poopernuf = new Card(1, "Horror", "Poopernuf", 1, 2, "   ", "   ");
        Card spahgeghti = new Card(1, "Horror", "Spahgeghti", 1, 2, "   ", "   ");
        Card wetSocks = new Card(1, "Horror", "WetSocks", 1, 2, "   ", "   ");
        Card whiteOreos = new Card(1, "Horror", "WhiteOreos", 1, 2, "   ", "   ");
        Card tingyFingy = new Card(1, "Horror", "TingyFingy", 1, 2, "   ", "   ");
        Card tacobell = new Card(1, "Horror", "Taco Bell", 1, 2, "   ", "   ");

        masterDeck.addCard(mopMan);
        masterDeck.addCard(bread);
        masterDeck.addCard(yourMom);
        masterDeck.addCard(coldPockets);
        masterDeck.addCard(poopernuf);
        masterDeck.addCard(spahgeghti);
        masterDeck.addCard(wetSocks);
        masterDeck.addCard(whiteOreos);
        masterDeck.addCard(tingyFingy);
        masterDeck.addCard(tacobell);

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

    public void compTurn(){
        boolean compTurn = true;
        Random compRan = new Random();
        while (!computer.getHand().isEmpty() && compTurn){
            for (int i = 0; i < computer.getHand().size(); i++) {

            }

        }
    }

    public void takeTurn() {
        boolean turn = true;
        while (!player.getHand().isEmpty() && turn) {
                printBoard();
                printCards(player.getHand());
                switch(menu.turnMenu(player, computer)) {
                    case 1:
                        playCard();
                        break;
                    case 4:
                        menu.displayRules();
                        break;
                    case 5:
                        turn = false;
                        break;
                }
            }
    }

    private void playCard() {
        int cardToPlay = menu.getInt(1, player.getHand().size(), "Pick a card") - 1;
        if (player.getHand().get(cardToPlay).getCost() <= player.getCurrentMana()) {
            board.addToPlayerBoard(player.getHand().get(cardToPlay));
            player.setCurrentMana(player.getCurrentMana() - player.getHand().get(cardToPlay).getCost());
            player.removeCardFromHand(player.getHand().get(cardToPlay));
        } else {
            System.out.println("Not enough Mana");
        }
    }

    private void printBoard() {
        printCards(board.getComputerBoard());
        printCards(board.getPlayerBoard());
    }

    public void endTurn(int turn){
        if(turn == 1) {
            for (int i = 0; i < board.getPlayerBoard().size(); i++) {
                try {
                    board.getComputerBoard().get(i).setHp(board.getComputerBoard().get(i).getHp() - board.getPlayerBoard().get(i).getAtk());
                } catch (IndexOutOfBoundsException e) {
                    computer.setHp(computer.getHp() - board.getPlayerBoard().get(i).getAtk());
                }
            }
        } else if(turn == 2) {
            for (int i = 0; i < board.getComputerBoard().size(); i++) {
                try {
                    board.getPlayerBoard().get(i).setHp(board.getPlayerBoard().get(i).getHp() - board.getComputerBoard().get(i).getAtk());
                } catch (IndexOutOfBoundsException e) {
                    player.setHp(player.getHp() - board.getComputerBoard().get(i).getAtk());
                }
            }
        }
    }
}
