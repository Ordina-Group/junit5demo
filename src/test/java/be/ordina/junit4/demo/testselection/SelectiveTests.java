package be.ordina.junit4.demo.testselection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assume.assumeTrue;

public class SelectiveTests {
    @Category(FastTest.class)
    @Test
    public void fastTest(){
        assertTrue("exceptionally useful test",true);
    }

    @Category(SlowTest.class)
    @Test
    public void slowTest() throws InterruptedException {
        Thread.sleep(2000L);
    }

    @Ignore
    @Test
    public void ignoredTest(){

    }

    @Test
    public void assumingTest(){
        assumeTrue(LocalDate.now().isAfter(LocalDate.of(2018, 9 , 26)));
    }
}
