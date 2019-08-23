package generics;

public class TestePilhaGenerica {

	public static void main(String[] args) {
		Pilha<String> minhaPilha = new Pilha<String>();
		
		//String elementoDesempilhado = minhaPilha.pop();
		
		// Empilhar elementos
		minhaPilha.push("MORANGO");
		minhaPilha.push("POLITICOS");
		minhaPilha.push("JOVENS");
		minhaPilha.push("BRASIL");
		//minhaPilha.push(1);  Isto n�o � permitido
		
		minhaPilha.imprimePilha();
		
		// desempilha o �ltimo empilhado
		minhaPilha.pop();
		
		minhaPilha.imprimePilha();
		
		Pilha<Integer> pilhaInteiros = new Pilha<Integer>();
		pilhaInteiros.push(1);
		pilhaInteiros.push(2);
		pilhaInteiros.push(3);
		pilhaInteiros.push(4);
		pilhaInteiros.push(5);
		
		pilhaInteiros.imprimePilha();
	}

}
