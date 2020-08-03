package com.ptong.worldcities.utils;

public class DataUtils {

    public static String removeBrackets(String str) {
        return str.replaceAll("\\[.*\\]", "").trim();
    }

}