import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @BeforeEach
    public void tearDown() {
        calculator = null;
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(1, 2, 3));
    }

    @MethodSource("source")
    @ParameterizedTest
    public void testPlus(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.plus.apply(a, b));
    }


    @Test
    public void testMinus() {
        int a = 5;
        int b = 2;
        int result = 3;
        assertThat(result, equalTo(calculator.minus.apply(a, b)));

    }


    @Test
    public void testIsPositive() {
        int a = 2;
        assertThat(calculator.isPositive.test(a), not(false));
    }


    @Test
    public void testDevide() {
        int a = 6;
        int b = 3;
        int result = 2;
        assertThat(result, equalTo(calculator.devide.apply(a, b)));
    }


}
