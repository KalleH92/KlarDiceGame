package com.Kalle.game;

 //import Model.Player;

import java.sql.*;




public class DBConnection {


    private String URL = "jdbc:mariadb://localhost:3306/Dicegame";

    private String USER = "root";
    private String password = "kh7276092";

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


    public String createTablePlayer() {
        String sql = "CREATE TABLE IF NOT EXISTS player (playerID INT NOT NULL AUTO_INCREMENT, Name VARCHAR(60), ReRoll INT, BonusPoint INT, Wins INT, primary KEY(playerID))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

            return "Something went wrong";

        }
        return "Table created";
    }


    public int createPlayer(Player p1) {

        int incrementID = 0;
        String sql = "INSERT INTO player (Name, ReRoll, BonusPoint, Wins) values (?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, p1.getName());
            preparedStatement.setInt(2, p1.getReRolls());
            preparedStatement.setInt(3, p1.getBonusPoint());
            preparedStatement.setInt(4, p1.getWins());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                incrementID = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(incrementID);

        return incrementID;
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

    public void updateReRoll(Player p1) {
        String sql = "UPDATE player set ReRoll = ?  where playerID = ?";
        //int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getReRolls());
            preparedStatement.setInt(2, p1.getID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----Update re-rolls----");
        //return affectedRows;
    }

    public void updateBonusPoint(Player p1) {
        String sql = "UPDATE player set BonusPoint = ?  where playerID = ?";
        //int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getBonusPoint());
            preparedStatement.setInt(2, p1.getID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----Update bonus points----");
        //return affectedRows;
    }

    public void updateWins(Player p1) {
        String sql = "UPDATE player set Wins = ?  where playerID = ?";
        //int affectedRows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, p1.getWins());
            preparedStatement.setInt(2, p1.getID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----Update wins----");
        //return affectedRows;
    }

    public void listPlayers() {
        String sql = "SELECT playerID, Name FROM player";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int playerID = resultSet.getInt(1);
                String Name = resultSet.getString(2);
                System.out.println(playerID + ". " + Name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadPlayer(int userInput, Player p1) {

        String sql = "SELECT * FROM player WHERE playerID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userInput);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p1.setID(resultSet.getInt(1));
                p1.setName(resultSet.getString(2));
                p1.setReRolls(resultSet.getInt(3));
                p1.setBonusPoint(resultSet.getInt(4));
                p1.setWins(resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}