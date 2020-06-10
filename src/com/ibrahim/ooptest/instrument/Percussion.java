package com.ibrahim.ooptest.instrument;

public abstract class Percussion extends Instrument {

    private boolean hihat;

    public Percussion(String manufacturer, boolean hihat) {
        super(manufacturer);
        this.hihat = hihat;
    }

    public boolean isHihat() {
        return hihat;
    }

    public void setHihat(boolean hihat) {
        this.hihat = hihat;
    }

    @Override
    public String toString() {
        return "Percussion{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "hihat=" + hihat +
                '}';
    }

}
