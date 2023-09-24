package org.ivermektin.caledonia.interfaces.domesticInterfaces.objects;

import java.util.ArrayList;

/**
 * This object class is packagedData.
 * It is used for GSON to read information from the files in which content is saved.
 * This is because it instantly reads like an object instead of an Array, so the Array must
 * be put inside an object.
 */

public class packagedData {
    public ArrayList<data> data;

    /**
     * Constructs a packagedData object with the given data.
     *
     * @param data the ArrayList of data objects
     */
    public packagedData(ArrayList<data> data) {
        this.data = data;
    }
}