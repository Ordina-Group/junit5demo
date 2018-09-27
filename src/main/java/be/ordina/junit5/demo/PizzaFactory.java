package be.ordina.junit5.demo;

import be.ordina.junit5.demo.model.Pizza;

public class PizzaFactory {
    public Pizza createQuattroStagioni(){
        return new Pizza("artichokes", "basil", "mushrooms","ham",  "olives");
    }
}
