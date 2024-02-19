package com.Kalle.game;

import static com.Kalle.game.Main.db;
import static com.Kalle.game.boosts.dv;

public class Game {

    static Player p1 = new Player();

    public void start() {
        System.out.println("Welcome to the dice game of Doom. Good luck and may the odds of the dice be ever in your favour.");
    }
    public void mainMenu() {
        boolean menuActive = true;
        do {
        System.out.println("Welcome to Kalle's dice game of doom");
        System.out.println("""
                1. New Game
                2. Load Game
                3. Quit
                """);

            switch (Scanners.getInput()) {
                case "1" -> {newGame(p1);
                menuActive = false;}
                case "2" -> {loadGame(p1);
                menuActive = false;}
                case "3" -> {System.out.println("Thanks for playing!"); System.exit(0);}
                default -> System.out.println("Choice unavailble!");
            }
        } while (menuActive);
        gameMenu();
    }

    public static void newGame(Player p1) {
        System.out.println("Player name:");
        p1.setName(Scanners.getInput());
        p1.setID(db.createPlayer(p1));
        //String name = Scanners.getInput();
        System.out.println("Name: " + p1.getID() + p1.getName());
        //db.createPlayer(p1);
    }

    public static void loadGame(Player p1) {
        System.out.println("Players:");
        db.listPlayers();
        System.out.println("Which player?");
        db.loadPlayer(Scanners.getInt(), p1);
        System.out.println(p1.getID());
        System.out.println(p1.getName());
        System.out.println(p1.getReRolls());
        System.out.println(p1.getBonusPoint());
        System.out.println(p1.getWins());
        Scanners.scan.nextLine();
    }


    public static void gameMenu() {
        do {
            System.out.println("Time to roll some dices");
            System.out.println("""
                1. Current boosts
                2. Play game!
                3. Rules
                4. Quit
                """);
            switch (Scanners.getInput()) {
                case "1" -> currentBoosts();
                case "2" -> playGame();
                case "3" -> gameRules();
                case "4" -> {System.out.println("Thanks for playing!"); System.exit(0);}
                default -> System.out.println("Choice unavailble!");
            }
        } while (true);
    }

    public static void currentBoosts() {
        boosts.booster(p1);
    }

    public static void playGame() {
        do {
            System.out.println("""
                1. Roll dices!
                2. Back to menu.
                """);
            switch (Scanners.getInput()) {
                case "1" -> {boosts.randomRolls();
                if (dv.getTotalScore() > dv.getOpponentValue()) {
                    System.out.println("Congratulations, you won!!!");

                    p1.setWins(p1.getWins()+1);
                    if (p1.getWins()==3) {
                        p1.setWins(0);
                        db.updateWins(p1);

                        if (dv.getBoostPrice() == 0) {
                            p1.setReRolls(p1.getReRolls()+1);
                            System.out.println("You also won an additional Re-roll. Total Re-rolls: " + p1.getReRolls());
                            db.updateReRoll(p1);
                        } else {
                            p1.setBonusPoint(p1.getBonusPoint()+1);
                            System.out.println("You also won an additional Bonus point. Total Bonus points: " + p1.getBonusPoint());
                            db.updateBonusPoint(p1);
                        }
                    } else {
                        db.updateWins(p1);
                        System.out.println("Your total wins are: " + p1.getWins() + "/3.");
                    }

                } else {
                    System.out.println("Noob, you lost against a bot!");
                    if (p1.getBonusPoint()+ p1.getReRolls()==0) {
                        gameMenu();
                    } else {
                        System.out.println("""
                                Do you wanna use any boosts?
                                1. Yes.
                                2. No.""");
                        switch (Scanners.getInput()) {
                            case "1" -> {
                                System.out.println("Available boosts:");
                                System.out.println("1. Re-rolls: " + p1.getReRolls());
                                System.out.println("2. Bonus points: " + p1.getBonusPoint());

                            }

                            case "2" -> gameMenu();
                            default -> System.out.println("Choice unavailble!");

                        }
                    }
                }
                }
                case "2" -> gameMenu();
                default -> System.out.println("Choice unavailble!");
            }
        } while (true);
    }

    public static void gameRules() {
        System.out.println("""
                Rules:
                Your goal is to beat your opponents value(means ties are a loss for you).
                The game starts with you rolling the dices. In Dice game of doom, you getting 5 dices. All dices are rolled automatically.
                After the roll, you get the value of each dice and the total value. As well as your opponents total value.
                If you roll higher, it is a win, congratulations!
                In case of rolling lower, hope isn't over yet. Now you get the option to use your boosts.
                
                Re-roll: With a re-roll, you simply pick one of the dices and re-rolls it, getting a new value on that dice.
                Bonus-score: With bonus-point, you picking one of the dices and increase the score by one (max is always 6).
                
                You can use at most three boosts per game, your choice if 3 re-roll or 3 bonus-score or any combination of them.
                
                For every 3 wins, you getting a chance to get one more boost.
                
                Good luck and may the dice-gods be with you.
                """);
    }
}

