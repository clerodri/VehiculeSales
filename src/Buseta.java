public class Buseta extends  Vehiculo{
    public Buseta(String color, String marca, String placa, String modelo) {
        super(color, marca, placa, modelo);
    }

    @Override
    String getType() {
        return "Buseta";
    }
}
