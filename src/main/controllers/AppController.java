package main.controllers;

import main.models.WithdrawalModel;
import main.services.DepositService;
import main.services.TotalService;
import main.services.WithdrawService;

import java.util.Scanner;

public class AppController {

    private Scanner input;
    DepositService depositService;
    WithdrawService withdrawService;
    TotalService totalService;

    public AppController(Scanner input) {
        this.input = input;
        this.depositService = new DepositService(input);
        this.withdrawService = new WithdrawService(input);
        this.totalService = new TotalService();
    }

    public void controller(){
        int threshold = 2;
        System.out.println("Enter number of $20 notes available");
        int numberTwenties = Integer.parseInt(input.nextLine());
        System.out.println("Enter number of $50 notes available");
        int numberFifties = Integer.parseInt(input.nextLine());

        boolean run = true;

        while(run) {
            System.out.println("What service do you require: Deposit, Withdraw, Total");
            String service = input.nextLine();

            switch (service) {
                case "Deposit":
                    numberTwenties = depositService.depositTwenties(numberTwenties);
                    numberFifties = depositService.depositFifties(numberFifties);
                    break;

                case "Withdraw":
                    WithdrawalModel withdrawal = withdrawService.withdraw(numberTwenties,numberFifties);
                    if(withdrawal.isValidRequest()){
                        System.out.println(String.format("Number of $20 = %s", withdrawal.getTwenties()));
                        System.out.println(String.format("Number of $50 = %s", withdrawal.getFifties()));
                        numberTwenties = numberTwenties - withdrawal.getTwenties();
                        numberFifties = numberFifties - withdrawal.getFifties();
                        if(numberTwenties <= threshold) {
                            System.out.println("Number of $20 notes is at or below the threshold");
                        }
                        if(numberFifties <= threshold) {
                            System.out.println("Number of $50 notes is at or below the threshold");
                        }
                    } else {
                        System.out.println("Amount not available with current available denominations");
                    }
                    break;

                case "Total":
                    totalService.balance(numberTwenties,numberFifties);
                    break;
                default:
                    System.out.println("Please choose from the available options");
            }
        }
    }
}
