package Exercise_1_test;

import Exercise_1.ArgumentException;
import Exercise_1.Date;
import Exercise_1.InvalidDateException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class DateTest {

    public DateTest() {
    }

    @Test
    public void NextDateTest_MinimumGoodBoundary() {
        Date result = new Date(1, 1, 1812);
        try {
            result = result.nextDate();
        } catch (ArgumentException | InvalidDateException e) {
            System.out.println("Exception occured");
            System.out.println(e.getMessage());
        }

        Date expectedResult = new Date(1, 2, 1812);
        assertEquals(expectedResult, result);
    }

    @Test
    public void NextDateTest_MaximumGoodBoundary() {
        Date result = new Date(12, 31, 2014);
        try {
            result = result.nextDate();
        } catch (InvalidDateException | ArgumentException e) {
            System.out.println("Exception occured");
            System.out.println(e.getMessage());
        }

        Date expectedResult = new Date(1, 1, 2015);
        assertEquals(expectedResult, result);
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MinimumBadBoundary_Month() throws InvalidDateException, ArgumentException {
        new Date(0, 1, 1812).nextDate();
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MinimumBadBoundary_Day() throws ArgumentException, InvalidDateException {
        new Date(1, 0, 1812).nextDate();
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MinimumBadBoundary_Year() throws ArgumentException, InvalidDateException {
        new Date(1, 1, 1811).nextDate();
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MaximumBadBoundary_Month() throws ArgumentException, InvalidDateException {
        new Date(13, 12, 2014).nextDate();
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MaximumBadBoundary_Day() throws ArgumentException, InvalidDateException {
        new Date(12, 32, 2014).nextDate();
    }

    @Test(expected=ArgumentException.class)
    public void NextDateTest_MaximumBadBoundary_Year() throws ArgumentException, InvalidDateException {
        new Date(12, 31, 2015).nextDate();
    }

    @Test
    public void NextDateTest_SpecialCase_LeapYear() {
        Date result = null;
        try {
            result = new Date(2, 28, 2012).nextDate();
        } catch (InvalidDateException | ArgumentException e) {
            System.out.println("Exception occured");
            System.out.println(e.getMessage());
        }

        Date expectedResult = new Date(2, 29, 2012);

        assertEquals(expectedResult, result);
    }

    @Test
    public void NextDateTest_SpecialCase_CommonYear() {
        Date result = null;
        try {
            result = new Date(2, 28, 2011).nextDate();
        } catch (InvalidDateException | ArgumentException e) {
            System.out.println("Exception occured");
            System.out.println(e.getMessage());
        }

        Date expectedResult = new Date(3, 1, 2011);

        assertEquals(expectedResult, result);
    }

    @Test(expected=InvalidDateException.class)
    public void NextDateTest_InvalidDate() throws InvalidDateException, ArgumentException {
        Date result = new Date(2, 29, 2011);
        result.nextDate();
    }
}