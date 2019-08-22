package streams.exercicios;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class OperacoesDoubleStream {

	public static void main(String[] args) {

		// Array original
		double[] notas = { 4.8, 5.5, 10.0, 8.2, 1.5, 4.5, 7.5, 8.0, 5.2, 6.0 };

		// exibe os valores originais
		System.out.print("Valores originais: ");
		// Consumer - executa uma ação para cada elemento do stream
		// forEach é uma operação terminal
		DoubleStream.of(notas).forEach(valor -> System.out.printf("%.2f ", valor));
		System.out.println();

		// count, min, max, sum e average dos valores
		System.out.printf("%nCount: %d%n", DoubleStream.of(notas).count());
		System.out.printf("Min: %.2f%n", DoubleStream.of(notas).min().getAsDouble());
		System.out.printf("Max: %.2f%n", DoubleStream.of(notas).max().getAsDouble());
		System.out.printf("Sum: %.2f%n", DoubleStream.of(notas).sum());
		System.out.printf("Average: %.2f%n", DoubleStream.of(notas).average().getAsDouble());

		// Quantidade de notas acima de 5.0
		System.out.printf("%nQuantidade de notas acima de 5.0: %d%n",
				DoubleStream.of(notas)
					.filter(valor -> valor >= 5.0)
					.count());

		// Notas abaixo de 5.0 exibidas em ordem crescente
		System.out.printf("%nNotas abaixo de 5.0 em ordem crescente: ");
		DoubleStream.of(notas)
			.filter(valor -> valor < 5.0)
			.sorted()
			.forEach(valor -> System.out.printf("%.2f ", valor));
		System.out.println();

		// O professor deu meio ponto para todos os alunos
		// Assim, todas as notas foram elevadas em meio ponto, desde que a nota máxima
		// se mantenha em 10
		// Calcule a nova média da turma e quantos alunos ficariam reprovados agora
		DoubleUnaryOperator notasAcrescidasMeioPonto = valor -> valor <= 9.5 ? valor + 0.5 : valor;
		System.out.printf("%nNova média da turma com notas acrescidas de 0.5 ponto: %.2f%n",
				DoubleStream.of(notas)
					.map(notasAcrescidasMeioPonto)
					.average().getAsDouble());
		
		System.out.printf("%nQuantos alunos ficariam reprovados: %d%n",
				DoubleStream.of(notas)
					.map(notasAcrescidasMeioPonto)
					.filter(valor -> valor < 5.0)
					.count());

		
		System.out.println();

	}
}
