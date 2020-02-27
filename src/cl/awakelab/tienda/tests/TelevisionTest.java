package cl.awakelab.tienda.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.tienda.models.Electrodomestico;
import cl.awakelab.tienda.models.Television;

class TelevisionTest {

    private Television television;
    
    private String color;
    private char consumo;
    private double peso;
    private long precio;
    
    private int resolucion;
    private boolean sintonizador;
    
    @BeforeEach
    void setUp() throws Exception {
        television = new Television();
        
        color = Electrodomestico.COLORES[(int) (Math.random() * Electrodomestico.COLORES.length)];
        television.setColor(color);
        
        consumo = Electrodomestico.CONSUMOS[(int) (Math.random() * 
                Electrodomestico.CONSUMOS.length)];
        television.setConsumo(consumo);
        
        peso = Math.random() * 100 + 10;
        television.setPeso(peso);
        
        precio = (long) (Math.random() * 1000000L);
        television.setPrecio(precio);
        
        resolucion = (int) (Math.random() * 90 + 10);
        television.setResolucion(resolucion);
        
        Random random = new Random(System.currentTimeMillis());
        sintonizador = random.nextBoolean();
        television.setSintonizador(sintonizador);
    }

    @Test
    void testGetResolucion() {
        assertEquals(resolucion, television.getResolucion());
    }

    @Test
    void testHasSintonizador() {
        assertEquals(sintonizador, television.hasSintonizador());
    }

    @Test
    void testSetResolucion() {
        int resolucion = 50;
        television.setResolucion(resolucion);
        
        assertEquals(resolucion, television.getResolucion());
    }

    @Test
    void testSetSintonizador() {
        boolean sintonizador = false;
        television.setSintonizador(sintonizador);
        
        assertEquals(sintonizador, television.hasSintonizador());
    }

    @Test
    void testGetPrecio() {
        assertEquals(precio, television.getPrecio());
    }

    @Test
    void testGetColor() {
        assertEquals(color, television.getColor());
    }

    @Test
    void testGetConsumo() {
        assertEquals(consumo, television.getConsumo());
    }

    @Test
    void testGetPeso() {
        assertEquals(peso, television.getPeso());
    }

    @Test
    void testSetPrecio() {
        long precio = 100L;
        television.setPrecio(precio);
        
        assertEquals(precio, television.getPrecio());
    }

    @Test
    void testSetColor() {
        String color = "rojo";
        television.setColor(color);
        
        assertEquals(color, television.getColor());
    }

    @Test
    void testSetConsumo() {
        char consumo = 'f';
        television.setConsumo(consumo);
        
        assertEquals(consumo, television.getConsumo());
    }

    @Test
    void testSetPeso() {
        double peso = 20.0D;
        television.setPeso(peso);
        
        assertEquals(peso, television.getPeso());
    }

}
