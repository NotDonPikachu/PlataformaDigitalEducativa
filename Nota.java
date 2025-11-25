public class Nota {
    private String tipo;
    private double valor;

    public Nota(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() { return tipo; }
    public double getValor() { return valor; }

    public String toString() { return tipo + ": " + valor; }
}