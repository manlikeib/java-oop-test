package com.ibrahim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<Band> bands = new ArrayList<>(); // This will store the Band objects
    static List<Musician> freeMusicians = new ArrayList<>(); // This will store musicians not in any band
    static List<Musician> unableToJoinBand = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {

        // Load initial data
        loadData();

        // The menu will be displayed now
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

    private static void loadData() {
        // create the first band
        Band band1 = new Band("Spoke 'n hub");
        bands.add(band1);

        // create the second band
        Band band2 = new Band("Fleerats");
        bands.add(band2);

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
        freeMusicians.add(musician7); // add her to list of free musicians so she can be added to a random band later
        unableToJoinBand.add(musician7);

        // creating my own empty custom band to test option 2
        Band band3 = new Band("Men like IB");
        bands.add(band3);

        System.out.println("All data have been entered!");
    }

    private static void displayMenu() {
        System.out.println("################ W E L C O M E #################" +
                "\n Press 1 for all band information" +
                "\n Press 2 to play one night" +
                "\n Press 3 to exit" +
                "\n PLEASE ENTER A NUMBER: ");
    }

    private static void listBand() {
        System.out.println(bands);
    }

    // method to delete random members of the band end add free musicians.
    private static void play() {
        for (Band band : bands) {
            if (band.getMusicians().size() > 0) {
                Musician removedMusician = band.removeRandomMusician();
                System.out.println("Musician " + removedMusician.getName() + " left " +
                        band.getName());
                freeMusicians.add(removedMusician);
                unableToJoinBand.add(removedMusician);
            }
        }

        // assign all free musicians to available bands
        for (Musician freeMusician : freeMusicians) {
            int randomBond = random.nextInt(bands.size());

            if (bands.get(randomBond).addMusician(freeMusician)) {
                System.out.println("Musician " + freeMusician.getName() + " joined " +
                        bands.get(randomBond). getName());
                unableToJoinBand.remove(freeMusician);
            }

        }
        freeMusicians.removeAll(freeMusicians);
        for (Musician musician : unableToJoinBand) {
            freeMusicians.add(musician);
        }

    }

    private static void close() {
        System.exit(0);
    }
}
