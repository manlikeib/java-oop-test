package com.ibrahim.ooptest.instrument.keyboard;

public class Piano extends keyboardInstrument {

    private boolean isAcoustic;

    public Piano(String manufacturer, int numberOfKeys, boolean isAcoustic) {
        super(manufacturer, numberOfKeys);
        this.isAcoustic = isAcoustic;
    }

    public boolean isAcoustic() {
        return isAcoustic;
    }

    public void setAcoustic(boolean acoustic) {
        isAcoustic = acoustic;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfKeys=" + super.getNumberOfKeys() +
                ", isAcoustic=" + isAcoustic +
                '}';
    }
}
