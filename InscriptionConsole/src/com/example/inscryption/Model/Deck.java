package com.example.inscryption.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Cloneable{
    private ArrayList<Card> deck = new ArrayList<>();
    private Random random = new Random();
    private String name;

    public Deck() {}

    public Deck(ArrayList<Card> deck, String name) {
        this.deck = deck;
        setName(name);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }

    public Card drawCard() {
        if(!deck.isEmpty()) {
            Card card = deck.get(deck.size() - 1);
            deck.remove(card);
            return card;
        } else {
            return null;
        }
    }

    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        while(!deck.isEmpty()) {
            int index = random.nextInt(deck.size());
            shuffledDeck.add(deck.get(index));
            deck.remove(deck.get(index));
        }
        deck = shuffledDeck;
    }

    public Deck clone() {
        try {
            return (Deck)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
