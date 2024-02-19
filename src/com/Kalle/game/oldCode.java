package com.Kalle.game;

public class oldCode {
    /*
--------
if (boosts.booster(0) > totalScore) {
                    System.out.println("You lose! Wanna use boosts?");
                    System.out.println("""
                    1. Yes
                    2. No""");
                    do {
                        switch (Scanners.getInput()) {
                            case "1" -> boosts.randomRolls();
                            case "2" -> System.out.println("Complete defeat");
                            gameMenu();
                            default -> System.out.println("Choice unavailble!");
                        }
                    } while (true);


                } else {
                    System.out.println("Re-rolls:");
                    System.out.println("Bonus points:");
                    System.out.println("""

                    Menu:""");
                }

                -------
    public int test(){
        int hej=5;
        System.out.println(hej);
        return hej;


    }

    int players = sc.nextInt();

                for (int i = 0; i < players; i++) {
                        int playerNumber = i + 1;
                        System.out.println("Name of player " + playerNumber + ":");

                        switch (playerNumber) {
                                case 1:
                                        String playerOne = sc.next();
                                        break;
                                case 2:
                                        String playerTwo = sc.next();
                                        break;
                                case 3:
                                        String playerThree = sc.next();
                                        break;
                                case 4:
                                        String playerFour = sc.next();
                                        break;
                        }
                }

                System.out.println("How many dices to roll(1-5)?");
                int dices = sc.nextInt();
                int minValue =1;
                int maxValue = 6;

                for (int i = 0; i < players; i++) {
                        int playerNumber = i + 1;
                        System.out.println("Player " + playerNumber + " type 'Roll' to roll your dices:");
                        String player = sc.next();
                        int randomOne = (int)Math.floor(Math.random() * (maxValue - minValue +1) + minValue);
                        int randomTwo = (int)Math.floor(Math.random() * (maxValue - minValue +1) + minValue);
                        int randomThree = (int)Math.floor(Math.random() * (maxValue - minValue +1) + minValue);
                        int randomFour = (int)Math.floor(Math.random() * (maxValue - minValue +1) + minValue);
                        int randomFive = (int)Math.floor(Math.random() * (maxValue - minValue +1) + minValue);
                        System.out.println("Rolls:");
                        switch (dices) {
                                case 1:
                                        System.out.println(randomOne);
                                        System.out.println("Total:");
                                        int totalOne = randomOne;
                                        System.out.println(totalOne);
                                        break;
                                case 2:
                                        System.out.println(randomOne);
                                        System.out.println(randomTwo);
                                        System.out.println("Total:");
                                        int totalTwo = randomOne + randomTwo;
                                        System.out.println(totalTwo);
                                        break;
                                case 3:
                                        System.out.println(randomOne);
                                        System.out.println(randomTwo);
                                        System.out.println(randomThree);
                                        System.out.println("Total");
                                        int totalThree = randomOne + randomTwo + randomThree;
                                        System.out.println(totalThree);
                                        break;
                                case 4:
                                        System.out.println(randomOne);
                                        System.out.println(randomTwo);
                                        System.out.println(randomThree);
                                        System.out.println(randomFour);
                                        System.out.println("Total:");
                                        int totalFour = randomOne + randomTwo + randomThree + randomFour;
                                        System.out.println(totalFour);
                                        break;
                                case 5:
                                        System.out.println(randomOne);
                                        System.out.println(randomTwo);
                                        System.out.println(randomThree);
                                        System.out.println(randomFour);
                                        System.out.println(randomFive);
                                        System.out.println("Totall:");
                                        int totalFive = randomOne + randomTwo +randomThree + randomFour + randomFive;
                                        System.out.println(totalFive);
                                        break;
                        }
                        switch (playerNumber) {
                                case 1: int playerOnePoints = randomOne + randomTwo + randomThree + randomFour + randomFive;
                                break;
                                case 2: int playerTwoPoints = randomOne + randomTwo + randomThree + randomFour + randomFive;
                                break;
                                case 3: int playerThreePoints = randomOne + randomTwo + randomThree + randomFour + randomFive;
                                break;
                                case 4: int playerFourPoints = randomOne + randomTwo + randomThree + randomFour + randomFive;
                                break;
                        }



                }

                ------
                package com.Kalle.game;

import Model.Player;

import java.sql.*;

public class DBConnection {


    private String URL = "jdbc:mariadb://localhost:3306/Dicegame";

    private String USER = "dbveaveaver usernameroot";
    private String password = "DBveaver-password";

    Connection connection;

    public void open() {
        try {
            connection = DriverManager.getConnection(URL, USER, password);
            System.out.println("Database connected");

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {

        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String createTablePlayer() {
        String sql = "CREATE TABLE player (playerID INT NOT NULL AUTO_INCREMENT, name VARCHAR(60), health INT, primary KEY(playerID))";
//Låt allt till rad 54 vara kvar som det är
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public String createTableMonster() {
        String sql = "CREATE TABLE monster (monsterID INT NOT NULL AUTO_INCREMENT, type VARCHAR(100), primary KEY(monsterID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }

    public int createPlayer (Player newPlayer) {

        int incrementID = 0;
        String sql = "INSERT INTO player (name, health ) values (?, ?)";

        try {


            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newPlayer.getName());
            preparedStatement.setInt(2, newPlayer.getHealth());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return incrementID;
    }

    public int updatePlayerHealth(int health, int id) {

        String sql = "UPDATE player set health = ? where PlayerID = ?";
        int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, health);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public String getPlayerWithId(int id) {

        String sql = "SELECT * from player where PlayerID = ?";
        String playerName;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                playerName = rs.getString("name");
                return playerName;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

}------
*/
}

