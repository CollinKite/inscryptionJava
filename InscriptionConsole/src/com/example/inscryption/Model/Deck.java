package com.example.inscryption.Model;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Cloneable, Serializable {
    //Properties
    private ArrayList<Card> deck = new ArrayList<>();
    private Random random = new Random();
    private String name;

    //Constructors
    public Deck() {}

    public Deck(ArrayList<Card> deck, String name) {
        this.deck = deck;
        setName(name);
    }

    //Get Deck
    public ArrayList<Card> getDeck() {
        return deck;
    }

    //Add and Remove Cards to Deck
    public void addCard(Card card) {
        deck.add(card);
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }

    //Returns Selected Card from deck and removes it
    public Card drawCard() {
        if(!deck.isEmpty()) {
            Card card = deck.get(deck.size() - 1);
            deck.remove(card);
            return card;
        } else {
            return null;
        }
    }

    //Randomizes Order of Cards in ArrayList
    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        while(!deck.isEmpty()) {
            int index = random.nextInt(deck.size());
            shuffledDeck.add(deck.get(index));
            deck.remove(deck.get(index));
        }
        deck = shuffledDeck;
    }

    //Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
