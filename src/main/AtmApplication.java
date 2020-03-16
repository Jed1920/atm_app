package main;

import main.controllers.AppController;

import java.util.Scanner;

public class AtmApplication {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        AppController appController = new AppController(input);
        appController.controller();
    }
}
