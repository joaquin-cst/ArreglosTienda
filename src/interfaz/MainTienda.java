package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    //En el main todo es static
    //se declara afuera y son staticos para poder usarlos en todos los metodos, sino, solo podria usarlo en el main
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.inicializarDatos();
        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:
                    ingresarJuego();
                    break;

                case 2:
                    imprimitJuegos();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                default:
                    System.out.println("------Opción no válida-----");
            }
        } while (opc!=7);
    }

    public static void menu(){
        System.out.println("========= AppStore UDLA ==========");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuego () {
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco:");

        String categoria = Validacion.leerString("Ingrese la categoria, no puede ser nula ni blanca:");

        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine()); //envoltorio: convertir cadenas a otros tipos de datos, usado segun el que necesite

        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine()); //al parecer integer no tiene un metodo para double, por lo que uso Double

        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());

        if (tienda.agregarJuego(new Juego(nombre,categoria,tamanio,licenciasDisponibles,precio))){
            //ventanas emergentes, parte de la interfaz gráfica, pero no basta con eos para el proyecto
            JOptionPane.showMessageDialog(null,"Juego ingresado con éxito");
        } else {
            JOptionPane.showMessageDialog(null,"No fue posible agregar el juego");
        }
    }

    public static void imprimitJuegos () {
        Juego juegos[] = tienda.getJuegos();
        for (Juego j : juegos){
            if (j!=null){
                System.out.println(j); //llamando al toString de j
            } else{
                System.out.println("No hay más juegos por mostrar");
                return;
            }
        }
    }

    public static void vender () {

    }


}
