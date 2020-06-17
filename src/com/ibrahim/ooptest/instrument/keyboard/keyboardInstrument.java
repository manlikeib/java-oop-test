package com.ibrahim.ooptest.instrument.keyboard;

import com.ibrahim.ooptest.instrument.Instrument;

public abstract class keyboardInstrument extends Instrument {

    private int numberOfKeys;

    public keyboardInstrument(String manufacturer, int numberOfKeys) {
        super(manufacturer);
        this.numberOfKeys = numberOfKeys;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    @Override
    public String toString() {
        return "keyboardInstrument{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfKeys=" + numberOfKeys +
                '}';
    }
}
