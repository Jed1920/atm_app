package main.services;

import main.models.RequestModel;
import main.models.WithdrawalModel;

import java.util.Scanner;

public class WithdrawService {

    private Scanner input;

    public WithdrawService(Scanner input) {
        this.input = input;
    }

    public WithdrawalModel withdraw(int numberTwenties, int numberFifties) {
        RequestModel requestModel = new RequestModel();
        requestModel.setTwentiesAvailable(numberTwenties);
        requestModel.setFiftiesAvailable(numberFifties);

        WithdrawalModel withdrawal;

        System.out.println("Enter desired amount in $");
        requestModel.setRequestAmount(Integer.parseInt(input.nextLine()));

        withdrawal = primaryNote50(requestModel);

        if (!withdrawal.isValidRequest()) {
            withdrawal = primaryNote20(requestModel);
            if (!withdrawal.isValidRequest()) {
                withdrawal = iterativeMethod(requestModel);
            }
        }

        return withdrawal;
    }

    private WithdrawalModel primaryNote50(RequestModel requestModel) {
        WithdrawalModel withdrawal = new WithdrawalModel();
        int twentiesInRequest = 0;
        int fiftiesInRequest = numberOfAvailableNotesInRequestedAmount(requestModel.getRequestAmount(), 50, requestModel.getFiftiesAvailable());
        int fiftiesRemainder = requestModel.getRequestAmount() - (fiftiesInRequest * 50);

        if (fiftiesRemainder != 0) {
            twentiesInRequest = numberOfAvailableNotesInRequestedAmount(fiftiesRemainder, 20, requestModel.getTwentiesAvailable());
        }

        if (fiftiesInRequest * 50 + twentiesInRequest * 20 == requestModel.getRequestAmount()) {
            withdrawal.setTwenties(twentiesInRequest);
            withdrawal.setFifties(fiftiesInRequest);
            withdrawal.setValidRequest(true);
        } else {
            withdrawal.setValidRequest(false);
        }
        return withdrawal;
    }

    private WithdrawalModel primaryNote20(RequestModel requestModel) {
        WithdrawalModel withdrawal = new WithdrawalModel();

        int twentiesInRequest = numberOfAvailableNotesInRequestedAmount(requestModel.getRequestAmount(), 20, requestModel.getTwentiesAvailable());

        if (twentiesInRequest * 20 == requestModel.getRequestAmount()) {
            withdrawal.setTwenties(twentiesInRequest);
            withdrawal.setValidRequest(true);
        } else {
            withdrawal.setValidRequest(false);
        }
        return withdrawal;
    }

    private WithdrawalModel iterativeMethod(RequestModel requestModel) {
        WithdrawalModel withdrawal = new WithdrawalModel();
        int x = 1;
        withdrawal.setValidRequest(false);

        while (!withdrawal.isValidRequest() && (x*50) < requestModel.getRequestAmount()) {
            int remainder = requestModel.getRequestAmount() - (x * 50);
            int twentiesInRequest = numberOfAvailableNotesInRequestedAmount(remainder, 20, requestModel.getTwentiesAvailable());
            if (x * 50 + twentiesInRequest * 20 == requestModel.getRequestAmount()){
                withdrawal.setFifties(x);
                withdrawal.setTwenties(twentiesInRequest);
                withdrawal.setValidRequest(true);
            } else {
                x++;
            }
        }
        return withdrawal;
    }

    private int numberOfAvailableNotesInRequestedAmount(int requestedAmount, int denomination, int numberofNotes) {
        int notesRequired = requestedAmount / denomination;
        if (notesRequired > numberofNotes) {
            return numberofNotes;
        }
        return notesRequired;
    }
}
