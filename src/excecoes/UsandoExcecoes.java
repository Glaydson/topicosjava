package excecoes;

// Mecanismo de tratamento de exceções em Java
public class UsandoExcecoes {
	public static void main(String[] args) {
		try {
			lancaExcecao();
		} catch (Exception e) { // exceção lançada por lancaExcecao
			System.out.flush();
			System.err.println("Exceção tratada no método main");
		}
		naoLancaExcecao();
	}

	public static void lancaExcecao() throws Exception {
		try { // lança uma exceção e a captura imediatamente
			System.out.println("Método lancaExcecao");
			throw new Exception(); // gera exceção
		} catch (Exception e) { // captura a exceção lançada no try
			System.out.flush();
			System.err.println("Exceção tratada no método lancaExcecao");
			throw e; // relança para processamento posterior

			// qualquer código aqui nunca será executado, irá gerar erro de compilação
		} finally { // executa independente do que ocorra no try...catch
			System.out.flush();
			System.err.println("Finally executado em lancaExcecao");
		}
	}

	private static void naoLancaExcecao() {
		try {   // o bloco try não lança uma exceção
			System.out.println("Método naoLancaExcecao");
		} catch (Exception e) {    // não executa
			System.out.flush();
			System.err.println(e);
		} finally {   // executa independente do que ocorra no try...catch
			System.out.flush();
			System.err.println("Finally executado em naoLancaExcecao");
		}
		System.out.println("Fim do método naoLancaExcecao");
	}
}
