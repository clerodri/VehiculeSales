import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente implements VentaVehiculo{
    private String name;
    private final List<Vehiculo> listaVehiculos;


    public Cliente(String name) {
        this.name = name;
        this.listaVehiculos = new ArrayList<>();
    }

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public String getName() {
        return name;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return name.equals(cliente.name);
    }
    public Boolean searchByMarca(String marca){
        boolean bandera=false;
        for (Vehiculo vehiculo:listaVehiculos
             ) {
             if(vehiculo.getMarca().equals(marca)){
                 bandera =true;
                 break;
             }
        }
        return bandera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
