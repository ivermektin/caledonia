package org.ivermektin.caledonia.interfaces.webInterfaces;

import org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel.RawWebManager;

import java.util.ArrayList;

public class VersionManager extends RawWebManager {

    private static String VERSION_INFO_URL = "https://raw.githubusercontent.com/ivermektin/caledonia/main/launcher_webinfo/versionInfo.txt";
    private static String DELIMITER = " : ";
    private static String REQUIRED_TAG = "[REQUIRED]";

    public static boolean isRecent(String versionName){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(DELIMITER)[0].equals(versionName);
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
        return data.get(0).split(DELIMITER)[1].startsWith(REQUIRED_TAG);
    }

    public static String getLatestUpdateDescription(){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(DELIMITER)[1];
    }

    public static String getLatestUpdateVersion(){
        ArrayList<String> data = pullVersionInfo();
        return data.get(0).split(DELIMITER)[0];
    }

    public static ArrayList<String> pullVersionInfo(){
        return pullFromSite(VERSION_INFO_URL);
    }
}
