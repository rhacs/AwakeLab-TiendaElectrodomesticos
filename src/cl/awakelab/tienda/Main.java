package cl.awakelab.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.awakelab.tienda.models.Electrodomestico;
import cl.awakelab.tienda.models.Lavadora;
import cl.awakelab.tienda.models.Television;

public class Main {

    // Constants -------------------------------------------------------------------------------
    
    /** Cantidad de productos a generar */
    private static final int QTY_PRODUCTOS = 10;
    
    // Methods ---------------------------------------------------------------------------------
    
    /**
     * Genera una lista con valores aleatorios de productos para posterior manipulacion
     * @return Lista de productos
     */
    private static List<Electrodomestico> generarProductos() {
        List<Electrodomestico> productos = new ArrayList<>();
        String[] colores = Electrodomestico.COLORES;
        char[] consumos = Electrodomestico.CONSUMOS;
        
        for(int i = 0; i < QTY_PRODUCTOS; i++) {
            long precio = (long) (Math.random() * 10000000L + 100000L);
            String color = colores[(int) (Math.random() * colores.length)];
            char consumo = consumos[(int) (Math.random() * consumos.length)];
            double peso = (long) (Math.random() * 199.0D + 1.0D);
            
            int tipo = (int) (Math.random() * 2);
            if(tipo == 0) {
                int carga = (int) (Math.random() * 45 + 5);
                
                Lavadora lavadora = new Lavadora();
                lavadora.setCarga(carga);
                lavadora.setColor(color);
                lavadora.setConsumo(consumo);
                lavadora.setPeso(peso);
                lavadora.setPrecio(precio);
                
                productos.add(lavadora);
            } else {
                Random random = new Random(System.currentTimeMillis());
                int resolucion = (int) (Math.random() * 85 + 15);
                boolean sintonizador = random.nextBoolean();
                
                Television television = new Television();
                television.setColor(color);
                television.setConsumo(consumo);
                television.setPeso(peso);
                television.setPrecio(precio);
                television.setResolucion(resolucion);
                television.setSintonizador(sintonizador);
                
                productos.add(television);
            }
        }
        
        return productos;
    }
    
    // Main Loop -------------------------------------------------------------------------------
    
    /**
     * Manipula las clases generadas
     * @param args Argumentos de la aplicacion
     */
    public static void main(String[] args) {
        List<Electrodomestico> productos = generarProductos();
        
        int total = 0;
        int totalTelevisores = 0;
        int totalLavadoras = 0;
        
        System.out.println("Lavadoras");
        for(Electrodomestico producto : productos) {
            if(producto instanceof Lavadora) {
                long precio = ((Lavadora) producto).precioFinal();
                total += precio;
                totalLavadoras += precio;
                
                System.out.println("  " + producto);
            }
        }
        
        System.out.println("Televisores");
        for(Electrodomestico producto : productos) {
            if(producto instanceof Television) {
                long precio = ((Television) producto).precioFinal();
                total += precio;
                totalTelevisores += precio;
                
                System.out.println("  " + producto);
            }
        }
        
        System.out.println("\nTotal Lavadoras: $" + totalLavadoras);
        System.out.println("Total Televisores: $" + totalTelevisores);
        System.out.println("Total: $" + total);
    }

}
