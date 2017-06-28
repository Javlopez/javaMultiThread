package com.jav.lopez;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
	// write your code here

        String[] inFiles = {"files/file1.txt", "files/file2.txt", "files/file3.txt", "files/file4.txt", "files/file5.txt"};
        String[] outFiles = {"files/file1.out.txt", "files/file2.out.txt", "files/file3.out.txt", "files/file4.out.txt", "files/file5.out.txt"};

        Thread[] threads = new Thread[inFiles.length];



        for (int i = 0; i < inFiles.length; i++) {

            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        }catch (InterruptedException e) {
            System.out.println("the application is failing " + e.getMessage());
        }
    }
}
