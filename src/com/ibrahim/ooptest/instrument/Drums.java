package com.ibrahim.ooptest.instrument;

public class Drums extends Percussion {

    public Drums(String manufacturer, boolean hihat) {
        super(manufacturer, hihat);
    }

    @Override
    public String toString() {
        return "Drums{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "hihat=" + super.isHihat() +
                '}';
    }
}
