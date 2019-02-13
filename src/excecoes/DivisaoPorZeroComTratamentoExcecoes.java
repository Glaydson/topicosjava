package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

// Tratando as exceções ArithmeticException e InputMismatchException
public class DivisaoPorZeroComTratamentoExcecoes {

	// Demonstra o lançamento de uma exceção quando ocorre uma divisão por zero
	public static int quociente(int numerador, int denominador) throws ArithmeticException {
		return numerador / denominador; // possível divisão por zero
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuaLoop = true;   // determina se mais entradas são necessárias
		
		do {
			try {   // lê dois números e calcula o quociente
				System.out.println("Por favor entre um numerador inteiro: ");
				int numerador = scanner.nextInt();
				System.out.println("Por favor entre um denominador inteiro: ");
				int denominador = scanner.nextInt();
				int resultado = quociente(numerador, denominador);
				System.out.printf("%nResultado: %d / %d = %d", numerador, denominador, resultado);
				continuaLoop = false;  // entrada bem sucedida, termina o loop
			} catch (InputMismatchException ime) {
				System.err.printf("%nExceção: %s%n", ime);
				scanner.nextLine();    // descarta a entrada para que o usuário possa tentar de novo
				System.out.printf("Você deve entrar inteiros. Por favor tente novamente.%n%n");
			} catch (ArithmeticException ae) {
				System.err.printf("%nExceção: %s%n", ae);
				scanner.nextLine();    // descarta a entrada para que o usuário possa tentar de novo
				System.out.printf("Zero é um denominador inválido. Por favor tente novamente.%n%n");
			} finally {
				System.out.println("Eu sempre vou aparecer.");
			}
		} while (continuaLoop);
		scanner.close();
	}

}
