package org.ivermektin.caledonia.interfaces.webInterfaces;

import org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel.rawWebInterface;

import java.util.ArrayList;

/**
 * This class is the updateInterface.
 * It provides methods to check for updates and retrieve information about the latest update.
 * It interacts with the rawWebInterface to get data about the latest version and compare it with the current version.
 */

public class updateInterface {

    /**
     * Checks if the given version is the most recent version.
     * @param versionName the name of the version to check
     * @return true if the given version is the most recent version, false otherwise
     */
    public static boolean isRecent(String versionName){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(" : ")[0].equals(versionName);
    }

    /**
     * Checks if an update is required for the given version.
     * An update is required if the given version is not the most recent version and the most recent version
     * is marked as "[REQUIRED]" in the version information.
     * @param versionName the name of the version to check
     * @return true if an update is required for the given version, false otherwise
     */
    public static boolean updateRequired(String versionName){
        ArrayList<String> data = pullVersionInfo();
        if(isRecent(versionName)) return false;
        return data.get(0).split(" : ")[1].startsWith("[REQUIRED]");
    }

    /**
     * Retrieves the description of the latest update.
     * @return the description of the latest update
     */
    public static String getLatestUpdateDescription(){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(" : ")[1];
    }

    /**
     * Retrieves the version number of the latest update.
     * @return the version number of the latest update
     */
    public static String getLatestUpdateVersion(){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(" : ")[0];
    }

    /**
     * Retrieves the version information from a web interface.
     * @return the version information as an ArrayList<String>
     */
    public static ArrayList<String> pullVersionInfo(){
        return rawWebInterface.pullFromSite("https://raw.githubusercontent.com/ivermektin/caledonia/main/launcher_webinfo/versionInfo.txt");
    }
}
