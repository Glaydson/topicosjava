package generics;

public class MetodosSobrecarregados {

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

	// imprime um array de caracteres
	private static void imprimeArray(Character[] arrayCaracteres) {
		for (Character elemento : arrayCaracteres)
			System.out.printf("%s ", elemento);
		System.out.println();

	}

	// imprime um array de doubles
	private static void imprimeArray(Double[] arrayDoubles) {
		for (Double elemento : arrayDoubles)
			System.out.printf("%s ", elemento);
		System.out.println();
	}

	// imprime um array de inteiros
	private static void imprimeArray(Integer[] arrayInteiros) {
		for (Integer elemento : arrayInteiros)
			System.out.printf("%s ", elemento);
		System.out.println();

	}
}