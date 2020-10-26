package com.pluralsight.javaCore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        //bufferedReaderImpl();
        javaNIOImpl();
    }

    //try-with-resource
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

    //chaining streams
    public static void chainingStreams(InputStream in){

        int length;
        char[] buff = new char[8];
        try(InputStreamReader reader = new InputStreamReader(in)){
            for(char charVal : buff){
                System.out.println(charVal);
            }

        }
        catch (IOException e){
            System.out.println(e.getClass().getSimpleName());
        }
    }

    //buffered-reader
    public static void bufferedReaderImpl(){
        String inputValue;
        try(BufferedReader reader = new BufferedReader(new FileReader("file1.txt"))){
            while((inputValue = reader.readLine())!= null){
                System.out.println(inputValue);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    //java-nio
    public static void javaNIOImpl(){
        Path path = Paths.get("file1.txt");
        String inputValue;
        //instead of new BufferedReader, we use factory methods of Files
        try(BufferedReader reader = Files.newBufferedReader(path)){
            while((inputValue = reader.readLine())!= null){
                System.out.println(inputValue);
            }
        }
        catch (IOException e){
            System.out.println(e.getClass().getSimpleName());
        }

    }

}
