package modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos [];
    private int indice;

    public AppStore(){
        juegos=new Juego[MAX];
        indice=-1;
    }

    public Juego[] getJuegos() { //notar corchetes pq es un arreglo
        return juegos;
    }

    /*
    public void setJuegos(Juego juegos[]) { // corchetes pq es un arreglo
        this.juegos = juegos;
    }
    No se utiliza porque los datos se ingresan de 1 en 1 en este set */

    public boolean agregarJuego (Juego juegoAgg){
        if (juegoAgg != null  &&  indice<MAX-1){
            juegos[++indice]=juegoAgg;
            return true;
        }
        return false;
    }

    public void inicializarDatos () {
        agregarJuego(new Juego("FIFA 27", "Deportes", 10, 70, 50));
        agregarJuego(new Juego("Roblox", "Variado", 10, 60, 5));
    }


    public Juego buscarJuego (String nombreBusq){ //retorna Juego pq retorna solo uno
        if (nombreBusq!=null && !nombreBusq.trim().isEmpty()){

            for (int i =0; i<=indice; i++){

                if (juegos[i].getNombre().equalsIgnoreCase(nombreBusq)){ //info unica: equals / info clq: equalsignorecase
                    return juegos [i];
                }
            }
            return null;
        }
        return null;
    }

    /* CON VARIABLES DE REFERENCIA
    ==compara referencias (se trata del mismo obj)

    this.nombre.equals(nombre) vompara contenidos
     */

    public boolean comprar (String nombreComp, int cant){
        Juego jComp = buscarJuego(nombreComp);
        if (jComp!=null){
            return jComp.comprarLicencias(cant);
        }
        return false;
    }

    public double vender (String nombre, int cant){
        Juego j = buscarJuego(nombre);
        if (j!=null){
            if(j.venderLicencias(cant)){
                return j.getPrecio()*cant;
            }
            return 0;
        }
        return 0;
    }

    public String juegoMasVendido(){
        String nombre="";
        int mayor;
        if (indice>=0){
            nombre=juegos[0].getNombre();
            mayor=juegos[0].getLicenciasVendidas();
            for (Juego jRef : juegos){
                //for de coleccion, crear un objeto de referencia + : + nombre de coleccion/arreglo. siempre inicia en 0 y siempre recorre todos los elementos
                //Java no tiene basura en arreglos, llena con 0 numericos y null objetos. por eso, se detiene al encontrar el primer null (pues ahi estaria el 1er elemento vacio)
                if (jRef!=null){
                    if (jRef.getLicenciasVendidas() > mayor){
                        mayor=jRef.getLicenciasVendidas();
                        nombre = jRef.getNombre();
                    }
                } else {
                    return nombre;
                }
            }
        }
        return nombre;
    }

}
