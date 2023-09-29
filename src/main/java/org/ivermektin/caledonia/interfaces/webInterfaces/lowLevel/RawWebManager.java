package org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class RawWebManager {
    
    public static ArrayList<String> pullFromSite(String URL){
        ArrayList<String> data = new ArrayList<>();
        try {
            java.net.URL webpage = new URL(URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(webpage.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
