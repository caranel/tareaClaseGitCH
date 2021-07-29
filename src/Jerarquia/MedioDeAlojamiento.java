package Jerarquia;

public abstract class MedioDeAlojamiento {

    //atributos
    protected DatosCliente datosCliente;
    protected int valorBaseNoche;
    protected int cantidadNoches;
    protected String tipoTemporada;

    //Constructores
    public MedioDeAlojamiento(DatosCliente datosCliente, int valorBaseNoche, int cantidadNoches, String tipoTemporada) {
        this.datosCliente = datosCliente;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
    }

       public MedioDeAlojamiento() {
    }

    //Accesadores y Mutadores

    public DatosCliente getDatosCliente() { return datosCliente; }

    public void setDatosCliente(DatosCliente datosCliente) { this.datosCliente = datosCliente; }

    public int getValorBaseNoche() { return valorBaseNoche; }

    public void setValorBaseNoche(int valorBaseNoche) { this.valorBaseNoche = valorBaseNoche; }

    public int getCantidadNoches() { return cantidadNoches; }

    public void setCantidadNoches(int cantidadNoches) { this.cantidadNoches = cantidadNoches; }

    public String getTipoTemporada() { return tipoTemporada; }

    public void setTipoTemporada(String tipoTemporada) { this.tipoTemporada = tipoTemporada; }



    //subtotal: devolverá el subtotal a cancelar el cual será cantidad de noches por el valorBaseNoche

    public int subTotal(){
        return valorBaseNoche*cantidadNoches;
    }

    //bonoDescuento: devolverá el valor a descontar sabiendo que es un 25% del subTotal si el tipo de temporada
    //es baja o es de un 12.5% si el tipo Temporada es media.

    public int bonoDescuento(){
        int bonoDescuento = 0;

        if (this.tipoTemporada.equalsIgnoreCase("Baja")){
            bonoDescuento = (this.subTotal()*25/100);
        }else if (this.tipoTemporada.equalsIgnoreCase("Media")) {
            bonoDescuento = (int) (this.subTotal() * 12.5 / 100);
        }
        return  bonoDescuento;
    }

    //valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el
    //adicional, donde corresponda.

    //Metodo abstracto
    public abstract int valorACancelar();

}
