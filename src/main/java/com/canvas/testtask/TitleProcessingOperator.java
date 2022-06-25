package com.canvas.testtask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleProcessingOperator {

    public static String shortenTitleLength(int requiredLength, String title) {
        StringBuilder finalTitle = new StringBuilder();
        Matcher matcher = Pattern.compile("(\\S+)").matcher(title);

        if (title.length() <= requiredLength) {
            return title;
        } else {
            while (matcher.find() && finalTitle.length() + matcher.group().length() <= requiredLength - 3) {
                finalTitle.append(matcher.group()).append(" ");
            }
            return finalTitle.toString().replaceFirst("^(.*?)([\\w\\-\"]+)(\\W*)(\\s+)$", "$1$2...");
        }
    }
}