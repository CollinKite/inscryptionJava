package com.example.inscryption.Model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int hp = 20, mana, currentMana;
    private String name;
    private Deck playerDeck = new Deck();
    private boolean isHuman;

    public Player() {}

    public Player(int hp, int mana, String name, boolean isHuman) {
        setHp(hp);
        setMana(mana);
        setName(name);
        setHuman(isHuman);
    }

    public void drawCard() {
        addCardToHand(this.playerDeck.drawCard());
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public boolean isHuman() {
        return isHuman;
    }
}
