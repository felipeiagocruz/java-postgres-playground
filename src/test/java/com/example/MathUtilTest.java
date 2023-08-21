package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1BImpar(){
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP1BPar(){
        int a = 6, b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP3Negativo(){
        int a = -361, b = 0;
        int esperado = 361;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP3Positivo(){
        int a = 361, b = 0;
        int esperado = 361;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP4(){
        int a = 2, b = 6, m=4;
        int esperado = MathUtil.mdc(m*a, m*b);
        int obtido = m * MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP5Decrescente(){
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(b,a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }
    @Test
    void testMdcP5Crescente(){
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(b,a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP7(){
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(-a,b);
        int obtido = MathUtil.mdc(a, -b);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP8Par(){
        int a = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado,obtido);

    }
    
    @Test
    void testMdcP8Negativo(){
        int a = -6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP12Doisprimos(){
        int p = 7, a = p;
        int esperado = p;
        int obtido = MathUtil.mdc(p , a);

        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP12UmPrimo(){
        int p = 7, a = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(p , a);

        assertEquals(esperado,obtido);

    }


    @Test
    void testMdcCasoGeral(){
        int a = 30, b = 12;
        int esperado = 6;
        int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado,obtido);

    }

}
