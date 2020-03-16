package main.services;

public class TotalService {

    public void balance(int numberTwenties,int numberFifties){
        System.out.println(String.format("Number of $20 notes: %d", numberTwenties));
        System.out.println(String.format("Number of $50 notes: %d", numberFifties));
        int total = numberFifties * 50 + numberTwenties * 20;
        System.out.println(String.format("Total: $%d", total));
    }
}
