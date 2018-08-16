package streams;

public class Carro {

	private String marca;
	private String modelo;
	private int ano;
	private double valor;

	public Carro(String marca, String modelo, int ano, double valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s %10d    %.2f", getMarca(), getModelo(), getAno(),
				getValor());
	}

}
