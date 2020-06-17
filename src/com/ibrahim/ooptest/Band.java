package com.ibrahim.ooptest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Band {

    private String name;
    private List<Musician> musicians;

    // new arraylist should be created when initializing a band object

    public Band(String name) {
        this.name = name;
        this.musicians = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    @Override
    public String toString() {
        return "Band{" +
                "Name='" + name + '\'' + "\n" +
                " Musicians= \n" + musicians +
                '}' + "\n";
    }

    /** method to add Musician to the band */
    public boolean addMusician(Musician musician) {
        if (instrumentAlreadyAdded(musician)) {
            return false;
        }
        musicians.add(musician);
        return true;
    }

    /** This methods checks if there's a musician with the instrument in the band */
    private boolean instrumentAlreadyAdded(Musician musician) {
        for (Musician m : musicians) {
            if (m.getInstrument().getClass().getSimpleName().equals(musician.getInstrument().getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    /** This method selects random musician from the band */
    private Musician pickRandomMusician() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.getMusicians().size());
        return this.musicians.get(randomIndex);
    }

    public Musician removeRandomMusician() {
        Musician toBeRemoved = pickRandomMusician();
        musicians.remove(toBeRemoved);
        return toBeRemoved;
    }

}