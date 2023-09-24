package org.ivermektin.caledonia.interfaces.webInterfaces;

import org.ivermektin.caledonia.interfaces.webInterfaces.lowLevel.rawWebInterface;

public class blurbInterface {
    public static String getBlurb(){
        return rawWebInterface.pullFromSite("https://raw.githubusercontent.com/ivermektin/caledonia/main/launcher_webinfo/blurb.txt").get(0);
    }
}
