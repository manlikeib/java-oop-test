package com.ibrahim.ooptest;

import com.ibrahim.ooptest.instrument.keyboard.Piano;
import com.ibrahim.ooptest.instrument.keyboard.Synthesizer;
import com.ibrahim.ooptest.instrument.percussion.Drums;
import com.ibrahim.ooptest.instrument.string.Banjo;
import com.ibrahim.ooptest.instrument.string.Guitar;

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
                option = scanner.nextInt();
            } else {
                System.out.println("Invalid input!");
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
                    System.out.println("Please enter a valid number!");
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
        System.out.println(StaticLists.bands);
    }

    /** This method deletes random members of the band and adds free musicians. */
    private static void play() {
        removeRandomMusician();
        addFreeMusician();
    }

    /** This method removes random members of the band */
    private static void removeRandomMusician() {
        for (Band band : StaticLists.bands) {
            if (band.getMusicians().size() > 0) {
                Musician removedMusician = band.removeRandomMusician();
                System.out.println("Musician " + removedMusician.getName() + " left " +
                        band.getName());
                StaticLists.freeMusicians.add(removedMusician);
            }
        }
    }

    /** This method adds a free musician to an available band
     * Any musician that fails to get a band at the end of the loop
     * remains in the tempList which is then copied into freeMusicians
     * list
     * */
    private static void addFreeMusician() {

        ArrayList<Musician> tempList = new ArrayList<>();
        tempList.addAll(StaticLists.freeMusicians);

        Random random = new Random();

        for (Musician freeMusician : StaticLists.freeMusicians) {
            int randomBond = random.nextInt(StaticLists.bands.size());
            if (StaticLists.bands.get(randomBond).addMusician(freeMusician)) {
                System.out.println("Musician " + freeMusician.getName() + " joined " +
                        StaticLists.bands.get(randomBond).getName());
                tempList.remove(freeMusician);
            }
            else {
                for (Band band : StaticLists.bands) {
                    if (band.addMusician(freeMusician)) {
                        System.out.println("Musician " + freeMusician.getName() + " joined " +
                                band.getName());
                        tempList.remove(freeMusician);
                        break;
                    }
                }
            }
        }
        StaticLists.freeMusicians.removeAll(StaticLists.freeMusicians);
        for (Musician musician : tempList) {
            StaticLists.freeMusicians.add(musician);
        }
        System.out.println("Free musicians: " + StaticLists.freeMusicians);
    }

    private static void close() {
        System.exit(0);
    }

    /** Load initial data */
    private static void loadData() {

        Band band1 = new Band("Spoke 'n hub");
        Band band2 = new Band("Fleerats");
        StaticLists.bands.add(band1);
        StaticLists.bands.add(band2);

        Musician musician1 = new Musician("Liza Baar", new Guitar("Bender", 5, 0.4));
        Musician musician2 = new Musician("Null Beat", new Piano("McFaren", 51, true));
        Musician musician3 = new Musician("Void", new Synthesizer("Lorg", 47, true));

        // Adding musicians to Spook 'n hub band
        band1.addMusician(musician1);
        band1.addMusician(musician2);
        band1.addMusician(musician3);

        Musician musician4 = new Musician("Stringsteen", new Banjo("Gibson", 4, 8));
        Musician musician5 = new Musician("Xindea", new Drums("Toyota", true));
        Musician musician6 = new Musician("Captor", new Synthesizer("Suzuki", 72, false));

        // Adding musicians to Fleerats band
        band2.addMusician(musician4);
        band2.addMusician(musician5);
        band2.addMusician(musician6);

        // extra musicians
        Musician musician7 = new Musician("Ivy Joe", new Banjo("Spic", 72, 0.7));
        Musician musician8 = new Musician("Jacuzzi", new Banjo("Ibile", 45, 0.6));
        Musician musician9 = new Musician("Spending", new Banjo("Locale", 32, 0.4));
        StaticLists.freeMusicians.add(musician7);
        StaticLists.freeMusicians.add(musician8);
        StaticLists.freeMusicians.add(musician9);

        // creating my own empty custom band to test option 2
        Band band3 = new Band("Men like IB");
        StaticLists.bands.add(band3);

        System.out.println("All data have been loaded!");
    }
}