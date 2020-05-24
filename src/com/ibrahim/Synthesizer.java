package com.ibrahim;

public class Synthesizer extends Instrument {

    private int numberOfKeys;
    private boolean hasLED;

    public Synthesizer(String manufacturer, int numberOfKeys, boolean hasLED) {
        super(manufacturer);
        this.numberOfKeys = numberOfKeys;
        this.hasLED = hasLED;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public boolean isHasLED() {
        return hasLED;
    }

    public void setHasLED(boolean hasLED) {
        this.hasLED = hasLED;
    }

    @Override
    public String toString() {
        return "Synthesizer{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfKeys=" + numberOfKeys +
                ", hasLED=" + hasLED +
                '}';
    }
}
