package Exercise_3_test;

import Exercise_3.GenListX;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenListXTest {
    
    private GenListX instance;
    
    public GenListXTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new GenListX();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of add method, of class GenListX.
     */
    @Test
    public void testAdd_Size_Get() {
        int obj = 123;
        System.out.println("Add_Size_Get");
        
        assertTrue(instance.size() == 0);
        
        instance.add(obj);
        
        assertTrue(instance.size() == 1);
        assertTrue((int)instance.get(0) == obj);
    }

    /**
     * Test of size method, of class GenListX.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int a, b, c;
        
        a = 1;
        b = 2;
        c = 3;
        
        assertTrue(instance.size() == 0);
        
        instance.add(a);
        instance.add(b);
        instance.add(0, c);
        
        assertTrue(instance.size() == 3);
        
        assertEquals(instance.get(0), c);
        assertEquals(instance.get(1), a);
        assertEquals(instance.get(2), b);
    }
}