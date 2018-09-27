package be.ordina.junit5.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimpleTest {
    private HelloSayer helloSayer;

    @BeforeAll
    static void beforeAll(){

    }
    @BeforeEach
    void setUp() {
        helloSayer = new HelloSayer();
    }
    @Test
    void helloWorld() {
        assertThat(helloSayer.hello("world"),is("Hello, world!"));
    }
    @Test
    void helloDude(){
        assertThat(helloSayer.hello("dude"), is("Hello, dude!"));
    }
    @Test
    void helloNull(){
        assertThrows(IllegalArgumentException.class,
                ()->helloSayer.hello(null),"str is Mandatory");
    }
    @Test
    void helloNull2(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> helloSayer.hello(null));
        assertThat(exception.getMessage(), is("str is Mandatory"));
    }
    @AfterEach
    void afterEach() {

    }
    @AfterAll
    static void afterAll() {

    }
}
