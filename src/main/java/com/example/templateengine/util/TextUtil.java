package com.example.templateengine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    /*
    * 功能说明：判断是否为数字
    * */
    public static boolean isNumericzidai(String str) {
        Pattern pattern = Pattern.compile("^(-|)?d+(.d+)?$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
