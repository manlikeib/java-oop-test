package com.ibrahim.ooptest.instrument.string;

public class Guitar extends StringInstrument {

    public Guitar(String manufacturer, int numberOfStrings, double stringSize) {
        super(manufacturer, numberOfStrings, stringSize);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfStrings=" + super.getNumberOfStrings() +
                ", stringSize=" + super.getStringSize() + "mm" +
                '}';
    }
}
