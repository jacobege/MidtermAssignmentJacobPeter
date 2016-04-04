package Exercise_1_test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Exercise_1.ArgumentException;
import Exercise_1.Date;
import Exercise_1.InvalidDateException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class DateTest {

    public DateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void NextDateTest_MinimumGoodBoundary() throws InvalidDateException, ArgumentException {
        Date result = new Date(1, 1, 1812);
        result.nextDate();

        Date expectedResult = new Date(1, 2, 1812);
        assertEquals(expectedResult, result);
    }

    @Test
    public void NextDateTest_MaximumGoodBoundary() throws InvalidDateException, ArgumentException {
        Date result = new Date(12, 31, 2014);
        result.nextDate();

        Date expectedResult = new Date(1, 1, 2015);
        assertEquals(expectedResult, result);
    }

    @Test
    public void NextDateTest_MinimumBadBoundary_Month() throws ArgumentException, InvalidDateException {
        new Date(0, 1, 1812).nextDate();
    }

    @Test
    public void NextDateTest_MinimumBadBoundary_Day() throws ArgumentException, InvalidDateException {
        new Date(1, 0, 1812).nextDate();
    }

    @Test
    public void NextDateTest_MinimumBadBoundary_Year() throws ArgumentException, InvalidDateException {
        new Date(1, 1, 1811).nextDate();
    }

    @Test
    public void NextDateTest_MaximumBadBoundary_Month() throws ArgumentException, InvalidDateException {
        new Date(13, 12, 2014).nextDate();
    }

    @Test
    public void NextDateTest_MaximumBadBoundary_Day() throws ArgumentException, InvalidDateException {
        new Date(12, 32, 2014).nextDate();
    }

    @Test
    public void NextDateTest_MaximumBadBoundary_Year() throws ArgumentException, InvalidDateException {
        new Date(12, 31, 2015).nextDate();
    }

    @Test
    public void NextDateTest_SpecialCase_LeapYear() throws InvalidDateException, ArgumentException {
        Date result = new Date(2, 28, 2012).nextDate();

        Date expectedResult = new Date(2, 29, 2012);

        assertEquals(expectedResult, result);
    }

    @Test
    public void NextDateTest_SpecialCase_CommonYear() throws InvalidDateException, ArgumentException {
        Date result = new Date(2, 28, 2011).nextDate();

        Date expectedResult = new Date(3, 1, 2011);

        assertEquals(expectedResult, result);
    }

}
