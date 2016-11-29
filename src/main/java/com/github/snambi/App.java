package com.github.snambi;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Java 8 Streams benchmark" );

        int count = 500;
        if( args != null && args.length == 1 ){
                // convert args to count
                count = Integer.parseInt(args[0]);
        }

        App app = new App();

        app.benchmark(count);
    }

    public void benchmark( int count ){

        System.out.println("Number of iterations: "+ count);

        // first create a list
        List<String> words = new ArrayList<String>();
        Queue queue = new ConcurrentLinkedQueue();

        // Add 500 words into the list
        for( int i=0 ; i<count; i++ ){
            words.add(UUID.randomUUID().toString() );
        }

        long begin1 = Calendar.getInstance().getTimeInMillis();
        for( String word: words ){
//            System.err.print( word);
//            System.err.print(" ");
            word.toLowerCase();
        }
        long end1 = Calendar.getInstance().getTimeInMillis();

        System.out.println("Java7 For Loop: time taken = "+ ( end1-begin1) + " ms");

        long begin2 = Calendar.getInstance().getTimeInMillis();
        words.stream().forEach( e -> e.toLowerCase());
        long end2 = Calendar.getInstance().getTimeInMillis();

        System.out.println("Java8 Stream: time taken = "+ ( end2-begin2) + " ms");


        long begin3 = Calendar.getInstance().getTimeInMillis();
        words.stream().parallel().forEach(e -> e.toLowerCase());
        long end3 = Calendar.getInstance().getTimeInMillis();

        System.out.println("Java8 Parallel Stream: time taken = "+ ( end3-begin3) + " ms");

        System.out.println("Total number of items: "+ queue.size());
    }
}
