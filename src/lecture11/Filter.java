package lecture11;

import java.util.Arrays;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Filter {
	
	private static int[] filterOnPredicate(int[] elements, IntPredicate predicate) {
		return Arrays.stream(elements).filter(predicate).toArray();
	}
	private static void checkNull(int[] elements) throws IllegalArgumentException{
		if (elements == null) {
			throw new IllegalArgumentException("elements cannot be null");
		}		
	}
	//	passaAlto: restituisce tutti gli elementi <= k nell’ordine iniziale
	public static int[] lowPass(int[] elements, int k) throws IllegalArgumentException{
		checkNull(elements);
		return filterOnPredicate(elements, i->(i<=k));
	}
	//	passaAlto: restituisce tutti gli elementi >= k nell’ordine iniziale
	public static int[] highPass(int[] elements, int k) throws IllegalArgumentException{
		checkNull(elements);
		return filterOnPredicate(elements, i->(i>=k));
	}
	//	filtra: restituisce l’array iniziale da cui sono state eliminate tutte le occorrenze dell’intero passato in input
	public static int[] filter(int[] elements, int k) throws IllegalArgumentException{
		checkNull(elements);
		return filterOnPredicate(elements, i->(i!=k));
	}
	//	filtra: una seconda versione del metodo che restituisce l’array iniziale da cui vengono eliminate tutte le occorrenze di interi presenti nell’array passato in input
	public static int[] filter(int[] elements, int[] ks) throws IllegalArgumentException{
		checkNull(elements);
		if (ks==null | ks.length==0) {
			return elements;
		}
		Set<Integer> localKs = Arrays.stream(ks).boxed().collect(Collectors.toSet());
		IntPredicate p = new IntPredicate() {
			@Override
			public boolean test(int value) {
				return !localKs.contains(value);
			}
		};
		return filterOnPredicate(elements, p);
	}

	public static void main(String[] args) {
		int[] theArray = {1,2, 3};
		for (int el: lowPass(theArray, 2)) {
			System.out.println(el);
		}

	}

}
