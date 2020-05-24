package com.ibrahim;

public class Drums extends Instrument {

    private boolean hihat;

    public Drums(String manufacturer, boolean hihat) {
        super(manufacturer);
        this.hihat = hihat;
    }

    public boolean isHihat() {
        return hihat;
    }

    public void setHihat(boolean hihat) {
        this.hihat = hihat;
    }
}
