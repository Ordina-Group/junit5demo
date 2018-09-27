package be.ordina.junit5.demo;

import be.ordina.junit5.demo.model.UpperCaseConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParameterizedTests {
    @ParameterizedTest
    @MethodSource("testData")
    void testConvertToUpperCase(TestCase testCase) {
        final String result = new UpperCaseConverter().convert(testCase.orig);
        assertEquals(result, testCase.result);
    }

    private static class TestCase {
        String orig;
        String result;

        TestCase(String orig, String result) {
            this.orig = orig;
            this.result = result;
        }
    }

    private static Stream<TestCase> testData() {
        return Stream.of(new TestCase("test", "TEST"),
                new TestCase("PiZzA", "PIZZA"),
                new TestCase("Numbers1234", "NUMBERS1234"));
    }

    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new UpperCaseConverter().convert(null), "str should not be null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"TEST", "PIZZA", "NUMBER1234"})
    void stringsInUpperCaseDontChange(String orig) {
        assertEquals(new UpperCaseConverter().convert(orig), orig);
    }


    @ParameterizedTest
    @CsvSource({"test, TEST", "PiZzA, PIZZA", "Number1234, NUMBER1234"})
    void testConvertCsv(String orig, String result) {
        assertEquals(new UpperCaseConverter().convert(orig), result);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/UpperCaseConverterTestCases.csv",
            delimiter = ';',lineSeparator = "\n", numLinesToSkip = 1)
    void testConvertCsvFile(String orig, String result){
        assertEquals(new UpperCaseConverter().convert(orig), result);
    }

    @ParameterizedTest
    @CsvSource({"test, TEST", "PiZzA, PIZZA", "Number1234, NUMBER1234"})
    @CsvFileSource(
            resources = "/UpperCaseConverterTestCases.csv",
            delimiter = ';',
            lineSeparator = "\n",
            numLinesToSkip = 1
    )
    void testConvertMultipleSources(String orig, String result){
        assertEquals(new UpperCaseConverter().convert(orig), result);
    }

}
