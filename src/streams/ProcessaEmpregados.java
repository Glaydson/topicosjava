package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessaEmpregados {

	public static void main(String[] args) {
		// Inicializa array de Empregados
		Empregado[] empregados = {
				new Empregado("Aécio", "Neves", 5000, "IT"),
				new Empregado("Tancredo", "Neves", 7600, "IT"),
				new Empregado("Fernando", "Collor", 3587.5, "Vendas"),
				new Empregado("Ciro", "Gomes", 4700.77, "Marketing"),
				new Empregado("Tasso", "Jereissati", 6200, "IT"),
				new Empregado("Camilo", "Santana", 3200, "Vendas"),
				new Empregado("José", "Sarney", 4236.4, "Marketing"),
		};
		
		// obtém uma lista dos empregados
		List<Empregado> lista = Arrays.asList(empregados);
		
		// exibe todos os empregados
		System.out.println("Lista completa de empregados:");
		lista.stream().forEach(System.out::println);
		
		// Predicado que retorna true para salários na faixa de 4000-6000
		Predicate<Empregado> quatroASeisMil = e -> (e.getSalario() >= 4000 && e.getSalario() <=6000);
		
		// Exibe empregados com salários na faixa de 4000-6000, ordenados em ordem crescente de salário
		System.out.printf("%nEmpregados ganhando de 4000 a 6000 por mês, ordenados por salário:%n");
		lista.stream()
			.filter(quatroASeisMil)
			.sorted(Comparator.comparing(Empregado::getSalario))
			.forEach(System.out::println);
				
		// Exibe o primeiro empregado com salário na faixa de 4000-6000
		System.out.printf("%nPrimeiro empregado que ganha entre 4000-6000:%n%s%n",
				lista.stream()
					.filter(quatroASeisMil)
					.findFirst()
					.get());
		
		// Funções para obter o primeiro e último nomes de um Empregado
		Function<Empregado, String> primeiroNome = Empregado::getPrimeiroNome;
		Function<Empregado, String> ultimoNome = Empregado::getUltimoNome;
		
		// Comparador para comparar Empregados pelo primeiro nome e depois pelo último
		Comparator<Empregado> ultimoDepoisPrimeiro = Comparator.comparing(ultimoNome).thenComparing(primeiroNome);
		
		// Ordena os empregados pelo último nome, e depois pelo primeiro nome
		System.out.printf("%nEmpregados em ordem ascendente por último nome e depois pelo primeiro:%n");
		lista.stream()
			.sorted(ultimoDepoisPrimeiro)
			.forEach(System.out::println);
		
		// ordena os empregados em ordem descendente pelo último nome e depois pelo primeiro
		System.out.printf("%nEmpregados em ordem descendente por último nome e depois pelo primeiro:%n");
		lista.stream()
			.sorted(ultimoDepoisPrimeiro.reversed())
			.forEach(System.out::println);
		
		// Exibe últimos nomes únicos dos empregados em ordem
		System.out.printf("%nLista de nomes únicos dos empregados:%n");
		lista.stream()
			.map(Empregado::getUltimoNome)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		// Exibe somente o primeiro e último nomes
		System.out.printf("%nNomes dos empregados em ordem de último nome e depois do primeiro nome:%n");
		lista.stream()
			.sorted(ultimoDepoisPrimeiro)
			.map(Empregado::getNome)
			.forEach(System.out::println);
		
		// Agrupa empregados por Departamento
		System.out.printf("%nEmpregados por departamento:%n");
		Map<String, List<Empregado>> agrupadosPorDepartamento =
				lista.stream().collect(Collectors.groupingBy(Empregado::getDepartamento));
		// System.out.println(agrupadosPorDepartamento);
		agrupadosPorDepartamento.forEach(
				(departamento, empregadosNoDepartamento) -> 
				{
					System.out.println(departamento);
					empregadosNoDepartamento.forEach(
							empregado -> System.out.printf("     %s%n", empregado));
				}
		);
		
		// conta o número de empregados em cada departamento
		System.out.printf("%nNúmero de empregados por departamento:%n");
		Map<String, Long> numeroEmpregadosPorDepartamento =
				lista.stream()
					.collect(Collectors.groupingBy(Empregado::getDepartamento, 
							TreeMap::new, Collectors.counting()));
		
		// System.out.println(numeroEmpregadosPorDepartamento);
		numeroEmpregadosPorDepartamento.forEach(
				(departamento, quantidade) -> System.out.printf(
						"%s possui %d empregado(s)%n", departamento, quantidade));
		
	}

}
