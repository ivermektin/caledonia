package org.ivermektin.caledonia.interfaces.systemInterfaces;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is the hygieneInterface.
 * It provides methods to read and save files.
 */

public class filesystemInterface {

    /**
     * Reads a file and returns its contents as an ArrayList of strings.
     *
     * @param filepath the path of the file to be read
     * @return an ArrayList containing the lines of the file
     */
    public static ArrayList<String> readFile(String filepath){
        ArrayList<String> temp = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(filepath));
            while (file.ready()) {
                temp.add(file.readLine());
            }//end while
        } catch (
                IOException e) {
            System.out.println(e);
        }
        return temp;
    }

    /**
     * Saves the contents of an ArrayList into a file.
     *
     * @param filepath the path of the file to be saved
     * @param temp the ArrayList containing the lines to be saved
     */
    public static void saveFile(String filepath, ArrayList temp) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filepath));
            for (int i = 0; i < temp.size(); i++) {
                file.println(temp.get(i));
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * Saves a string into a file.
     *
     * @param filepath the path of the file to be saved
     * @param temp the string to be saved
     */
    public static void saveString(String filepath, String temp) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filepath));
            file.println(temp);
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}