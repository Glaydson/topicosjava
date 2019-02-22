package streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OperacoesIntStream {

	public static void main(String[] args) {
		// Array original
		int[] valores = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };

		// Usando um loop normal - programação imperativa
		for (int v: valores) {
			System.out.printf("%d ", v);
		}
		System.out.println();
		
		// exibe os valores originais
		System.out.print("Valores originais: ");
		// Consumer - executa uma ação para cada elemento do stream
		// forEach é uma operação terminal
		IntStream.of(valores).forEach(a -> System.out.printf("%d ", a));
		System.out.println();

		// count, min, max, sum e average dos valores
		
		IntStream fluxo1 = IntStream.of(valores);
		long quantidadeElementos = fluxo1.count();
		
		System.out.printf("%nCount: %d%n", IntStream.of(valores).count());
		
		// Se eu não sei se o array tem elementos, como testar se o mínimo existe
		OptionalInt menorValor = IntStream.of(valores).min();
		
		if (menorValor.isPresent()) {
			System.out.println(menorValor.getAsInt());
		} else {
			System.out.println("O array está vazio");
		}
		
				
		System.out.printf("Min: %d%n", IntStream.of(valores).min().getAsInt());
		System.out.printf("Max: %d%n", IntStream.of(valores).max().getAsInt());
		System.out.printf("Sum: %d%n", IntStream.of(valores).sum());
		System.out.printf("Average: %.2f%n", IntStream.of(valores).average().getAsDouble());
		
		// soma dos valores com o método reduce
		System.out.printf("%nSoma usando o método reduce: %d%n", IntStream.of(valores).reduce(0, (x, y) -> x + y));

		// soma dos quadrados dos valores usando reduce
		System.out.printf("%nSoma dos quadrados usando método reduce: %d%n",
				IntStream.of(valores).reduce(0, (x, y) -> x + y * y));

		// produto dos valores usando reduce
		System.out.printf("%nProduto dos valores usando método reduce: %d%n",
				IntStream.of(valores).reduce(1, (x, y) -> x * y));

		// valores pares exibidos em ordem
		System.out.printf("%nValores pares exibidos em ordem: ");
		IntStream.of(valores)
			.filter(valor -> valor % 2 == 0)
			//.map(i -> -i).sorted().map(i -> -i)    // trick para ordenar em ordem descrescente
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();

		// Valores ímpares multiplicados por 10 e exibidos em ordem crescente
		System.out.printf("%nValores ímpares multiplicados por 10 e exibidos em ordem crescente: ");
		IntStream.of(valores)
			.filter(valor -> valor % 2 != 0)  //impares
			.map(valor -> valor * 10)	// multiplicados por 10
			.sorted()				// em ordem crescente
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();

	}
}
