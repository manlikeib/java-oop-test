package com.ibrahim.ooptest;

import java.util.ArrayList;
import java.util.List;

/** This class will hold all static fields.
 * The static fields are the list of bands and list of free musicians.
 * This will ensure that there are no static variables in the main class
 * */
public class StaticLists {

    static List<Band> bands = new ArrayList<>(); // This will store the Band objects
    static List<Musician> freeMusicians = new ArrayList<>();

}
