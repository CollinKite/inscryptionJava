package com.example.inscryption.Model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> playerBoard = new ArrayList<>();
    private ArrayList<Card> computerBoard = new ArrayList<>();

    public ArrayList<Card> getPlayerBoard() {
        return playerBoard;
    }

    public ArrayList<Card> getComputerBoard() {
        return computerBoard;
    }

    public void addToPlayerBoard(Card card) {
        playerBoard.add(card);
    }

    public void addToComputerBoard(Card card) {
        computerBoard.add(card);
    }

    public void removeFromPlayerBoard(Card card) {
        playerBoard.remove(card);
    }

    public void removeFromComputerBoard(Card card) {
        computerBoard.remove(card);
    }
}
