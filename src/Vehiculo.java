abstract class Vehiculo {
    private String color,marca,placa,modelo;

    public Vehiculo(String color, String marca, String placa, String modelo) {
        this.color = color;
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    abstract String getType();
}
