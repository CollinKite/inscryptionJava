package com.example.inscryption.View;

import com.example.inscryption.Model.Card;
import com.example.inscryption.Model.Deck;
import com.example.inscryption.Model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner getAnswerInt = new Scanner(System.in);
    private BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));


    //Creates menu in a box
    public int startMenu() {
        List cardPos = new ArrayList<>(); //◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆  ◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇
        String cardTop =    "◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆╔═══════════╗◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆";
        String firstLine =  "◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇│1: New     │◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇";
        String blankSpace = "◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆│2: Credits │◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆";
        String secondLine = "◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇│3: Shop    │◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇";
        String specialLine ="◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆│4: MakeDeck│◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆";
        String thirdLine =  "◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇│5: Exit    │◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇";
        String cardBottom = "◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆╚═══════════╝◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆";

        cardPos.add(cardTop);
        cardPos.add(firstLine);
        cardPos.add(blankSpace);
        cardPos.add(secondLine);
        cardPos.add(specialLine);
        cardPos.add(thirdLine);
        cardPos.add(cardBottom);

        cardPos.forEach(System.out::println);
while (!getAnswerInt.hasNext("[12345]")){
    System.out.println("Enter a valid option");
    getAnswerInt.next();
}
int answer = getAnswerInt.nextInt();
return answer;
    }
    public void viewCredits(){

    }


    /**
     *  turn menu, also in a box, nice right
     * @param player
     * @param computer
     * @return
     */
    public int turnMenu(Player player, Player computer, Deck deck) {
        String cardTop =    "╔══════════╗\n";
        String firstLine =  "║1: Play   ║  Your HP: " +player.getHp() + "\n";
        String blankSpace = "║2: Pray   ║  Opponent HP: " + computer.getHp() + "\n";
        String secondLine = "║3: Rules  ║  Mana: " + getManaString(player) + "\n";
        String thirdLine =  "║4: End    ║\n";
        String cardBottom = "╚══════════╝\n";

        System.out.println(cardTop + firstLine + blankSpace + secondLine + thirdLine + cardBottom);
        while (!getAnswerInt.hasNext("[1234]")){
            System.out.println("Enter a valid option");
            getAnswerInt.next();
        }

        return getAnswerInt.nextInt();

    }

    /**
     * Method
     * @param min lower bounds to validate
     * @param max upper bounds to validate
     * @param prompt asks user to input number
     * @return returns validated input
     */
    public int getInt(int min, int max, String prompt) {
        while(true) {
            System.out.println(prompt);
            int response = getAnswerInt.nextInt();
            if(response >= min && response <= max) {
                return response;
            }
        }
    }

    //Displays rules. who'd of thought?
    public void displayRules(){
        //╔ ╗ ╚ ╝ ║ ═
        String line1 = "╔═════════════════════════════════════════════╗\n";
        String line2 = "║◇ At the start of the turn, player draws card║\n";
        String line3 = "║◇ Playing a card costs mana                  ║\n";
        String line4 = "║◇ Mana regenerates increasing by one /turn   ║\n";
        String line5 = "║◇ Cards attack the opposing enemy's card     ║\n";
        String line6 = "║◇ if no opposing card, player deals damage   ║\n";
        String line7 = "║          directly to enemy's health         ║\n";
        String line8 = "║◇ Player wins when enemy health is 0         ║\n";
        String line9 = "║                                             ║\n";
        String line10= "║                                             ║\n";
        String line11= "║                                             ║\n";
        String line12= "╚═════════════════════════════════════════════╝\n";

        System.out.println(line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9 + line10 + line11 + line12);
    }

    /**
     * retrieve mana converted into a String
     * @param player
     * @return
     */
    private String getManaString(Player player) {
        String manaString = "";
        for (int i = 0; i < player.getCurrentMana(); i++) {
            manaString += "*";
        }
        return manaString;
    }

    /**
     * Displays creature encased in a []. hotpockets
     * @param cards
     */
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
            secondLine += "│" + "A:" + cards.get(i).getAtk() + "/" + "H:" + cards.get(i).getHp() + "   │";
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

    public int deckEditor() {
        String cardTop =    "┌──────────┐\n";
        String firstLine =  "│1: Add    │\n";
        String blankSpace = "│2: Remove │\n";
        String secondLine = "│3: View   │\n";
        String thirdLine =  "│4: End    │\n";
        String cardBottom = "└──────────┘\n";

        System.out.println(cardTop + firstLine + blankSpace + secondLine + thirdLine + cardBottom);
        while (!getAnswerInt.hasNext("[1234]")){
            System.out.println("Enter a valid option");
            getAnswerInt.next();
        }

        return getAnswerInt.nextInt();
    }

    public String getString(String prompt) {
        if(prompt != null) {
            System.out.println(prompt);
        }
        try {
            return bread.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
        return "";

    }

    public int chooseDeck(ArrayList<Deck> decks) {
        for (int i = 0; i < decks.size(); i++) {
            System.out.println(i +": " + decks.get(i).getName());
        }

        return getInt(0, decks.size(), "Which deck would you like to use?");
    }

    public void print(String prompt) {
        System.out.println(prompt);
    }

}
