package be.ordina.junit5.demo;

public class HelloSayer {

    public String hello(String str) {
        if(str == null){
            throw new IllegalArgumentException("str is Mandatory");
        }
        return "Hello, " + str + "!";
    }
}
