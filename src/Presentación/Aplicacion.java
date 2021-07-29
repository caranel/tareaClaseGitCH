package Presentación;


import Controladora.EmpresaHospedaje;
import Jerarquia.*;


import java.util.ArrayList;

public class Aplicacion {

    public static void main(String[] args) {
        int opcion;
        String cliente = null;
        EmpresaHospedaje empresa = new EmpresaHospedaje(new ArrayList<>());

        do {
            opcion = menu();

            switch (opcion) {

                case 1:
                    cliente = pideNombre();
                    if (empresa.buscarRutCliente(cliente) == -1) {
                        System.out.println("¡Ingrese su Rut!");
                        String nombre = Leer.dato();

                        System.out.println("¿Cantidad de Noches?");
                        int numeroNoches = Leer.datoInt();

                        System.out.println("¿Valor base noche?");
                        int valorBase = Leer.datoInt();

                        String tipoTemporada;
                        do {
                            System.out.println("¿Tipo de Temporada? (Alta, Media o Baja)");
                            tipoTemporada = Leer.dato();
                        } while (tipoTemporada.compareToIgnoreCase("Alta") != 0
                                && tipoTemporada.compareToIgnoreCase("Media") != 0
                                && tipoTemporada.compareToIgnoreCase("Baja") != 0);

                        int respuesta;
                        do {
                            System.out.println("Seleccione Tipo de Reserva: 1) Carpa 2) Hotel 3) Cabaña");
                            System.out.println("Ingrese opcion 1, 2 o 3");
                            respuesta = Leer.datoInt();
                        } while (respuesta < 1 || respuesta > 3);

                        if (respuesta == 1) {//carpa
                            System.out.println("¿Cantidad de personas?");
                            int numPersonas = Leer.datoInt();

                            DatosCliente datosCliente = new DatosCliente(cliente, nombre);
                            Carpa carpa = new Carpa(datosCliente, valorBase, numeroNoches, tipoTemporada, numPersonas);
                            empresa.ingresarClienteCarpa(carpa);
                            System.out.println("El alojamiento Carpa se ingresa correctamente");

                        } else {

                            System.out.println("¡Indique Capacidad requerida!");
                            int capacidad = Leer.datoInt();

                            String fumador;
                            do {
                                System.out.println("¿Es fumador? (Si o No)");
                                fumador = Leer.dato();
                            }while (fumador.compareToIgnoreCase("SI") != 0
                            && fumador.compareToIgnoreCase("NO") != 0);
                            boolean fumadorRespuesta = false;
                            if (fumador.equalsIgnoreCase("SI")){
                                fumadorRespuesta = true;
                            }


                            if (respuesta == 2) {

                                String desayuno;
                                do {
                                    System.out.println("¿Incluir Desayuno? (Si o No)");
                                    desayuno = Leer.dato();
                                }while (desayuno.compareToIgnoreCase("SI") != 0
                                && desayuno.compareToIgnoreCase("NO") != 0);
                                boolean desayunoRespuesta = false;
                                if (desayuno.equalsIgnoreCase("SI")){
                                    desayunoRespuesta = true;
                                }

                                empresa.ingresarClienteHotel(new Hotel(new DatosCliente(cliente, nombre),
                                        valorBase, numeroNoches, tipoTemporada, capacidad, fumadorRespuesta, desayunoRespuesta));
                                System.out.println("El alojamiento Hotel se ingresa correctamente");
                            }else {
                                String chimenea;
                                do {
                                    System.out.println("¿Cabaña con Chimenea? (Si o No)");
                                    chimenea = Leer.dato();
                                }while (chimenea.compareToIgnoreCase("SI") != 0
                                && chimenea.compareToIgnoreCase("NO") != 0);
                                boolean chimeneaRespuesta = false;
                                if (chimenea.equalsIgnoreCase("SI")){
                                    chimeneaRespuesta = true;
                                }
                                empresa.ingresarClienteCabagna(new Cabagna(new DatosCliente(cliente, nombre),
                                        valorBase,numeroNoches,tipoTemporada,capacidad,fumadorRespuesta,chimeneaRespuesta));
                                System.out.println("El alojamiento Cabaña se ingresa correctamente");
                            }
                        }
                    }else {
                        System.out.println("El rut ingresado ya existe");
                    }
                    break;
                case 2:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        System.out.println(empresa.mostrarMediosDeAlojamientoClientes());
                    }
                    break;
                case 3:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        String rutCli = pideRut();
                        System.out.println(empresa.datosDeUnCliente(rutCli));
                    }
                    break;
                case 4:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        System.out.println(empresa.toTalAdicional());
                    }
                    break;
                case 5:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        System.out.println(empresa.totalBonoDescuento());
                    }
                    break;
                case 6:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        System.out.println(empresa.cantidadMediosAlojamiento());
                    }
                    break;
                case 7:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        String consultaRut = pideRut();
                        System.out.println(empresa.valorACancelar(consultaRut));
                    }
                    break;
               case 8:
                    if (cliente == null) {
                        System.out.println("** Empezar con opcion 1 del Menu **");

                    }else {
                        System.out.println(empresa.incrementoValorBase());
                    }
                    break;
                    }
            }
            while (opcion != 9) ;
        }

    public static int menu() {
        System.out.println("\n++ Bienvenido a Empresa de Turismo ++\n");
        System.out.println("1. Ingresar Medio de Alojamiento");
        System.out.println("2. Mostrar medios de alojamiento");
        System.out.println("3. Datos de un cliente X ");
        System.out.println("4. Total adicional");
        System.out.println("5. Total bono descuento");
        System.out.println("6. Cantidad medios de alojamiento X");
        System.out.println("7. Valor a cancelar por un cliente X");
        System.out.println("8. Aplicar incremento del valor base");
        System.out.println("9. Salir");
        return Leer.datoInt();
    }

    public static String pideNombre() {
        System.out.println("¡Ingrese su nombre!");
        return Leer.dato();
    }

    public static String pideRut() {
        System.out.println("¡Ingrese Rut!");
        return Leer.dato();
    }
}