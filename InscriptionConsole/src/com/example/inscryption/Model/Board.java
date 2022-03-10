package com.example.inscryption.Model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> playerBoard = new ArrayList<>();
    private ArrayList<Card> computerBoard = new ArrayList<>();

    //Returns Player Cards
    public ArrayList<Card> getPlayerBoard() {
        return playerBoard;
    }

    //Returns Computer Cards
    public ArrayList<Card> getComputerBoard() {
        return computerBoard;
    }

    //Add Human Player Cards to board
    public void addToPlayerBoard(Card card) {
        playerBoard.add(card);
    }

    //Add Computer Cards to board
    public void addToComputerBoard(Card card) {
        computerBoard.add(card);
    }

    //Find's Cards with health <= 0 and removes them
    public void removeDeadCards() {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < playerBoard.size(); i++) {
            if(playerBoard.get(i).getHp() <= 0) {
                indexes.add(i);
            }
        }
        if(!indexes.isEmpty()) {
            for (int i = indexes.size() - 1; i > -1; i--) {
                playerBoard.remove(indexes.get(i).intValue());
            }
        }
        indexes = new ArrayList<>();
        for (int i = 0; i < computerBoard.size(); i++) {
            if(computerBoard.get(i).getHp() <= 0) {
                indexes.add(i);
            }
        }
        if(!indexes.isEmpty()) {
            for (int i = indexes.size() - 1; i > -1; i--) {
                computerBoard.remove(indexes.get(i).intValue());
            }
        }
    }
}
