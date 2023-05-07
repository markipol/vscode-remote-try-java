package com.mycompany.app;
import java.io.*;

public class Lab6 {
    public static void main(String[] args) throws IOException,  EOFException{

        File file = new File("file.txt");
        // write:
        // FileOutputStream fos = new FileOutputStream(file, false);
        // ObjectOutputStream outFile = new ObjectOutputStream(fos);
        // outFile.writeInt(6);
        // outFile.writeDouble(5.5);
        // outFile.writeBoolean(true);
        // outFile.writeUTF("S");
        // outFile.close();

        // read:
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(ois.readInt());
        System.out.println(ois.readDouble());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());
        ois.close();


 
    }
}
