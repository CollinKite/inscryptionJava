package com.example.inscryption.Controller;

import com.example.inscryption.Model.Board;
import com.example.inscryption.Model.Deck;
import com.example.inscryption.Model.Card;
import com.example.inscryption.Model.Player;
import com.example.inscryption.View.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Menu menu = new Menu();
    private Deck masterDeck = new Deck();
    private Board board = new Board();
    private Player player = new Player();
    private Player computer = new Player();


    /**
     * Initializes and starts game with appropriate methods
     */
    public void start(){
        boolean gaming = true;
        while(gaming) {
            if (masterDeck.getDeck().isEmpty()) {
                createCreatures();
            }
            board = new Board();
            player = new Player();
            computer = new Player();
            player.setHuman(true);
            computer.setHuman(false);
            switch (menu.startMenu()) {
                case 1:
                    initGame();
                    break;
                case 2:
                    System.out.println("It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armoured space station with enough power to destroy an entire planet. \n" +
                            "\n" +
                            "Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy….");
                    break;
                case 3:
                    System.out.println("Exit successful, this time...");
                    gaming = false;
                    break;
            }
        }
    }

    public void pray(){
        Random ranPray = new Random();
        int answer = ranPray.nextInt(2);
        switch (answer){
            case 0:
                System.out.println("your prayers have been answered");
                if(masterDeck.getDeck().isEmpty()) {
                    createCreatures();
                    masterDeck.shuffle();
                }
                player.addCardToHand(masterDeck.drawCard());
                break;
            case 1:
                System.out.println("your prayers were unheard");
                player.setHp(player.getHp() - 5);
                checkWin(player);
                break;
        }

    }

    /**
     * Sets Game Up
     */
    public void initGame(){
        boolean gameIsRunning = true, playerTurn = true, playerWin = false, computerWin = false;
        masterDeck.shuffle();
        while (player.getHand().size() < 3){
            if(masterDeck.getDeck().isEmpty()) {
                createCreatures();
                masterDeck.shuffle();
            }
            player.addCardToHand(masterDeck.drawCard());
        }
        while(gameIsRunning){
            if(masterDeck.getDeck().isEmpty()) {
                createCreatures();
                masterDeck.shuffle();
            }
            if (playerTurn) {
                player.addCardToHand(masterDeck.drawCard());
                player.setMana(player.getMana() + 1);
                player.setCurrentMana(player.getMana());
                takeTurn();
                endTurn(1);
                playerWin = checkWin(computer);
                playerTurn = false;
            } else {
                computer.addCardToHand(masterDeck.drawCard());
                computer.setMana(computer.getMana() + 1);
                computer.setCurrentMana(computer.getMana());
                compTurn();
                endTurn(2);
                computerWin = checkWin(player);
                playerTurn = true;
            }
            gameIsRunning = !playerWin && !computerWin;
        }
        if(playerWin) {
            //win
            System.out.println("You don' defeatified your badguy!!");
        } else {
            //loss
            System.out.println("You joined collin's dad (DEAD)");
        }
    }

    /**
     * creates all creatures and adds them to the deck
     */
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
        Card coldPockets = new Card(1, "Horror", "ColdPocket", 1, 2, "   ", "   ");
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

    }

    /**
     * computer takes a turn
     */
    public void compTurn(){
        boolean compTurn = true;
        Random compRan = new Random();
        boolean canPlay;
        while (!computer.getHand().isEmpty() && compTurn){
            canPlay = false;
            for (int i = 0; i < computer.getHand().size(); i++) {
                if(computer.getHand().get(i).getCost() <= computer.getCurrentMana()) {
                    canPlay = true;
                }
            }
            if(canPlay) {
                playCard(computer, compRan.nextInt(computer.getHand().size()));
            } else {
                compTurn = false;
            }
        }
    }

    /**
     * player turn.
     */
    public void takeTurn() {
        boolean turn = true;
        while (!player.getHand().isEmpty() && turn) {
                printBoard();
                menu.printCards(player.getHand());
                switch(menu.turnMenu(player, computer)) {
                    case 1:
                        playCard(player, menu.getInt(1, player.getHand().size(), "Pick a card, any card!") - 1);
                        break;
                    case 2:
                        pray();
                        break;
                    case 3:
                        menu.displayRules();
                        break;
                    case 4:
                        break;
                }
            }
    }

    /**
     * Method to play a card from player
     * @param player Passes through player to select
     * @param cardToPlay takes an int to select which card in selected players hand to play
     */
    private void playCard(Player player, int cardToPlay) {
        if (player.getHand().get(cardToPlay).getCost() <= player.getCurrentMana()) {
            if (player.isHuman()) {
                board.addToPlayerBoard(player.getHand().get(cardToPlay));
            } else {
                board.addToComputerBoard(player.getHand().get(cardToPlay));
            }
            player.setCurrentMana(player.getCurrentMana() - player.getHand().get(cardToPlay).getCost());
            player.removeCardFromHand(player.getHand().get(cardToPlay));
        } else {
            if (player.isHuman()) {
                System.out.println("Not enough Manas in your pockets");
            }
        }
    }

    /**
     * prints board according how the board prints
     */
    private void printBoard() {
        menu.printCards(board.getComputerBoard());
        menu.printCards(board.getPlayerBoard());
    }

    /**
     * checks for loss. haha just kidding. checks for win
     * @param player
     * @return
     */
    private boolean checkWin(Player player) {
        if(player.getHp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * deals damage to cards/computer/player and removes un-live cards and checks for win
     * @param turn
     */
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
        board.removeDeadCards();
    }
}
