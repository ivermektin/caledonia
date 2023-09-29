package org.ivermektin.caledonia.interfaces.webInterfaces;

import org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel.RawWebManager;

public class BlurbManager extends RawWebManager{
    private static String BLURB_SITE = "https://raw.githubusercontent.com/ivermektin/caledonia/main/launcher_webinfo/blurb.txt";
    public static String getBlurb(){
        return pullFromSite(BLURB_SITE).get(0);
    }
}
