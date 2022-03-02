package com.example.inscryption.Model;

public class Card {
    private int cost;
    private String type, name;
    private int atk, hp;
    private String special1, special2;

    public Card(){}

    public Card(int cost, String type, String name, int atk, int hp, String special1, String special2) {
        setCost(cost);
        setType(type);
        setName(name);
        setAtk(atk);
        setHp(hp);
        setSpecial1(special1);
        setSpecial2(special2);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }

    public void setSpecial1(String special1) {
        this.special1 = special1;
    }

    public String getSpecial1() {
        return special1;
    }

    public void setSpecial2(String special2) {
        this.special2 = special2;
    }

    public String getSpecial2() {
        return special2;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
