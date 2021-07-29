package Jerarquia;

public  abstract class Hospederia extends MedioDeAlojamiento{

    //Atributos
    protected int capacidad;
    protected boolean esFumador;

    //Constructores
    public Hospederia(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada,
                      int capacidad, boolean esFumador) {
        super(datosCliente, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public Hospederia(){

    }

    //Accesadores y Mutadores

    public int getCapacidad() { return capacidad; }

    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public boolean getEsFumador() { return esFumador; }

    public void setEsFumador(boolean esFumador) { this.esFumador = esFumador; }


}
