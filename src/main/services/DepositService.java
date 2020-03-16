package main.services;

import java.util.Scanner;

public class DepositService {

    public void deposit(int numberTwenties, int numberFifties, Scanner input){
        System.out.println("Enter number of $20 to deposit");
        int numberNewTwenties = Integer.parseInt(input.nextLine());
        numberTwenties = numberNewTwenties + numberTwenties;

        System.out.println("Enter number of $50 to deposit");
        int numberNewFifties = Integer.parseInt(input.nextLine());
        numberFifties = numberNewFifties + numberFifties;
    }
}
