package com.Kalle.game;

public class Dices {

    private int boostPrice;

    public int getBoostPrice() {
        return boostPrice;
    }

    public void setBoostPrice(int boostPrice) {
        this.boostPrice = boostPrice;
    }

    private int diceOne;
    private int diceTwo;
    private int diceThree;
    private int diceFour;
    private int diceFive;
    private int totalScore;

    public int getDiceOne() {
        return diceOne;
    }

    public void setDiceOne(int diceOne) {
        this.diceOne = diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public void setDiceTwo(int diceTwo) {
        this.diceTwo = diceTwo;
    }

    public int getDiceThree() {
        return diceThree;
    }

    public void setDiceThree(int diceThree) {
        this.diceThree = diceThree;
    }

    public int getDiceFour() {
        return diceFour;
    }

    public void setDiceFour(int diceFour) {
        this.diceFour = diceFour;
    }

    public int getDiceFive() {
        return diceFive;
    }

    public void setDiceFive(int diceFive) {
        this.diceFive = diceFive;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getOpponentValue() {
        return opponentValue;
    }

    public void setOpponentValue(int opponentValue) {
        this.opponentValue = opponentValue;
    }

    private int opponentValue;

}
