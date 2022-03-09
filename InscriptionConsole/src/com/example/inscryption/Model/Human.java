package com.example.inscryption.Model;

import java.util.ArrayList;

public class Human extends Player {

    public Human(int hp, int mana, String name, boolean isHuman) {
        super(hp, mana, name, isHuman);
    }

    public Human(){}

    private ArrayList<Deck> madeDecks = new ArrayList<>(); //H
    private int gold = 0; //H
    private ArrayList<Card> ownedCards = new ArrayList<>(); //H



    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


    public ArrayList<Deck> getMadeDecks() {
        return madeDecks;
    }

    public ArrayList<Card> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(ArrayList<Card> ownedCards) {
        this.ownedCards = ownedCards;
    }


    public void setMadeDecks(ArrayList<Deck> madeDecks) {
        this.madeDecks = madeDecks;
    }
}
