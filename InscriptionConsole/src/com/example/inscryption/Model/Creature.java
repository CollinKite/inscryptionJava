//package com.example.inscryption.Model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Creature extends Card{
//    private int atk, hp;
//    private String special1, special2;
//
//    public Creature() {}
//
//    public Creature(int cost, String type, String name, int atk, int hp, String special1, String special2) {
//        super(cost, type, name);
//        setAtk(atk);
//        setHp(hp);
//        setSpecial1(special1);
//        setSpecial2(special2);
//    }
//
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
//
//    public int getHp() {
//        return hp;
//    }
//
//    public void setAtk(int atk) {
//        this.atk = atk;
//    }
//
//    public int getAtk() {
//        return atk;
//    }
//
//    public void setSpecial1(String special1) {
//        this.special1 = special1;
//    }
//
//    public String getSpecial1() {
//        return special1;
//    }
//
//    public void setSpecial2(String special2) {
//        this.special2 = special2;
//    }
//
//    public String getSpecial2() {
//        return special2;
//    }
//
//    public String toString() {
//        List cardPos = new ArrayList<>();
//        String CardTop = "┌──────────┐"  + "\n";
//        String firstLine = "│" + getName();
//        String blankSpace = "│          │\n" ;
//        String specialLine = "│" + getSpecial1() + "   " + getSpecial2() + " │\n";
//        String secondLine = "│" + getAtk() + "/" + getHp() + "       │\n";
//        String thirdLine = "│" + getCost() + "         │\n";
//        String cardBottom = "└──────────┘";
//
//        //╚══════╝
//
//
//        for (int i = 0; i < (10 - getName().length()); i++) {
//            firstLine += " ";
//        }
//
//        firstLine += "│\n";

//        cardPos.add(CardTop);
//        cardPos.add(firstLine);
//        cardPos.add(blankSpace);
//        cardPos.add(specialLine);
//        cardPos.add(secondLine);
//        cardPos.add(thirdLine);
//        cardPos.add(cardBottom);
//
//        cardPos.forEach(System.out::println);

//        return CardTop + firstLine + blankSpace + specialLine + secondLine + thirdLine + cardBottom;
//    }
//}
