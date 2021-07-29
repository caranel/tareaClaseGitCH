package Jerarquia;

public class Hotel extends Hospederia{

    //Atributos
    protected boolean conDesayuno;

    //Constructores
    public Hotel(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada,
                 int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public Hotel(){

    }

    //Accesadores y Mutadores

    public boolean getConDesayuno() { return conDesayuno; }

    public void setConDesayuno(boolean conDesayuno) { this.conDesayuno = conDesayuno; }


    //Metodos


    //adicional: devolverá el valor adicional, que corresponde al 30% del subtotal si es Fumador y con desayuno.

    public int adicional() {

        int adicional;
       if (this.getEsFumador() == true && this.conDesayuno == true) {
           adicional = (int) Math.round(this.subTotal() * 0.30);
           return adicional;
       }else {
           adicional = 0;
           return adicional;
       }

    }

    public int valorACancelar() {

        int valor = (subTotal() + adicional() -bonoDescuento());
        return valor;
    }

}
