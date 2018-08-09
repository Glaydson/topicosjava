package generics;

public class Maximo {

	public static void main(String[] args) {
		System.out.printf("O máximo entre %d, %d e %d é %d%n%n", 3, 4, 5, maximo(3, 4, 5));
		System.out.printf("O máximo entre %.1f, %.1f e %.1f é %.1f%n%n", 6.6, 8.8, 7.7, maximo(6.6, 8.8, 7.7));
		System.out.printf("O máximo entre %s, %s e %s é %s%n%n", "pera", "maçã", "laranja",
				maximo("pera", "maçã", "laranja"));
	}

	public static <T extends Comparable<T>> T maximo(T x, T y, T z) {
		T max = x; // assume que x é inicialmente o maior
		if (y.compareTo(max) > 0)
			max = y; // y é o maior até agora
		if (z.compareTo(max) > 0)
			max = z; // z é o maior
		return max;
	}

}
