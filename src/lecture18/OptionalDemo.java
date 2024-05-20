package lecture18;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		System.out.println(Optional.of("Saur!"));
		String saur = "Saur!";
		System.out.println(Optional.of(saur));
		System.out.println(Optional.ofNullable(saur));
		saur = null;
		System.out.println(Optional.ofNullable(saur));
//		System.out.println(Optional.of(saur));

	}

}
