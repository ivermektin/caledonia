package org.ivermektin.caledonia.interfaces.webInterfaces;

import org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel.RawWebManager;

public class BlurbManager extends RawWebManager{
    public static String getBlurb(){
        return pullFromSite("https://raw.githubusercontent.com/ivermektin/caledonia/main/launcher_webinfo/blurb.txt").get(0);
    }
}
