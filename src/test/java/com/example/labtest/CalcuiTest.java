
package com.example.labtest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalcuiTest {

    Calcui obj = new Calcui();

    // Test 1: HRA calculation
    @Test
    void testHRA() {
        assertEquals(6000.0, obj.calculateHRA(30000), 0.01);
    }

    // Test 2: DA calculation
    @Test
    void testDA() {
        assertEquals(3000.0, obj.calculateDA(30000), 0.01);
    }

    // Test 3: Gross salary calculation
    @Test
    void testGrossSalary() {
        assertEquals(39000.0, obj.calculateGrossSalary(30000), 0.01);
    }

    // Test 4: Deduction calculation
    @Test
    void testDeductions() {
        assertEquals(3600.0, obj.calculateDeductions(30000), 0.01);
    }

    // Test 5: Net salary calculation
    @Test
    void testNetSalary() {
        assertEquals(35400.0, obj.calculateNetSalary(30000), 0.01);
    }

    // Test 6: Zero salary boundary test
    @Test
    void testZeroSalary() {
        assertEquals(0.0, obj.calculateNetSalary(0), 0.01);
    }

    // Test 7: Negative salary validation
    @Test
    void testNegativeSalary() {
        assertThrows(IllegalArgumentException.class,
                () -> obj.calculateGrossSalary(-10000));
    }

    // Test 8: Invalid salary (NaN)
    @Test
    void testInvalidSalary() {
        assertThrows(IllegalArgumentException.class,
                () -> obj.calculateNetSalary(Double.NaN));
    }
}
