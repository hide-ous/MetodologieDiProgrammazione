package lecture11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilterTest {
	int[] numbers1;
	int[] numbers2;
	int[] numbers3;

	@BeforeEach
	void setUp() throws Exception {
		numbers1 = new int[]{1,2,3};
		numbers2 = new int[]{-1,-2,-3};
		numbers3 = new int[]{-3, 1240, -34};
	}

	@Test
	void testLowPass() {
		assertArrayEquals(new int[]{1,2,3}, Filter.lowPass(numbers1, 10));
		assertArrayEquals(new int[]{1,2,3}, Filter.lowPass(numbers1, 3));
		assertArrayEquals(new int[]{1,2}, Filter.lowPass(numbers1, 2));
		assertArrayEquals(new int[]{}, Filter.lowPass(numbers1, 0));
		assertArrayEquals(new int[]{}, Filter.lowPass(numbers1, -1));
		assertThrows(IllegalArgumentException.class, ()-> Filter.lowPass(null, -1));
	}

//	@Test
//	void testHighPass() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFilterIntArrayInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFilterIntArrayIntArray() {
//		fail("Not yet implemented");
//	}

}
