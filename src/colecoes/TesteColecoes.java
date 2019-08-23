package colecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Demonstração da interface Collection usando um objeto ArrayList
public class TesteColecoes {

	public static void main(String[] args) {
		// Cria um array de cores e adiciona a uma lista
		String[] cores = { "MAGENTA", "VERMELHO", "BRANCO", "AZUL", "CIANO" };
		List<String> lista = new ArrayList<>();

		for (String cor : cores) {
			lista.add(cor); // Adiciona a cor no final da lista
		}
		
		// Cria um novo array de cores e adiciona a uma lista
		String[] removeCores = { "VERMELHO", "BRANCO", "AZUL" };
		List<String> listaRemocao = new ArrayList<String>();

		for (String cor : removeCores) {
			listaRemocao.add(cor);
		}

		// imprime o conteúdo da lista
		System.out.println("ArrayList: ");

		for (int contador = 0; contador < lista.size(); contador++) {
			System.out.printf("%s ", lista.get(contador));
		}

		// remove de lista as cores contidas em listaRemocao
		removeCores(lista, listaRemocao);

		// imprime o conteúdo da lista
		System.out.printf("%n%nArrayList após chamar removeCores:%n");

		for (String cor : lista) {
			System.out.printf("%s ", cor);
		}

	}

	private static void removeCores(Collection<String> colecao1, Collection<String> colecao2) {
		// obtém um Iterator
		Iterator<String> iterator = colecao1.iterator();
		
		// faz o loop enquanto houverem itens
		while (iterator.hasNext()) {
			if(colecao2.contains(iterator.next()))
				iterator.remove();   // remove o elemento atual
		}
	}

}
