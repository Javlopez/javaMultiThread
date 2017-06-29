package com.jav.lopez;

import java.io.IOException;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
	// write your code here

        String[] inFiles = {"files/file1.txt", "files/file2.txt", "files/file3.txt", "files/file4.txt", "files/file5.txt"};
        String[] outFiles = {"files/file1.out.txt", "files/file2.out.txt", "files/file3.out.txt", "files/file4.out.txt", "files/file5.out.txt"};

        //Thread[] threads = new Thread[inFiles.length];

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];



        for (int i = 0; i < inFiles.length; i++) {

            Adder adder = new Adder(inFiles[i], outFiles[i]);
            //es.submit(adder);
            results[i] = es.submit(adder);

            //threads[i] = new Thread(adder);
            //threads[i].start();
        }

        for(Future<Integer> result:results) {
            try {
                int value = result.get();
                System.out.println("Total:" + value);
            } catch (ExecutionException e) {
                Throwable adderException = e.getCause(); // Get adder Exception

                System.out.println("Something happened here ExecutionException" );
            } catch (Exception e) {
                System.out.println("Something happened here Normal Exception" );
            }

        }

        /*

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);

        }catch (InterruptedException e) {
            System.out.println("the application is failing " + e.getMessage());
        }*/
    }
}
