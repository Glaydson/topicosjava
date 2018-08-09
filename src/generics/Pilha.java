package generics;

import java.util.ArrayList;

public class Pilha<T> {

	private final ArrayList<T> elementos;

	public Pilha() {
		this(10);
	}

	public Pilha(int capacidade) {
		int capacidadeInicial = capacidade > 0 ? capacidade : 10;
		elementos = new ArrayList<T>(capacidadeInicial);
	}

	public void push(T valorPush) {
		elementos.add(valorPush);
	}

	public T pop() {
		if (elementos.isEmpty())
			throw new RuntimeException("Pilha está vazia, não pode fazer o pop");
		return elementos.remove(elementos.size() - 1);
	}

}
