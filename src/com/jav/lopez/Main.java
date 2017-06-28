package com.jav.lopez;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[] inFiles = {"files/file1.txt", "files/file2.txt", "files/file3.txt", "files/file4.txt", "files/file5.txt"};
        String[] outFiles = {"files/file1.out.txt", "files/file2.out.txt", "files/file3.out.txt", "files/file4.out.txt", "files/file5.out.txt"};


        try {
            for (int i = 0; i < inFiles.length; i++) {

                Adder adder = new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();

            }
        }catch (IOException e) {
            System.out.println("Something happened");
        }
    }
}
