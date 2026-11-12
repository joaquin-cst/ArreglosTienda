package interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    //necesito scanner, todos los metodos staticos
    public static String leerString (String mensaje){
        String nombre;
        do {
            System.out.print(mensaje);
            nombre = sc.nextLine();
        }while(nombre==null || nombre.trim().isEmpty());
        return nombre;
    }

    public static char leerCaracter(String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = sc.nextLine();

            if (input.isEmpty() || input.length() > 1) {
                System.out.println("Error: Por favor ingrese exactamente un caracter.");
            }

        } while (input.isEmpty() || input.length() > 1);

        return input.charAt(0);
    }

    public static int validarIntRango (String mensaje, int inicio, int finaL){
        int num;
        do {
            System.out.print(mensaje);
            num=Integer.parseInt(sc.nextLine());
        } while (num<=inicio || num>=finaL);
        return num;
    }

    public static int intPositivo(String mensaje) {
        int num;
        do {
            System.out.print(mensaje);
            num = Integer.parseInt(sc.nextLine());
        } while (num < 0);
        return num;
    }

    public static int intMayorA(String mensaje, int mayorA){
        int num;
        do {
            System.out.print(mensaje);
            num = Integer.parseInt(sc.nextLine());
        } while (num < mayorA);
        return num;
    }

    public static int intMenorA(String mensaje, int menorA){
        int num;
        do {
            System.out.print(mensaje);
            num = Integer.parseInt(sc.nextLine());
        } while (num >= menorA);
        return num;
    }

}
