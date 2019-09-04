package streams.exercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExercicioCarros {

	public static void main(String[] args) {
		Carro[] carros = { new Carro("Ford", "Corcel", 1985, 2000),
				new Carro("Ford", "Fiesta", 2015, 15000),
				new Carro("Ford", "Ranger", 2014, 75000),
				new Carro("Fiat", "Uno", 1999, 5000),
				new Carro("Fiat", "Palio", 2014, 10000),
				new Carro("Chevrolet", "Cobalt", 2017, 40000),
				new Carro("Chevrolet", "Onix", 2016, 30000),
				new Carro("Chevrolet", "Vectra", 2010, 23000),
				new Carro("Kia", "Sportage", 2014, 70000),
				new Carro("Toyota", "Corolla", 2018, 98000) };

		// obt�m uma lista dos carros
		List<Carro> lista = Arrays.asList(carros);

		// exibe todos os carros
		System.out.println("Lista completa de carros:");
		lista.stream().forEach(System.out::println);

		// Carros com ano entre 2000 e 2015 (inclusive), em ordem de marca

		// Predicado que retorna os carros com ano entre 2000 e 2015
		Predicate<Carro> carrosEntre2000e2015 = c -> (c.getAno() >= 2000
				&& c.getAno() <= 2015);

		// Exibe carros fabricados entre 2000 e 2015, em ordem de marca
		System.out.printf(
				"%nCarros fabricados entre 2000 e 2015, ordenados por marca:%n");
		lista.stream().filter(carrosEntre2000e2015)
				.sorted(Comparator.comparing(Carro::getMarca))
				.forEach(System.out::println);

		// M�dia dos pre�os dos carros
		System.out.printf(
				"%nM�dia dos pre�os dos carros (m�todo average): %.2f%n",
				lista.stream().mapToDouble(Carro::getValor).average()
						.getAsDouble());

		// Carros agrupados por marca
		System.out.printf("%nCarros por Marca:%n");
		Map<String, List<Carro>> agrupadosPorMarca = lista.stream()
				.collect(Collectors.groupingBy(Carro::getMarca));

		agrupadosPorMarca.forEach((marca, carrosDaMarca) -> {
			System.out.println(marca);
			carrosDaMarca
					.forEach(carro -> System.out.printf("     %s%n", carro));
		});

		// N�mero de carros de cada marca

		System.out.printf("%nN�mero de carros por marca:%n");
		Map<String, Long> numeroCarrosPorMarca = lista.stream()
				.collect(Collectors.groupingBy(Carro::getMarca, TreeMap::new,
						Collectors.counting()));

		numeroCarrosPorMarca.forEach((marca, quantidade) -> System.out
				.printf("%s possui %d carro(s)%n", marca, quantidade));

	}

}
