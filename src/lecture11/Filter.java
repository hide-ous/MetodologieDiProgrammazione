package lecture11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Filter {
	public static int[] lowPass(int[] elements, int k) {

		return Arrays.stream(elements).filter(i->(i<=k)).toArray();
	}
	public static int[] highPass(int[] elements, int k) {

		return Arrays.stream(elements).filter(i->(i>=k)).toArray();
	}
	public static int[] filter(int[] elements, int k) {

		return Arrays.stream(elements).filter(i->(i!=k)).toArray();
	}
	public static int[] filter(int[] elements, int[] ks) {
		List<Integer> localKs = Arrays.stream(ks).boxed().collect(Collectors.toList()); 
		return Arrays.stream(elements).filter(i->!localKs.contains(i)).toArray();
	}
//	passaAlto: restituisce tutti gli elementi >= k nell’ordine iniziale
//	filtra: restituisce l’array iniziale da cui sono state eliminate tutte le occorrenze dell’intero passato in input
//	filtra: una seconda versione del metodo che restituisce l’array iniziale da cui vengono eliminate tutte le occorrenze di interi presenti nell’array passato in input

	public static void main(String[] args) {
		int[] theArray = {1,2, 3};
		for (int el: lowPass(theArray, 2)) {
			System.out.println(el);
		}

	}

}
