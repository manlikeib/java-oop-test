package com.ibrahim.ooptest;

import com.ibrahim.ooptest.instrument.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        loadData();

        while(true) {
            displayMenu();

            Scanner scanner = new Scanner(System.in);
            int option = 0;
            if (scanner.hasNextInt(4)) {
                option = scanner.nextInt() ;
            } else {
                System.out.println("Please enter a valid option!");
            }

            switch (option) {
                case 1:
                    listBand();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    close();
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }
    }

    /** This method displays the menu */
    private static void displayMenu() {
        System.out.println("################ W E L C O M E #################" +
                "\n Press 1 for all band information" +
                "\n Press 2 to play one night" +
                "\n Press 3 to exit" +
                "\n PLEASE ENTER A NUMBER: ");
    }

    private static void listBand() {
        System.out.println(StaticFields.bands);
    }

    /** This method deletes random members of the band and adds free musicians. */
    private static void play() {
        removeRandomMusician();
        addFreeMusician();
    }

    /** This method removes random members of the band */
    private static void removeRandomMusician() {
        for (Band band : StaticFields.bands) {
            if (band.getMusicians().size() > 0) {
                Musician removedMusician = band.removeRandomMusician();
                System.out.println("Musician " + removedMusician.getName() + " left " +
                        band.getName());
                StaticFields.freeMusicians.add(removedMusician);
            }
        }
    }

    /** This method tries to add a free musician to an available band
     * Any musician that fails to get a band at the end of the loop
     * remains in the tempList which is then copied into freeMusicians
     * list
     * */
    private static void addFreeMusician() {

        ArrayList<Musician> tempList = new ArrayList<>();
        tempList.addAll(StaticFields.freeMusicians);

        Random random = new Random();

        for (Musician freeMusician : StaticFields.freeMusicians) {
            int randomBond = random.nextInt(StaticFields.bands.size());
            if (StaticFields.bands.get(randomBond).addMusician(freeMusician)) {
                System.out.println("Musician " + freeMusician.getName() + " joined " +
                        StaticFields.bands.get(randomBond).getName());
                tempList.remove(freeMusician);
            }
            else {
                for (Band band : StaticFields.bands) {
                    if (band.addMusician(freeMusician)) {
                        System.out.println("Musician " + freeMusician.getName() + " joined " +
                                band.getName());
                        tempList.remove(freeMusician);
                        break;
                    }
                }
            }
        }
        StaticFields.freeMusicians.removeAll(StaticFields.freeMusicians);
        for (Musician musician : tempList) {
            StaticFields.freeMusicians.add(musician);
        }
        System.out.println("Free musicians: " + StaticFields.freeMusicians);
    }

    private static void close() {
        System.exit(0);
    }

    /** Load initial data */
    private static void loadData() {
        // create the first band
        Band band1 = new Band("Spoke 'n hub");
        StaticFields.bands.add(band1);

        // create the second band
        Band band2 = new Band("Fleerats");
        StaticFields.bands.add(band2);

        // create instrument and musician objects for first band
        Instrument guitar1 = new Guitar("Bender", 5, 0.4);
        Musician musician1 = new Musician("Liza Baar", guitar1);

        Instrument piano1 = new Piano("McFaren", 51, true);
        Musician musician2 = new Musician("Null Beat", piano1);

        Instrument synthesizer1 = new Synthesizer("Lorg", 47, true);
        Musician musician3 = new Musician("Void", synthesizer1);

        // Add musicians to Spook 'n hub band
        band1.addMusician(musician1);
        band1.addMusician(musician2);
        band1.addMusician(musician3);

        // create instrument and musician objects for second band
        Instrument banjo1 = new Banjo("Gibson", 4, 8);
        Musician musician4 = new Musician("Stringsteen", banjo1);

        Instrument drums1 = new Drums("Toyota", true);
        Musician musician5 = new Musician("Xindea", drums1);

        Instrument synthesizer2 = new Synthesizer("Suzuki", 72, false);
        Musician musician6 = new Musician("Captor", synthesizer2);

        // Add musicians to Fleerats band
        band2.addMusician(musician4);
        band2.addMusician(musician5);
        band2.addMusician(musician6);


        // extra musician
        Instrument banjo2 = new Banjo("Spic", 72, 0.7);
        Musician musician7 = new Musician("Ivy Joee", banjo2);
        StaticFields.freeMusicians.add(musician7); // add her to list of free musicians so she can be added to a random band later

        Musician musician8 = new Musician("Jacuzzi", new Banjo("Ibile", 45, 0.6));
        Musician musician9 = new Musician("Spending", new Banjo("Locale", 32, 0.4));
        StaticFields.freeMusicians.add(musician8);
        StaticFields.freeMusicians.add(musician9);

        // creating my own empty custom band to test option 2
        Band band3 = new Band("Men like IB");
        StaticFields.bands.add(band3);

        System.out.println("All data have been entered!");
    }
}
