package com.canvas.testtask;

import org.testng.annotations.DataProvider;

public class TitleProcessingOperatorDataProvider {

    @DataProvider(name = "PunctuationMarksInTheEnd")
    public static Object[][] punctuationMarksInTheEnd() {
        return new Object[][]{
                {10, "01 23, 45 67", "01 23..."},
                {10, "01 23 - 45 67", "01 23..."}};
    }

    @DataProvider(name = "EndWithWholeWord")
    public static Object[][] endWithWholeWord() {
        return new Object[][]{
                {10, "01 23 45 67", "01 23..."},
                {10, "01 23-45 67", "01..."},
                {10, "01 \"23\" 45 67", "01 \"23\"..."}};
    }
}