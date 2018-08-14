package generics;

public class MetodoGenerico {

	public static void main(String[] args) {
		// cria arrays de Integer, Double e Character
		Integer[] arrayInteiros = { 1, 2, 3, 4, 5, 6 };
		Double[] arrayDoubles = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] arrayCaracteres = { 'H', 'E', 'L', 'L', 'O' };

		System.out.printf("Array de inteiros contém:%n");
		imprimeArray(arrayInteiros); // passa um array de inteiros
		System.out.printf("Array de doubles contém:%n");
		imprimeArray(arrayDoubles); // passa um array de doubles
		System.out.printf("Array de caracteres contém:%n");
		imprimeArray(arrayCaracteres); // passa um array de caracteres
	}

	// implementação genérica
	public static <T> void imprimeArray(T[] arrayEntrada) {
		for (T elemento : arrayEntrada)
			System.out.printf("%s ", elemento);
		System.out.println();
	}

}

