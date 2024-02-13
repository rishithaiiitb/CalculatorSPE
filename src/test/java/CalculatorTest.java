import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.spe.Calculator;

public class CalculatorTest {
    static Calculator calculator;
    private static final double delta = 1e-10;

    @BeforeAll
    static void setup() {
        System.out.println("Initializing Calculator Class");
        calculator = new Calculator();
    }

    @Test
    public void squareRootEquals() {
        assertEquals(9.0, calculator.squareRoot(81), delta, "Square Root Test 1");
        assertEquals(1.41421356237, calculator.squareRoot(2), delta, "Square Root Test 2");
    }

    @Test
    public void squareRootNotEquals() {
        assertNotEquals(1, calculator.squareRoot(7), delta, "Square Root Test 1");
        assertNotEquals(6, calculator.squareRoot(34), delta, "Square Root Test 2");
    }

    @Test
    public void factorialEquals() {
        assertEquals(1, calculator.factorial(0), delta, "Factorial Test 1");
        assertEquals(120, calculator.factorial(5), delta, "Factorial Test 2");
    }

    @Test
    public void factorialNotEquals() {
        assertNotEquals(0, calculator.factorial(1), delta, "Factorial Test 1");
        assertNotEquals(3, calculator.factorial(7), delta, "Factorial Test 2");
    }

    @Test
    public void naturalLogEquals() {
        assertEquals(2.302585092994046, calculator.naturalLogarithm(10), delta, "Natural Log Test 1");
        assertEquals(4.605170185988092, calculator.naturalLogarithm(100), delta, "Natural Log Test 2");
    }

    @Test
    public void naturalLogNotEquals() {
        assertNotEquals(2, calculator.naturalLogarithm(3), delta, "Natural Log Test 1");
        assertNotEquals(7, calculator.naturalLogarithm(40), delta, "Natural Log Test 2");
    }

    @Test
    public void powerEquals() {
        assertEquals(32, calculator.powerFunction(2, 5), delta, "Power Test 1");
        assertEquals(125, calculator.powerFunction(5, 3), delta, "Power Test 2");
    }

    @Test
    public void powerNotEquals() {
        assertNotEquals(10, calculator.powerFunction(2, 2), delta, "Power Test 1");
        assertNotEquals(0, calculator.powerFunction(5, 3), delta, "Power Test 2");
    }
}
