package com.ibrahim.ooptest.instrument;

import com.ibrahim.ooptest.instrument.Instrument;

public class Synthesizer extends keyboardInstrument {

    private boolean hasLED;

    public Synthesizer(String manufacturer, int numberOfKeys, boolean hasLED) {
        super(manufacturer, numberOfKeys);
        this.hasLED = hasLED;
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
                "numberOfKeys=" + super.getNumberOfKeys() +
                ", hasLED=" + hasLED +
                '}';
    }
}
