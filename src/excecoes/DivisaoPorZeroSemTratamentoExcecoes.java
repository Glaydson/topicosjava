package excecoes;

import java.util.Scanner;

// Divisão inteira sem tratamento de exceções
public class DivisaoPorZeroSemTratamentoExcecoes {

	// Demonstra o lançamento de uma exceção quando ocorre uma divisão por zero
	public static int quociente(int numerador, int denominador) {
		return numerador / denominador; // possível divisão por zero
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor entre um numerador inteiro: ");
		int numerador = scanner.nextInt();
		System.out.println("Por favor entre um denominador inteiro: ");
		int denominador = scanner.nextInt();

		int resultado = quociente(numerador, denominador);
		System.out.printf("%nResultado: %d / %d = %d", numerador, denominador, resultado);
		scanner.close();
	}

}
