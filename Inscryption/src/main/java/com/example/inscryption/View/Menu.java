package com.example.inscryption.View;

import com.example.inscryption.Model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner getAnswerInt = new Scanner(System.in);
    int answer;

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
        //╚══════╝


    }


    public int turnMenu() {
        List cardPos = new ArrayList<>();
        String cardTop =    "┌──────────┐\n";
        String firstLine =  "│1: Play   │\n";
        String blankSpace = "│          │\n";
        String specialLine ="│          │\n";
        String secondLine = "│          │\n";
        String thirdLine =  "│5: End    │\n";
        String cardBottom = "└──────────┘\n";

        System.out.println(cardTop + firstLine + blankSpace + specialLine + secondLine + thirdLine + cardBottom);
        while (!getAnswerInt.hasNext("[15]")){
            System.out.println("Enter a valid option");
            getAnswerInt.next();
        }

        return getAnswerInt.nextInt();

    }
}
