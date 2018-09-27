package be.ordina.junit5.demo.testselection;

import be.ordina.junit4.demo.testselection.FastTest;
import be.ordina.junit4.demo.testselection.SlowTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assumptions.assumeTrue;


class SelectiveTests {
    @Tag("fastTest")
    @Test
    void fastTest(){
        Assertions.assertTrue(true,"exceptionally useful test");
    }

    @Tag("slowTest")
    @Test
    void slowTest() throws InterruptedException {
        Thread.sleep(2000L);
    }

    @Disabled
    @Test
    void disabledTest(){

    }
    
    @Test
    void assumingTest(){
        assumeTrue(LocalDate.now().isAfter(LocalDate.of(2018, 9 , 26)));
    }
}
