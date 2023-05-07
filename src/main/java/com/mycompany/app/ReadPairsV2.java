package com.mycompany.app;
import java.io.*;

public class ReadPairsV2 {
    public static void main(String[] args) throws IOException,  EOFException{

        File numbers = new File("Lab6Files/numbers3.bin");
        File rules = new File("Lab6Files/rules3.bin");
        // write:
        // FileOutputStream fos = new FileOutputStream(file, false);
        // ObjectOutputStream outFile = new ObjectOutputStream(fos);
        // outFile.writeInt(6);
        // outFile.writeDouble(5.5);
        // outFile.writeBoolean(true);
        // outFile.writeUTF("S");
        // outFile.close();

        // read:
        
        ObjectInputStream nois = new ObjectInputStream(new FileInputStream(numbers));
        ObjectInputStream rois = new ObjectInputStream(new FileInputStream(rules));
        for (int i=0;i<5;i++){
            System.out.printf("%-4d: %s \n", nois.readInt(), rois.readUTF());
            
            
        }
        nois.close();
        rois.close();
        // System.out.println(ois.readInt());
        // System.out.println(ois.readDouble());
        // System.out.println(ois.readBoolean());
        // System.out.println(ois.readUTF());
        // ois.close();


 
    }
}
