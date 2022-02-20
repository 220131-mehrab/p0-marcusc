package com.revature.cardex;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

    private Scanner x;

    public void openFile() {
        try{
            x = new Scanner(new File("cars.csv"));
        }
        catch (Exception e) {
            System.out.println("Could not find file.");
        }

    }
    public void readFile(){
        while(x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String e = x.next();

            System.out.println(a+b+e);
        }
        closeFileVoid();



    }
    public void closeFileVoid() {
        x.close();
    }

}
