package com.example.inscryption.View;

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
while (!getAnswerInt.hasNextInt()){
    System.out.println("Enter a valid option");
    getAnswerInt.next();
}
answer = getAnswerInt.nextInt();
return answer;
        //╚══════╝


    }
}
