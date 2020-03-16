package main.models;

public class RequestModel {

    private int requestAmount;
    private int twentiesAvailable;
    private int fiftiesAvailable;

    public int getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    public int getTwentiesAvailable() {
        return twentiesAvailable;
    }

    public void setTwentiesAvailable(int twentiesAvailable) {
        this.twentiesAvailable = twentiesAvailable;
    }

    public int getFiftiesAvailable() {
        return fiftiesAvailable;
    }

    public void setFiftiesAvailable(int fiftiesAvailable) {
        this.fiftiesAvailable = fiftiesAvailable;
    }
}
