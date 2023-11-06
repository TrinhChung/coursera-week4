import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Week4Test {
    @Test
    public void testMax2Int1(){
        assertEquals(2,Week4.max2Int(2,1));
    }

    @Test
    public void testMax2Int2(){
        assertEquals(6,Week4.max2Int(4,6));
    }

    @Test
    public void testMax2Int3(){
        assertEquals(8,Week4.max2Int(4,8));
    }

    @Test
    public void testMax2Int4(){
        assertEquals(10,Week4.max2Int(10,5));
    }

    @Test
    public void testMax2Int5(){
        assertEquals(2,Week4.max2Int(2,0));
    }

    @Test
    public void testMinArray1(){
        int[] a = new int[10];
        for(int i = 0; i <10; i++) {
            a[i] = i;
        }
        assertEquals(0, Week4.minArray(a));
    }

    @Test
    public void testMinArray2(){
        int[] a = new int[15];
        for(int i = 0; i < 15; i++) {
            a[i] = i + 11;
        }
        assertEquals(11, Week4.minArray(a));
    }


    @Test
    public void testMinArray3(){
        int[] a = new int[5];
        for(int i = 0; i < 5; i++) {
            a[i] = i + 3;
        }
        assertEquals(3, Week4.minArray(a));
    }

    @Test
    public void testMinArray4(){
        int[] a = new int[35];
        for(int i = 0; i < 35; i++) {
            a[i] = i + 101;
        }
        assertEquals(101, Week4.minArray(a));
    }

    @Test
    public void testMinArray5(){
        int[] a = new int[15];
        for(int i = 0; i < 15; i++) {
            a[i] = i + 11;
        }
        assertEquals(11, Week4.minArray(a));
    }

    @Test
    public void testCalculateBMI1(){
        assertEquals("Bình thường",Week4.calculateBMI(65,1.69));
    }

    @Test
    public void testCalculateBMI2(){
        assertEquals("Bình thường",Week4.calculateBMI(65,1.69));
    }

    @Test
    public void testCalculateBMI3(){
        assertEquals("Bình thường",Week4.calculateBMI(65,1.69));
    }

    @Test
    public void testCalculateBMI4(){
        assertEquals("Bình thường",Week4.calculateBMI(65,1.69));
    }

    @Test
    public void testCalculateBMI5(){
        assertEquals("Bình thường",Week4.calculateBMI(65,1.69));
    }
}