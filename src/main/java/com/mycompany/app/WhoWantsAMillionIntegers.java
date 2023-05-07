package com.mycompany.app;
import java.io.*;

public class WhoWantsAMillionIntegers {
    public static void main(String[] args) throws IOException{
        //ONE. MILLON. INTEGERS.
        PrintWriter outText = new PrintWriter(new FileWriter("million.txt"));
        
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000000; ++i){
            outText.print(i + " ");
        }
        long stop = System.currentTimeMillis();
        System.out.println("text mode: time elapsed: " + (stop - start));

        ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("million.dat"));

        long binstart = System.currentTimeMillis();
        for (int i = 1; i < 1000000; ++i){
            outFile.writeInt(i);
        }
        long binstop = System.currentTimeMillis();
        System.out.println("bin mode: time elapsed: " + (binstop - binstart));
    }
}
