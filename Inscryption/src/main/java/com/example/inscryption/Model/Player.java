package com.example.inscryption.Model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int hp, mana;
    private String name;
    private Deck playerDeck = new Deck();

    public Player() {}

    public Player(int hp, int mana, String name) {
        setHp(hp);
        setMana(mana);

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


}
