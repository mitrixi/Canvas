package com.canvas.testtask;

import java.util.regex.Pattern;

public class TitleProcessingOperator {

    public static String shortenTitleLength(int requiredLength, String title) {
        if (title.length() <= requiredLength) {
            return title;
        } else {
            var matcher = Pattern.compile("(\\S+)").matcher(title);
            var finalTitle = new StringBuilder();

            while (matcher.find() && finalTitle.length() + matcher.group().length() <= requiredLength - 3) {
                finalTitle.append(matcher.group()).append(" ");
            }
            return finalTitle.toString().replaceFirst("^(.*?)([\\w\\-\"]+)(\\W*)(\\s+)$", "$1$2...");
        }
    }
}