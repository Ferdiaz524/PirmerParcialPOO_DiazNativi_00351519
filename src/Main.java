import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ElectroMart.Articulo.Articulo;
import ElectroMart.Caracteristicas;
import ElectroMart.Laptop;
import ElectroMart.Telefono;

import javax.sound.midi.Soundbank;


public class Main {
    static ArrayList<Articulo> listaDeArticulos = new ArrayList<Articulo>();
    public static void main(String[] args) {
        menuPrincipal();
    }

    static void mostrarMenuPrincipal(){
        System.out.println("Elija una opcion:\n"
                +"\t1.Agregar un articulo\n"
                +"\t2.Modificar un articulo\n"
                +"\t3.Mostrar listado de articulos\n"
                +"\t0.Salir\n");
        System.out.println("opcion >>");
    }

    static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true){
            mostrarMenuPrincipal();
            try{
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion == 0){
                    System.out.println("\n Adios..\n");
                    break;
                }
                switch (opcion){
                    case 1:
                        agregarArticulo();
                        break;
                    case 2:
                        modificarArticulo();
                        break;
                    case 3:
                        MostrarListadoDeArticulos();
                        break;
                    default:
                        System.out.println("\nIntente con otro digito\n");
                        break;
                }

            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("\nIntente con otro digito\n");
            };
        }
    }


    private static void agregarArticulo(){
        int TipoDeArticulo = tipoArticulo();
        Articulo articulo = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Ingrese la descripcion: ");
        String descripcion =sc.nextLine();
        System.out.println("Ingrese el precio: ");
        float precio = sc.nextFloat();

        Caracteristicas caracteristicas = new Caracteristicas(nombre, modelo, descripcion, precio);
        sc.nextLine();

        switch (TipoDeArticulo){
            case 1:
                System.out.println("Ingrese el color de la laptop: ");
                String color = sc.nextLine();
                System.out.println("Ingrese el tamanio de la laptop: ");
                String tamanio = sc.nextLine();
                articulo = new Laptop(caracteristicas, color, tamanio);
                break;
            case 2:
                System.out.println("Ingrese el color del telefono: ");
                String Color = sc.nextLine();
                System.out.println("Ingrese el tamanio del telefono: ");
                String Tamanio = sc.nextLine();
                articulo = new Telefono(caracteristicas, Color, Tamanio);
                break;
        }
        listaDeArticulos.add(articulo);

    }
    private static int tipoArticulo(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true){
            try{
                System.out.println("Ingrese el tipo de articulo que desea agregar: \n"+
                        "\t1.Laptop\n"
                        +"\t2.Telefono\n"
                );
                System.out.println("opcion>>");
                opcion = sc.nextInt();
                if (opcion >=1 && opcion <=2) return opcion;
                System.out.println("\nIntente con otro digito\n");
            }catch (InputMismatchException e){
                System.out.println("\nIntente con otro digito\n");
            }
            sc.nextLine();
        }

    }

    private static void modificarArticulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de articulo a modificar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i <listaDeArticulos.size(); i++){
            if (listaDeArticulos.get(i).getNombre().equals(nombre)){
                System.out.println("Ingrese una nueva descripcion: ");
                String nuevaDescripcion = sc.nextLine();
                listaDeArticulos.get(i).setDescripcion(nuevaDescripcion);
                return;
            }
        }
    }

    private static void MostrarListadoDeArticulos(){
        System.out.println("LISTADO DE ARTICULOS:\n");
        System.out.println("Nombre | modelo | descripcion | precio \n");
        for (int i = 0; i < listaDeArticulos.size(); i++){
            Articulo art = listaDeArticulos.get(i);
            System.out.println((i+1)+ "."+ art.getNombre()
                                +"| "+ art.getModelo()
                                +"| "+ art.getDescripcion()
                                +"| "+ art.getPrecio());
        }
        System.out.println("\n");
    }
}