package com.example.inscryption.Model;


import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int hp = 20, mana, currentMana;
    private String name;
    private Deck playerDeck = new Deck();
    private boolean isHuman;
    private ArrayList<Deck> madeDecks = new ArrayList<>(); //H
    private int gold = 0; //H
    private ArrayList<Card> ownedCards = new ArrayList<>(); //H

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

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

    public void setPlayerDeck(Deck deck) {
        this.playerDeck = deck;
    }

    public void setMadeDecks(ArrayList<Deck> madeDecks) {
        this.madeDecks = madeDecks;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Deck getPlayerDeck() {
        return playerDeck;
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
}
