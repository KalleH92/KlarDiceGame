package com.Kalle.game;

import java.util.Scanner;

public class Scanners {
    static Scanner scan = new Scanner(System.in);

    public static String getInput() {
        return scan.nextLine();
    }
    public static int getInt() {
        return scan.nextInt();
    }
}
