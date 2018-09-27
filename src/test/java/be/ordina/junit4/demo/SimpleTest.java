package be.ordina.junit4.demo;

import be.ordina.junit5.demo.HelloSayer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private HelloSayer helloSayer;
    @BeforeClass
    public static void beforeAll(){

    }
    @Before
    public void setUp() {
        helloSayer = new HelloSayer();
    }
    @Test
    public void helloWorld() {
        assertThat(helloSayer.hello("world"),is("Hello, world!"));
    }
    @Test
    public void helloDude(){
        assertThat(helloSayer.hello("dude"), is("Hello, dude!"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void helloNull(){
        helloSayer.hello(null);
    }
    @Test
    public void helloNullRule(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("str is Mandatory");
        helloSayer.hello(null);
    }
    @After
    public void tearDown() throws Exception {

    }
    @AfterClass
    public static void afterAll() throws Exception {

    }
}
