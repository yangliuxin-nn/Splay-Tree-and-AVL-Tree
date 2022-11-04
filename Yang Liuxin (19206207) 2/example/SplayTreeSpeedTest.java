package dsa.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dsa.iface.IBinarySearchTree;
import dsa.impl.SplayTree;

/**
 * Class to measure how quickly my Splay Tree implementation works.
 *
 * Strategy: - Insert a number of values (set in the 'range' variable) into an
 * Splay Tree, in random order. - Search for 'range' random variables. - Remove
 * 1/10 of the values from the tree.
 */

public class SplayTreeSpeedTest {
    public static void main( String[] args ) throws Exception {
        int range = 10000000;

        System.out.println( "Values: " + range );

        // get a list of 'range' values.
        List<Integer> values = IntStream.range( 0, range ).boxed().collect( Collectors.toList() );

        // shuffle the list into random order
        Collections.shuffle( values );

        // create the AVL tree
        IBinarySearchTree<Integer> t = new SplayTree<>();

        // record the time I started inserting at
        long start = System.currentTimeMillis();

        // insert all values into the tree
        for ( Integer v : values ) {
            t.insert( v );
        }

        // record the time I stopped inserting at
        long end = System.currentTimeMillis();

        // output the time for inserting
        System.out.println( "Inserting: " + ( end - start ) );

        // shuffle the list again (I should not check this in the same order as I inserted everything)
        Collections.shuffle( values );

        // record the time I started checking contains(...) at
        start = System.currentTimeMillis();


        // find each value in the tree
        for ( int v : values ) {
            t.contains( v );
        }

        // record the end time and print the time taken for contains
        end = System.currentTimeMillis();
        System.out.println( "Contains: " + ( end - start ) );

        // shuffle one more time
        Collections.shuffle( values );

        // record the start again
        start = System.currentTimeMillis();

        // get 10% of the values in this list and remove from the tree
        values = values.subList( 0, values.size() / 10 );
        for ( int v : values ) {
            t.remove( v );
        }

        // print the last time
        end = System.currentTimeMillis();
        System.out.println( "Removing: " + ( end - start ) );
    }
}
