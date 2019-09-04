package generics;

public class Maximo {

	public static void main(String[] args) {
		System.out.printf("O m�ximo entre %d, %d e %d � %d%n%n", 3, 4, 5, maximo(3, 4, 5));
		System.out.printf("O m�ximo entre %.1f, %.1f e %.1f � %.1f%n%n", 6.6, 8.8, 7.7, maximo(6.6, 8.8, 7.7));
		System.out.printf("O m�ximo entre %s, %s e %s � %s%n%n", "pera", "ma��", "laranja",
				maximo("pera", "ma��", "laranja"));
		
		
	}

	public static <T extends Comparable<T>> T maximo(T x, T y, T z) {
		T max = x; // assume que x � inicialmente o maior
		if (y.compareTo(max) > 0)
			max = y; // y � o maior at� agora
		if (z.compareTo(max) > 0)
			max = z; // z � o maior
		return max;
	}

}

