package be.ordina.junit5.demo;

import be.ordina.junit5.demo.model.UpperCaseConverter;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicTests {

    @TestFactory
    Stream<DynamicTest> tests() {
        return Stream.of(
                DynamicTest.dynamicTest("Test 1",
                        () -> test("test", "TEST")),
                DynamicTest.dynamicTest("Test 2",
                        () -> test("PiZzA", "PIZZA")),
                DynamicTest.dynamicTest("Test 3",
                        () -> test("Numbers1234", "NUMBERS1234"))
        );
    }


    private void test(String str, String expectedResult) {
        final String result = new UpperCaseConverter().convert(str);
        assertEquals(result, expectedResult);
    }
}
