package be.ordina.junit5.demo.spring;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Bean2 {
    private Bean1 bean1;

    public Bean2(Bean1 bean1) {
        this.bean1 = bean1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean2 bean2 = (Bean2) o;
        return Objects.equals(bean1, bean2.bean1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bean1);
    }

    public void doStuffUsingBean1(String param) {
        bean1.doStuff(param);
    }
}
