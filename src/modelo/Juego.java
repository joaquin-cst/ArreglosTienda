package modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamanio;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, int tamanio, int licenciasDisponibles, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tamanio = tamanio;
        this.licenciasDisponibles = licenciasDisponibles;
        this.precio = precio;
        licenciasVendidas=0;
    }


    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTamanio() {
        return tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }


    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty())
            this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        if (nombre!=null && nombre.trim().isEmpty())
            this.categoria = categoria;
    }

    public void setTamanio(int tamanio) {
        if (tamanio>0)
            this.tamanio = tamanio;
    }

    public void setPrecio(double precio) {
        if (tamanio>0)
            this.precio = precio;
    }



    public boolean comprarLicencias (int cantidad){
        if (cantidad > 0) {
            licenciasDisponibles+=cantidad;
            return true;
        }
        return false;
    }

    public boolean venderLicencias (int cantidad){
        if (cantidad>0 && cantidad<=licenciasDisponibles){
            licenciasDisponibles-=cantidad;
            licenciasVendidas+=cantidad;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tamanio=" + tamanio +
                ", precio=" + precio +
                ", licenciasDisponibles=" + licenciasDisponibles +
                ", licenciasVendidas=" + licenciasVendidas +
                '}';
    }
}
