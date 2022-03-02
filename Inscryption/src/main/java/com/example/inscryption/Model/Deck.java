package com.example.inscryption.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

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
        Random random = new Random();
        while(!deck.isEmpty()) {
            int index = random.nextInt(deck.size());
            shuffledDeck.add(deck.get(index));
            deck.remove(deck.get(index));
        }
        deck = shuffledDeck;
    }

}
