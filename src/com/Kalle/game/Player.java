package com.Kalle.game;

public class Player {

    private String name;
    private int reRolls;
    private int bonusPoint;
    private int wins;
private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReRolls() {
        return reRolls;
    }

    public void setReRolls(int reRolls) {
        this.reRolls = reRolls;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
