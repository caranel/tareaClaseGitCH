package Jerarquia;

public class Cabagna extends Hospederia{

    //Atributos
    protected boolean chimenea;

    //Constructores


    public Cabagna(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada,
                   int capacidad, boolean esFumador, boolean chimenea) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public Cabagna(){

    }


    //Accesadores y Mutadores

    public boolean getChimenea() { return chimenea; }

    public void setChimenea(boolean chimenea) { this.chimenea = chimenea; }

    //metodos

    @Override
    public int valorACancelar() {

        int valor = (subTotal() - bonoDescuento());
        return valor;
    }

    //incrementaValorBase: aumenta el valor base en un 18% si la capacidad de la cabaña es superior a 5.

    public int incrementaValorBase(){
        int incremento = 0;

        if (this.getCapacidad()>5){
            incremento = this.valorBaseNoche * 18 /100;
            return incremento;
        }else {
            return incremento;
        }
    }

}
