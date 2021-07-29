package Jerarquia;

public class Carpa extends MedioDeAlojamiento{

    //Atributos
    protected int cantidadPersonas;

    //Constructor
    public Carpa(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int cantidadPersonas) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public Carpa(){

    }

    //valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el
    //adicional, donde corresponda.
    @Override
    public int valorACancelar() {

        int valor = (subTotal() - bonoDescuento());
        return valor;
    }

    //Accesadores y Mutadores

    public int getCantidadPersonas() { return cantidadPersonas; }

    public void setCantidadPersonas(int cantidadPersonas) { this.cantidadPersonas = cantidadPersonas; }
}
