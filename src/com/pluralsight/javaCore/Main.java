package com.pluralsight.javaCore;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {
        doTryWithResources();
    }

    public static void doTryWithResources(){
        char buff[] = new char[8];
        int length;
        try(Reader reader = new FileReader("file1.txt")){
            while((length = reader.read(buff)) >=0){
                for(char charVal : buff){
                    System.out.println(charVal);
                }
            }

        }
        catch (IOException e){
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
