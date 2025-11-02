package com.empresa.proyecto_automatizacion;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSumarNumerosPositivos() {
        // Given - números positivos
        int a = 5;
        int b = 3;
        
        // When - se ejecuta la suma
        int resultado = calculadora.sumar(a, b);
        
        // Then - verificar resultado esperado
        assertEquals(8, resultado, "La suma de 5 + 3 debe ser 8");
    }

    @Test
    void testRestarNumerosMixtos() {
        // Given - números positivos y negativos
        int a = 10;
        int b = -5;
        
        // When - se ejecuta la resta
        int resultado = calculadora.restar(a, b);
        
        // Then - verificar resultado esperado
        assertEquals(15, resultado, "La resta de 10 - (-5) debe ser 15");
    }

    @Test
    void testEsPositivoConCero() {
        // Given - número cero
        int numero = 0;
        
        // When - se verifica si es positivo
        boolean resultado = calculadora.esPositivo(numero);
        
        // Then - verificar que cero no es positivo
        assertFalse(resultado, "El número 0 no debe ser considerado positivo");
    }
}