package com.ibrahim;

public class Banjo extends StringInstrument{

    public Banjo(String manufacturer, int numberOfStrings, double stringSize) {
        super(manufacturer, numberOfStrings, stringSize);
    }

    @Override
    public String toString() {
        return "Banjo{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "numberOfStrings=" + super.getNumberOfStrings() +
                ", stringSize=" + super.getStringSize() + "mm" +
                '}';
    }
}
