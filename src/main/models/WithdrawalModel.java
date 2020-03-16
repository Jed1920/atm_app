package main.models;

public class WithdrawalModel {

    private int twenties = 0;
    private int fifties = 0;
    private boolean validRequest;

    public boolean isValidRequest() {
        return validRequest;
    }

    public void setValidRequest(boolean validRequest) {
        this.validRequest = validRequest;
    }

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }
}
