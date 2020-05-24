package com.ibrahim;

public class Musician {

    private String name;
    private Instrument instrument;

    public Musician(String name, Instrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "name='" + name + '\'' +
                ", instrument=" + instrument +
                '}';
    }
}
