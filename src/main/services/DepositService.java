package main.services;

import java.util.Scanner;

public class DepositService {

    private Scanner input;

    public DepositService(Scanner input) {
        this.input = input;
    }

    public int depositTwenties(int numberTwenties) {
        System.out.println("Enter number of $20 to deposit");
        int numberNewTwenties = Integer.parseInt(input.nextLine());
        return numberNewTwenties + numberTwenties;
    }

    public int depositFifties(int numberFifties) {
        System.out.println("Enter number of $50 to deposit");
        int numberNewFifties = Integer.parseInt(input.nextLine());
        return numberNewFifties + numberFifties;
    }
}
