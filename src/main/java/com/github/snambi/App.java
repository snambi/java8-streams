package com.github.snambi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // first create a list
        List<String> words = new ArrayList<String>();

        // Add 500 words into the list
        for( int i=0 ; i<100; i++ ){
            words.add(UUID.randomUUID().toString() );
        }

        long begin1 = Calendar.getInstance().getTimeInMillis();
        for( String word: words ){
            System.err.print( word);
            System.err.print(" ");
        }
        long end1 = Calendar.getInstance().getTimeInMillis();

        System.err.println("\n time taken = "+ ( end1-begin1));

        long begin2 = Calendar.getInstance().getTimeInMillis();
        words.stream().forEach( System.err::print);
        long end2 = Calendar.getInstance().getTimeInMillis();

        System.out.println("\n time taken = "+ ( end2-begin2));


        long begin3 = Calendar.getInstance().getTimeInMillis();
        words.stream().parallel().forEach( System.err::print);
        long end3 = Calendar.getInstance().getTimeInMillis();

        System.out.println("\n time taken = "+ ( end3-begin3));
    }
}
