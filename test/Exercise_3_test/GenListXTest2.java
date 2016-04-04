package Exercise_3_test;

import Exercise_3.GenListX;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sean Emerson on 04-04-2016.
 */
public class GenListXTest2 {


    GenListX list;

    @Before
    public void setUp() throws Exception {
        list = new GenListX();
    }

    @Test
    public void testAdd() throws Exception {

        GenListX localList = new GenListX();
        localList.add("Test");
        assertEquals(1, localList.size());
        localList.add("Test2");
        assertEquals(2, localList.size());

    }

    @Test
    public void testSize() throws Exception {
        GenListX localList = new GenListX();
         assertEquals(0,localList.size());
        localList.add("Test");
        assertEquals(1,localList.size());
        localList.remove(0);
        assertEquals(0,localList.size());
    }

    @Test
    public void testGet()  {
        GenListX localList = new GenListX();
        try {
        localList.get(0);
        fail("No exception was thrown");}
        catch (IndexOutOfBoundsException e) {}

        localList.add("Test");
        assertEquals("Test", localList.get(0));

    }

    @Test
    public void testAdd1() throws Exception {

        GenListX localList = new GenListX();
        localList.add(0,"Test");
        assertEquals(1,localList.size());
        localList.add(0,"Test2");
        assertEquals(2,localList.size());

    }

    @Test
    public void testRemove(){
        GenListX localList = new GenListX();
        try{localList.remove(0);
        fail("No indexout of bounds message");}
        catch (IndexOutOfBoundsException e){}

        localList.add("Test");
        localList.add("Test2");
        localList.remove(0);
        assertEquals(1, localList.size());


        localList.remove(0);
        assertEquals(0, localList.size());
    }
}