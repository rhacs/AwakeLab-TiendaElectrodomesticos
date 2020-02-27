package cl.awakelab.tienda.models;

public class Television extends Electrodomestico {

    // Constants -------------------------------------------------------------------------------
    
    /** Valor por defecto para el atributo resolucion */
    private final int DEFAULT_RESOLUCION = 20;
    /** Valor por defecto para el atributo sintonizador */
    private final boolean DEFAULT_SINTONIZADOR = false;
    
    // Attributes ------------------------------------------------------------------------------
    
    private int resolucion;
    private boolean sintonizador;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor por defecto. Todos los atributos adquieren el valor por defecto de cada clase
     */
    public Television() {
        super();
        this.resolucion = DEFAULT_RESOLUCION;
        this.sintonizador = DEFAULT_SINTONIZADOR;
    }

    /**
     * Constructor de la clase
     * @param precio Precio del producto
     * @param peso Peso del producto
     */
    public Television(long precio, double peso) {
        super(precio, peso);
        this.resolucion = DEFAULT_RESOLUCION;
        this.sintonizador = DEFAULT_SINTONIZADOR;
    }

    /**
     * Constructor de la clase
     * @param resolucion Resolucion en pulgadas de la pantalla
     * @param sintonizador Tiene o no un Sintonizador TDT
     * @param precio Precio del producto
     * @param color Color del producto
     * @param consumo Consumo electrico del producto
     * @param peso Peso del producto
     */
    public Television(int resolucion, boolean sintonizador, long precio, String color, 
            char consumo, double peso) {
        super(precio, color, consumo, peso);
        
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
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
        
        if(this.sintonizador)
            total += 50;
        
        if(this.resolucion > 40)
            total *= 1.3;
        
        return total;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el valor de la resolucion de pantalla
     * @return resolucion
     */
    public int getResolucion() {
        return this.resolucion;
    }
    
    /**
     * Devuelve si tiene o no un sintonizador tdt incorporado
     * @return disponibilidad de sintonizador tdt
     */
    public boolean hasSintonizador() {
        return this.sintonizador;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    /**
     * Cambia el valor de la resolucion de pantalla
     * @param resolucion Nuevo valor
     */
    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }
    
    /**
     * Cambia el valor del sintonizador
     * @param sintonizador Nuevo valor
     */
    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
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
                "kg, resolucion: " + this.getResolucion() + 
                " pulgadas, tieneSintonizador: " + this.hasSintonizador() + ")";
    }

}
