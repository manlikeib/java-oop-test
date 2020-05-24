package com.ibrahim;

public class Guitar extends Instrument {

    private int numberOfStrings;
    private double stringSize;

    public Guitar(String manufacturer, int numberOfStrings, double stringSize) {
        super(manufacturer);
        this.numberOfStrings = numberOfStrings;
        this.stringSize = stringSize;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public double getStringSize() {
        return stringSize;
    }

    public void setStringSize(double stringSize) {
        this.stringSize = stringSize;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfStrings=" + numberOfStrings +
                ", stringSize=" + stringSize +
                '}';
    }
}
