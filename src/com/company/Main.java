package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        App myApp=new App();
        myApp.welcomeMenu();
        in.nextLine(); //to detect any key press
        myApp.mainMenu();

    }
}
