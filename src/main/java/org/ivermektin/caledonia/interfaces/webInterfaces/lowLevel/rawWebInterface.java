package org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class is the rawWebInterface.
 * It is used by the updateInterface and blurbInterface.
 * It uses Java's basic networking interface.
 */
public class rawWebInterface {

    /**
     * This method is used to pull data from a specific website by
     * taking in the URL as a parameter and returning an ArrayList
     * of strings containing the data from the website.
     * @param URL - the URL of the website to pull data from
     * @return an ArrayList of strings containing the data from the website
     * @throws IOException if an error occurs while reading the data from the website
     */
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
