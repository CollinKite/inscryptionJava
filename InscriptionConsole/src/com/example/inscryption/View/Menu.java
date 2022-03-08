package com.example.inscryption.View;

import com.example.inscryption.Model.Card;
import com.example.inscryption.Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner getAnswerInt = new Scanner(System.in);
    int answer;

    //Creates menu in a box
    public int startMenu() {
        List cardPos = new ArrayList<>();
        String cardTop =    "┌──────────┐";
        String firstLine =  "│1: New    │";
        String blankSpace = "│2:        │";
        String specialLine ="│          │";
        String secondLine = "│          │";
        String thirdLine =  "│5: Exit   │";
        String cardBottom = "└──────────┘";

        cardPos.add(cardTop);
        cardPos.add(firstLine);
        cardPos.add(blankSpace);
        cardPos.add(specialLine);
        cardPos.add(secondLine);
        cardPos.add(thirdLine);
        cardPos.add(cardBottom);

        cardPos.forEach(System.out::println);
while (!getAnswerInt.hasNext("[15]")){
    System.out.println("Enter a valid option");
    getAnswerInt.next();
}
answer = getAnswerInt.nextInt();
return answer;
    }

//turn menu, also in a box, nice right?
    public int turnMenu(Player player, Player computer) {
        String cardTop =    "┌──────────┐\n";
        String firstLine =  "│1: Play   │  Your HP: " +player.getHp() + "\n";
        String blankSpace = "│2:        │  Opponent HP: " + computer.getHp() + "\n";
        String specialLine ="│3:        │  Mana: " + getManaString(player) + "\n";
        String secondLine = "│4: Rules  │\n";
        String thirdLine =  "│5: End    │\n";
        String cardBottom = "└──────────┘\n";

        System.out.println(cardTop + firstLine + blankSpace + specialLine + secondLine + thirdLine + cardBottom);
        while (!getAnswerInt.hasNext("[145]")){
            System.out.println("Enter a valid option");
            getAnswerInt.next();
        }

        return getAnswerInt.nextInt();

    }

    /**
     *
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
        String line2 = "║ At the start of the turn, player draws card ║\n";
        String line3 = "║ Playing a card costs mana                   ║\n";
        String line4 = "║ Mana regenerates increasing by one /turn    ║\n";
        String line5 = "║ Cards attack the opposing enemy's card      ║\n";
        String line6 = "║ if no opposing card, player deals damage    ║\n";
        String line7 = "║          directly to enemy's health         ║\n";
        String line8 = "║ Player wins when enemy health is 0          ║\n";
        String line9 = "║                                             ║\n";
        String line10= "║                                             ║\n";
        String line11= "║                                             ║\n";
        String line12= "╚═════════════════════════════════════════════╝\n";

        System.out.println(line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9 + line10 + line11 + line12);
    }

    private String getManaString(Player player) {
        String manaString = "";
        for (int i = 0; i < player.getCurrentMana(); i++) {
            manaString += "*";
        }
        return manaString;
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
}
