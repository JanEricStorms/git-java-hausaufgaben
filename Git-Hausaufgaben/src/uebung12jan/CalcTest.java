package uebung12jan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    public void test1(){
        assertEquals(1,Calc.calcFibonacciNuber(1),"1");
    }

    @Test
    public void test2(){
        assertEquals(1,Calc.calcFibonacciNuber(2),"2");
    }

    @Test
    public void test3(){
        assertEquals(2,Calc.calcFibonacciNuber(3),"3");
    }

    @Test
    public void test4(){
        assertEquals(55,Calc.calcFibonacciNuber(10),"10");
    }

    @Test
    public void test5(){
        assertThrows(IllegalArgumentException.class, () -> {
            Calc.calcFibonacciNuber(-1);
        }, "-1");
    }

//    @Test
//    public void test6(){
//        assertEquals(55,Calc.calcFibonacciNuber(1000000000),"10");
//    }

}