package org.ivermektin.caledonia.services.systemServices;

import java.io.*;
import java.util.ArrayList;

public class FilesystemService {

    public static ArrayList<String> readFile(String filepath){
        ArrayList<String> temp = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(filepath));
            while (file.ready()) {
                temp.add(file.readLine());
            }
            file.close();
        } catch (
                IOException e) {
            System.out.println(e);
        }
        return temp;
    }

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
