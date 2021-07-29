package Controladora;

import Jerarquia.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmpresaHospedaje {

    //Atributos
    private ArrayList<MedioDeAlojamiento> empresa;

    //Contructor

    public EmpresaHospedaje(ArrayList<MedioDeAlojamiento> empresa) {
        this.empresa = empresa;
    }

    public EmpresaHospedaje() {
    }

    //Accesadores y Mutadores

    public ArrayList<MedioDeAlojamiento> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<MedioDeAlojamiento> empresa) {
        this.empresa = empresa;
    }

    //Metodos

    //empresa = {0,    1,   2,   3}
    //empresa = {Alojamiento1, alojamiento2, alojamiento3, alojamiento4}
    //empresa = {Carpa, Hotel, Cabagna, Carpa}
    //empresa = {rut1, rut2, rut3, rut4}

    public int buscarRutCliente(String rutCliente) {

        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i).getDatosCliente().getRutCliente().
                    compareToIgnoreCase(rutCliente) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void ingresarClienteCarpa(Carpa carpa) {
        if (this.buscarRutCliente(carpa.getDatosCliente().getRutCliente()) == -1) {
            empresa.add(carpa);
        }
    }

    public void ingresarClienteHotel(Hotel hotel) {
        if (this.buscarRutCliente(hotel.getDatosCliente().getRutCliente()) == -1) {
            empresa.add(hotel);
        }
    }

    public void ingresarClienteCabagna(Cabagna cabagna) {
        if (this.buscarRutCliente(cabagna.getDatosCliente().getRutCliente()) == -1) {
            empresa.add(cabagna);
        }
    }

    //Mostrar medios de alojamiento (muestra datos de todos los objetos almacenados)


    public String mostrarMediosDeAlojamientoClientes() {
        String mensaje = "";
        String mensaje2 = "";
        Cabagna cabagna;
        Hotel hotel;
        Carpa carpa;

        System.out.println("\nInformacion de pasajeros hospedados:");
        for (int i = 0; i < empresa.size(); i++) {

            if (empresa.get(i) instanceof Carpa) {
                carpa = (Carpa) empresa.get(i);
                mensaje = mensaje +"\nHospedado en Carpa--> "+
                        "Nombre Cliente: " + carpa.getDatosCliente().getNombre() + " - " +
                        "Rut Cliente: " + carpa.getDatosCliente().getRutCliente();
            }
            if (empresa.get(i) instanceof Hotel) {
                hotel = (Hotel) empresa.get(i);
                mensaje = mensaje +"\nHospedado en Hotel--> "+
                        "Nombre Cliente: " + hotel.getDatosCliente().getNombre() + " - " +
                        " Rut Cliente: " + hotel.getDatosCliente().getRutCliente();
            }
            if (empresa.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) empresa.get(i);
                mensaje = mensaje +"\nHospedado en Cabaña--> "+
                        "Nombre Cliente: " + cabagna.getDatosCliente().getNombre() + " - " +
                        " Rut Cliente: " + cabagna.getDatosCliente().getRutCliente();
            }
        }return mensaje;

    }

    //Datos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)

    public String datosDeUnCliente(String rutCliente) {

        Cabagna cabagna = null;
        Hotel hotel = null;
        Carpa carpa = null;
        String mensaje = "";


        System.out.println("Los datos del cliente son: ");
        for (int i = 0; i < empresa.size(); i++) {
            if ((empresa.get(i).getDatosCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) && (empresa.get(i) instanceof Hotel)) {
                hotel = (Hotel) empresa.get(i);

                boolean desayuno= hotel.getConDesayuno();
                String muestraDesayuno;
                if (desayuno==true){
                    muestraDesayuno="si";
                }else{
                    muestraDesayuno="no";
                }

                boolean fumador= hotel.getEsFumador();
                String muestraFumador;
                if (fumador==true){
                    muestraFumador="si";
                }else{
                    muestraFumador="no";
                }
                mensaje = mensaje + "Nombre Cliente: " + hotel.getDatosCliente().getNombre() + " - " +
                        " Rut: " + hotel.getDatosCliente().getRutCliente() + " - " +
                        " Capacidad: " + hotel.getCapacidad() + " - " +
                        " Tipo Temporada: " + hotel.getTipoTemporada() + " - " +
                        " Cantidad de noches: " + hotel.getCantidadNoches() + " - " +
                        " Valor Base Noche: " + hotel.getValorBaseNoche()+ " - " +
                        " Desayuno: " + muestraDesayuno + " - " +
                        " Es Fumador: " + muestraFumador+ "\n";
            }

                if ((empresa.get(i).getDatosCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) && (empresa.get(i) instanceof Cabagna)) {
                    cabagna = (Cabagna) empresa.get(i);

                    boolean muestraFumadoCabagna= cabagna.getEsFumador();
                    String esFumadorCabagna;
                    if (muestraFumadoCabagna==true){
                        esFumadorCabagna="si";
                    }else{
                        esFumadorCabagna="no";
                    }

                    boolean chimena=cabagna.getChimenea();
                    String muestraChimenea;
                    if (chimena==true){
                        muestraChimenea="si";
                    }else{
                        muestraChimenea="no";
                    }

                    mensaje = mensaje + "Nombre Cliente: " + cabagna.getDatosCliente().getNombre() + " - " +
                            " Rut: " + cabagna.getDatosCliente().getRutCliente() + " - " +
                            " Capacidad: " + cabagna.getCapacidad() + " - " +
                            " Tipo Temporada: " + cabagna.getTipoTemporada() + " - " +
                            " Cantidad de noches: " + cabagna.getCantidadNoches() + " - " +
                            " Valor Base Noche: " + cabagna.getValorBaseNoche() + " - " +
                            " Es Fumador: " + esFumadorCabagna + " - " +
                            " Chimenea: " + muestraChimenea+ "\n";

                }
                if ((empresa.get(i).getDatosCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) && (empresa.get(i) instanceof Carpa)) {
                    carpa = (Carpa) empresa.get(i);
                    mensaje = mensaje + "Nombre Cliente: " + carpa.getDatosCliente().getNombre() + " - " +
                            " Rut: " + carpa.getDatosCliente().getRutCliente() + " - " +
                            " Valor Base Noche: " + carpa.getValorBaseNoche() + " - " +
                            " Cantidad de noches: " + carpa.getCantidadNoches() + " - " +
                            " Tipo de Temporada: " + carpa.getTipoTemporada() + " - " +
                            " Cantidad de Personas: " + carpa.getCantidadPersonas()+ "\n";
                }
            }return mensaje;


        }

        //Total adicional

    public String toTalAdicional() {
        String mensaje = "";
        Carpa carpa = null;
        Cabagna cabagna = null;
        Hotel hotel = null;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Hotel) {
                hotel = (Hotel) empresa.get(i);
                mensaje = mensaje + "El Total Adicional del cliente " +hotel.getDatosCliente().getNombre()
                        + " que esta alojado en Hotel es --> " +
                        " $ " + hotel.adicional()+ "\n";
            }
        }
        return mensaje;
    }

        //Total bono descuento

        public String totalBonoDescuento () {
            String mensaje = "";
            int total = 0;

            for (int i = 0; i < empresa.size(); i++) {

                if (empresa.get(i).getTipoTemporada().equalsIgnoreCase("Baja")) {
                    total = total + empresa.get(i).bonoDescuento();
                } else if (empresa.get(i).getTipoTemporada().equalsIgnoreCase("Media")) {
                    total = total + empresa.get(i).bonoDescuento();
                }
                mensaje = mensaje + "El total bono descuento de temporada " +empresa.get(i).getTipoTemporada()
                        + " del Cliente " +empresa.get(i).getDatosCliente().getNombre() +
                        " es --> $ " +total+"\n";
            }
            return mensaje;
        }

        // Cantidad medios de alojamiento

    public String cantidadMediosAlojamiento()
    {
        int cabagna = 0;
        int hotel = 0;
        int carpa = 0;

        System.out.println("Total de alojamientos por tipo: ");

        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Hotel) {
                hotel = hotel + 1;
            } else if (empresa.get(i) instanceof Cabagna) {
                cabagna = cabagna + 1;
            } else
                carpa = carpa + 1;
        }
        return "\n N° de Carpas reservadas --> "+carpa +
                "\n N° de Hoteles reservadas --> "+hotel +
                "\n N° de Cabañas reservadas --> "+cabagna ;
    }

    // Total a cancelar

    public String valorACancelar(String rut) {
        Cabagna cabagna = null;
        Hotel hotel = null;
        Carpa carpa = null;

        String mensaje = "";

        for (int i = 0; i < empresa.size(); i++)
            if(empresa.get(i).getDatosCliente().getRutCliente().compareToIgnoreCase(rut) == 0) {
                if (empresa.get(i) instanceof Hotel) {
                    hotel = (Hotel) empresa.get(i);
                    mensaje = "El valor total a cancelar es: " +
                            "$ " + hotel.valorACancelar() + " - " +
                            "Nombre Cliente: " + hotel.getDatosCliente().getNombre() + " - " +
                            "Rut : " + hotel.getDatosCliente().getRutCliente();


                } else if(empresa.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresa.get(i);
                    mensaje = "El valor total a cancelar es: " +
                            "$ " + cabagna.valorACancelar() + " - " +
                            "Nombre Cliente: " + cabagna.getDatosCliente().getNombre() + " - " +
                            "Rut : " + cabagna.getDatosCliente().getRutCliente();

                } else if(empresa.get(i) instanceof Carpa) {
                    carpa = (Carpa) empresa.get(i);
                    mensaje = "El valor total a cancelar es: " +
                            "$ " + carpa.valorACancelar() + " - " +
                            "Nombre Cliente: " + carpa.getDatosCliente().getNombre() + " - " +
                            "Rut : " + carpa.getDatosCliente().getRutCliente();
                }
            }
        return mensaje;
    }

    //Incremento valor base

    public String incrementoValorBase() {
        String mensaje = "";
        Cabagna cabagna = null;

        System.out.println("Cliente Cabaña: ");
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) empresa.get(i);
                mensaje = mensaje + "Nombre: " + cabagna.getDatosCliente().getNombre() + " - " +
                        "Rut:  " + cabagna.getDatosCliente().getRutCliente() + " - " +
                        "Total Incremento: $ " + cabagna.incrementaValorBase()+"\n";
            }
        }
        return mensaje;
    }

}











