package main;

import java.util.Scanner;

public class AtmApplication {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

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
                    System.out.println("Enter number of $20 to deposit");
                    int numberNewTwenties = Integer.parseInt(input.nextLine());
                    numberTwenties = numberNewTwenties + numberTwenties;

                    System.out.println("Enter number of $50 to deposit");
                    int numberNewFifties = Integer.parseInt(input.nextLine());
                    numberFifties = numberNewFifties + numberFifties;
                    break;
                case "Withdraw":
                    System.out.println("Enter desired amount in $");
                    int requestedAmount = Integer.parseInt(input.nextLine());
                    break;
                case "Total":
                    System.out.println(String.format("Number of $20 notes: %d", numberTwenties));
                    System.out.println(String.format("Number of $50 notes: %d", numberFifties));
                    int total = numberFifties * 50 + numberTwenties * 20;
                    System.out.println(String.format("Total: $%d", total));
                    break;
            }
        }
    }
}
