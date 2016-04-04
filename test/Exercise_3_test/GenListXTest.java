package Exercise_3_test;

import Exercise_3.GenListX;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sean Emerson on 04-04-2016.
 */
public class GenListXTest {
    GenListX list;

    @Before
    public void setUp() {
        list = new GenListX();
    }
    
    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testAdd() throws Exception {
        list.add("Test");
        assertEquals(1, list.size());
        list.add("Test2");
        assertEquals(2, list.size());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0,list.size());
        list.add("Test");
        assertEquals(1,list.size());
        list.remove(0);
        assertEquals(0,list.size());
    }

    @Test
    public void testGet()  {
        try {
        list.get(0);
        fail("No exception was thrown");}
        catch (IndexOutOfBoundsException e) {}

        list.add("Test");
        assertEquals("Test", list.get(0));
    }

    @Test
    public void testAdd1() throws Exception {
        list.add(0,"Test");
        assertEquals(1,list.size());
        list.add(0,"Test2");
        assertEquals(2,list.size());
    }

    @Test
    public void testRemove(){
        try{list.remove(0);
        fail("No index out of bounds message");}
        catch (IndexOutOfBoundsException e){}

        list.add("Test");
        list.add("Test2");
        list.remove(0);
        assertEquals(1, list.size());

        list.remove(0);
        assertEquals(0, list.size());
    }
}