package com.Kalle.game;

public class boosts {
    //Player p1 = new Player();
    static Dices dv = new Dices();

    public static void booster(Player p1) {
        
        int boostAmount = p1.getReRolls() + p1.getBonusPoint();
        if (boostAmount == 0) {
            System.out.println("No boosts, go play game.");
            System.out.println("""
                    
                    Menu:""");
        } else {
            System.out.println("Re-rolls:" + p1.getReRolls());
            System.out.println("Bonus points:" + p1.getBonusPoint());
            System.out.println("""
                    
                    Menu:""");
        }
    }

    public static void randomRolls() {


        dv.setBoostPrice((int)(Math.random() * 2));
        dv.setDiceOne((int)((Math.random() * 6))+1);
        dv.setDiceTwo((int)((Math.random() * 6))+1);
        dv.setDiceThree((int)((Math.random() * 6))+1);
        dv.setDiceFour((int)((Math.random() * 6))+1);
        dv.setDiceFive((int)((Math.random() * 6))+1);
        dv.setTotalScore(dv.getDiceOne()+ dv.getDiceTwo()+ dv.getDiceThree()+ dv.getDiceFour()+ dv.getDiceFive());
        dv.setOpponentValue((int)((Math.random() * 26))+5);

        System.out.println("Dice one: " + dv.getDiceOne());
        System.out.println("Dice two: " + dv.getDiceTwo());
        System.out.println("Dice three: " + dv.getDiceThree());
        System.out.println("Dice four: " + dv.getDiceFour());
        System.out.println("Dice five: " + dv.getDiceFive());
        System.out.println("Your total score: " + dv.getTotalScore());
        System.out.println("Your opponents score: " + dv.getOpponentValue());



    }

}
