import java.util.*;

public class MainClass   {

    public static void main(String[] args) {
        List<Venta> ventas = new ArrayList();
         HashSet<Cliente> clientes = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;

        String op ;
        while (!bandera) {
            System.out.println("*****MENU******");
            System.out.println("1. Registrar Venta de Vehiculo");
            System.out.println("2. Buscar clientes por ano");
            System.out.println("3. Buscar cliente marcas");
            System.out.println("4. Salir");
            try {
                System.out.println("Ingrese opcion: ");
                op = sc.nextLine();
                switch (op) {
                    case "1" -> addDatos(sc, ventas, clientes);
                    case "2" -> getClientesByYear(clientes);
                    case "3" -> getClientesByMarca(sc, clientes);
                    case "4" -> {
                        sc.close();
                        System.out.println("Programa Terminado");
                        bandera = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, debes ingresar un numero");
                System.out.println("\n");
                sc.next();
            }
        }
    }
    public static void getClientesByYear(HashSet<Cliente> clientes){
        System.out.println("***** CLIENTES CON MAS DE 1 VEHICULO X AñO  **");
        for (Cliente cliente : clientes) {
            if(cliente.getListaVehiculos().size()>1){
                System.out.println("Cliente: "+cliente.getName());
            }
        }
    }
    public static void getClientesByMarca(Scanner sc,HashSet<Cliente> clientes){
        System.out.println(" **CLIENTES CON VEHICULOS X MARCA****");
        System.out.println("Ingrese la marca:");
        String marca = sc.nextLine();
        for (Cliente cliente : clientes) {
            if(cliente.searchByMarca(marca)){
                System.out.println("Cliente: "+cliente.getName());
            }
        }
    }

    private static void addDatos(Scanner sc,List<Venta> ventas,HashSet<Cliente> clientes) {
        boolean bandera2=false;
        do {
            System.out.println("Ingrese el nombre del Cliente:");
            String nombre = sc.nextLine();
            System.out.println("Ingresa el color:");
            String color = sc.nextLine();
            System.out.println("Ingresa la marca:");
            String marca = sc.nextLine();
            System.out.println("Ingresa el Placa:");
            String placa = sc.nextLine();
            System.out.println("Ingresa el modelo:");
            String modelo = sc.nextLine();
            if(Objects.equals(modelo, "Buseta")){
                Buseta buseta = new Buseta(color,marca,placa,modelo);
                Cliente newClient = new Cliente(nombre);
                if(clientes.contains(newClient)){
                    for (Cliente cliente:clientes) {
                            if(cliente.equals(newClient)){
                                cliente.agregarVehiculo(buseta);
                            }
                    }
                }else{
                    newClient.agregarVehiculo(buseta);
                    clientes.add(newClient);
                }
                Venta venta= new Venta(newClient,buseta);
                ventas.add(venta);
                System.out.println("Clientes: "+clientes);
                for (Cliente c: clientes) {
                    System.out.println("AUTOS VENDIDOS:"+c.getListaVehiculos());
                }
                bandera2=true;
            }
        }while(!bandera2);
    }
}
