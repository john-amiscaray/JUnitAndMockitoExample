import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final MultiplicationService multiplier = mock(MultiplicationService.class);
    private final Calculator calc = new Calculator(multiplier);

    @Nested
    @DisplayName("Testing the add method: ")
    class AdditionTests{

        @Test
        @DisplayName("When adding 2 and 2, expect 4")
        void test1() {

            assertEquals(4, calc.add(2, 2));

        }

        @Test
        @DisplayName("When adding 4 and -1, expect 3")
        void test2(){

            assertEquals(3, calc.add(4, -1));

        }

        @Test
        @DisplayName("When adding -1 and -1, expect -2")
        void test3(){

            assertEquals(-2, calc.add(-1, -1));

        }

    }

    @Nested
    @DisplayName("Testing the divide method: ")
    class DivisionTests{


        // Takes the expected exception and an executable with the code we expect to throw an exception
        @Test
        @DisplayName("When dividing by zero, expect an Arithmetic Exception")
        void test1() {

            assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));

        }

    }

    @Nested
    @DisplayName("Testing the power method: ")
    class PowerTests{


        // Takes the expected exception and an executable with the code we expect to throw and exception
        @Test
        @DisplayName("When evaluating 2^2, expect 4.0")
        void test1() {

            when(multiplier.multiply(1, 2)).thenReturn(2.0);
            when(multiplier.multiply(2, 2)).thenReturn(4.0);

            assertEquals(4.0, calc.power(2,2));


        }

    }

}