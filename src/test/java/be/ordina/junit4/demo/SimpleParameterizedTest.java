package be.ordina.junit4.demo;


import be.ordina.junit5.demo.model.UpperCaseConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SimpleParameterizedTest {
    private final String str;
    private String result;

    public SimpleParameterizedTest(String orig, String result) {
        this.str = orig;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"test", "TEST"},
                {"PiZzA", "PIZZA"},
                {"Numbers1234", "NUMBERS1234"}});
    }

    @Test
    public void test() {
        final String result = new UpperCaseConverter().convert(str);
        assertEquals(result, this.result);

    }
}

