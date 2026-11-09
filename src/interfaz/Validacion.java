package interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    //necesito scanner, todos los metodos staticos
    public static String leerString (String mensaje){
        String nombre;
        do {
            System.out.print(mensaje + ": ");
            nombre = sc.nextLine();
        }while(nombre==null || nombre.trim().isEmpty());
        return nombre;
    }
    //añadir caracter, num positivo, num mayor a algo, num menor a algo y leer dentro de un rango
}
