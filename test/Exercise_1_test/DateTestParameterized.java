package Exercise_1_test;

import Exercise_1.ArgumentException;
import Exercise_1.Date;
import Exercise_1.InvalidDateException;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DateTestParameterized {
    private final Date input, expectedOutput;
    
    public DateTestParameterized(Date input, Date expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }
    
    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Date[][] {
            {new Date(1, 1, 1842), new Date(1, 2, 1842)},
            {new Date(12, 31, 2014), new Date(1, 1, 2015)},
            {new Date(2, 28, 2012), new Date(2, 29, 2012)},
            {new Date(2, 28, 2011), new Date(3, 1, 2011)}
        });
    }
    
    @Test
    public void testGoodDates() {
        try {
            System.out.println("The input are: " + input.toString());
            assertEquals(input.nextDate(), expectedOutput);
        } catch (InvalidDateException | ArgumentException ex) {
            Logger.getLogger(DateTestParameterized.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
}