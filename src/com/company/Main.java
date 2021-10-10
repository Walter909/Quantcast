package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static com.company.CookieReader.printResults;
import static com.company.CookieReader.readFile;

public class Main {

    public static void main(String[] args) {

       if (args.length != 3){
           System.out.println("Arguments must be of the form 'file.csv -d 2018-12-09'");
           return;
       }

        HashMap<String, Integer> cookieFrequencyMap = new HashMap<>();

        try {
            cookieFrequencyMap = readFile(args[0], args[2]);
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found!");
        } catch (IOException e) {
            System.out.println("File input/output error!");
        }

        if (!cookieFrequencyMap.isEmpty()) {
            printResults(cookieFrequencyMap);
        }

    }

}

