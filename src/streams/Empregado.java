package streams;

public class Empregado {

	private String primeiroNome;
	private String ultimoNome;
	private double salario;
	private String departamento;

	public Empregado(String primeiroNome, String ultimoNome, double salario, String departamento) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return String.format("%s %s", getPrimeiroNome(), getUltimoNome());
	}

	public String toString() {
		return String.format("%-10s %-10s %10.2f    %s", getPrimeiroNome(), getUltimoNome(), getSalario(),
				getDepartamento());
	}

}
