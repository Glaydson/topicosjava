package streams.exercicios;

import java.util.stream.DoubleStream;

public class DoubleStreams {

	public static void main(String[] args) {
		// Array original
		double[] notas = { 4.8, 5.5, 10.0, 8.2, 1.5, 4.5, 7.5, 8.0, 5.2, 6.0 };
/*
		A média das notas
		A maior e menor notas
		A quantidade de notas maiores ou iguais a 5.0
		A lista de notas abaixo de 5.0 em ordem crescente
*/

		System.out.println("Fluxo original");
		DoubleStream.of(notas).forEach(a -> System.out.printf("%.2f ", a));
		System.out.println(); 
		
		//Media fluxo
		System.out.printf("Media: %.2f%n", DoubleStream.of(notas).average().getAsDouble());
		//Menor e Maior valor no fluxo
		System.out.printf("Min: %.2f%n", DoubleStream.of(notas).min().getAsDouble());
		System.out.printf("Max: %.2f%n", DoubleStream.of(notas).max().getAsDouble());
		//Quantidade de notas >= 5 
		System.out.println("Quantidade de notas maior ou igual a 5");
		System.out.println(DoubleStream.of(notas).filter(nota -> nota >= 5).count());
		// Lista de notas < 5
		System.out.println("Notas menores que 5");
		DoubleStream.of(notas).filter(nota-> nota< 5 ).sorted().forEach(a -> System.out.printf("%.2f ", a));
		
		//novo fluxo com meio ponto para cada aluno
		
		DoubleStream notasAtualizadas = DoubleStream.of(notas).map(nota-> ((nota <= 9.5) ? nota+0.5 : 10));
		DoubleStream notasAtualizadasCopia = DoubleStream.of(notas).map(nota-> ((nota <= 9.5) ? nota+0.5 : 10));
		// Media das notas atualizadas
		System.out.printf("%nMedia atualizada: %.2f%n", (notasAtualizadas).average().getAsDouble());
		//Quantidade de alunos reprovados
		System.out.println((notasAtualizadasCopia).filter(nota -> nota < 5).count());

	}
}
