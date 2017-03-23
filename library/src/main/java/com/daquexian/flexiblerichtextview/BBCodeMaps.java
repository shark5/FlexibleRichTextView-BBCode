package com.daquexian.flexiblerichtextview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panj on 2017/3/17.
 */

public class BBCodeMaps {

    public static Map<String, String> getCovertMap() {
        Map<String, String> bbMap = new HashMap<String, String>();

        bbMap.put("\\[url\\](.+?)\\[/url\\]", "[url=$1]$1[/url]");
        bbMap.put("\\[url=(.+?)\\]\\[img(.+?)\\[/img\\]\\[/url\\]", "[img link=$1$2[/img]");
        bbMap.put("\\[img=(.+?)x(.+?)\\](.+?)\\[/img\\]", "[img width=$1 height=$2]$3[/img]");
        return bbMap;
    }
}
