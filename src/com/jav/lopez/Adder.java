package com.jav.lopez;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Adder implements Runnable {

    private String inFile, outFile;

    public Adder(String inFile, String outFile){
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        int total = 0;
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
                writer.write("Total: " + total + " - Time:" + timeStamp);
            }
        }
    }

    public void run() {

        try {
            doAdd();
        }catch (IOException e) {

        }

    }


}
