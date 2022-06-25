package com.canvas.testtask;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TitleProcessingOperatorTest {

    @Test
    public void shouldDisplayAppropriateLengthTitleInWhole() {
        String result = TitleProcessingOperator.shortenTitleLength(10, "0123456789");
        assertThat(result).isEqualTo("0123456789");
    }

    @Test
    public void shouldTrimLongTitleAndPutEllipsisInTheEnd() {
        String result = TitleProcessingOperator.shortenTitleLength(10, "0 123456789");
        assertThat(result).isEqualTo("0...");
    }

    @Test(dataProvider = "EndWithWholeWord", dataProviderClass = TitleProcessingOperatorDataProvider.class)
    public void titleShouldEndWithWholeWord(int requiredLength, String title, String pattern) {
        String result = TitleProcessingOperator.shortenTitleLength(requiredLength, title);
        assertThat(result).isEqualTo(pattern);
    }

    @Test(dataProvider = "PunctuationMarksInTheEnd", dataProviderClass = TitleProcessingOperatorDataProvider.class)
    public void titleShouldNotHavePunctuationMarksInTheEnd(int requiredLength, String title, String pattern) {
        String result = TitleProcessingOperator.shortenTitleLength(requiredLength, title);
        assertThat(result).isEqualTo(pattern);
    }
}