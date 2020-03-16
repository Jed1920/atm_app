package main;

import main.services.DepositService;
import main.services.TotalService;
import main.services.WithdrawService;

import java.util.Scanner;

public class AtmApplication {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DepositService depositService = new DepositService();
        WithdrawService withdrawService = new WithdrawService();
        TotalService totalService = new TotalService();

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
                    depositService.deposit(numberTwenties,numberFifties,input);
                    break;
                case "Withdraw":
                    withdrawService.withdraw(numberTwenties,numberFifties,input);
                    break;
                case "Total":
                    totalService.balance(numberTwenties,numberFifties);
                    break;
            }
        }
    }
}
