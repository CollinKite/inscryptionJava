package com.example.inscryption.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Human extends Player implements Serializable {

    //Constructors
    public Human(int hp, int mana, String name) {
        super(hp, mana, name, true);
    }

    public Human(){
        setHuman(true);
    }

    //Properties
    private ArrayList<Deck> madeDecks = new ArrayList<>(); //H
    private int gold = 0; //H
    private ArrayList<Card> ownedCards = new ArrayList<>(); //H


    //Getters and up-Setters >:(
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
