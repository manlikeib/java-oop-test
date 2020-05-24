package com.ibrahim;

import java.util.ArrayList;
import java.util.List;

public class Band {

    private List<Musician> musicians;

    // new arraylist should be created when initializing a band object
    public Band() {
        this.musicians = new ArrayList<>();
    }


    public List<Musician> getMusicians() {
        return musicians;
    }

    @Override
    public String toString() {
        return "Band{" +
                "musicians=" + musicians +
                '}';
    }

    // method to add Musician to the band
    public boolean addMusician(Musician musician) {
        if (!musicianAlreadyAdded(musician)) {
            System.out.println("This user already exists on this list");
            return false;
        }
        if (instrumentAlreadyAdded(musician)) {
            System.out.println("There's a musician with this instrument type");
            return false;
        }
        musicians.add(musician);
        return true;
    }

    // method to remove Musician from the band
    public boolean removeMusician(Musician musician) {
        if (!musicianAlreadyAdded(musician)) {
            System.out.println("This user does not exist on this list");
            return false;
        }
        musicians.remove(musician);
        return true;
    }

    // method overloading... Removing musician using index
    public boolean removeMusician(int index) {
        musicians.remove(index);
        return true;
    }

    // method to check if Musician is on the list
    public boolean musicianAlreadyAdded(Musician musician) {
        return musicians.contains(musician);
    }

    // method to get the index of the musician on the list
    public int getPositionOfMusician(Musician musician) {
        if (!musicianAlreadyAdded(musician)) {
            return -1;
        }
        return musicians.indexOf(musician);
    }

    // method to check if there's a musician with the instrument in the band
    public boolean instrumentAlreadyAdded(Musician musician) {
        for (Musician m : musicians) {
            if (m.getInstrument() == musician.getInstrument()) {
                return true;
            }
        };
        return false;
    }
}
