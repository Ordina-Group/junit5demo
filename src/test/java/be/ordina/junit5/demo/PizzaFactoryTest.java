package be.ordina.junit5.demo;

import be.ordina.junit5.demo.model.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaFactoryTest {

    private PizzaFactory pizzaFactory;

    @BeforeEach
    void setUp() {
        pizzaFactory = new PizzaFactory();
    }

    @Test
    @Disabled
    void createQuattroStagioni() {
        final Pizza pizza = pizzaFactory.createQuattroStagioni();
        assertAll(
                () -> assertTrue(pizza.hasTopping("olives")),
                () -> assertTrue(pizza.hasTopping("Olives"), "Case should not matter"),
                () -> assertTrue(pizza.hasTopping("Prosciutto"), "A Pizza Quattro stagioni should contain Prosciutto"),
                () -> assertThrows(IllegalArgumentException.class, () ->pizza.hasTopping(null), "Topping cannot be null")
        );
    }
}