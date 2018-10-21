package week4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @DUCTT
 */
public class ProgramTest {
    
    public ProgramTest() {
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

    /**
     * Test of max method, of class Program.
     */
    @Test
    public void testMax1() {
        System.out.println("max");
        int a = 1;
        int b = 0;
        int expResult = 1;
        int result = Program.max(a, b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMax2() {
        System.out.println("max");
        int a = 1;
        int b = 2;
        int expResult = 2;
        int result = Program.max(a, b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMax3() {
        System.out.println("max");
        int a = 1;
        int b = 0;
        int expResult = 1;
        int result = Program.max(a, b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMax4() {
        System.out.println("max");
        int a = 1;
        int b = 1;
        int expResult = 1;
        int result = Program.max(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of min method, of class Program.
     */
    @Test
    public void testMin1() {
        System.out.println("min");
        int[] arr = {0};
        int expResult = 0;
        int result = Program.min(arr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMin2() {
        System.out.println("min");
        int[] arr = {1,1,3};
        int expResult = 1;
        int result = Program.min(arr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMin3() {
        System.out.println("min");
        int[] arr = {4,-1,10,10};
        int expResult = -1;
        int result = Program.min(arr);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMin4() {
        System.out.println("min");
        int[] arr = {50};
        int expResult = 50;
        int result = Program.min(arr);
        assertEquals(expResult, result);
    }

    /**
     * Test of BMI method, of class Program.
     */
    @Test
    public void testBMI1() {
        System.out.println("BMI");
        double weight = 47.36;
        double height = 1.60;
        String expResult = "Bình thường";
        String result = Program.BMI(weight, height);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBMI2() {
        System.out.println("BMI");
        double weight = 60;
        double height = 1.7;
        String expResult = "Bình thường";
        String result = Program.BMI(weight, height);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBMI3() {
        System.out.println("BMI");
        double weight = 50;
        double height = 1.7;
        String expResult = "Thiếu cân";
        String result = Program.BMI(weight, height);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBMI4() {
        System.out.println("BMI");
        double weight = 80;
        double height = 1.7;
        String expResult = "Béo phì";
        String result = Program.BMI(weight, height);
        assertEquals(expResult, result);
    }
    
}
