package com.example.inscryption.Controller;

import com.example.inscryption.Model.*;
import com.example.inscryption.View.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Menu menu = new Menu();
    private Deck masterDeck = new Deck();
    private Board board = new Board();
    private Random random = new Random();

    /**
     * Checks to see if Save File exists, if it exists we return the saved object, otherwise return a new empty object
     * @return
     */
    private Human setUpHuman(){
        File file = new File("SaveData.txt");
        try {
            if(file.createNewFile()){

            } // Try to create new file, if it fails, file already exists, and we need to read the data from it.
            else{
                menu.print("Found Save File!");
                if(file.length() > 1){
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Human player = (Human)ois.readObject();
                    fis.close();
                    return player;
                }
                else {
                    menu.print("Save File Has No Data");
                }
            }
        }
        catch (Exception e){
            menu.print("Save File Corrupted, Please Clear or delete the SaveData.txt file");
        }
        Human player = new Human();
        return player;
    }

    /**
     * Initializes and starts game with appropriate methods
     */
    public void start(){
        boolean gaming = true;
        createCreatures();
        Human player = setUpHuman();
        Computer computer = createComputer();
        while (gaming) {
            board = new Board();
            switch (menu.startMenu()) {
                case 1:
                    chooseDeck(player);
                    initGame(player, computer);
                    break;
                case 2:
                    menu.print("It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armoured space station with enough power to destroy an entire planet. \n" +
                            "\n" +
                            "Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy….");
                    break;
                case 3:
                    cardShop(player);
                    break;
                case 4:
                    makeDeck(player);
                    break;
                case 5:
                    save(player);
                    menu.print("Exit successful, this time...");
                    gaming = false;
                    break;
            }
        }
    }

    /**
     * Checks if Custom Decks exist
     * @param player
     */
    private void chooseDeck(Human player) {
        if(player.getMadeDecks().isEmpty()) {
            Deck starterDeck = new Deck(cloneDeck(masterDeck), "Starter Deck");
            player.setPlayerDeck(starterDeck);
            player.getMadeDecks().add(starterDeck);
        } else {
            int chosenDeck = menu.chooseDeck(player.getMadeDecks());
            player.setPlayerDeck(new Deck(cloneDeck(player.getMadeDecks().get(chosenDeck)), player.getMadeDecks().get(chosenDeck).getName()));
        }
    }

    private ArrayList<Card> cloneDeck(Deck deck) {
        ArrayList<Card> deckCopy = new ArrayList<>();
        for (int i = 0; i < deck.getDeck().size(); i++) {
            deckCopy.add(deck.getDeck().get(i).clone());
        }
        return deckCopy;
    }

    /**
     * Creates and returns Computer Player
     * @return
     */
    private Computer createComputer() {
        Computer computer = new Computer();
        computer.setPlayerDeck(new Deck(cloneDeck(masterDeck), "Computer Deck"));
        computer.setHuman(false);
        for (int i = 0; i < 2; i++) {
            computer.drawCard();
        }
        return computer;
    }

    /**
     * Allows player to take in cards purchased from shop and create custom deck of purchased cards
     * @param player
     */
    private void makeDeck(Human player) {
        ArrayList<Card> newDeck = new ArrayList<>();
        if (!player.getOwnedCards().isEmpty()) {
            boolean editing = true;
            String numbers = "     ";
            while(editing) {
                switch (menu.deckEditor()) {
                    case 1:
                        menu.printCards(player.getOwnedCards());
                        numbers = "     ";
                        for (int i = 0; i < player.getOwnedCards().size(); i++) {
                            numbers += i + "         ";
                        }
                        menu.print(numbers);
                        newDeck.add(player.getOwnedCards().get(menu.getInt(0, player.getOwnedCards().size(), "Which card would you like to add?")).clone());
                        break;
                    case 2:
                        menu.printCards(newDeck);
                        numbers = "     ";
                        for (int i = 0; i < newDeck.size(); i++) {
                            numbers += i + "         ";
                        }
                        menu.print(numbers);
                        newDeck.remove(menu.getInt(0, newDeck.size(), "Which card would you like to remove?"));
                        break;
                    case 3:
                        menu.printCards(newDeck);
                        break;
                    case 4:
                        String deckName = menu.getString("Enter a name for the deck");
                        player.getMadeDecks().add(new Deck(newDeck, deckName));
                        editing = false;
                        break;
                }
            }
        } else {
            menu.print("You don't own any cards to make a deck");
        }
    }

    /**
     *creates an appeal to the gods, hopefully you're in their favor (if you are you draw a card if you arent you lose 5 hp)
     * @param player
     */
    private void pray(Human player) {
        int answer = random.nextInt(2);
        switch (answer) {
            case 0:
                menu.print("your prayers have been answered");
                if (masterDeck.getDeck().isEmpty()) {
                    createCreatures();
                    masterDeck.shuffle();
                }
                player.addCardToHand(masterDeck.drawCard());
                break;
            case 1:
                menu.print("your prayers were unheard");
                player.setHp(player.getHp() - 5);
                break;
        }

    }

    /**
     * Resets Stats after a game is completed
     * @param player players that get passed through to get their health and mana reset for next game
     * @param computer
     */

    private void resetPlayers(Human player, Computer computer) {
        player.setHp(20);
        computer.setHp(20);
        player.setHand(new ArrayList<Card>());
        computer.setHand(new ArrayList<Card>());
        player.setMana(0);
        computer.setMana(0);
        player.setCurrentMana(0);
        computer.setCurrentMana(0);
        computer.setPlayerDeck(new Deck(cloneDeck(masterDeck), "Computer Deck"));
    }

    /**
     * Sets Game Up
     */
    private void initGame(Human player, Computer computer) {
        boolean gameIsRunning = true, playerTurn = true, playerWin = false, computerWin = false, initialDraw = true;
        masterDeck.shuffle();
        resetPlayers(player,computer);
        while (player.getHand().size() < 3 && initialDraw) {
            if (!player.getPlayerDeck().getDeck().isEmpty()) {
                player.drawCard();
            } else {
                initialDraw = false;
            }
        }
        while (gameIsRunning) {
            if (playerTurn) {
                if(!player.getPlayerDeck().getDeck().isEmpty()) {
                    player.drawCard();
                }
                player.setMana(player.getMana() + 1);
                player.setCurrentMana(player.getMana());
                takeTurn(player, computer);
                endTurn(1, player, computer);
                playerWin = checkWin(computer);
                playerTurn = false;
            } else {
                if(!computer.getPlayerDeck().getDeck().isEmpty()) {
                    computer.drawCard();
                }
                computer.setMana(computer.getMana() + 1);
                computer.setCurrentMana(computer.getMana());
                compTurn(computer);
                endTurn(2, player, computer);
                computerWin = checkWin(player);
                playerTurn = true;
            }
            gameIsRunning = !playerWin && !computerWin;
        }
        if (playerWin) {
            //win
            menu.print("You don' defeatified your badguy!!");
            menu.print("You got 1 shmeckle(goldboi for bying good shtuff)");
            player.setGold(player.getGold() + 1);
        } else {
            //loss
            menu.print("WelcOomeE to dead(un-life), you did great at doing bad!!");
        }
    }

    /**
     * god has created enemies to destroy you. (Creates the cards for the game)
     */
    private void createCreatures() {
        //Beast creatures.
        Card goblin = new Card(1, "Beast", "Goblin", 2, 1, "   ", "   ");
        Card HUNYBUNZ = new Card(4, "Beast", "Hunter", 0, 6, "   ", "   ");
        Card lizard = new Card(1, "Beast", "Lizard", 1, 1, "   ", "   ");
        Card wolf = new Card(2, "Beast", "Wolf", 2, 3, "   ", "   ");
        Card hogRider = new Card(1, "CofC", "Hog Rider", 1, 2, "   ", "   ");
        Card squirl = new Card(0, "Beast", "Squirl", 1, 1, "   ", "   ");
        Card bear = new Card(4, "Beast", "Bear", 4, 6, "   ", "   ");
        Card gremlin = new Card(1, "Beast", "Gremlin", 1, 2, "   ", "   ");
        Card turtle = new Card(3, "Beast", "Turtle", 1, 5, "   ", "   ");
        Card porcupine = new Card(3, "Beast", "Porcupine", 2, 4, "   ", "   ");
        Card bird = new Card(1, "Beast", "Bird", 2, 1, "   ", "   ");

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
        Card ghoul = new Card(2, "Undead", "Ghoul", 2, 2, "   ", "   ");
        Card lich = new Card(3, "Undead", "Lich", 4, 2, "   ", "   ");
        Card mummy = new Card(2, "Undead", "Mummy", 1, 3, "   ", "   ");

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

        //Techno Deck
        Card robot = new Card(2, "Tech", "Robot", 2, 2, "   ", "   ");
        Card toaster = new Card(1, "Tech", "Toaster?", 1, 1, "   ", "   ");
        Card computer = new Card(5, "Tech", "Computer", 5, 3, "   ", "   ");
        Card lazerGun = new Card(3, "Tech", "Lazer Gun", 3, 1, "   ", "   ");
        Card cyborg = new Card(3, "Tech", "Cyborg", 3, 3, "   ", "   ");
        Card scrapDroid = new Card(1, "Tech", "ScrapDroid", 2, 1, "   ", "   ");
        Card welderBot = new Card(2, "Tech", "WelderBot", 2, 1, "   ", "   ");
        Card cyberBully = new Card(2, "Tech", "CyberBully", 4, 1, "   ", "   ");
        Card meanText = new Card(1, "Tech", "Mean Text", 1, 1, "   ", "   ");
        Card battery = new Card(3, "Tech", "Battery", 2, 2, "   ", "   ");

        masterDeck.addCard(robot);
        masterDeck.addCard(toaster);
        masterDeck.addCard(computer);
        masterDeck.addCard(lazerGun);
        masterDeck.addCard(cyborg);
        masterDeck.addCard(scrapDroid);
        masterDeck.addCard(welderBot);
        masterDeck.addCard(cyberBully);
        masterDeck.addCard(meanText);
        masterDeck.addCard(battery);

    }

    /**
     * computer takes a turn
     */
    private void compTurn(Computer computer) {
        boolean compTurn = true;
        boolean canPlay;
        while (!computer.getHand().isEmpty() && compTurn) {
            canPlay = false;
            for (int i = 0; i < computer.getHand().size(); i++) {
                if (computer.getHand().get(i).getCost() <= computer.getCurrentMana()) {
                    canPlay = true;
                }
            }
            if (canPlay) {
                playCard(computer, random.nextInt(computer.getHand().size()));
            } else {
                compTurn = false;
            }
        }
    }

    /**
     * well, if your hand dunt be empty then you get a menucitto of what you can doer. once you doer it doe'd (Turn logic)
     * @param player
     * @param computer
     */
    private void takeTurn(Human player, Computer computer) {
        boolean turn = true;
        while (!player.getHand().isEmpty() && turn) {
            printBoard();
            menu.printCards(player.getHand());
            switch (menu.turnMenu(player, computer,player.getPlayerDeck())) {
                case 1:
                    playCard(player, menu.getInt(1, player.getHand().size(), "Pick a card, any card!") - 1);
                    break;
                case 2:
                    pray(player);
                    break;
                case 3:
                    menu.displayRules();
                    break;
                case 4:
                    turn = false;
                    break;
            }
        }
    }

    /**
     * Method to play a card from player
     *
     * @param player     Passes through player to select
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
                menu.print("Not enough Manas in your pockets");
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
     *
     * @param player
     * @return
     */
    private boolean checkWin(Player player) {
        if (player.getHp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * deals damage to cards/computer/player and removes un-alive cards and checks for win
     *
     * @param turn
     */
    private void endTurn(int turn, Human player, Computer computer) {
        if (turn == 1) {
            for (int i = 0; i < board.getPlayerBoard().size(); i++) {
                try {
                    board.getComputerBoard().get(i).setHp(board.getComputerBoard().get(i).getHp() - board.getPlayerBoard().get(i).getAtk());
                } catch (IndexOutOfBoundsException e) {
                    computer.setHp(computer.getHp() - board.getPlayerBoard().get(i).getAtk());
                }
            }
        } else if (turn == 2) {
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

    /**
     * lets player buy card packs using gold they've earned from the blood of their fallen foes.
     * @param player
     */
    private void cardShop(Human player) {
        if (player.getGold() == 0) {
            menu.print("You dont have any gold");
        } else {
            while (player.getGold() > 0) {
                switch (menu.getInt(1, 2, "Oh hello... " +
                        "Would you like to buy a card pack? \n " +
                        "1: Duh! my points expire! \n " +
                        "2: Nah, I don't make strategies")) {
                    case 1:
                            player.setGold(player.getGold() - 1);
                        for (int i = 0; i < 3; i++) {
                            player.getOwnedCards().add(masterDeck.getDeck().get(random.nextInt(masterDeck.getDeck().size())).clone());
                            menu.print("You got: " + player.getOwnedCards().get(player.getOwnedCards().size() - 1).getName());
                        }
                        break;
                    case 2:
                        start();
                        break;

                }
            }
        }
    }

    /**
     * saves earned cards persistently
     * @param player
     */
    private void save(Human player) {
        File file = new File("SaveData.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(player);
            outputStream.close();
        } catch (IOException e) {
            menu.print("Tried to save to a file that doesnt exist");
        }
    }
}

