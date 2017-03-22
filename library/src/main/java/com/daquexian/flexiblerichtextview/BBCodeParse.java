package com.daquexian.flexiblerichtextview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by panjun on 2015/7/20.
 */
public class BBCodeParse {

    private static final String REPLACE_NO_PARSE = "np~@!#np";
    private static final String TAG_NO_PARSE = "\\[noparse\\](.+?)\\[/noparse\\]";

    public static String bbcode2Html(String text) {
        if (text == null) {
            return "";
        }
        String html = text;
        Map<String, String> bbMap = BBCodeMaps.getBBcodeMap();

        html = parseNoParse2Lowercase(html);
        ArrayList<String> noParseList = getNoParseList(html);

        html = replaceNoParseTag(html);

        for (Map.Entry entry : bbMap.entrySet()) {
            if (entry.getKey().toString().contains("\\[list\\](.+?)\\[/list\\]")) {
                html = bbcodeListParse(html);
            }
            html = html.replaceAll(entry.getKey().toString(), entry.getValue().toString());
        }
        html = recoveryNoParseTag(html, noParseList);
        return html;
    }

    /**
     * To lowercase
     * @param text
     * @return
     */
    private static String parseNoParse2Lowercase(String text) {
        Map<String, String> bbMap = new HashMap<String, String>();
        bbMap.put("\\[noparse\\](.+?)\\[/noparse\\]", "\\[noparse\\]$1\\[/noparse\\]");
        bbMap.put("\\[NOPARSE\\](.+?)\\[/NOPARSE\\]", "\\[noparse\\]$1\\[/noparse\\]");

        for (Map.Entry entry : bbMap.entrySet()) {
            text = text.replaceAll(entry.getKey().toString(), entry.getValue().toString());
        }

        return text;
    }

    /**
     * Get the string list which is contains in tag [noparse][/noparse].
     * @param text
     * @return
     */
    private static ArrayList<String> getNoParseList(String text) {
        Pattern p = Pattern.compile(TAG_NO_PARSE);
        Matcher m = p.matcher(text);
        ArrayList<String> noParseList = new ArrayList<String>();
        while (m.find()) {
            noParseList.add(m.group(1));
        }
        return noParseList;
    }

    /**
     * Replace tag [noparse][/noparse] by special strings.
     * @param text
     * @return
     */
    private static String replaceNoParseTag(String text) {
        return text.replaceAll(TAG_NO_PARSE, REPLACE_NO_PARSE);
    }

    /**
     * Recovery the original strings which in noParseList
     * @param text
     * @param noParseList
     * @return
     */
    private static String recoveryNoParseTag(String text, ArrayList<String> noParseList) {
        int pos = 0;
        while (text.indexOf(REPLACE_NO_PARSE) != -1 && pos < noParseList.size()) {
            text = text.replaceFirst(REPLACE_NO_PARSE, noParseList.get(pos));
            pos++;
        }
        return text;
    }

    /**
     * Parse List Tag: [list] [*]Entry 1 [*]Entry 2 [/list] or [list] *Entry 1 *Entry 2 [/list]
     * @param html html text
     * @return html
     */
    private static String bbcodeListParse(String html) {
        String listTagStart = "[list]";
        String listTagEnd = "[/list]";
        String asteriskTag1 = "[*]";
        String asteriskTag2 = "*";

        int pos = 0;
        // Only replace * which contains in [list]...[/list]
        while (html.indexOf(listTagStart, pos) != -1) {
            int sPos = html.indexOf(listTagStart, pos);
            int ePos = html.indexOf(listTagEnd, sPos) + listTagEnd.length();
            pos = ePos;

            boolean isAsteriskTag = false;

            String str1 = html.substring(sPos, ePos);
            String str2 = html.substring(sPos, ePos);

            // This must be first step
            if (str1.contains(asteriskTag1)) {
                while (str1.contains(asteriskTag1)) {
                    str1 = str1.replaceAll("\\[\\*\\](.+?)\\[", "<li>$1</li>\\[");
                }
                isAsteriskTag = true;
            }
            if (html.contains(asteriskTag2)) {
                str1 = str1.replaceAll("\\*", asteriskTag1);
                while (str1.contains(asteriskTag1)) {
                    str1 = str1.replaceAll("\\[\\*\\](.+?)\\[", "<li>$1</li>\\[");
                }
                isAsteriskTag = true;
            }
            if (isAsteriskTag) {
                html = html.substring(0, html.indexOf(str2)) + str1 + html.substring(html.indexOf(str2) + str2.length(), html.length());
            }
        }
        return  html;
    }
}
