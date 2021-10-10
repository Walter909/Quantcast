package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CookieReader {

    public static HashMap<String, Integer> readFile(String fileName, String date) throws IOException {

        BufferedReader r = new BufferedReader(new FileReader(fileName));

        String line = r.readLine();
        HashMap<String, Integer> cookieFrequencyMap = new HashMap<>();

        while (line != null) {
            line = r.readLine(); // skip first line: cookie,timestamp

            if (line == null || line.equals("")) {
                continue;
            }

            String[] parts = line.split(",");

            if (date.equals(line.substring(17, 27))) {
                String cookie = parts[0];
                if (!cookieFrequencyMap.containsKey(cookie)) { // check for duplicate cookies
                    cookieFrequencyMap.put(cookie, 1);
                } else {
                    cookieFrequencyMap.replace(cookie, cookieFrequencyMap.get(cookie) + 1);
                }
            }
        }
        return cookieFrequencyMap;

    }

    public static void printResults(HashMap<String, Integer> cookieFrequencyMap) {
        int maxValueInMap = Collections.max(cookieFrequencyMap.values()); // max value in hashmap

        for (Map.Entry<String, Integer> entry : cookieFrequencyMap.entrySet()) {
            if (maxValueInMap == entry.getValue()) {
                System.out.println(entry.getKey());
            }
        }
    }
}
