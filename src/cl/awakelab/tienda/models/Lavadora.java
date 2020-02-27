package cl.awakelab.tienda.models;

public class Lavadora extends Electrodomestico {

    // Constants -------------------------------------------------------------------------------

    /** Valor por defecto para la carga del producto */
    private final int DEFAULT_CARGA = 5;
    
    // Attributes ------------------------------------------------------------------------------
    
    private int carga;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor por defecto. Asigna el valor por defecto de la carga.
     */
    public Lavadora() {
        super();
        this.carga = DEFAULT_CARGA;
    }

    /**
     * Constructor de la clase
     * @param precio Precio del producto
     * @param peso Peso del producto
     */
    public Lavadora(long precio, double peso) {
        super(precio, peso);
        this.carga = DEFAULT_CARGA;
    }

    /**
     * Constructor de la clase
     * @param carga Carga del producto
     * @param precio Precio del producto
     * @param color Color del producto
     * @param consumo Consumo electrico del producto
     * @param peso Peso del producto
     */
    public Lavadora(int carga, long precio, String color, char consumo, double peso) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    // Methods ---------------------------------------------------------------------------------
    
    /**
     * Calcula el precio final del producto teniendo en cuenta los factores que alteran el valor
     * @return precio final
     */
    @Override
    public long precioFinal() {
        long total = this.getPrecio();
        char consumo = this.getConsumo();
        double peso = this.getPeso();
        
        if(consumo == 'a')
            total += 100;
        else if(consumo == 'b')
            total += 80;
        else if(consumo == 'c')
            total += 60;
        else if(consumo == 'd')
            total += 50;
        else if(consumo == 'e')
            total += 30;
        else
            total += 10;
        
        if(peso < 20)
            total += 10;
        else if(peso < 50)
            total += 50;
        else if(peso < 80)
            total += 80;
        else
            total += 100;
        
        if(this.carga > 30)
            total += 50;
        
        return total;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el valor de la carga del producto
     * @return carga del producto
     */
    public int getCarga() {
        return this.carga;
    }
    
    // Setters ---------------------------------------------------------------------------------

    /**
     * Cambia el valor de la carga del producto
     * @param carga Nuevo valor
     */
    public void setCarga(int carga) {
        this.carga = carga;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "Electrodomestico(precio: " + this.getPrecio() + 
                ", color: '" + this.getColor() + 
                "', consumo: '" + this.getConsumo() + 
                "', peso: " + this.getPeso() + 
                "kg, carga: " + this.getCarga() + "kg)";
    }
}
