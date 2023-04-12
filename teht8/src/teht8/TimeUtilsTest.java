package teht8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeUtilsTest {

	@ParameterizedTest
	@ValueSource(ints = (4))
	public void testNormi(int num) {
		TimeUtils.secToTime(num);
		System.out.print(TimeUtils.secToTime(num));
	}
	
	@ParameterizedTest
	@ValueSource(ints = (-4))
	public void testNegativinen(int num) {
		TimeUtils.secToTime(num);
	}
	@ParameterizedTest
	@ValueSource(ints = (-1000000000))
	public void testTosiNegativinen(int num) {
		TimeUtils.secToTime(num);
	}
	
	@ParameterizedTest
	@ValueSource(ints = (1000000000))
	public void testIso(int num) {
		TimeUtils.secToTime(num);
	}
	
	@ParameterizedTest
	@ValueSource(ints = (0))
	public void testNolla(int num) {
		TimeUtils.secToTime(num);
	}
	
	

}
