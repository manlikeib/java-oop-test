package com.ibrahim;

public class Piano extends Instrument{

    private int numberOfKeys;
    private boolean isAcoustic;

    public Piano(String manufacturer, int numberOfKeys, boolean isAcoustic) {
        super(manufacturer);
        this.numberOfKeys = numberOfKeys;
        this.isAcoustic = isAcoustic;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public boolean isAcoustic() {
        return isAcoustic;
    }

    public void setAcoustic(boolean acoustic) {
        isAcoustic = acoustic;
    }
}
