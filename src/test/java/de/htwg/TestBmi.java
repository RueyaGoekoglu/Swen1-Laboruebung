package de.htwg;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestBmi {

    @Test
    public void testBmiKorrekt() {
        double result = Bmi.calc(80, 1.90);
        assertEquals(22.1606648199446,result,0.001 );
    }

    @Test
    public void testBmiNegativeZahlenWeight() {
        try {
            double result = Bmi.calc(-80, 1.90);
            fail();
        } catch (Exception e) {
            assertEquals("Weight can´t be negative", e.getMessage());
        }
    }
    @Test
    public void testBmiNegativeZahlenHeight() {
        try {
            double result = Bmi.calc(80, -1.90);
            fail();
        } catch (Exception e) {
            assertEquals("height can´t be negative", e.getMessage());
        }
    }

    @Test
    public void testBmiNullWeight() {
        double result = Bmi.calc(0.0, 1.90);
        assertEquals(0.0, result, 0.001);
    }



}
