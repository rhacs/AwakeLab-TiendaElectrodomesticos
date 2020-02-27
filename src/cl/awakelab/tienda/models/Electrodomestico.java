package cl.awakelab.tienda.models;

import java.util.Arrays;

public abstract class Electrodomestico {

    // Constants -------------------------------------------------------------------------------
    
    /** Valor del precio por defecto */
    private final long DEFAULT_PRECIO = 100000L;
    /** Valor del color por defecto */
    private final String DEFAULT_COLOR = "blanco";
    /** Valor del consumo por defecto */
    private final char DEFAULT_CONSUMO = 'f';
    /** Valor del peso por defecto */
    private final double DEFAULT_PESO = 5.0D;
    
    /** Valores que puede tomar la variable consumo */
    public static final char[] CONSUMOS = {'a', 'b', 'c', 'd', 'e', 'f'};
    /** Valores que puede tomar la variable color */
    public static final String[] COLORES = {"blanco", "negro", "rojo", "azul", "gris"};
    
    // Attributes ------------------------------------------------------------------------------
    
    private long precio;
    private String color;
    private char consumo;
    private double peso;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Genera un objeto de tipo Electrodomestico con todos los valores de sus atributos configurados
     * con los valores por defecto de la aplicacion
     */
    public Electrodomestico() {
        this.precio = DEFAULT_PRECIO;
        this.color = DEFAULT_COLOR;
        this.consumo = DEFAULT_CONSUMO;
        this.peso = DEFAULT_PESO;
    }
    
    /**
     * Genera un objeto de tipo Electrodomestico con los valores de precio y peso indicados por el
     * usuario, y los demas configurados con los valores por defecto de la aplicacion
     * @param precio Valor del producto
     * @param peso Peso del producto
     */
    public Electrodomestico(long precio, double peso) {
        this();
        
        this.precio = precio;
        this.peso = peso;
    }
    
    /**
     * Genera un objeto de tipo Electrodomestico con los valores indicados por el usuario
     * @param precio Precio del producto
     * @param color Color del producto
     * @param consumo Consumo energetico del producto
     * @param peso Peso del producto
     */
    public Electrodomestico(long precio, String color, char consumo, double peso) {
        this(precio, peso);
        
        this.color = (comprobarColor(color.toLowerCase()) ? color : DEFAULT_COLOR);
        this.consumo = (comprobarConsumo(consumo) ? consumo : DEFAULT_CONSUMO);
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    /**
     * Comprueba que el consumo electrico ingresado por el usuario sea viable
     * @param consumo Consumo electrico ingresado por el usuario
     * @return verdadero o falso segun el caso
     */
    private boolean comprobarConsumo(char consumo) {
        for(char c : CONSUMOS)
            if(c == consumo)
                return true;
        
        return false;
    }
    
    /**
     * Comprueba que el valor para el color del producto ingresado por el usuario sea viable.
     * @param color Color ingresado por el usuario
     * @return verdadero o falso segun el caso
     */
    private boolean comprobarColor(String color) {
        return Arrays.toString(COLORES).contains(color);
    }
    
    /**
     * Calcula el precio final del producto teniendo en cuenta los factores que alteran el valor
     * @return precio final
     */
    public abstract long precioFinal();
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el precio del producto
     * @return precio
     */
    public long getPrecio() {
        return this.precio;
    }
    
    /**
     * Devuelve el color del producto
     * @return color
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Devuelve el consumo electrico del producto
     * @return consumo electrico
     */
    public char getConsumo() {
        return this.consumo;
    }
    
    /**
     * Devuelve el peso del producto
     * @return peso
     */
    public double getPeso() {
        return this.peso;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    /**
     * Cambia el valor del precio del producto
     * @param precio Nuevo valor
     */
    public void setPrecio(long precio) {
        this.precio = precio;
    }
    
    /**
     * Cambia el valor del color del producto
     * @param color Nuevo valor
     */
    public void setColor(String color) {
        this.color = (comprobarColor(color.toLowerCase()) ? color : DEFAULT_COLOR);
    }
    
    /**
     * Cambia el valor del consumo electrico del producto
     * @param consumo Nuevo valor
     */
    public void setConsumo(char consumo) {
        this.consumo = (comprobarConsumo(consumo) ? consumo : DEFAULT_CONSUMO);
    }
    
    /**
     * Cambia el valor del peso del producto
     * @param peso Nuevo valor
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Electrodomestico(precio: " + this.getPrecio() + 
                ", color: '" + this.getColor() + 
                "', consumo: '" + this.getConsumo() + 
                "', peso: " + this.getPeso() + "kg)";
    }
}
