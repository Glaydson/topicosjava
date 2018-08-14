package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysStreams {

	// Demonstra lambdas e streams com arrays de Integers e Strings
	public static void main(String[] args) {
		
		// define um array de Integer
		Integer[] valores = { 2, 9, 5, 0, 3, 7, 1, 4, 8, 6 };

		// Ordena em ordem crescente usando streams
		System.out.printf("%nValores Ordenados: %s%n", 
				Arrays.stream(valores)
				.sorted()
				.collect(Collectors.toList()));
		
		// Valores maiores que 4
		List<Integer> maiorQue4 = 
				Arrays.stream(valores)
				.filter(valor -> valor > 4)
				.collect(Collectors.toList());
		System.out.printf("Valores maiores que 4: %s%n", maiorQue4);
		
		// Define um array de Strings
		String[] strings = {"Vermelho", "laranja", "Amarelo", "verde", "Azul", "roxo", "Violeta"};
		
		System.out.println();
		
		// Exibe o array em caixa alta
		System.out.printf("Strings em caixa alta: %s%n",
				Arrays.stream(strings)
					.map(String::toUpperCase)
					.collect(Collectors.toList()));
		
		// Strings maiores que "m" (insensível à caixa), em ordem ascendente
		System.out.printf("Strings maiores que m em ordem crescente: %s%n",
				Arrays.stream(strings)
					.filter(s -> s.compareToIgnoreCase("m") > 0)
					.sorted(String.CASE_INSENSITIVE_ORDER)
					.collect(Collectors.toList()));
		

	}

}
