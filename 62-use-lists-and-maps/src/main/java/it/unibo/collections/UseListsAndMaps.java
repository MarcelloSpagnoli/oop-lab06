package it.unibo.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int CYCLE = 1000;
    private static final int ADD = 100000;
    private static final int READ = 1000;

    private static final long AFRICA  = 1110635000L;
    private static final long AMERICA  = 72005000L;
    private static final long ANTARCTICA  = 0;
    private static final long ASIA  = 4298723000L;
    private static final long EUROPE  = 742452000L;
    private static final long OCEANIA  = 38304000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        ArrayList<Integer> arrayList = new ArrayList<>();
        for ( int i = 0; i < CYCLE ; i++ ) {
            arrayList.add(i + 1000);
        }


        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp;
        temp = arrayList.getLast();
        arrayList.set(arrayList.size() - 1, arrayList.getFirst());
        arrayList.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for ( int i = 0; i < ADD ; i++ ) {
            arrayList.add(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ADD
                + " ints to String and inserting them in a array list took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for ( int i = 0; i < ADD ; i++ ) {
            linkedList.add(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + ADD
                + " ints to String and inserting them in a linked list took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        for ( int i = 0; i < READ ; i++ ) {
            arrayList.get(arrayList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + READ
                + " ints to String and inserting them in a array list took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for ( int i = 0; i < READ ; i++ ) {
            linkedList.get(linkedList.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Adding "
                + READ
                + " ints to String and inserting them in a linked list took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final HashMap<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA); 
        map.put("America", AMERICA); 
        map.put("Antarctica", ANTARCTICA); 
        map.put("Asia", ASIA); 
        map.put("Europe", EUROPE); 
        map.put("Oceania", OCEANIA); 

        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        final ArrayList<Long> people = (ArrayList<Long>) map.values();
        for (Long long1 : people) {
            population = population + long1;
        }
        System.out.println();
    }
}
