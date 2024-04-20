package ElectroMart;

import ElectroMart.Articulo.Articulo;

public class Laptop extends Articulo implements Precio_Descripcion{

    private String color ;
    private String tamanio;

    public Laptop(Caracteristicas caracteristicas, String color, String tamanio) {
        super(caracteristicas);
        this.color = color;
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public void obtenerPrecio() {
        System.out.println("El precio de laptop es: "+ getPrecio());

    }

    @Override
    public void obtenerDescripcion() {
        System.out.println("Descripcion de laptop: " + getDescripcion());

    }
}

