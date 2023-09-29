package org.ivermektin.caledonia.services.internalServices.objects;

import java.util.ArrayList;

/**
 * This object class is PackagedData.
 * It is used for GSON to read information from the files in which content is saved.
 * This is because it instantly reads like an object instead of an Array, so the Array must
 * be put inside an object.
 */

public class PackagedData {
    public ArrayList<Data> data;

    public PackagedData(ArrayList<Data> data) {
        this.data = data;
    }
}
