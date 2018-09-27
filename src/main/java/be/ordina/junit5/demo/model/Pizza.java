package be.ordina.junit5.demo.model;


import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pizza {

    private final List<String> topping;

    public Pizza(String... toppings) {
        this.topping = Stream.of(toppings).map(StringUtils::lowerCase).collect(Collectors.toList());
    }


    public boolean hasTopping(String topping){
        return this.topping.contains(StringUtils.lowerCase(topping));
    }
}
