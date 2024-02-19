package com.Kalle.game;

import java.util.Scanner;

public class Main {


        static DBConnection db = new DBConnection();


        public static void main(String[] args) {

                Game game = new Game();

                db.open();

                db.createTablePlayer();

                game.start();

                game.mainMenu();


        }
}