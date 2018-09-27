package be.ordina.junit5.demo.extensions.spring;


import be.ordina.junit5.demo.spring.Bean1;
import be.ordina.junit5.demo.spring.Bean2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
class SpringAndMockitoTest {
    @Mock
    private Bean1 bean1;
    @Test
    void name( @Autowired Bean2 bean2) {

        assertNotNull(bean1);
        assertNotNull(bean2);
    }
}
