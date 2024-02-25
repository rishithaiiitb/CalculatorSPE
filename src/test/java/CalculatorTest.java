import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.spe.Calculator;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    private static final double delta = 1e-10;


    @Test
    public void squareRootEquals() {
        assertEquals(8.0, calculator.squareRoot(81), delta);
        assertEquals(1.41421356237, calculator.squareRoot(2), delta);
    }

    @Test
    public void squareRootNotEquals() {
        assertNotEquals(1, calculator.squareRoot(7), delta);
        assertNotEquals(6, calculator.squareRoot(34), delta);
    }

    @Test
    public void factorialEquals() {
        assertEquals(1, calculator.factorial(0), delta);
        assertEquals(120, calculator.factorial(5), delta);
    }

    @Test
    public void factorialNotEquals() {
        assertNotEquals(0, calculator.factorial(1), delta);
        assertNotEquals(3, calculator.factorial(7), delta);
    }

    @Test
    public void naturalLogEquals() {
        assertEquals(2.302585092994046, calculator.naturalLogarithm(10), delta);
        assertEquals(4.605170185988092, calculator.naturalLogarithm(100), delta);
    }

    @Test
    public void naturalLogNotEquals() {
        assertNotEquals(2, calculator.naturalLogarithm(3), delta);
        assertNotEquals(7, calculator.naturalLogarithm(40), delta);
    }

    @Test
    public void powerEquals() {
        assertEquals(32, calculator.powerFunction(2, 5), delta);
        assertEquals(125, calculator.powerFunction(5, 3), delta);
    }

    @Test
    public void powerNotEquals() {
        assertNotEquals(10, calculator.powerFunction(2, 2), delta);
        assertNotEquals(0, calculator.powerFunction(5, 3), delta);
    }
}
