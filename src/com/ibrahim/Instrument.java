package com.ibrahim;

public abstract class Instrument {

    private String manufacturer;

    public Instrument(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
