package be.ordina.junit4.demo;


import be.ordina.junit5.demo.model.UpperCaseConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class EnhancedParameterizedTest {
    private final String str;
    private String result;

    public EnhancedParameterizedTest(TestCase testCase) {
        this.str = testCase.orig;
        this.result = testCase.result;
    }

    @Parameterized.Parameters
    public static Collection<TestCase[]> data() {
        return Arrays.asList(new TestCase[][]{
                {new TestCase("test", "TEST")},
                {new TestCase("PiZzA", "PIZZA")},
                {new TestCase("Numbers1234", "NUMBERS1234")}});
    }

    @Test
    public void test() {
        final String result = new UpperCaseConverter().convert(str);
        assertEquals(result, this.result);

    }

    private static class TestCase {
        String orig;
        String result;

        TestCase(String orig, String result) {
            this.orig = orig;
            this.result = result;
        }
    }
}

