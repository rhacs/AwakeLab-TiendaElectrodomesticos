package cl.awakelab.tienda.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.tienda.models.Electrodomestico;
import cl.awakelab.tienda.models.Lavadora;

class LavadoraTest {

    private Lavadora lavadora;
    
    private int carga;
    private String color;
    private char consumo;
    private double peso;
    private long precio;
    
    @BeforeEach
    void setUp() throws Exception {
        lavadora = new Lavadora();
        
        carga = (int) (Math.random() * 100 + 1);
        lavadora.setCarga(carga);
        
        color = Electrodomestico.COLORES[(int) (Math.random() * Electrodomestico.COLORES.length)];
        lavadora.setColor(color);
        
        consumo = Electrodomestico.CONSUMOS[(int) (Math.random() * 
                Electrodomestico.CONSUMOS.length)];
        lavadora.setConsumo(consumo);
        
        peso = Math.random() * 100 + 10;
        lavadora.setPeso(peso);
        
        precio = (long) (Math.random() * 1000000L);
        lavadora.setPrecio(precio);
    }

    @Test
    void testGetCarga() {
        assertEquals(carga, lavadora.getCarga());
    }

    @Test
    void testSetCarga() {
        int carga = 200;
        lavadora.setCarga(carga);
        
        assertEquals(carga, lavadora.getCarga());
    }

    @Test
    void testGetPrecio() {
        assertEquals(precio, lavadora.getPrecio());
    }

    @Test
    void testGetColor() {
        assertEquals(color, lavadora.getColor());
    }

    @Test
    void testGetConsumo() {
        assertEquals(consumo, lavadora.getConsumo());
    }

    @Test
    void testGetPeso() {
        assertEquals(peso, lavadora.getPeso());
    }

    @Test
    void testSetPrecio() {
        long precio = 10000000000L;
        lavadora.setPrecio(precio);
        
        assertEquals(precio, lavadora.getPrecio());
    }

    @Test
    void testSetColor() {
        String color = "negro";
        lavadora.setColor(color);
        
        assertEquals(color, lavadora.getColor());
    }

    @Test
    void testSetConsumo() {
        char consumo = 'a';
        lavadora.setConsumo(consumo);
        
        assertEquals(consumo, lavadora.getConsumo());
    }

    @Test
    void testSetPeso() {
        double peso = 150.0D;
        lavadora.setPeso(peso);
        
        assertEquals(peso, lavadora.getPeso());
    }

}
