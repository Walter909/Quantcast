package com.company;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.HashMap;

public class CookieReaderTest {

    @Test
    public void testReadFile() throws IOException {
        HashMap<String,Integer> cookieFrequencyMap = CookieReader.readFile("cookie_log.csv","2018-12-09");

        Assertions.assertEquals(cookieFrequencyMap.get("AtY0laUfhglK3lC7"),2);
        Assertions.assertEquals(cookieFrequencyMap.get("SAZuXPGUrfbcn5UA"),1);
        Assertions.assertEquals(cookieFrequencyMap.get("5UAVanZf6UtGyKVS"),1);

        Assertions.assertFalse(cookieFrequencyMap.containsKey("vbhnfujbgfbchdufdh"));
    }

}
