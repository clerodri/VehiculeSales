public class Trailer extends Vehiculo{
    public Trailer(String color, String marca, String placa, String modelo) {
        super(color, marca, placa, modelo);
    }

    @Override
    String getType() {
        return "Trailer";
    }
}
